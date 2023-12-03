package com.odesa.notify.model

import java.util.UUID

data class Task (
    val id: String = UUID.randomUUID().toString(),
    val taskItemList: List<TaskItem> = mutableListOf()
)
