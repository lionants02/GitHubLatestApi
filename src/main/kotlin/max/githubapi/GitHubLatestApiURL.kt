package max.githubapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface GitHubLatestApiURL {

    @GET("repos/{repoName}/releases/latest")
    fun latestRelease(
        @Path("repoName", encoded = true) repoName: String
    ): Call<GithubRelease>

    @GET("repos/{repoName}/releases")
    fun release(
        @Path("repoName", encoded = true) repoName: String,
        @Query("page") page: Int
    ): Call<List<GithubRelease>>
}
