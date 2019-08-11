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
import com.pedrosoares.desafioconcrete.core.util.decimalFormat
import com.pedrosoares.desafioconcrete.data.entity.repository.Items
import kotlinx.android.synthetic.main.item_data.view.*

class RepositoryListAdapter(var listItem: ArrayList<Items>, private var context: Context) :
    RecyclerView.Adapter<RepositoryListAdapter.RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_data, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {

        val dataItem = listItem[position]

        holder.nameRepository.text = dataItem.fullName
        holder.description.text = dataItem.description
        holder.countFork.text = dataItem.forksCount.decimalFormat()
        holder.countStar.text = dataItem.stargazersCount.decimalFormat()
        holder.nameUser.text = dataItem.owner.login
        holder.nickName.text = dataItem.name

        holder.imageAvatar.alpha = 0.3f
        holder.imageAvatar.animate().setDuration(400).setInterpolator(AccelerateDecelerateInterpolator()).alpha(1f)

        val drawableImageDefault = R.drawable.ic_account_circle

        Glide.with(context)
            .load(dataItem.owner.avatarUrl)
            .placeholder(drawableImageDefault)
            .error(drawableImageDefault)
            .circleCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.imageAvatar)
    }

    fun clear(datas: ArrayList<Items>) {
        listItem.clear()
        listItem.addAll(datas)
        notifyDataSetChanged()
    }

    class RepositoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameRepository = view.text_name_repository!!
        val description = view.text_description!!
        val countFork = view.text_count_fork!!
        val countStar = view.text_count_star!!
        val nameUser = view.text_name_user!!
        val nickName = view.text_nick_name!!
        val imageAvatar = view.image_avatar!!
    }
}