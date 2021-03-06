package ir.myket.interview.myket_task_kotlin.data.model

import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class ProgramItem @Inject constructor(
    @SerializedName("title") val mTitle : String,
    @SerializedName("rating") val mRating : Float,
    @SerializedName("categoryName") val mCategory : String,
    @SerializedName("iconPath") val mIconUrl : String,
)
