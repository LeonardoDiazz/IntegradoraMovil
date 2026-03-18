package com.utez.recursos.navigation

sealed class Destination(val route: String, val title: String) {
    data object Login : Destination("login", "Login")
    data object ForgotPassword : Destination("forgot-password", "Recuperar contraseña")
    data object Portal : Destination("portal", "Portal del solicitante")
    data object Dashboard : Destination("dashboard", "Dashboard")
    data object NewRequest : Destination("new-request", "Nueva solicitud")
    data object RequestHistory : Destination("request-history", "Historial de solicitudes")
    data object Users : Destination("users", "Gestión de usuarios")
    data object UserRegistration : Destination("users/new", "Registro de usuario")
    data object Infrastructure : Destination("infrastructure", "Infraestructura")
    data object Inventory : Destination("inventory", "Inventario")
    data object Reservations : Destination("reservations", "Reservaciones")
    data object Audit : Destination("audit", "Auditoría")
    data object Profile : Destination("profile", "Perfil")
    data object Resources : Destination("resources", "Recursos")
    data object Settings : Destination("settings", "Configuración")
    data object Support : Destination("support", "Soporte")
}
