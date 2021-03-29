package com.sgn.apps.populararticles.articles_management.data.network

import com.sgn.apps.populararticles.articles_management.domain.data.ListArticlesResponse
import com.sgn.apps.populararticles.base.network.BaseNetwork
import com.sgn.apps.populararticles.base.network.EndPointConfig

object ArticleManagementCloud {
    suspend fun listArticles(period: Int): ListArticlesResponse? {
        return BaseNetwork.create(ArticleManagementService::class.java)
            .getListArticles(period, EndPointConfig.API_KEY)
    }
}