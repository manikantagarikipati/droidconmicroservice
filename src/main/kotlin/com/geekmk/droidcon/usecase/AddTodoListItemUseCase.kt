package com.geekmk.droidcon.usecase

import com.geekmk.droidcon.entity.local.TodoItem
import com.geekmk.droidcon.exception.AddItemException
import com.geekmk.droidcon.model.TodoItemDto
import com.geekmk.droidcon.repository.TodoListRepository
import com.geekmk.droidcon.utils.Utils
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory
import javax.validation.ConstraintViolationException

interface AddTodoListItemUseCase {
    fun execute(todoItemDto: TodoItemDto): TodoItemDto
}

@Singleton
class AddTodoListItemUseCaseImpl constructor(
    val repository: TodoListRepository,
    val utils: Utils
) : AddTodoListItemUseCase {

    companion object {
        private val LOG = LoggerFactory.getLogger(AddTodoListItemUseCaseImpl::class.java)
    }

    override fun execute(todoItemDto: TodoItemDto): TodoItemDto {
        LOG.info("Adding todo list item")
        try {
            val savedItem = repository.save(TodoItem.of(todoItemDto, utils.getGMTUnixtime()))
            return TodoItemDto(savedItem.title)
        } catch (exception: ConstraintViolationException) {
            LOG.error("Error saving Todo Item: ${exception.message}")
            throw AddItemException("Error Adding An Todo Item")
        }
    }
}
