package com.sgn.apps.populararticles.articles_management.presentation.view.adapter

import android.view.View
import com.sgn.apps.populararticles.R
import com.sgn.apps.populararticles.articles_management.domain.data.ResultsEntity
import com.sgn.apps.populararticles.articles_management.presentation.view.listener.OnArticleClicked
import com.sgn.apps.populararticles.base.presntation.view.adapter.BaseLocalizedRecyclerViewAdapter
import kotlinx.android.synthetic.main.item_list_articles.view.*
import java.util.*

class ListPopularArticlesAdapter(
    language: Locale,
    var mListener: OnArticleClicked
) : BaseLocalizedRecyclerViewAdapter<ResultsEntity, BaseLocalizedRecyclerViewAdapter.BaseRecyclerViewHolder<ResultsEntity>>(
    language
) {
    override fun getLayout(type: Int): Int {
        return R.layout.item_list_articles
    }

    override fun getViewHolder(view: View, type: Int): BaseRecyclerViewHolder<ResultsEntity> {
        return ListArticlesViewHolder(view)
    }

    inner class ListArticlesViewHolder(itemView: View) :
        BaseLocalizedRecyclerViewAdapter.BaseRecyclerViewHolder<ResultsEntity>(itemView) {
        override fun onBind(item: ResultsEntity) {
            itemView.setOnClickListener {
                mListener.onArticleClicked(item)
            }
            itemView.articleTitle.text=item.title
            itemView.articleDate.text=item.publishedDate
            itemView.articleDescription.text=item.byline

        }
    }

}