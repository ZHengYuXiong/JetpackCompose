package com.example.jetpackcomposedemo.ui.home

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposedemo.state.tweets
import com.example.jetpackcomposedemo.ui.common.CustomDivider
import com.example.jetpackcomposedemo.ui.common.TweetLayout

/**
 * 主页内容组件模块
 */
@Composable
fun Content(scaffoldState: ScaffoldState) {
    Column(
            modifier = Modifier.padding(bottom = 54.dp)
    ) {
        /* 顶部导航栏 */
        TopBar(scaffoldState = scaffoldState)

        /* 主页内容主题 */
        ScrollableColumn {
            Column {
                tweets.forEach { tweet ->
                    TweetLayout(tweet)
                    CustomDivider() // 绘制横线
                }
            }
        }
    }
}

