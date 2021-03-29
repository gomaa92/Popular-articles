package com.sgn.apps.populararticles.articles_management.domain.repository

import com.sgn.apps.populararticles.articles_management.domain.data.ListArticlesResponse

interface ArticlesManagementRepository {
    suspend fun listArticles(period: Int): ListArticlesResponse?
}