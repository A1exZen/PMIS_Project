package com.example.lab0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.lab0.ui.theme.AppTheme
import com.example.lab0.ui.theme.Nunito_Font


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkTheme by remember { mutableStateOf(true) }

            AppTheme(darkTheme = isDarkTheme) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    AboutScreen(onThemeSwitch = {
                        isDarkTheme = !isDarkTheme
                    }, isDarkTheme = isDarkTheme)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(onThemeSwitch: () -> Unit = {}, isDarkTheme: Boolean = true) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    //------------------------Main Container------------------------
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Transparent,
                titleContentColor = MaterialTheme.colorScheme.onBackground,
            ),
            title = {
                Text(
                    stringResource(R.string.about_title),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    overflow = TextOverflow.Ellipsis
                )
            },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "arrow back"
                    )
                }
            },
            scrollBehavior = scrollBehavior,
        )

        //------------------------Body Container------------------------
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //------------------------AppName+Version Container------------------------
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(top = 36.dp)
                )
                Text(
                    text = "Version " + stringResource(id = R.string.app_version),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 5.dp)
                )
            }

            //------------------------List Container------------------------
            Box(contentAlignment = Alignment.Center) {
                LazyColumn(
                    contentPadding = PaddingValues(2.dp),
                    verticalArrangement = Arrangement.spacedBy(7.dp)
                ) {
                    item { HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp)) }
                    item {
                        CategoryItem(
                            title = "Privacy",
                            icon = Icons.Outlined.Lock,
                            onClick = { /*TODO*/ })
                    }
                    item {
                        CategoryItem(
                            title = "Contact Support",
                            icon = Icons.Outlined.Call,
                            onClick = { /*TODO*/ })
                    }
                    item { HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp)) }

                    item {
                        CategoryItem(
                            title = "Send Feedback",
                            icon = Icons.Outlined.Email,
                            onClick = { /*TODO*/ })
                    }
                    item {
                        CategoryItem(
                            title = "Open in Google Play",
                            icon = Icons.Outlined.ShoppingCart,
                            onClick = { /*TODO*/ })
                    }
                    item {
                        CategoryItem(
                            title = "Rate us",
                            icon = Icons.Outlined.Star,
                            onClick = { /*TODO*/ })
                    }
                    item { HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp)) }

                }
            }

//            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp, 15.dp, 40.dp, 15.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                val iconTint = if (isDarkTheme) Color.White else Color.Black
                val iconSize = 35.dp
                Image(
                    painter = painterResource(id = R.drawable.ic_telegram),
                    contentDescription = "telegram icon",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(iconSize),
                    colorFilter = tint(iconTint)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_like),
                    contentDescription = "like icon",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(iconSize),
                    colorFilter = tint(iconTint)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_github),
                    contentDescription = "github icon",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(iconSize),
                    colorFilter = tint(iconTint)
                )
            }
//            FilledIconToggleButton(
//                checked = isDarkTheme,
//                modifier = Modifier.align(Alignment.End),
//                onCheckedChange = { onThemeSwitch() }) {
//                if (isDarkTheme) {
//                    Icon(Icons.Filled.Lock, contentDescription = "Theme toggle")
//                } else {
//                    Icon(Icons.Outlined.Lock, contentDescription = "Theme toggle")
//                }
//            }
        }
    }
}

@Composable
fun CategoryItem(title: String, icon: ImageVector, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            Icon(
                icon, contentDescription = null, modifier = Modifier.size(28.dp),
                tint = MaterialTheme.colorScheme.onSurface
            )
            Text(title, style = MaterialTheme.typography.bodyLarge)
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    AppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
        ) {
            AboutScreen()
        }
    }
}