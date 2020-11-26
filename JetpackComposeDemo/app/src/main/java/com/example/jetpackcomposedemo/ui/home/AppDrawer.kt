package com.example.jetpackcomposedemo.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.state
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemo.R
import com.example.jetpackcomposedemo.state.sudorizwan
import com.example.jetpackcomposedemo.ui.common.CustomDivider
import com.example.jetpackcomposedemo.ui.common.ThemedText
import com.example.jetpackcomposedemo.ui.common.UserInfo

/**
 * 侧边栏组件模块
 */
@Composable
fun AppDrawer() {
    val showThemeDialog = state { false }
    Surface() {
        Column {
            Column(
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)
            ) {
                Image(
                    imageResource(R.drawable.profile_image),
                    modifier = Modifier
                        .preferredSize(50.dp)
                        .clip(shape = RoundedCornerShape(25.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.preferredHeight(2.dp))
                UserInfo(user = sudorizwan) // 调用用户信息
                Spacer(modifier = Modifier.preferredHeight(16.dp))
            }
            CustomDivider() // 绘制分割线
            Column(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp,end = 16.dp)
            ) {
                SideBarListItem(
                    text = "Lists",
                    icon = R.drawable.ic_lists
                )
                SideBarListItem(
                    text = "Topics",
                    icon = R.drawable.ic_topics
                )
                SideBarListItem(
                    text = "Bookmarks",
                    icon = R.drawable.ic_bookmarks
                )
                SideBarListItem(
                    text = "Moments",
                    icon = R.drawable.ic_moments
                )
            }
            CustomDivider()
            Column(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                ThemedText(
                    text = "隐私",
                    style = TextStyle(fontSize = 18.sp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                ThemedText(
                    text = "通用",
                    style = TextStyle(fontSize = 18.sp)
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            CustomDivider()
            Column(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                ThemedText(
                    text = "帮助与反馈",
                    style = TextStyle(fontSize = 18.sp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                ThemedText(
                    text = "关于",
                    style = TextStyle(fontSize = 18.sp)
                )
            }
            Spacer(modifier = Modifier.weight(weight = 1f))

            Row(
                modifier = Modifier.fillMaxWidth()
                        .preferredHeight(40.dp),
                horizontalArrangement = Arrangement.SpaceBetween, // 水平排列

            ) {
                Button(
                    backgroundColor = Color.Transparent,
                    elevation = 0.dp,
                    onClick = { showThemeDialog.value = true }) {
                        Image(
                            imageResource(R.drawable.ic_theme),
                            modifier = Modifier.preferredSize(30.dp)
                        )
                }
                Button(
                    backgroundColor = Color.Transparent,
                    elevation = 0.dp,
                    onClick = {}) {
                    Image(
                            imageResource(R.drawable.ic_qrcode),
                            modifier = Modifier.preferredSize(30.dp)
                    )
                }
            }
        }

    }
}

/* 侧边栏列表 */
@Composable
fun SideBarListItem(text: String, icon: Int) {
    Row(
        modifier = Modifier.preferredHeight(50.dp)
    ) {
        Image(
            imageResource(icon),
            modifier = Modifier.preferredSize(24.dp)
        )
        Spacer(modifier = Modifier.preferredWidth(12.dp))
        ThemedText(
            text = text,
            style = TextStyle(fontSize = 18.sp)
        )
    }
}