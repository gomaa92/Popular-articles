package com.sgn.apps.populararticles

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.sgn.apps.populararticles.articles_management.domain.data.ListArticlesResponse
import com.sgn.apps.populararticles.articles_management.domain.interactor.ListPopularArticlesUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ListArticlesViewModelTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()


    private lateinit var useCase: ListPopularArticlesUseCase

    @Mock
    private lateinit var articlesLiveDate: MutableLiveData<ListArticlesResponse>

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        useCase = ListPopularArticlesUseCase()
    }

    @Test
    fun givenServerResponse200_whenFetch_shouldReturnSuccess_7() {
        runBlocking {
            articlesLiveDate.postValue(
                useCase.build(7)
            )
        }
    }
    @Test
    fun givenServerResponse200_whenFetch_shouldReturnSuccess_1() {
        runBlocking {
            articlesLiveDate.postValue(
                useCase.build(1)
            )
        }
    }
    @Test
    fun givenServerResponse200_whenFetch_shouldReturnSuccess_30() {
        runBlocking {
            articlesLiveDate.postValue(
                useCase.build(30)
            )
        }
    }


}