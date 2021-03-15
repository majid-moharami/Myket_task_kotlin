package ir.myket.interview.myket_task_kotlin.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import ir.myket.interview.myket_task_kotlin.data.repository.Repository
import javax.inject.Singleton

@Module
class RepositoryModule constructor() {
    @Provides
    @Singleton
    fun getRepository(): Repository{
        return Repository()
    }
}