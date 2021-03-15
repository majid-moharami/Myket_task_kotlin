package ir.myket.interview.myket_task_kotlin.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import ir.myket.interview.myket_task_kotlin.R
import ir.myket.interview.myket_task_kotlin.adapter.ProgramListAdapter
import ir.myket.interview.myket_task_kotlin.data.model.ProgramItem
import ir.myket.interview.myket_task_kotlin.databinding.ListFragmentBinding
import ir.myket.interview.myket_task_kotlin.di.MyApplication
import ir.myket.interview.myket_task_kotlin.ui.activity.DialogActivity
import ir.myket.interview.myket_task_kotlin.viewmodel.ProgramItemsViewModel
import javax.inject.Inject


class ProgramListFragment : Fragment() {

    lateinit var mBinding: ListFragmentBinding
    @Inject lateinit var vmFactory : ViewModelProvider.Factory
    private val mViewModel: ProgramItemsViewModel by viewModels{vmFactory}
    @Inject lateinit var mAdaptor: ProgramListAdapter
    var isLoading = true

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val mainActivitySubComponent = (activity?.application as MyApplication).appComponent.mainActivitySubComponent().create()
        mainActivitySubComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAdaptor = ProgramListAdapter(mViewModel)
        observers()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = ListFragmentBinding.inflate(inflater, container, false)
        mBinding.rere.layoutManager = GridLayoutManager(context, 1)
        mBinding.rere.adapter = mAdaptor
        mBinding.mostRatingView.imageViewIcon.setOnClickListener {
            startActivity(Intent(activity , DialogActivity::class.java))
        }
        return mBinding.root
    }

    private fun observers(){
        mViewModel.mMostRateLiveData.observe(this, Observer {
            val programItem: ProgramItem? = mViewModel.getProgramItem(it)
            programItem?.let {
                mBinding.mostRatingView.ratingBar.rating = programItem.mRating
                mBinding.mostRatingView.textViewTitle.text = programItem.mTitle
                mBinding.mostRatingView.textViewCategory.text = (programItem.mCategory)
                context?.let { it1 ->
                    Glide.with(it1).load(programItem.mIconUrl)
                        .into(mBinding.mostRatingView.imageViewIcon)
                }
            }

        })

        mViewModel.mProgramItemLiveData.observe(this, Observer {
            if (isLoading){
                isLoading=false
                mBinding.loadingAnim.visibility = View.GONE
                mBinding.wholeScreen.visibility = View.VISIBLE
            }
            mAdaptor.mList=it
            mAdaptor.notifyDataSetChanged()
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProgramListFragment().apply {
            arguments = Bundle().apply {
            }
        }
    }
}