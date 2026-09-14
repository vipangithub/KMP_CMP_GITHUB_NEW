package com.example.cmpshop.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cmpshop.app.shared.generated.resources.Res
import cmpshop.app.shared.generated.resources.unsplash
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ListExampleCompose(
    onClickBack: () -> Unit,
) {
    val rememberListState = rememberLazyListState() // to scroll at specific pos
    val scope = rememberCoroutineScope()
    val showFloating by remember { // show floating button when item index > 10
        derivedStateOf {
            rememberListState.firstVisibleItemIndex > 10
        }
    }

    val headerHeight = 250.dp
    val toolbarHeight = 56.dp
    val density = LocalDensity.current
    val headerHeightPx = with(density) { headerHeight.toPx() }
    val toolbarHeightPx = with(density) { toolbarHeight.toPx() }

    val scrollOffset = remember {
        derivedStateOf {
            if (rememberListState.firstVisibleItemIndex == 0) {
                rememberListState.firstVisibleItemScrollOffset.toFloat()
            } else {
                headerHeightPx
            }
        }
    }

    Scaffold(
        floatingActionButton = {
            if (showFloating) {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            // rememberListState.animateScrollToItem(0)
                            rememberListState.scrollToItem(0)
                        }
                    },
                    modifier = Modifier.padding(20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = ""
                    )
                }
            }
        }
    ) { _ ->
        val dummyItems = listOf("Amit", "Vipan", "Rohan", "Muskan", "Nicky")
        val dummyHolderItems = listOf(
            DummyHolder(1, "Amit", profile = dummyItems),
            DummyHolder(2, "Vipan", profile = dummyItems),
            DummyHolder(3, "Rohan", profile = dummyItems),
            DummyHolder(4, "Muskan", profile = dummyItems),
            DummyHolder(5, "Nicky", profile = dummyItems),
            DummyHolder(6, "Amit", profile = dummyItems),
            DummyHolder(7, "Vipan", profile = dummyItems),
            DummyHolder(8, "Rohan", profile = dummyItems),
            DummyHolder(9, "Muskan", profile = dummyItems),
            DummyHolder(20, "Nicky", profile = dummyItems)
        )

        Box(modifier = Modifier.fillMaxSize()) {
            // Parallax Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(headerHeight)
                    .graphicsLayer {
                        // Translation for parallax effect
                        translationY = -scrollOffset.value / 2f
                        // Fade out effect
                        alpha = 1f - (scrollOffset.value / headerHeightPx).coerceIn(0f, 1f)
                    }
            ) {
                Image(
                    painter = painterResource(Res.drawable.unsplash),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                // Gradient overlay for better text visibility
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.5f))
                            )
                        )
                )
                Text(
                    text = "Parallax Header",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                )
            }

//        Column(
//            modifier = Modifier.padding(inner)
//                .padding(20.dp)
//                //verticalScroll(ScrollState(1)),
//            // horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                "Column Example",
//                style = TextStyle(
//                    fontSize = 20.sp
//                )
//            )
//            Column {
//                dummyItems.forEach {
//                    Text(it)
//                }
//            }
//            Text(
//                "Lazy Column Example with listitem",
//                style = TextStyle(
//                    fontSize = 20.sp
//                )
//            )
//
//            LazyColumn(
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                item {
//                    Text("Header")
//                }
//                items(dummyItems) {
//                    Text(it)
//                }
//                item {
//                    Text("Footer")
//                }
//            }
//            Text(
//                "Lazy Column Example with listitem Index",
//                style = TextStyle(
//                    fontSize = 20.sp
//                )
//            )
//            LazyColumn(
//            ) {
//                itemsIndexed(dummyHolderItems) { index, user ->
//                    Text("${index + 1}.${user.name}")
//                }
//            }
//
//            Text(
//                "Lazy Column Example with  key",
//                style = TextStyle(
//                    fontSize = 20.sp
//                )
//            )
//            LazyColumn {
//                items(
//                    items = dummyHolderItems,
//                    key = { user -> user.id }
//                ) { user ->
//                    ListRow(user)
//
//                }
//            }
//
//        }

            LazyColumn(
                state = rememberListState,
                userScrollEnabled = true, // false,
                contentPadding = PaddingValues(bottom = 20.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                // Spacer for Parallax Header
                item {
                    Spacer(modifier = Modifier.height(headerHeight))
                }

                item {
                    Text(
                        "Column Example",
                        style = TextStyle(
                            fontSize = 20.sp
                        ),
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
                    )
                }
                items(dummyItems) {
                    Text(it, modifier = Modifier.padding(horizontal = 20.dp, vertical = 4.dp))
                }
                stickyHeader {
                    Text(
                        "Lazy Column with listitem",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(horizontal = 20.dp, vertical = 10.dp)
                    )
                }
                items(dummyHolderItems) {
                    Text(it.name, modifier = Modifier.padding(horizontal = 20.dp, vertical = 4.dp))
                }

                stickyHeader {
                    Text(
                        "Lazy Column with Index",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(horizontal = 20.dp, vertical = 10.dp)
                    )
                }
                itemsIndexed(dummyHolderItems) { index, user ->
                    Text(
                        "${index + 1}.${user.name}",
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 4.dp)
                    )
                }

                stickyHeader {
                    Text(
                        "Lazy Column Example with  key",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(horizontal = 20.dp, vertical = 10.dp)
                    )
                }
                items(
                    items = dummyHolderItems,
                    key = { user -> "row_${user.id}" }
                ) { user ->
                    ListRow(user)
                }
                item {
                    Text(
                        "List with Expand Collapse",
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
                    )
                }
                items(
                    items = dummyHolderItems,
                    key = { user -> "expand_${user.id}" }
                ) { user ->
                    ListRowExpand(user)
                }
            }

            // Collapsing Toolbar Overlay
            val toolbarAlpha = (scrollOffset.value / (headerHeightPx - toolbarHeightPx)).coerceIn(0f, 1f)
            TopAppBar(
                title = {
                    Text(
                        text = "List Example",
                        modifier = Modifier.alpha(toolbarAlpha)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onClickBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = if (toolbarAlpha > 0.5f) MaterialTheme.colorScheme.onSurface else Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface.copy(alpha = toolbarAlpha),
                    titleContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = toolbarAlpha)
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun ListRow(user: DummyHolder) {
    Card(
        modifier = Modifier.padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Green,
            contentColor = Color.Blue
        ),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(user.id.toString())
            Text(user.name)
        }

    }
}

@Composable
fun ListRowExpand(user: DummyHolder) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Green,
            contentColor = Color.Blue
        ),
        onClick = {
            expanded = !expanded
        }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(user.id.toString())
                Text(user.name)
                Icon(
                    imageVector = if (!expanded) Icons.Default.ArrowDropDown else Icons.Default.KeyboardArrowUp,
                    contentDescription = if (expanded) "Collapse" else "Expand"
                )
            }
            if (expanded) {
                LazyRow(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    items(user.profile) {
                        Text(it)
                    }
                }
            }
        }

    }
}

data class DummyHolder(
    val id: Int,
    val name: String,
    val profile:List<String>
)