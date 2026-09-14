package com.example.cmpshop.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cmpshop.app.shared.generated.resources.Res
import cmpshop.app.shared.generated.resources.fitness_app_icon
import cmpshop.app.shared.generated.resources.unsplash
import org.jetbrains.compose.resources.painterResource

@Composable
fun ComposeProductScreen() {
//    Surface(
//        modifier = Modifier.fillMaxSize(),
//        color = MaterialTheme.colorScheme.primaryContainer,
//        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
//    ) {
    Box(modifier = Modifier.fillMaxSize().border(
        width = 2.dp,
        color = MaterialTheme.colorScheme.primary,
        shape = RoundedCornerShape(16.dp)
    ),) {
        Image(
            painter = painterResource(Res.drawable.unsplash),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Card(
            modifier = Modifier.fillMaxWidth().padding(20.dp).clip(
                RoundedCornerShape(20.dp)
            ).windowInsetsPadding(
                WindowInsets.safeDrawing
            ),
            colors = CardDefaults.cardColors(
                containerColor =
                    Color.Black.copy(alpha = 0.45f)
//           colors = CardDefaults.cardColors(
//               containerColor =
//                 MaterialTheme.colorScheme.primary,
//                contentColor =
//                    MaterialTheme.colorScheme.onSecondaryContainer
//            ),
           ),



        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                val spacer = Modifier.height(20.dp)

                Text(
                    text = "Product Detail",
                    style = MaterialTheme.typography.headlineLarge
                )
                Spacer(modifier = spacer)

                Box(
                    modifier = Modifier.fillMaxWidth()
                        .padding(16.dp).height(120.dp)
                        .background(
                          //  Color.Black,
                           // shape = RoundedCornerShape(16.dp)
                            // VERTICAL
//                            Brush.verticalGradient(
//                                colors = listOf(
//                                    Color.Transparent,
//                                    Color.Black.copy(alpha = 0.75f)
//                                )
//                            )
                            // HORIZONTAL
                                    Brush.horizontalGradient(
                                    colors = listOf(
                                        Color.Black.copy(alpha = 0.7f),
                                        Color.Transparent
                                    )
                                    )
                        )
                ) {
                    Image(
                        painter = painterResource(Res.drawable.fitness_app_icon),
                        contentDescription = "image",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxWidth()

                    )
                    IconButton(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter).padding(
                            top = 0.dp, start = 80.dp
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "icon",
                        )
                    }
                }
                Spacer(modifier = spacer)

                Text(
                    text = "iPhone 7 Pro Max",
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.error,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.align(Alignment.Start)
                )
                Spacer(modifier = spacer)


                Text(
                    text = "│ Latest Apple smartphone...│",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.align(Alignment.Start)
                )
                Spacer(modifier = spacer)

                OutlinedCard(
                    border = BorderStroke(
                        1.dp, MaterialTheme.colorScheme.outline
                    ),
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Description",
                            style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier.align(Alignment.Start)
                        )
                        Spacer(modifier = spacer)
                        Text(
                            text = "Some longer product text...    ",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.align(Alignment.Start)
                        )
                    }

                }


                Spacer(modifier = spacer)

                ElevatedCard(
                    elevation = CardDefaults.elevatedCardElevation(
                        defaultElevation = 6.dp
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Description",
                            style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier.align(Alignment.Start)
                        )
                        Spacer(modifier = spacer)
                        Text(
                            text = "Some longer product text...    ",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.align(Alignment.Start)
                        )
                    }

                }
                Spacer(modifier = spacer)

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Text("Add to Cart")
                }
            }
            //      }
        }
    }
}