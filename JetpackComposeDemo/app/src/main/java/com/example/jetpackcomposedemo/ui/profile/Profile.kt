package com.example.jetpackcomposedemo.ui.profile

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.WithConstraints
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.jetpackcomposedemo.R
import com.example.jetpackcomposedemo.models.User
import com.example.jetpackcomposedemo.state.*
import com.example.jetpackcomposedemo.ui.common.CustomDivider
import com.example.jetpackcomposedemo.ui.common.TweetLayout
import com.example.jetpackcomposedemo.ui.common.UserInfo

/**
 * 个人资料信息模块
 */
@Preview
@Composable
fun Profile() {
    WithConstraints {
        ScrollableColumn (
                modifier = Modifier.background(AppState.theme.surface)
        ){
            val constraints = DecoupledConstraints() // 接收返回的ConstraintSet

            ConstraintLayout(constraints) { //将ConstraintSet作为参数传递给 ConstraintLayout

                // 调用组件模块进行页面布局
                Banner()
                ProfileContent(sudorizwan)
                FollowBtn()
                TopBar()
                Avatar(sudorizwan)
            }
        }
    }
}

/**
 * 返回 ConstraintSet
 */
@Composable
private fun DecoupledConstraints() : ConstraintSet {
    return ConstraintSet {
        //创建约束
        val banner = createRefFor("banner")
        val avatar = createRefFor("avatar")
        val followButton = createRefFor("followButton")
        val userInfo = createRefFor("userInfo")
        val closeButton = createRefFor("closeButton")
        val moreButton = createRefFor("moreButton")


        /**
         * 使用 constrain修饰符提供约束，该修饰符将引用作为参数
         * 使用 linkTo指定约束
         */
        constrain(banner) {
            top.linkTo(parent.top)
        }
        constrain(closeButton){
            top.linkTo(parent.top)
            absoluteLeft.linkTo(parent.absoluteLeft)
        }

        constrain(moreButton){
            top.linkTo(parent.top)
            absoluteRight.linkTo(parent.absoluteRight)
        }
        constrain(avatar) {
            top.linkTo(banner.top,margin = 140.dp)
            absoluteLeft.linkTo(parent.absoluteLeft, margin = 16.dp)
        }
        constrain(followButton) {
            top.linkTo(banner.bottom,margin = 30.dp)
            absoluteRight.linkTo(parent.absoluteRight,margin = 16.dp)
        }
        constrain(userInfo) {
            top.linkTo(banner.bottom)
        }
    }
}

/**
 * 该模块用于编写用户信息，并指定对应的约束
 */
@Composable
private fun ProfileContent(user: User) {
    Column(
            modifier = Modifier.layoutId("userInfo")
    ) {
        Column(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        ) {
            Spacer(modifier = Modifier.preferredHeight(44.dp))
            UserInfo(
                    user = user,
                    showBio = true
            )
            Spacer(modifier = Modifier.preferredHeight(16.dp))
        }
        CustomDivider()
        tweets.filter { it.user == user }.forEach { tweet ->
            TweetLayout(tweet)
            CustomDivider()
        }
    }
}

/**
 * 该模块用于编写用户头像，并指定对应的约束
 */
@Composable
private fun Avatar(user: User) {
    Image(
            imageResource(user.avatar),
            modifier = Modifier
                    .preferredSize(80.dp)
                    .clip(shape = RoundedCornerShape(40.dp))
                    .layoutId("avatar")
                    .drawBorder(
                            border = Border(size = 3.dp, color = AppState.theme.surface),
                            shape = RoundedCornerShape(40.dp)
                    ),
            contentScale = ContentScale.Crop
    )
}

/**
 * 该模块用于编写顶部模块，并指定对应的约束
 */
@Composable
private fun TopBar() {
    Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
                modifier = Modifier.layoutId("closeButton"),
                onClick = { navigateTo(Screen.Home) }) {
            Icon(asset = Icons.Filled.ArrowBack, tint = Color.White)
        }

        IconButton(modifier = Modifier.layoutId("moreButton"), onClick = {}) {
            Icon(asset = Icons.Filled.MoreVert, tint = Color.White)
        }
    }
}

/**
 * 该模块用于编写按钮，并指定对应的约束
 */
@Composable
private fun FollowBtn() {
    Button(
            modifier = Modifier.layoutId("followButton"),
            onClick = {
            },
            shape = RoundedCornerShape(20.dp),
            backgroundColor = AppState.theme.surface,
            border = BorderStroke(1.dp, AppState.theme.primary)
    ) {
        Text(text = "Follow", color = AppState.theme.primary)
    }
}

/**
 * 该模块用于编写顶部banner，并指定对应的约束
 */
@Composable
private fun Banner() {
    Image(
        imageResource(R.drawable.profile_banner),
        modifier = Modifier
            .preferredHeight(180.dp)
            .fillMaxWidth()
            .layoutId("banner"),
        contentScale = ContentScale.Crop
    )
}
