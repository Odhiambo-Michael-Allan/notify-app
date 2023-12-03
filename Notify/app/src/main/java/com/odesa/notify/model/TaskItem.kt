package com.odesa.notify.model

import java.util.UUID

data class TaskItem (
    var description: String = "",
    var isCompleted: Boolean = false,
    val id: String = UUID.randomUUID().toString(),
    val taskId: String
) {
    val isEmpty
        get() = description.isEmpty()
}