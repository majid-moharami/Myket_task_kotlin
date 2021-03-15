package ir.myket.interview.myket_task_kotlin.di

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import dagger.Module
import dagger.Provides
import ir.myket.interview.myket_task_kotlin.data.network.MyketApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun getRetrofitInstance():MyketApi{
        return Retrofit.Builder()
            .baseUrl("https://apiserver236.myket.ir/v1/applications/package/All_Data/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyketApi::class.java)
    }


    @Provides
    @Singleton
    fun provideQueue(context: Context): RequestQueue? {
        return Volley.newRequestQueue(context)
    }
}