package com.sgn.apps.populararticles.articles_management.data.network

import com.sgn.apps.populararticles.articles_management.domain.data.ListArticlesResponse
import com.sgn.apps.populararticles.base.network.EndPointConfig
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArticleManagementService {

    @GET(EndPointConfig.LIST_ARTICLES)
    suspend fun getListArticles(
        @Path("period") period: Int?,
        @Query("api-key") apiKey: String?,
    ): ListArticlesResponse?
}