package com.utez.recursos.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.utez.recursos.data.FakeRepository
import com.utez.recursos.data.User
import com.utez.recursos.data.UserRole

class AuthViewModel : ViewModel() {
    var currentUser by mutableStateOf<User?>(null)
        private set

    fun login(email: String, password: String): Boolean {
        val user = FakeRepository.login(email, password)
        currentUser = user
        return user != null
    }

    fun logout() {
        currentUser = null
    }

    val isAdmin: Boolean get() = currentUser?.role == UserRole.Administrador
}
