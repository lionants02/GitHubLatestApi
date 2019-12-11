package max.githubapi

import org.junit.Ignore
import org.junit.Test

@Ignore("Use")
class GithubReleasePageTest {
    @Test
    fun testNextPage() {
        val githubReleasePage = GithubReleasePage("AdoptOpenJDK/openjdk8-binaries")
        while (githubReleasePage.next() != null) {
            val data = githubReleasePage.data.first()
            println("${data.name}  size: ${githubReleasePage.data.size}")
        }
    }
}
