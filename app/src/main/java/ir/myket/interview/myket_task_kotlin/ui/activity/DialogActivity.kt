package ir.myket.interview.myket_task_kotlin.ui.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import ir.myket.interview.myket_task_kotlin.R
import ir.myket.interview.myket_task_kotlin.di.MyApplication
import ir.myket.interview.myket_task_kotlin.viewmodel.DialogViewModel
import ir.myket.interview.myket_task_kotlin.viewmodel.ProgramItemsViewModel
import javax.inject.Inject

class DialogActivity : AppCompatActivity() {
//    @Inject
//    lateinit var vmFactory : ViewModelProvider.Factory
   // private val mViewModel: DialogViewModel by viewModels{vmFactory}
    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        val dialogComponent = (application as MyApplication).appComponent.dialogComponent().create()
        dialogComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog2)
       // mViewModel.dialog
       // Toast.makeText(this,mViewModel.dialog,Toast.LENGTH_LONG)
       // Log.d("MAJID",mViewModel.dialog)
    }
}