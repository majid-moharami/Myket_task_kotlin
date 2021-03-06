package ir.myket.interview.myket_task_kotlin.di

import dagger.Subcomponent
import ir.myket.interview.myket_task_kotlin.ui.activity.MainActivity
import ir.myket.interview.myket_task_kotlin.ui.fragment.ProgramListFragment

@Subcomponent(modules =  [ViewModelModule::class])
interface MainActivitySubComponent {
    @Subcomponent.Factory
    interface Factory{
        fun create():MainActivitySubComponent
    }

    fun inject(mainActivity: MainActivity)
    fun inject(programListFragment: ProgramListFragment)
}