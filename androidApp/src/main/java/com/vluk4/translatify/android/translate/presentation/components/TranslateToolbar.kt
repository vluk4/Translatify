package com.vluk4.translatify.android.translate.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TranslateToolbar() {
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Text(
            text = "Text Translation",
            style = MaterialTheme.typography.body1,
            fontSize = 20.sp,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Divider()
    }
}