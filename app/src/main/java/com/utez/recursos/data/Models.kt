package com.utez.recursos.data

enum class UserRole { Administrador, Personal, Estudiante }

data class User(
    val id: String,
    val email: String,
    val name: String,
    val role: UserRole,
    val initials: String,
    val phone: String? = null,
)

data class Resource(
    val id: String,
    val nombre: String,
    val tipo: String,
    val capacidad: Int? = null,
    val ubicacion: String,
    val disponible: Boolean,
)

data class ResourceRequest(
    val id: String,
    val recurso: String,
    val tipo: String,
    val solicitante: String,
    val fechaInicio: String,
    val horaInicio: String,
    val fechaDevolucion: String,
    val horaDevolucion: String,
    val motivo: String,
    val estado: String,
)
