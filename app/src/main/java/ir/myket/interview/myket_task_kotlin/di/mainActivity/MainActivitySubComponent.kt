package ir.myket.interview.myket_task_kotlin.di.mainActivity

import dagger.Subcomponent
import ir.myket.interview.myket_task_kotlin.di.AdapterModule
import ir.myket.interview.myket_task_kotlin.di.ViewModelModule
import ir.myket.interview.myket_task_kotlin.ui.activity.MainActivity
import ir.myket.interview.myket_task_kotlin.ui.fragment.ProgramListFragment
@MainActivityScope
@Subcomponent(modules = [AdapterModule::class, ViewModelModule::class])
interface MainActivitySubComponent {
    @Subcomponent.Factory
    interface Factory{
        fun create(): MainActivitySubComponent
    }

    fun inject(mainActivity: MainActivity)
    fun inject(programListFragment: ProgramListFragment)
}