package com.sgn.apps.populararticles.articles_management.data.repository

import com.sgn.apps.populararticles.articles_management.data.network.ArticleManagementCloud
import com.sgn.apps.populararticles.articles_management.domain.data.ListArticlesResponse
import com.sgn.apps.populararticles.articles_management.domain.repository.ArticlesManagementRepository

object ArticlesManagementRepositoryImpl : ArticlesManagementRepository {
    override suspend fun listArticles(period: Int): ListArticlesResponse? {
        return ArticleManagementCloud.listArticles(period)
    }
}