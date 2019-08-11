package com.pedrosoares.desafioconcrete.presentation.view.activities

import android.os.Bundle
import com.pedrosoares.desafioconcrete.R
import com.pedrosoares.desafioconcrete.core.bases.BaseActivity
import com.pedrosoares.desafioconcrete.data.entity.pullrequests.PullsRequestsResponse
import com.pedrosoares.desafioconcrete.presentation.PullsRequestsPresentationContract
import com.pedrosoares.desafioconcrete.presentation.presenter.PullsRequestsPresenter
import kotlinx.android.synthetic.main.activity_main.*

class PullsRequestsActivity: BaseActivity<PullsRequestsPresentationContract.PullsRequestsPresenter>(),
    PullsRequestsPresentationContract.PullsRequestsListView {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
        createPresenter()
        initUi()
    }

    override fun createPresenter() = PullsRequestsPresenter(this)

    private fun initUi() {
//        presenter!!.fetchPullsRequests()
//        repositoryResponse = ArrayList()
//        repositoryListAdapter = RepositoryListAdapter(repositoryResponse, this)

        with(recycler_home) {
//            adapter = repositoryListAdapter
//            layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }

    override fun populatePullsRequests(itemList: List<PullsRequestsResponse>) {
    }

    override fun success() {
    }

    override fun loading() {
    }

    override fun error() {
    }
}