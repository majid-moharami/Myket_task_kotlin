package ir.myket.interview.myket_task_kotlin.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
abstract class ContextModule constructor(private val context : Context) {

    @Singleton
    @Binds
    abstract fun context(appInstance: Application):Context
}