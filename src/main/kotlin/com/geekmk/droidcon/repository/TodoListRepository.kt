package com.geekmk.droidcon.repository

import com.geekmk.droidcon.entity.local.TodoItem
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface TodoListRepository : CrudRepository<TodoItem, Long>
