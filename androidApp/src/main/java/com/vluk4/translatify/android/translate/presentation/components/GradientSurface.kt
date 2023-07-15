package com.vluk4.translatify.android.translate.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape

fun Modifier.gradientSurface(shape: Shape = RectangleShape): Modifier = composed {
    if (isSystemInDarkTheme()) {
        Modifier
            .clip(shape = shape)
            .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF23262E),
                    Color(0xFF212329)
                )
            ),
            shape = shape,
        )
    } else Modifier.background(MaterialTheme.colors.surface)
}