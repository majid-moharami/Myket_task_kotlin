package ir.myket.interview.myket_task_kotlin.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ir.myket.interview.myket_task_kotlin.di.dialogactivity.DialogSubComponent
import ir.myket.interview.myket_task_kotlin.di.mainActivity.MainActivityScope
import ir.myket.interview.myket_task_kotlin.di.mainActivity.MainActivitySubComponent
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        AppSubComponent::class,
        RepositoryModule::class]
)
interface AppComponentGraph {

    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        //fun createNetWorkModule(@BindsInstance context: Context):NetworkModule
        fun create(@BindsInstance context: Context): AppComponentGraph
    }


    fun mainActivitySubComponent(): MainActivitySubComponent.Factory
    fun dialogComponent(): DialogSubComponent.Factory
}