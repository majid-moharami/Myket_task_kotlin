package ir.myket.interview.myket_task_kotlin.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import ir.myket.interview.myket_task_kotlin.data.model.ProgramItem
import ir.myket.interview.myket_task_kotlin.data.model.ProgramList
import ir.myket.interview.myket_task_kotlin.data.network.MyketApi
import ir.myket.interview.myket_task_kotlin.data.network.RetrofitCreator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton
@Singleton
class Repository @Inject constructor(val context: Context) {
   //retrofit and api
   private lateinit var mApi: MyketApi
   private var mRetrofit : Retrofit? = RetrofitCreator.getRetrofitInstance()

   init {
     mApi = mRetrofit?.create(MyketApi::class.java)!!
   }
   //live data
   val mProgramItemLiveData : MutableLiveData<List<ProgramItem>> = MutableLiveData<List<ProgramItem>>()

   var mElo : Boolean = false

   fun fetchProgramItems(offset : Int){
      var call : Call<ProgramList> = mApi.fetchPrograms(offset.toString())
      call.enqueue(object : Callback<ProgramList>{
         override fun onResponse(call: Call<ProgramList>, response: Response<ProgramList>) {
            response.let { it1 ->
               var list : MutableList<ProgramItem> = mutableListOf()
               if (mProgramItemLiveData.value != null){
                  list = (mProgramItemLiveData.value as MutableList<ProgramItem>?)!!
               }
               it1.body()?.let {it2-> list.addAll(it2.mProgramList) }
               mProgramItemLiveData.value = list
               mElo = it1.body()?.mElo!!
            }
         }

         override fun onFailure(call: Call<ProgramList>, t: Throwable) {
            TODO("Not yet implemented")
         }

      })
   }


}