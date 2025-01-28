import com.google.gson.annotations.SerializedName
import com.onespan.android.interview.data.remote.model.Data
import com.onespan.android.interview.data.remote.model.Link

data class Item(
    @SerializedName("current_page")
    val currentPage: Int = 0,
    @SerializedName("data")
    val `data`: List<Data> = emptyList(),
    @SerializedName("first_page_url")
    val firstPageUrl: String = "",
    @SerializedName("from")
    val from: Int = 0,
    @SerializedName("last_page")
    val lastPage: Int = 0,
    @SerializedName("last_page_url")
    val lastPageUrl: String = "",
    @SerializedName("links")
    val links: List<Link> = emptyList(),
    @SerializedName("next_page_url")
    val nextPageUrl: String = "",
    @SerializedName("path")
    val path: String = "",
    @SerializedName("per_page")
    val perPage: Int = 0,
    @SerializedName("prev_page_url")
    val prevPageUrl: Any = "",
    @SerializedName("to")
    val to: Int = 0,
    @SerializedName("total")
    val total: Int = 0
)
