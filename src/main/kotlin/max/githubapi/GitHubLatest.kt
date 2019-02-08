package max.githubapi

interface GitHubLatest {

    fun getLastRelease(): GithubRelease
    fun getLastRelease(callback: (callback: GithubRelease) -> Unit)
}
