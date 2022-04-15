package com.geekmk.droidcon.usecase

import com.geekmk.droidcon.model.TodoItemDto
import com.geekmk.droidcon.repository.TodoListRepository
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory

interface FetchTodoListUseCase {
    fun execute(): List<TodoItemDto>
}

@Singleton
class FetchTodoListUseCaseImpl constructor(
    val todoListRepository: TodoListRepository
) : FetchTodoListUseCase {

    companion object {
        private val LOG = LoggerFactory.getLogger(FetchTodoListUseCaseImpl::class.java)
    }

    override fun execute(): List<TodoItemDto> {
        LOG.info("Fetching todo list items")
        return todoListRepository.findAll().map {
            TodoItemDto(it.title)
        }
    }
}
