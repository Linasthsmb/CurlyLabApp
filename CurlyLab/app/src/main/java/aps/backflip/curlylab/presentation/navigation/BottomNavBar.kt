package aps.backflip.curlylab.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import aps.backflip.curlylab.ui.theme.DarkGreen
import aps.backflip.curlylab.ui.theme.LightBeige

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.News,
        BottomNavItem.Profile
    )

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(LightBeige),
        containerColor = Color.Transparent
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        items.forEach { navItem ->
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = stringResource(id = navItem.titleRes)
                    )
                },
                label = {
                    Text(text = stringResource(id = navItem.titleRes))
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = DarkGreen,
                    selectedTextColor = DarkGreen,
                    indicatorColor = DarkGreen.copy(alpha = 0.2f)
                )
            )
        }
    }
}