package ir.myket.interview.myket_task_kotlin.di

import androidx.lifecycle.LifecycleOwner
import dagger.Module
import dagger.Provides
import ir.myket.interview.myket_task_kotlin.adapter.ProgramListAdapter
import ir.myket.interview.myket_task_kotlin.di.mainActivity.MainActivityScope
import ir.myket.interview.myket_task_kotlin.viewmodel.ProgramItemsViewModel

@Module
class AdapterModule {
    @Provides
    @MainActivityScope
    fun getListAdapter(viewModel: ProgramItemsViewModel) : ProgramListAdapter{
        return ProgramListAdapter(viewModel)
    }
}