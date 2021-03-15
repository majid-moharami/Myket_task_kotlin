package ir.myket.interview.myket_task_kotlin.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import dagger.Binds
import dagger.Module
import ir.myket.interview.myket_task_kotlin.di.dialogactivity.DialogSubComponent
import ir.myket.interview.myket_task_kotlin.di.mainActivity.MainActivityScope
import ir.myket.interview.myket_task_kotlin.di.mainActivity.MainActivitySubComponent

@Module(subcomponents = [MainActivitySubComponent::class , DialogSubComponent::class])
abstract class AppSubComponent