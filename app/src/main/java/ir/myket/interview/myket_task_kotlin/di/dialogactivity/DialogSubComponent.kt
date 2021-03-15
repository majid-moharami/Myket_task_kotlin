package ir.myket.interview.myket_task_kotlin.di.dialogactivity

import dagger.Subcomponent
import ir.myket.interview.myket_task_kotlin.ui.activity.DialogActivity

@Subcomponent
interface DialogSubComponent {
    @Subcomponent.Factory
    interface Factory{
        fun create():DialogSubComponent
    }
    fun inject(dialogActivity: DialogActivity)
}