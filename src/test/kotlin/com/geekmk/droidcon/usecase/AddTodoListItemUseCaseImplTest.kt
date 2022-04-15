package com.geekmk.droidcon.usecase

import com.geekmk.droidcon.entity.local.TodoItem
import com.geekmk.droidcon.model.TodoItemDto
import com.geekmk.droidcon.repository.TodoListRepository
import com.geekmk.droidcon.utils.Utils
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.stub
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDateTime


class AddTodoListItemUseCaseImplTest {

    private val mockDateTimeNow: LocalDateTime = LocalDateTime.of(1900, 1, 1, 1, 1)

    private val repository = mock<TodoListRepository>()

    private val utils = mock<Utils> {
        on { getGMTUnixtime() } doReturn mockDateTimeNow
    }

    private val mockedSavedItem = TodoItem(title = "MyTitle", insertedAt = mockDateTimeNow)
    private val itemToBeSaved = TodoItem(title = "MyTitle", insertedAt = mockDateTimeNow)

    lateinit var useCase: AddTodoListItemUseCase

    @BeforeEach
    fun setUp() {
        useCase = AddTodoListItemUseCaseImpl(repository = repository, utils = utils)
    }

    @Test
    fun `addTodoItem should return the added item`() {

        repository.stub {
            on { save(itemToBeSaved) } doReturn mockedSavedItem
        }
        Assertions.assertEquals(TodoItemDto("MyTitle"), useCase.execute(TodoItemDto("MyTitle")))
        verify(repository, times(1)).save(itemToBeSaved)
    }
}
