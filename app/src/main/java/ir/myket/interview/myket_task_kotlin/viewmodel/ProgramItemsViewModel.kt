package ir.myket.interview.myket_task_kotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.myket.interview.myket_task_kotlin.data.model.ProgramItem
import ir.myket.interview.myket_task_kotlin.data.repository.Repository
import ir.myket.interview.myket_task_kotlin.di.mainActivity.MainActivityScope
import ir.myket.interview.myket_task_kotlin.utill.CalculateLastRating
import javax.inject.Inject
import javax.inject.Singleton

class ProgramItemsViewModel @Inject constructor(val mRepository : Repository): ViewModel() {
    private var mOffset = 20
    lateinit var mProgramItemLiveData: LiveData<List<ProgramItem>>
    var mMostRateLiveData: MutableLiveData<Int> = MutableLiveData<Int>()
    private var mCalculateLastRating = CalculateLastRating()

    init {

        mRepository.fetchProgramItems(0)
        mProgramItemLiveData = mRepository.mProgramItemLiveData
    }

    fun getProgramItem(position: Int): ProgramItem? {
        var programItem = mProgramItemLiveData.value?.get(position)
        if (programItem != null) {
            if (mCalculateLastRating.check(position, programItem.mRating)) {
                mMostRateLiveData.value = position
            }
        }
        return programItem
    }

    fun upDateList() {
        if (!mRepository.mElo) {
            mRepository.fetchProgramItems(mOffset)
            mOffset += 20
        }
    }

}