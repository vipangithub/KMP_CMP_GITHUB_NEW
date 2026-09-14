package com.example.cmpshop.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cmpshop.theme.ThemeMode

@Composable
fun SettingsScreen(
    themeMode: ThemeMode,
    onThemeModeChange: (ThemeMode) -> Unit,
    onBackPress: () -> Unit,
    onClickMe:()-> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("TextField Example") }
            )
        }
    ) { inner ->
        Column(
            modifier = Modifier
                .fillMaxWidth().padding(inner)
                .padding(16.dp)
        ) {

            Text(
                text = "Settings"
            )

            Text(
                text = "Appearance",
                modifier = Modifier.padding(
                    top = 24.dp,
                    bottom = 8.dp
                )
            )

            ThemeOption(
                title = "System Default",
                selected = themeMode == ThemeMode.SYSTEM,
                onClick = {
                    onThemeModeChange(ThemeMode.SYSTEM)
                    onBackPress()
                }
            )

            ThemeOption(
                title = "Light",
                selected = themeMode == ThemeMode.LIGHT,
                onClick = {
                    onThemeModeChange(ThemeMode.LIGHT)
                    onBackPress()
                }
            )

            ThemeOption(
                title = "Dark",
                selected = themeMode == ThemeMode.DARK,
                onClick = {
                    onThemeModeChange(ThemeMode.DARK)
                    onBackPress()
                }
            )

            Button(
                // onClick = onClickMe
                onClick = {
                    onClickMe()
                }
            ) {
                Text(text = "Click Me")
            }
        }
    }
}

@Composable
private fun ThemeOption(
    title: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        RadioButton(
            selected = selected,
            onClick = onClick
        )

        Text(
            text = title,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}