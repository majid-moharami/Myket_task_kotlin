package ir.myket.interview.myket_task_kotlin.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ir.myket.interview.myket_task_kotlin.viewmodel.ProgramItemsViewModel
import ir.myket.interview.myket_task_kotlin.viewmodel.TestVMFactory

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKeys(ProgramItemsViewModel::class)
    abstract fun bindProgramItemsViewModel(viewModel: ProgramItemsViewModel) : ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: TestVMFactory): ViewModelProvider.Factory
}