package com.sgn.apps.populararticles.articles_management.presentation.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.navigation.NavigationView
import com.sgn.apps.populararticles.R
import com.sgn.apps.populararticles.articles_management.domain.data.ResultsEntity
import com.sgn.apps.populararticles.articles_management.presentation.view.adapter.ListPopularArticlesAdapter
import com.sgn.apps.populararticles.articles_management.presentation.view.listener.OnArticleClicked
import com.sgn.apps.populararticles.articles_management.presentation.view.utils.ListArticlesPossiblesValues
import com.sgn.apps.populararticles.articles_management.presentation.viewmodel.ListPopularArticlesViewModel
import kotlinx.android.synthetic.main.activity_list_popular_articles.*
import java.util.*


class ListPopularArticlesActivity : AppCompatActivity(), OnArticleClicked,
    NavigationView.OnNavigationItemSelectedListener, SearchView.OnQueryTextListener {
    private lateinit var viewModel: ListPopularArticlesViewModel
    private lateinit var adapter: ListPopularArticlesAdapter
    private lateinit var data: List<ResultsEntity>

    companion object {
        const val EXTRA_RESULT = "EXTRA_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_popular_articles)

        initToolBar()

        viewModel = ViewModelProvider(this).get(ListPopularArticlesViewModel::class.java)
        initRecyclerView()
        if (viewModel.getListArticlesLiveDate().value == null)
            viewModel.listGroups(ListArticlesPossiblesValues.SEVEN_DAY.value)
        bindPopularArticles()
    }

    private fun initToolBar() {
        setSupportActionBar(toolbar)
        nav_view.setNavigationItemSelectedListener(this)
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            0, 0
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

    }

    private fun initRecyclerView() {
        adapter = ListPopularArticlesAdapter(Locale.ENGLISH, this)
        listArticlesRecyclerView.adapter = adapter
    }

    private fun bindPopularArticles() {
        viewModel.getListArticlesLiveDate()
            .observe(this@ListPopularArticlesActivity, {
                if (it != null && !it.results.isNullOrEmpty()) {
                    listArticlesProgressBar.visibility = View.GONE
                    adapter.setItems(it.results)
                    data = it.results
                }

            })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tool_bar_menu, menu)
        val searchItem = menu!!.findItem(R.id.searchToolBar)
        val searchView: SearchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onArticleClicked(item: ResultsEntity) {
        val intent = Intent(this@ListPopularArticlesActivity, ArticleDetailsActivity::class.java)
        intent.putExtra(EXTRA_RESULT, item)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.oneDayToolBar -> {
                adapter.clearItems()
                listArticlesProgressBar.visibility = View.VISIBLE
                viewModel.listGroups(ListArticlesPossiblesValues.ONE_DAY.value)

            }
            R.id.thirtyDaysToolBar -> {
                adapter.clearItems()
                listArticlesProgressBar.visibility = View.VISIBLE
                viewModel.listGroups(ListArticlesPossiblesValues.THIRTY_DAY.value)

            }
            R.id.sevenDaysToolBar -> {
                adapter.clearItems()
                listArticlesProgressBar.visibility = View.VISIBLE
                viewModel.listGroups(ListArticlesPossiblesValues.SEVEN_DAY.value)

            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.oneDay -> {
                adapter.clearItems()
                listArticlesProgressBar.visibility = View.VISIBLE
                viewModel.listGroups(ListArticlesPossiblesValues.ONE_DAY.value)

            }
            R.id.thirtyDays -> {
                adapter.clearItems()
                listArticlesProgressBar.visibility = View.VISIBLE
                viewModel.listGroups(ListArticlesPossiblesValues.THIRTY_DAY.value)
            }
            R.id.sevenDays -> {
                adapter.clearItems()
                listArticlesProgressBar.visibility = View.VISIBLE
                viewModel.listGroups(ListArticlesPossiblesValues.SEVEN_DAY.value)
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        filter(newText!!)
        return true
    }

    private fun filter(searchWord: String) {
        val temp: MutableList<ResultsEntity> = ArrayList()
        for (entity in data) {
            if (entity.title!!.toLowerCase(Locale.ROOT)
                    .contains(searchWord.toLowerCase(Locale.ROOT))
            ) {
                temp.add(entity)
            }
        }
        //update recyclerview
        adapter.clearItems()
        adapter.addItems(temp)
        adapter.notifyDataSetChanged()

    }
}