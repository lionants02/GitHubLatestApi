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
    val name: String,
    val id: Long,
    val html_url: String,
    val tag_name: String,
    val draft: Boolean,
    val prerelease: Boolean,
    val created_at: DateTime,
    val published_at: DateTime,
    val assets: List<Assets>,
    val body: String
)

data class Assets(
    val name: String,
    val url: String,
    val content_type: String?,
    val size: Long,
    val created_at: DateTime,
    val updated_at: DateTime,
    val browser_download_url: String
)
