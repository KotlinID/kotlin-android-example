package com.gojek.sample.kotlin.views.home

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
class HomePresenterTest {

    @Mock
    lateinit var mockView: HomeView

    @Mock
    lateinit var mockApi: Api

    @get:Rule
    val overrideRule = RxSchedulersOverrideRule()

    lateinit var presenter: HomePresenter

    @Before
    fun setUp() {
        presenter = HomePresenter(mockApi)
        presenter.onAttach(mockView)
    }

    @After
    fun tearDown() {
        presenter.onDetach()
    }

    @Test
    fun testShouldLoadContacts() {
        presenter.loadContacts()
        verify<HomeView>(mockView).onLoadContacts()
    }
}