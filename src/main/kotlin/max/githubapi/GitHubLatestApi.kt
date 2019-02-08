package max.githubapi

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GitHubLatestApi(val repoName: String) : GitHubLatest {

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(githubGson))
        .baseUrl("""https://api.github.com/""")
        .build()

    override fun getLastRelease(): GithubRelease {
        val response = retrofit.create(GitHubLatestApiURL::class.java).latestRelease(repoName).execute()
        check(response.body() != null) { "Return error ${response.code()} : ${response.errorBody()}" }
        return response.body()!!
    }

    override fun getLastRelease(callback: (callback: GithubRelease) -> Unit) {
        retrofit.create(GitHubLatestApiURL::class.java).latestRelease(repoName)
            .enqueue(object : Callback<GithubRelease> {
                override fun onFailure(call: Call<GithubRelease>, t: Throwable) {
                    throw t
                }

                override fun onResponse(call: Call<GithubRelease>, response: Response<GithubRelease>) {
                    check(response.body() != null) { "Return error ${response.code()} : ${response.errorBody()}" }
                    callback(response.body()!!)
                }
            })
    }
}
