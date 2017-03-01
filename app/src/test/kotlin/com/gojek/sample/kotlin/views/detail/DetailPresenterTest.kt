package com.gojek.sample.kotlin.views.detail

import com.gojek.sample.kotlin.internal.data.remote.Api
import com.gojek.sample.kotlin.utils.RxSchedulersOverrideRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailPresenterTest {

    @Mock
    lateinit var mockView: DetailView

    @Mock
    lateinit var mockApi: Api

    @get:Rule
    val overrideRule = RxSchedulersOverrideRule()

    lateinit var presenter: DetailPresenter

    @Before
    fun setUp() {
        presenter = DetailPresenter(mockApi)
        presenter.onAttach(mockView)
    }

    @After
    fun tearDown() {
        presenter.onDetach()
    }

    @Test
    fun testShouldLoadContact() {
        val id: Int = 1
        presenter.loadContact(id)
        verify<DetailView>(mockView).onLoadContact()
    }
}