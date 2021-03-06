package ir.myket.interview.myket_task_kotlin.data.model

import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class ProgramList @Inject constructor(@SerializedName("eol") val mElo : Boolean,
                       @SerializedName("appPlusMetaDataList") val mProgramList: List<ProgramItem>)
