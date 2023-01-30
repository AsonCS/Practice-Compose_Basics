package com.example.practice_composebasics.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

internal data class Person(
    val logo: ImageVector = Icons.Filled.Person,
    val fullName: String = "Anderson Costa da Silva",
    val role: String = "Android Developer, Fullstack",
    val phoneNumber: String = "+55 11 91234-5678",
    val userName: String = "AsonCS",
    val email: String = "asoncs@gamil.com"
)
