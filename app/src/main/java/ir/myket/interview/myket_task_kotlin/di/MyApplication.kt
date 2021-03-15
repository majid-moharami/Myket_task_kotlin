package ir.myket.interview.myket_task_kotlin.di

import android.app.Application
import dagger.internal.MapFactory.builder
import dagger.internal.MapProviderFactory.builder
import dagger.internal.SetFactory.builder

class MyApplication : Application() {

    private val component: AppComponentGraph? = null
    val appComponent: AppComponentGraph by lazy {
        DaggerAppComponentGraph.builder()
            .appModule(AppModule(applicationContext as Application?))
            .build()
    }
//     var appComponent: AppComponentGraph? = null
//
//    @JvmName("getAppComponent1")
//    fun getAppComponent(): AppComponentGraph? {
//        return appComponent
//    }

     fun initDagger(application: MyApplication?): AppComponentGraph? {
        return DaggerAppComponentGraph.builder()
            .appModule(AppModule(application))
            .build()
    }
}