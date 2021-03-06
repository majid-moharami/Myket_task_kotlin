package ir.myket.interview.myket_task_kotlin.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitCreator {
    companion object {
        val BaseURL = "https://apiserver236.myket.ir/v1/applications/package/All_Data/"
        private var sRetrofit : Retrofit? = null
        fun getRetrofitInstance(): Retrofit? {
            if (sRetrofit == null) {
                sRetrofit = Retrofit.Builder()
                    .baseUrl(BaseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return sRetrofit
        }
    }


}