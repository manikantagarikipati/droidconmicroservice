package com.geekmk.droidcon.entity.local

import com.geekmk.droidcon.model.TodoItemDto
import io.micronaut.core.annotation.Introspected
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Introspected
@Entity
@Table(name = "todo")
data class TodoItem(
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "title", nullable = false)
    val title: String,

    @Column(name = "inserted_at")
    val insertedAt: LocalDateTime,
) {
    companion object {
        fun of(todoItem: TodoItemDto, currentTime: LocalDateTime) = TodoItem(
            title = todoItem.title,
            insertedAt = currentTime
        )
    }
}
