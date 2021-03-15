package ir.myket.interview.myket_task_kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.myket.interview.myket_task_kotlin.R
import ir.myket.interview.myket_task_kotlin.data.model.ProgramItem
import ir.myket.interview.myket_task_kotlin.data.model.ProgramList
import ir.myket.interview.myket_task_kotlin.databinding.ProgramItemBinding
import ir.myket.interview.myket_task_kotlin.viewmodel.ProgramItemsViewModel
import javax.inject.Inject

class ProgramListAdapter @Inject constructor(viewModel: ProgramItemsViewModel) :
    RecyclerView.Adapter<ProgramListAdapter.ProgramHolder>() {

    var mViewModel: ProgramItemsViewModel = viewModel
   // var mOwner : LifecycleOwner = owner
    var mList : List<ProgramItem>?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramHolder {
        var mBinding =ProgramItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProgramHolder(mBinding , mViewModel)
    }

    override fun onBindViewHolder(holder: ProgramHolder, position: Int) {
        mViewModel.getProgramItem(position)?.let { holder.bindProgramItem(it) }

        if (position == (mViewModel.mProgramItemLiveData.value?.size !! ) - 1) {
            mViewModel.upDateList()
        }
    }

    override fun getItemCount(): Int {
//        val size = intArrayOf(0)
//        mViewModel.mProgramItemLiveData.observe(mOwner,
//            Observer<List<Any?>> { programItems -> size[0] = programItems.size })
        return mList?.size ?: 0
    }

    class ProgramHolder(
        programItemBinding: ProgramItemBinding,
        viewModel: ProgramItemsViewModel
    ) :
        RecyclerView.ViewHolder(programItemBinding.root) {
        var mBinding: ProgramItemBinding = programItemBinding
        var viewModel = viewModel;


        fun bindProgramItem(programItem: ProgramItem){
            mBinding.textViewTitle.text = programItem.mTitle
            mBinding.textViewCategory.text = programItem.mCategory
            var imageURL = viewModel.mProgramItemLiveData.value?.get(position)?.mIconUrl
            Glide.with(mBinding.root).load(imageURL)
                .into(mBinding.imageViewIcon)
            mBinding.ratingBar.rating = viewModel.getProgramItem(position)?.mRating !!
        }
    }
}