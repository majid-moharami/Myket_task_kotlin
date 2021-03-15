package ir.myket.interview.myket_task_kotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class DialogViewModel @Inject constructor() : ViewModel() {
    val dialog = "yes it work..."
}