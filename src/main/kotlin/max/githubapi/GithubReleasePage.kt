package max.githubapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubReleasePage(val repoName: String) {
    var data: List<GithubRelease> = emptyList()
    private var page = 1
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(githubGson))
        .baseUrl(GITHUB_API_URL)
        .build()

    fun next(): List<GithubRelease>? {
        val response = retrofit.create(GitHubLatestApiURL::class.java).release(repoName, page++).execute()
        check(response.body() != null) { "Return error ${response.code()} : ${response.errorBody()}" }
        val release = response.body()
        data = if (!release.isNullOrEmpty()) release else return null
        return data
    }
}
