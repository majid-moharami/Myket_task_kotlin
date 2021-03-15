package ir.myket.interview.myket_task_kotlin.di

import android.app.Application

class MyApplication : Application() {

    private val component: AppComponentGraph? = null
    val appComponent: AppComponentGraph by lazy {
        DaggerAppComponentGraph.factory().create(applicationContext)
    }
}