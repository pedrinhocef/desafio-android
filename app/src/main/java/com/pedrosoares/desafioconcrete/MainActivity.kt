package com.pedrosoares.desafioconcrete

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedrosoares.desafioconcrete.core.bases.BaseActivity
import com.pedrosoares.desafioconcrete.data.entity.Items
import com.pedrosoares.desafioconcrete.presentation.RepositoryPresentationContract
import com.pedrosoares.desafioconcrete.presentation.presenter.RepositoryPresenter
import com.pedrosoares.desafioconcrete.presentation.view.adapter.RepositoryListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<RepositoryPresentationContract.RepositoryListPresenter>(), RepositoryPresentationContract.RepositoryListView {

    private lateinit var repositoryListAdapter: RepositoryListAdapter
    private lateinit var repositoryResponse: ArrayList<Items>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
        createPresenter()
        initUi()
    }

    override fun createPresenter() = RepositoryPresenter(this)

    private fun initUi() {
        presenter!!.fetchRepository()
        repositoryResponse = ArrayList()
        repositoryListAdapter = RepositoryListAdapter(repositoryResponse, this)

        with(recycler_home) {
            adapter = repositoryListAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }

    override fun populateRepository(itemList: List<Items>) {
        this.repositoryResponse.addAll(itemList)
        repositoryListAdapter.notifyDataSetChanged()
    }

    override fun success() {
        recycler_home.visibility = View.VISIBLE
    }

    override fun loading() {
        recycler_home.visibility = View.GONE
    }

    override fun error() {
        recycler_home.visibility = View.GONE
    }

}
