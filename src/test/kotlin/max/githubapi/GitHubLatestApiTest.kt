package max.githubapi

import org.junit.Ignore
import org.junit.Test

@Ignore("Use")
class GitHubLatestApiTest {
    @Test
    fun test1() {
        val github = GitHubLatestApi("lionants02/GitHubLatestApi")
        val lastRelease = github.getLastRelease()

        println(lastRelease.body)

        println("Assets...")
        lastRelease.assets.forEach {
            println(it.browser_download_url)
        }
    }

    @Test
    fun getPreLastRelease() {
        val github = GitHubLatestApi("lionants02/GitHubLatestApi")
        val lastRelease = github.getLastPreRelease()

        println(lastRelease!!.tag_name)
    }
}
