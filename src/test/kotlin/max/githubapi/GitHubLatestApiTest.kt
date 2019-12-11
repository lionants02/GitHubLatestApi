package max.githubapi

import org.junit.Ignore

class GitHubLatestApiTest {
    @Ignore("Use")
    fun test1() {
        val github = GitHubLatestApi("lionants02/GitHubLatestApi")
        val lastRelease = github.getLastRelease()

        println(lastRelease.body)

        println("Assets...")
        lastRelease.assets.forEach {
            println(it.browser_download_url)
        }
    }
}
