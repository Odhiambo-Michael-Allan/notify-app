package com.odesa.notify.model

import java.util.UUID

data class Task(
    var description: String = "",
    var isCompleted: Boolean = false,
    val id: String = UUID.randomUUID().toString()
) {
    val isActive
        get() = !isCompleted
    val isEmpty
        get() = description.isEmpty()
}
