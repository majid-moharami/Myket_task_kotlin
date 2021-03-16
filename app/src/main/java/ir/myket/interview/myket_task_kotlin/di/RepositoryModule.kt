package ir.myket.interview.myket_task_kotlin.di

import android.app.Application
import android.content.Context
import com.android.volley.RequestQueue
import dagger.Module
import dagger.Provides
import ir.myket.interview.myket_task_kotlin.data.repository.Repository
import javax.inject.Singleton

@Module
class RepositoryModule constructor() {
    @Provides
    @Singleton
    fun getRepository(
        requestQueue: RequestQueue
    ): Repository{
        return Repository(requestQueue)
    }
}