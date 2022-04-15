package com.geekmk.droidcon.controller

import com.geekmk.droidcon.exception.AddItemException
import com.geekmk.droidcon.model.TodoItemDto
import com.geekmk.droidcon.usecase.AddTodoListItemUseCase
import com.geekmk.droidcon.usecase.FetchTodoListUseCase
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/todo")
class TodoListController constructor(
    val addTodoListUseCase: AddTodoListItemUseCase,
    val fetchTodoListUseCase: FetchTodoListUseCase
) {

    @Get("/items/")
    fun getTodoList(): HttpResponse<Any> {
        return HttpResponse.ok(fetchTodoListUseCase.execute())
    }

    @Post("/item/")
    fun addTodoListItem(todoItem: TodoItemDto): HttpResponse<Any> {
        return try {
            HttpResponse.created(addTodoListUseCase.execute(todoItem))
        } catch (e: AddItemException) {
            HttpResponse.serverError(e.message)
        }
    }
}
