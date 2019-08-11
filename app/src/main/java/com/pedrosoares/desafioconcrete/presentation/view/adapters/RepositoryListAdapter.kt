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

class RepositoryListAdapter(private var listItem: ArrayList<Items>, private var context: Context,
                            private val onItemClickListener: ((items: Items) -> Unit)) :
    RecyclerView.Adapter<RepositoryListAdapter.RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_data, parent, false)
        return RepositoryViewHolder(view, onItemClickListener)
    }

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {

        val dataItem = listItem[position]
        holder.bindView(dataItem)

    }

    fun clear(datas: ArrayList<Items>) {
        listItem.clear()
        listItem.addAll(datas)
        notifyDataSetChanged()
    }

    class RepositoryViewHolder(private val view: View, private val onItemClickListener: (items: Items) -> Unit) :
        RecyclerView.ViewHolder(view) {
        private val nameRepository = view.text_name_repository!!
        private val description = view.text_description!!
        private val countFork = view.text_count_fork!!
        private val countStar = view.text_count_star!!
        private val nameUser = view.text_name_user!!
        private val nickName = view.text_nick_name!!
        private val imageAvatar = view.image_avatar!!

        fun bindView(items: Items) = with(view) {
            nameRepository.text = items.fullName
            description.text = items.description
            countFork.text = items.forksCount.decimalFormat()
            countStar.text = items.stargazersCount.decimalFormat()
            nameUser.text = items.owner.login
            nickName.text = items.name

            imageAvatar.alpha = 0.3f
            imageAvatar.animate().setDuration(400).setInterpolator(AccelerateDecelerateInterpolator()).alpha(1f)

            val drawableImageDefault = R.drawable.ic_account_circle

            Glide.with(context)
                .load(items.owner.avatarUrl)
                .placeholder(drawableImageDefault)
                .error(drawableImageDefault)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageAvatar)

            this.setOnClickListener {
                onItemClickListener.invoke(items)
            }
        }


    }
}