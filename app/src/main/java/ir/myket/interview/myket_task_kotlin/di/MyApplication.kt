package ir.myket.interview.myket_task_kotlin.di

import android.app.Application

class MyApplication : Application() {
    val appComponent: AppComponentGraph by lazy {
        DaggerAppComponentGraph.factory().create(applicationContext)
    }
}