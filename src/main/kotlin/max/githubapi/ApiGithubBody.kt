package max.githubapi

import com.fatboyindustrial.gsonjodatime.DateTimeConverter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.joda.time.DateTime

internal val githubGson: Gson by lazy {
    GsonBuilder()
        .registerTypeAdapter(DateTime::class.java, DateTimeConverter())
        .create()
}

data class GithubRelease(
    val url: String,
    val html_url: String,
    val assets_url: String,
    val upload_url: String,
    val tarball_url: String,
    val zipball_url: String,
    val id: Long,
    val node_id: String,
    val tag_name: String,
    val target_commitish: String,
    val name: String,
    val body: String,
    val draft: Boolean,
    val prerelease: Boolean,
    val created_at: DateTime,
    val published_at: DateTime,
    val author: Author,
    val assets: List<Assets>
)

data class Author(
    val login: String,
    val id: Long,
    val node_id: String,
    val avatar_url: String,
    val gravatar_id: String,
    val url: String,
    val html_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val starred_url: String,
    val subscriptions_url: String,
    val organizations_url: String,
    val repos_url: String,
    val events_url: String,
    val received_events_url: String,
    val type: String,
    val site_admin: Boolean
)

data class Assets(
    val name: String,
    val url: String,
    val content_type: String?,
    val size: Long,
    val created_at: DateTime,
    val updated_at: DateTime,
    val browser_download_url: String,
    val id: Long,
    val node_id: String,
    val label: String,
    val state: String,
    val download_count: Long,
    val uploader: Author
)
