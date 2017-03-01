package com.gojek.sample.kotlin.views.create

import com.gojek.sample.kotlin.internal.data.local.model.NewContact
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
class CreatePresenterTest {

    @Mock
    lateinit var mockView: CreateView

    @Mock
    lateinit var mockApi: Api

    @Mock
    lateinit var mockNewContact: NewContact

    @get:Rule
    val overrideRule = RxSchedulersOverrideRule()

    lateinit var presenter: CreatePresenter

    @Before
    fun setUp() {
        presenter = CreatePresenter(mockApi)
        presenter.onAttach(mockView)
    }

    @After
    fun tearDown() {
        presenter.onDetach()
    }

    @Test
    fun textShouldAddContact() {
        val firstName: String = "Budi Oktaviyan"
        val lastName: String = "Suryanto"
        val email: String = "budi.suryanto@go-jek.com"
        val phoneNumber: String = "6281289880275"
        val profilePic: String = "https://avatars3.githubusercontent.com/u/2031493?v=3&s=460"

        mockNewContact = NewContact(firstName, lastName, email, phoneNumber, profilePic)
        presenter.createContact(mockNewContact)
        verify<CreateView>(mockView).onCreateContact()
    }
}