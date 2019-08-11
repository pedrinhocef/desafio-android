package com.pedrosoares.desafioconcrete.presentation.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.pedrosoares.desafioconcrete.R
import com.pedrosoares.desafioconcrete.data.entity.pullrequests.PullsRequestsResponse

class PullsRequestsAdapter(var listItem: ArrayList<PullsRequestsResponse>, private var context: Context) :
    RecyclerView.Adapter<PullsRequestsAdapter.PullsRequestsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullsRequestsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_data_pulls, parent, false)
        return PullsRequestsViewHolder(view)
    }

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: PullsRequestsViewHolder, position: Int) {
        val dataItem = listItem[position]

//        holder.nameRepository.text = dataItem.fullName
//        holder.description.text = dataItem.description
//        holder.countFork.text = dataItem.forksCount.decimalFormat()
//        holder.countStar.text = dataItem.stargazersCount.decimalFormat()
//
//        holder.imageAvatar.alpha = 0.3f
//        holder.imageAvatar.animate().setDuration(400).setInterpolator(AccelerateDecelerateInterpolator()).alpha(1f)
//
//        val drawableImageDefault = R.drawable.ic_account_circle
//
//        Glide.with(context)
//            .load(dataItem.owner.avatarUrl)
//            .placeholder(drawableImageDefault)
//            .error(drawableImageDefault)
//            .circleCrop()
//            .diskCacheStrategy(DiskCacheStrategy.ALL)
//            .into(holder.imageAvatar)
    }

    fun clear(datas: ArrayList<PullsRequestsResponse>) {
        listItem.clear()
        listItem.addAll(datas)
        notifyDataSetChanged()
    }

    class PullsRequestsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val nameRepository = view.text_name_repository!!
//        val description = view.text_description!!
//        val countFork = view.text_count_fork!!
//        val countStar = view.text_count_star!!

    }
}