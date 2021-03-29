package com.sgn.apps.populararticles.articles_management.domain.interactor

import com.sgn.apps.populararticles.articles_management.data.repository.ArticlesManagementRepositoryImpl
import com.sgn.apps.populararticles.articles_management.domain.data.ListArticlesResponse
import com.sgn.apps.populararticles.base.interactor.BaseUseCase

class ListPopularArticlesUseCase : BaseUseCase<Int, ListArticlesResponse?> {
    override suspend fun build(param: Int): ListArticlesResponse? {
        return ArticlesManagementRepositoryImpl.listArticles(param)
    }
}