package ir.myket.interview.myket_task_kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.myket.interview.myket_task_kotlin.R
import ir.myket.interview.myket_task_kotlin.databinding.ProgramItemBinding
import ir.myket.interview.myket_task_kotlin.viewmodel.ProgramItemsViewModel

class ProgramListAdapter(viewModel: ProgramItemsViewModel, owner: LifecycleOwner) :
    RecyclerView.Adapter<ProgramListAdapter.ProgramHolder>() {

    var mViewModel: ProgramItemsViewModel = viewModel
    var mOwner : LifecycleOwner = owner

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramHolder {
        var mBinding = DataBindingUtil.inflate<ProgramItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.program_item,
            parent,
            false
        )
        return ProgramHolder(mBinding , mViewModel , mOwner)
    }

    override fun onBindViewHolder(holder: ProgramHolder, position: Int) {
        holder.bindProgramItem(position)

        if (position == (mViewModel.mProgramItemLiveData.value?.size !! ) - 1) {
            mViewModel.upDateList()
        }
    }

    override fun getItemCount(): Int {
        val size = intArrayOf(0)
        mViewModel.mProgramItemLiveData.observe(mOwner,
            Observer<List<Any?>> { programItems -> size[0] = programItems.size })
        return size[0]
    }

    class ProgramHolder(
        programItemBinding: ProgramItemBinding,
        viewModel: ProgramItemsViewModel,
        owner: LifecycleOwner
    ) :
        RecyclerView.ViewHolder(programItemBinding.root) {
        var mBinding: ProgramItemBinding = programItemBinding
        var viewModel = viewModel;
        init {
            mBinding.viewModel = viewModel
            mBinding.lifecycleOwner = owner
        }

        fun bindProgramItem(position: Int){
            mBinding.position = position
            mBinding.executePendingBindings()

            var imageURL = viewModel.mProgramItemLiveData.value?.get(position)?.mIconUrl
            Glide.with(mBinding.root).load(imageURL)
                .into(mBinding.imageViewIcon)
            mBinding.ratingBar.rating = viewModel.getProgramItem(position)?.mRating !!
        }
    }
}