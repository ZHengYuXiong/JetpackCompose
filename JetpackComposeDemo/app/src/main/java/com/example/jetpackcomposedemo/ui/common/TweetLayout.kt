package com.example.jetpackcomposedemo.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposedemo.R
import com.example.jetpackcomposedemo.models.Tweet
import com.example.jetpackcomposedemo.state.Screen
import com.example.jetpackcomposedemo.state.navigateTo

/**
 * 内容主体
 */
@Composable
fun TweetLayout(tweet: Tweet) {
    Row(modifier = Modifier.padding(all = 10.dp)) {
        UserAvatar(tweet)
        Spacer(modifier = Modifier.preferredSize(12.dp))
        Column {
            NameAndUserName(tweet)
            Spacer(modifier = Modifier.preferredSize(1.dp))
            TweetAndImage(tweet)
            Spacer(modifier = Modifier.preferredSize(10.dp))
            TweetActions(tweet)
        }
    }
}

@Composable
private fun TweetActions(tweet: Tweet) {

}

@Composable
private fun TweetAndImage(tweet: Tweet) {
    ThemedText(
        text = tweet.tweet,
        style = TextStyle(fontSize = 14.sp)
    )
    if (tweet.image != null) {
        Spacer(modifier = Modifier.preferredHeight(10.dp))
        Image(
            imageResource(tweet.image),
            modifier = Modifier
                .preferredHeight(180.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(2.dp)),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun NameAndUserName(tweet: Tweet) {
    Row() {
        ThemedText(
            text = tweet.user.name,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
        )
        if (tweet.user.verified) {
            Spacer(modifier = Modifier.preferredSize(2.dp))
            Image(
                imageResource(R.drawable.ic_verified),
                modifier = Modifier.preferredSize(16.dp)
            )
        }
        Spacer(modifier = Modifier.preferredSize(5.dp))
        GrayText(text = "@${tweet.user.username} · ${tweet.timeAgo()}")
    }
}

@Composable
private fun UserAvatar(tweet: Tweet) {
    IconButton(
            onClick = { navigateTo(Screen.Profile(tweet.user)) }
    ) {
        Image(
            imageResource(tweet.user.avatar),
            modifier = Modifier
                    .preferredSize(50.dp)
                    .clip(shape = RoundedCornerShape(25.dp)),
            contentScale = ContentScale.Crop
        )
    }

}
