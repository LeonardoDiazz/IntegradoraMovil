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
fun AdminDashboardScreen(
    user: User?,
    resources: List<Resource>,
    requests: List<ResourceRequest>,
    onNavigate: (String) -> Unit,
    onLogout: () -> Unit,
) {
    val menu = listOf(
        Destination.Users,
        Destination.UserRegistration,
        Destination.Infrastructure,
        Destination.Inventory,
        Destination.Audit,
        Destination.Profile,
        Destination.Resources,
        Destination.Settings,
        Destination.Support,
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Reservaciones") },
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
                        Text("Hola, ${user?.name ?: "Administrador"}", style = MaterialTheme.typography.headlineSmall)
                        Text("Panel migrado desde React Router a Navigation Compose.")
                    }
                }
            }
            item {
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.fillMaxWidth()) {
                    StatCard("Recursos", resources.size.toString(), Modifier.weight(1f))
                    StatCard("Solicitudes", requests.size.toString(), Modifier.weight(1f))
                }
            }
            item {
                Text("Accesos rápidos", style = MaterialTheme.typography.titleMedium)
            }
            items(menu) { destination ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(destination.title, style = MaterialTheme.typography.titleMedium)
                            Text(destination.route, style = MaterialTheme.typography.bodySmall)
                        }
                        Button(onClick = { onNavigate(destination.route) }) {
                            Text("Abrir")
                        }
                    }
                }
            }
            item { Text("Solicitudes recientes", style = MaterialTheme.typography.titleMedium) }
            items(requests.take(4)) { request ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp)) {
                        Text("${request.id} • ${request.recurso}")
                        Text("${request.solicitante} • ${request.estado}")
                    }
                }
            }
        }
    }
}

@Composable
private fun StatCard(title: String, value: String, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column(Modifier.padding(16.dp)) {
            Text(title, style = MaterialTheme.typography.titleMedium)
            Text(value, style = MaterialTheme.typography.headlineMedium)
        }
    }
}
