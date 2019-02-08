package max.githubapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

internal interface GitHubLatestApiURL {

    @GET("repos/{repoName}/releases/latest")
    fun latestRelease(
        @Path("repoName", encoded = true) repoName: String
    ): Call<GithubRelease>
}
