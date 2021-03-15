package ir.myket.interview.myket_task_kotlin.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private var application: Application?) {

    @Provides
    @Singleton
    fun provideContext(): Context? {
        return application?.applicationContext
    }

}