package ir.myket.interview.myket_task_kotlin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ir.myket.interview.myket_task_kotlin.R
import ir.myket.interview.myket_task_kotlin.databinding.ActivityMainBinding
import ir.myket.interview.myket_task_kotlin.di.AppComponentGraph
import ir.myket.interview.myket_task_kotlin.di.MainActivitySubComponent
import ir.myket.interview.myket_task_kotlin.di.MyApplication
import ir.myket.interview.myket_task_kotlin.ui.fragment.ProgramListFragment

class MainActivity : AppCompatActivity() {

    lateinit var mBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val mainActivitySubComponent = (application  as MyApplication).appComponent.mainActivitySubComponent().create()
        mainActivitySubComponent.inject(this)
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this , R.layout.activity_main)
        val fm = supportFragmentManager
        fm.beginTransaction().
        add(R.id.fragment_container1,ProgramListFragment.newInstance()).commit()
    }
}