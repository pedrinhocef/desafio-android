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
import com.pedrosoares.desafioconcrete.core.util.dateFormat
import com.pedrosoares.desafioconcrete.data.entity.pullrequests.PullsRequestsResponse
import kotlinx.android.synthetic.main.item_data_pulls.view.*

class PullsRequestsAdapter(private var listItem: ArrayList<PullsRequestsResponse>,  var context: Context,
                           private val onItemClickListener: ((items: PullsRequestsResponse) -> Unit)) :
    RecyclerView.Adapter<PullsRequestsAdapter.PullsRequestsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullsRequestsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_data_pulls, parent, false)
        return PullsRequestsViewHolder(view, onItemClickListener)
    }

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: PullsRequestsViewHolder, position: Int) {
        val dataItem = listItem[position]
        holder.bindView(dataItem)
    }

    fun clear(datas: ArrayList<PullsRequestsResponse>) {
        listItem.clear()
        listItem.addAll(datas)
        notifyDataSetChanged()
    }

    class PullsRequestsViewHolder(private val view: View, private val onItemClickListener: (dataItem: PullsRequestsResponse) -> Unit)
        : RecyclerView.ViewHolder(view) {
        private val titlePullRequest = view.text_title_pull!!
        private val description = view.text_description!!
        private val userName = view.text_name_user!!
        private val imageAvatar = view.image_avatar!!
        private val dataPullRequest = view.text_data!!

        fun bindView(dataItem: PullsRequestsResponse) = with(view) {
            titlePullRequest.text = dataItem.title
            description.text = dataItem.body
            userName.text = dataItem.user.login
            dataPullRequest.text = dataItem.createdAt.dateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")

            imageAvatar.alpha = 0.3f
            imageAvatar.animate().setDuration(400).setInterpolator(AccelerateDecelerateInterpolator()).alpha(1f)

            val drawableImageDefault = R.drawable.ic_account_circle

            Glide.with(context)
                .load(dataItem.user.avatarUrl)
                .placeholder(drawableImageDefault)
                .error(drawableImageDefault)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageAvatar)

            this.setOnClickListener {
                onItemClickListener.invoke(dataItem)
            }
        }

    }
}