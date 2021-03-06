package ir.myket.interview.myket_task_kotlin.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class ,
    AppSubComponent::class])
interface AppComponentGraph {

    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponentGraph
    }

    fun mainActivitySubComponent(): MainActivitySubComponent.Factory
}