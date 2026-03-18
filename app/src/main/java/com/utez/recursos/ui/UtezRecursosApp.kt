package com.utez.recursos.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.utez.recursos.data.FakeRepository
import com.utez.recursos.navigation.Destination
import com.utez.recursos.ui.screens.AdminDashboardScreen
import com.utez.recursos.ui.screens.ApplicantPortalScreen
import com.utez.recursos.ui.screens.GenericListScreen
import com.utez.recursos.ui.screens.GenericPlaceholderScreen
import com.utez.recursos.ui.screens.LoginScreen
import com.utez.recursos.ui.screens.NewRequestScreen
import com.utez.recursos.viewmodel.AuthViewModel

@Composable
fun UtezRecursosApp(authViewModel: AuthViewModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destination.Login.route) {
        composable(Destination.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    if (authViewModel.isAdmin) {
                        navController.navigate(Destination.Reservations.route) {
                            popUpTo(Destination.Login.route) { inclusive = true }
                        }
                    } else {
                        navController.navigate(Destination.Portal.route) {
                            popUpTo(Destination.Login.route) { inclusive = true }
                        }
                    }
                },
                onForgotPassword = { navController.navigate(Destination.ForgotPassword.route) },
                authViewModel = authViewModel,
            )
        }
        composable(Destination.ForgotPassword.route) {
            GenericPlaceholderScreen(
                title = "Recuperar contraseña",
                subtitle = "Aquí puedes conectar después tu flujo real de recuperación por correo institucional.",
                onBack = { navController.popBackStack() }
            )
        }
        composable(Destination.Portal.route) {
            ApplicantPortalScreen(
                user = authViewModel.currentUser,
                resources = FakeRepository.resources,
                requests = FakeRepository.requests,
                onNavigate = { navController.navigate(it) },
                onLogout = {
                    authViewModel.logout()
                    navController.navigate(Destination.Login.route) {
                        popUpTo(0)
                    }
                }
            )
        }
        composable(Destination.Reservations.route) {
            AdminDashboardScreen(
                user = authViewModel.currentUser,
                resources = FakeRepository.resources,
                requests = FakeRepository.requests,
                onNavigate = { navController.navigate(it) },
                onLogout = {
                    authViewModel.logout()
                    navController.navigate(Destination.Login.route) { popUpTo(0) }
                }
            )
        }
        composable(Destination.NewRequest.route) {
            NewRequestScreen(onBack = { navController.popBackStack() })
        }
        composable(Destination.RequestHistory.route) {
            GenericListScreen(
                title = "Historial de solicitudes",
                items = FakeRepository.requests.map { "${it.id} • ${it.recurso} • ${it.estado}" },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Destination.Users.route) {
            GenericListScreen(
                title = "Gestión de usuarios",
                items = FakeRepository.systemUsers.map { "${it.name} • ${it.role} • ${it.email}" },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Destination.UserRegistration.route) {
            GenericPlaceholderScreen(
                title = "Registro de usuario",
                subtitle = "Pantalla lista para conectar formulario, validaciones y guardado real.",
                onBack = { navController.popBackStack() }
            )
        }
        composable(Destination.Infrastructure.route) {
            GenericListScreen(
                title = "Infraestructura",
                items = FakeRepository.resources.filter { it.tipo == "Espacio" }.map { "${it.id} • ${it.nombre} • ${it.ubicacion}" },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Destination.Inventory.route) {
            GenericListScreen(
                title = "Inventario",
                items = FakeRepository.resources.filter { it.tipo == "Equipo" }.map { "${it.id} • ${it.nombre} • ${it.ubicacion}" },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Destination.Dashboard.route) {
            GenericPlaceholderScreen(title = "Dashboard", subtitle = "Ruta preservada del proyecto original.", onBack = { navController.popBackStack() })
        }
        composable(Destination.Audit.route) {
            GenericPlaceholderScreen(title = "Auditoría", subtitle = "Aquí puedes mapear bitácoras, cambios y eventos.", onBack = { navController.popBackStack() })
        }
        composable(Destination.Profile.route) {
            GenericPlaceholderScreen(title = "Perfil", subtitle = authViewModel.currentUser?.let { "${it.name} • ${it.email}" } ?: "Sin sesión activa", onBack = { navController.popBackStack() })
        }
        composable(Destination.Resources.route) {
            GenericListScreen(
                title = "Recursos",
                items = FakeRepository.resources.map { "${it.nombre} • ${it.tipo} • ${if (it.disponible) "Disponible" else "No disponible"}" },
                onBack = { navController.popBackStack() }
            )
        }
        composable(Destination.Settings.route) {
            GenericPlaceholderScreen(title = "Configuración", subtitle = "Pantalla base para preferencias y parámetros del sistema.", onBack = { navController.popBackStack() })
        }
        composable(Destination.Support.route) {
            GenericPlaceholderScreen(title = "Soporte", subtitle = "Centro de ayuda, FAQ o canal con TI.", onBack = { navController.popBackStack() })
        }
    }
}
