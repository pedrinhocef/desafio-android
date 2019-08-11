package com.pedrosoares.desafioconcrete.presentation.view.activities

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.pedrosoares.desafioconcrete.R
import com.pedrosoares.desafioconcrete.core.bases.BaseActivity
import com.pedrosoares.desafioconcrete.core.helper.PaginationScroll
import com.pedrosoares.desafioconcrete.data.entity.repository.Items
import com.pedrosoares.desafioconcrete.presentation.RepositoryPresentationContract
import com.pedrosoares.desafioconcrete.presentation.presenter.RepositoryPresenter
import com.pedrosoares.desafioconcrete.presentation.view.adapters.RepositoryListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_error.*

class MainActivity : BaseActivity<RepositoryPresentationContract.RepositoryListPresenter>(),
    RepositoryPresentationContract.RepositoryListView {

    private val repositoryListAdapter: RepositoryListAdapter by lazy {
        RepositoryListAdapter(repositoryResponse, this) {
            intentActivity(it)
        }
    }

    private lateinit var repositoryResponse: ArrayList<Items>

    private var releasedLoad: Boolean = true
    private var countPages: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        swipeRefresh()
    }

    private fun swipeRefresh() {
        swipe_refresh.setOnRefreshListener {
            presenter!!.fetchRepository()
            countPages = 2
            repositoryListAdapter.clear(repositoryResponse)
            loading()
            swipe_refresh.isRefreshing = false
        }
    }

    override fun onStart() {
        super.onStart()
        createPresenter()
        initUi()
    }

    override fun createPresenter() = RepositoryPresenter(this)

    private fun initUi() {
        presenter?.fetchRepository()
        repositoryResponse = ArrayList()
        setupAdapter()

    }

    private fun setupAdapter() {
        with(recycler_home) {
            adapter = repositoryListAdapter
            val layout = LinearLayoutManager(this@MainActivity)

            addOnScrollListener(object : PaginationScroll(layout) {
                override fun loadMoreItems() {
                    presenter?.fetchRepository(countPages++)
                    include_layout_loading_bottom.visibility = View.VISIBLE
                    releasedLoad = false
                }

                override fun isLoading(): Boolean {
                    return releasedLoad
                }

                override fun hideMoreItems() {
                    include_layout_loading.visibility = View.GONE
                }
            })
            layoutManager = layout

        }
    }

    override fun populateRepository(itemList: List<Items>) {
        this.repositoryResponse.addAll(itemList)
        repositoryListAdapter.notifyDataSetChanged()
    }

    override fun success() {
        recycler_home.visibility = View.VISIBLE
        include_layout_loading.visibility = View.GONE
        include_layout_error.visibility = View.GONE
        include_layout_loading_bottom.visibility = View.GONE
        releasedLoad = true
    }

    override fun loading() {
        include_layout_loading.visibility = View.VISIBLE
        include_layout_loading_bottom.visibility = View.GONE
        recycler_home.visibility = View.GONE
    }

    override fun error() {
        include_layout_error.visibility = View.VISIBLE
        include_layout_loading.visibility = View.GONE
        include_layout_loading_bottom.visibility = View.GONE
        recycler_home.visibility = View.GONE

        image_refresh.setOnClickListener {
            ObjectAnimator.ofFloat(image_refresh, View.ROTATION, 0f, 360f).setDuration(300).start()
            presenter?.fetchRepository()
            countPages = 2
            repositoryListAdapter.clear(repositoryResponse)
            repositoryListAdapter.notifyDataSetChanged()
            loading()
        }
    }

    override fun onConnectionChange(isConnected: Boolean) {
        if(!isConnected){
            Snackbar.make(findViewById(android.R.id.content), getString(R.string.no_connection), Snackbar.LENGTH_LONG).show()
        }
    }

    private fun intentActivity(it: Items) {
        val intent = Intent(this, PullsRequestsActivity::class.java)
        intent.putExtra("creator", it.owner.login)
        intent.putExtra("repo", it.name)
        startActivity(intent)
    }

}
