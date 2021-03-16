package ir.myket.interview.myket_task_kotlin.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import ir.myket.interview.myket_task_kotlin.data.model.ProgramItem
import ir.myket.interview.myket_task_kotlin.data.model.ProgramList
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Repository @Inject constructor(
    val mRequestQueue: RequestQueue
) {
    //retrofit and api
//   private lateinit var mApi: MyketApi
//   private var mRetrofit : Retrofit? = RetrofitCreator.getRetrofitInstance()
//    @Inject
//    lateinit var mRequestQueue: RequestQueue
//    @Inject
//    lateinit var rr: Retrofit

    //   init {
//     mApi = mRetrofit?.create(MyketApi::class.java)!!
//   }
    //live data
    val mProgramItemLiveData: MutableLiveData<List<ProgramItem>> =
        MutableLiveData<List<ProgramItem>>()

    var mElo: Boolean = false
//
//   fun getRequestQueue(context:Context) : RequestQueue? {
//      if (mRequestQueue == null){
//         mRequestQueue = Volley.newRequestQueue(context)
//      }
//      return mRequestQueue
//   }

    fun fetchItemWithVolley(offset: Int) {
        val url =
            "https://apiserver236.myket.ir/v1/applications/package/All_Data/?offset=$offset&limit=20&lang=fa"

        val programRequest = object : JsonObjectRequest(Method.GET, url, null,
            Response.Listener<JSONObject> { response ->
                val programList = response as ProgramList

                var programItem = programList.mProgramList

                var list: MutableList<ProgramItem> = mutableListOf()
                if (mProgramItemLiveData.value != null) {
                    list = (mProgramItemLiveData.value as MutableList<ProgramItem>?)!!
                }
                list.addAll(programItem)
                mProgramItemLiveData.value = list
                mElo = programList.mElo

            },
            Response.ErrorListener { error -> // Do something when get error
                Log.d("MAJID", "TOF")
            }
        ) {
            override fun getHeaders(): MutableMap<String, String> {
                val map = mutableMapOf<String, String>()
                map["Myket-Version"] = "735"
                map["Authorization"] =
                    "eyJhY2MiOiJraC5tYXNoYXlla2hAeWFob28uY29tIiwiYXBpIjoiMjMiLCJjcHUiOiJhcm02NC12OGE7YXJtZWFiaS12N2E7YXJtZWFiaSIsImR0IjozOTMzMzQ4MjYsImgiOiIzNTc5NjMwNTA2MjQ4NzEiLCJoc2giOiJMUW5IN0p1SVNMN3BwMnJpK3R5MFpqTVBBSW89Iiwic2NyIjoiMzAwXzQ4MCJ9"
                return map
            }

            override fun getParams(): MutableMap<String, String> {
                val map = mutableMapOf<String, String>()
                map["offset"] = offset.toString()
                return map
            }
        }
        mRequestQueue.add(programRequest)
    }

    fun fetchProgramItems(offset: Int) {
//      var call : Call<ProgramList> = mApi.fetchPrograms(offset.toString())
//      call.enqueue(object : Callback<ProgramList>{
//         override fun onResponse(call: Call<ProgramList>, response: Response<ProgramList>) {
//            response.let { it1 ->
//               var list : MutableList<ProgramItem> = mutableListOf()
//               if (mProgramItemLiveData.value != null){
//                  list = (mProgramItemLiveData.value as MutableList<ProgramItem>?)!!
//               }
//               it1.body()?.let {it2-> list.addAll(it2.mProgramList) }
//               mProgramItemLiveData.value = list
//               mElo = it1.body()?.mElo!!
//            }
//         }
//
//         override fun onFailure(call: Call<ProgramList>, t: Throwable) {
//            TODO("Not yet implemented")
//         }
//
//      })
    }


}