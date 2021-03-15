package ir.myket.interview.myket_task_kotlin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import ir.myket.interview.myket_task_kotlin.R
import ir.myket.interview.myket_task_kotlin.databinding.ActivityMainBinding
import ir.myket.interview.myket_task_kotlin.di.MyApplication
import ir.myket.interview.myket_task_kotlin.ui.fragment.ProgramListFragment

class MainActivity : AppCompatActivity() {

    lateinit var mBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val mainActivitySubComponent = (application  as MyApplication).appComponent.mainActivitySubComponent().create()
        mainActivitySubComponent.inject(this)
        super.onCreate(savedInstanceState)
        mBinding =ActivityMainBinding.inflate(layoutInflater)
        val fm = supportFragmentManager
        fm.beginTransaction()
            .replace(mBinding.fragmentContainer1.id,ProgramListFragment.newInstance())
            .commit()
    }
}