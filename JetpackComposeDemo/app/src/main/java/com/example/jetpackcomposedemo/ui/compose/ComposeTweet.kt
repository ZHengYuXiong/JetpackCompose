package com.example.jetpackcomposedemo.ui.compose

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.jetpackcomposedemo.R
import com.example.jetpackcomposedemo.state.AppState
import com.example.jetpackcomposedemo.state.Screen
import com.example.jetpackcomposedemo.state.createNewTweet
import com.example.jetpackcomposedemo.state.navigateTo

@Preview
@Composable
fun ComposeTweet() {
    val tweetText = state { TextFieldValue(text = "") }
    Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(AppState.theme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
        ) {
            CloseButton()
            TweetButton(tweetText)
        }
        AvatarWithTextField(tweetText)
    }
}

@Composable
private fun AvatarWithTextField(tweetText: MutableState<TextFieldValue>) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp,top = 10.dp,bottom = 10.dp)
    ) {
        Image(
                imageResource(R.drawable.profile_image),
                modifier = Modifier
                        .preferredSize(34.dp)
                        .clip(shape = RoundedCornerShape(17.dp)),
                contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.weight(weight = 1f))
        TextFieldWithHint(
            modifier = Modifier.fillMaxWidth(),
            value = tweetText.value,
            onValueChange = { textFieldValue -> tweetText.value = textFieldValue },
            hint = "What's happening?"
        )
    }
}

@Composable
private fun TextFieldWithHint(
    value: TextFieldValue,
    modifier: Modifier,
    hint: String,
    onValueChange: (TextFieldValue) -> Unit
) {
    Stack() {
        TextField(
            value = value,
            modifier = modifier,
            onValueChange = onValueChange,
            keyboardType = KeyboardType.Text
        )
        if (value.text.isEmpty()) Text(
            text = hint,
            style = TextStyle(color = Color(0xFF666666), fontSize = 18.sp)
        )
    }

}

@Composable
private fun TweetButton(tweetText: MutableState<TextFieldValue>){
    Button(
        onClick = {
            createNewTweet(tweetText.value.text)
            navigateTo(Screen.Home)
        },
        shape = RoundedCornerShape(20.dp),
        backgroundColor = AppState.theme.primary
    ) {
        Text(text = "Tweet", color = Color.White)

    }
}

@Composable
private fun CloseButton() {
    IconButton(
            onClick = { navigateTo(Screen.Home)}
    ) {
        Icon(
            asset = Icons.Filled.Close,
            modifier = Modifier.size(50.dp),
            tint = AppState.theme.primary
        )
    }
}
