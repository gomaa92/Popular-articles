package com.sgn.apps.populararticles.articles_management.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgn.apps.populararticles.articles_management.domain.data.ListArticlesResponse
import com.sgn.apps.populararticles.articles_management.domain.interactor.ListPopularArticlesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListPopularArticlesViewModel : ViewModel() {
    private val listArticlesLiveData = MutableLiveData<ListArticlesResponse?>()
    private var listArticlesUseCase: ListPopularArticlesUseCase = ListPopularArticlesUseCase()
    fun listGroups(period: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            listArticlesLiveData.postValue(
                listArticlesUseCase.build(period)
            )
        }
    }

    fun getListArticlesLiveDate() = listArticlesLiveData
}