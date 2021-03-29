package com.sgn.apps.populararticles.articles_management.presentation.view.activity

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sgn.apps.populararticles.R
import com.sgn.apps.populararticles.articles_management.domain.data.ResultsEntity
import kotlinx.android.synthetic.main.activity_article_details.*


class ArticleDetailsActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_RESULT = "EXTRA_RESULT"
    }

    private lateinit var  item: ResultsEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_details)

        item = intent.getSerializableExtra(EXTRA_RESULT) as ResultsEntity
        setScreenData(item)

        clickToReadMoreOnWebSite.paintFlags =
            clickToReadMoreOnWebSite.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        readMore()
    }

    private fun setScreenData(item: ResultsEntity) {
        detailsArticleTitle.text = item.title
        articleBy.text = item.byline
        published_date.text = item.publishedDate
    }

    private fun readMore() {
        clickToReadMoreOnWebSite.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
            startActivity(browserIntent)
        }
    }
}