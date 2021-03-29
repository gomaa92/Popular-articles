package com.sgn.apps.populararticles.articles_management.presentation.view.listener

import com.sgn.apps.populararticles.articles_management.domain.data.ResultsEntity

interface OnArticleClicked {
    fun onArticleClicked(item: ResultsEntity)
}