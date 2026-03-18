package com.utez.recursos.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.utez.recursos.data.Resource
import com.utez.recursos.data.ResourceRequest
import com.utez.recursos.data.User
import com.utez.recursos.navigation.Destination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApplicantPortalScreen(
    user: User?,
    resources: List<Resource>,
    requests: List<ResourceRequest>,
    onNavigate: (String) -> Unit,
    onLogout: () -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Portal del solicitante") },
                actions = {
                    IconButton(onClick = onLogout) {
                        Icon(Icons.Default.ExitToApp, contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp)) {
                        Text("Hola, ${user?.name ?: "Usuario"}", style = MaterialTheme.typography.headlineSmall)
                        Text("Rol: ${user?.role ?: "Sin rol"}")
                    }
                }
            }
            item {
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.fillMaxWidth()) {
                    Button(onClick = { onNavigate(Destination.NewRequest.route) }, modifier = Modifier.weight(1f)) {
                        Text("Nueva solicitud")
                    }
                    Button(onClick = { onNavigate(Destination.RequestHistory.route) }, modifier = Modifier.weight(1f)) {
                        Text("Historial")
                    }
                }
            }
            item { Text("Recursos disponibles", style = MaterialTheme.typography.titleMedium) }
            items(resources.filter { it.disponible }) { resource ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp)) {
                        Text(resource.nombre, style = MaterialTheme.typography.titleMedium)
                        Text("${resource.tipo} • ${resource.ubicacion}")
                    }
                }
            }
            item { Text("Mis solicitudes recientes", style = MaterialTheme.typography.titleMedium) }
            items(requests.filter { it.solicitante == user?.name }) { request ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp)) {
                        Text("${request.recurso} • ${request.estado}")
                        Text("${request.fechaInicio} ${request.horaInicio} - ${request.fechaDevolucion} ${request.horaDevolucion}")
                    }
                }
            }
        }
    }
}
