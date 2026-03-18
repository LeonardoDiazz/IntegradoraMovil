package com.utez.recursos.data

object FakeRepository {
    val systemUsers = listOf(
        User("user-001", "20243ds135@utez.edu.mx", "Shanny Ramos", UserRole.Administrador, "SR", "777 890 1234"),
        User("user-002", "20243ds003@utez.edu.mx", "Valeria Lagunas", UserRole.Personal, "VL", "777 123 4567"),
        User("user-003", "20243ds004@utez.edu.mx", "Luis Castelar", UserRole.Estudiante, "LC", "777 567 8901"),
    )

    val resources = listOf(
        Resource("ESP-001", "Auditorio Principal", "Espacio", 300, "Edificio A - Planta Baja", true),
        Resource("ESP-002", "Laboratorio de Cómputo 4", "Espacio", 35, "Edificio B - Piso 2", true),
        Resource("ESP-003", "Sala de Juntas Rectoría", "Espacio", 15, "Edificio Administrativo", false),
        Resource("EQP-001", "Laptop Dell Latitude 5420", "Equipo", null, "Centro de Recursos", true),
        Resource("EQP-002", "Proyector Epson PowerLite", "Equipo", null, "Centro de Recursos", true),
    )

    val requests = listOf(
        ResourceRequest("REQ-045", "Laptop Dell Latitude 5420", "Equipo", "Valeria Lagunas", "2026-03-12", "12:00", "2026-03-12", "15:00", "Exposición de Proyecto Integrador", "En préstamo"),
        ResourceRequest("REQ-046", "Proyector Epson PowerLite", "Equipo", "Luis Castelar", "2026-03-13", "09:00", "2026-03-13", "11:00", "Presentación de proyecto final", "Aprobada"),
        ResourceRequest("REQ-038", "Auditorio Principal", "Espacio", "Valeria Lagunas", "2026-03-18", "14:00", "2026-03-18", "17:00", "Presentación de Tesis", "Aprobada"),
        ResourceRequest("REQ-047", "Laboratorio de Cómputo 4", "Espacio", "Luis Castelar", "2026-03-15", "10:00", "2026-03-15", "13:00", "Práctica de programación avanzada", "Pendiente"),
    )

    fun login(email: String, password: String): User? {
        if (password.isBlank()) return null
        return systemUsers.firstOrNull { it.email.equals(email.trim(), ignoreCase = true) }
    }
}
