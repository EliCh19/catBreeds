package com.onespan.android.interview.presentation.screens.home

import Item
import android.util.Log
import com.onespan.android.interview.MainDispatcherRule
import com.onespan.android.interview.common.Resource
import com.onespan.android.interview.data.remote.model.Data
import com.onespan.android.interview.domain.repository.CatsRepository
import io.mockk.clearAllMocks
import io.mockk.clearMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeScreenViewModelTest {

    private lateinit var viewModel: HomeScreenViewModel
    private lateinit var repository: CatsRepository

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Before
    fun setup() {
        repository = mockk(relaxed = true)
        viewModel = HomeScreenViewModel(repository)


    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `test getArtists return success`() = runTest {
        val catsList =
            Item(
                currentPage = 1,
                data = listOf(
                    Data(
                        breed = "Abyssinian",
                        country = "Ethiopia",
                        origin = "Natural/Standard",
                        coat = "Short",
                        pattern = "Ticked"
                    )
                ),
                "",
                1,
                4,
                "",
                emptyList(),
                "",
                "",
                1,
                "",
                1,
                1
            )

        coEvery { repository.getBreeds() } returns Resource.Success(catsList)

        // When
        viewModel.getItems()

        // Then
        coVerify(exactly = 1) { repository.getBreeds() }
        assertEquals(catsList.data.size, viewModel.catsList.data.size)
        assertEquals("Abyssinian", viewModel.catsList.data[0].breed)
        assertFalse(viewModel.isLoading)
    }

    @Test
    fun `test getItems returns error`() = runTest {
        // Given
        mockkStatic(Log::class)
        every { Log.i(any(), any()) } returns 0
        val errorMessage = "Network error"
        coEvery { repository.getBreeds() } returns Resource.Error(null, errorMessage)

        // When
        viewModel.getItems()

        // Then
        assertFalse(viewModel.isLoading)
        verify { Log.i("Network", "showCats: Failed to load cat breeds") }
    }

}