package ir.myket.interview.myket_task_kotlin.data.network

import ir.myket.interview.myket_task_kotlin.data.model.ProgramList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MyketApi {
    @Headers(
        "Myket-Version:" + 735,
        "Authorization:eyJhY2MiOiJraC5tYXNoYXlla2hAeWFob28uY29tIiwiYXBpIjoiMjMiLCJjcHUiOiJhcm02NC12OGE7YXJtZWFiaS12N2E7YXJtZWFiaSIsImR0IjozOTMzMzQ4MjYsImgiOiIzNTc5NjMwNTA2MjQ4NzEiLCJoc2giOiJMUW5IN0p1SVNMN3BwMnJpK3R5MFpqTVBBSW89Iiwic2NyIjoiMzAwXzQ4MCJ9"
    )
    @GET("https://apiserver236.myket.ir/v1/applications/package/All_Data/?limit=20&lang=fa")
    fun fetchPrograms(@Query("offset") offset: String) : Call<ProgramList>


}