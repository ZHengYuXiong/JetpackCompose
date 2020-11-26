package com.example.jetpackcomposedemo.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposedemo.R

/**
 * 顶部栏组件模块
 */
@Composable
fun TopBar(scaffoldState: ScaffoldState) {
    Surface(elevation = 2.dp) {
        Row(
            modifier = Modifier
                .preferredHeight(50.dp)
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,

        ) {
            IconButton(
                onClick = {
                    scaffoldState.drawerState.open()
                }
            ){
                Image(
                    imageResource(R.drawable.profile_image),
                    modifier = Modifier
                        .preferredSize(34.dp)
                        .clip(shape = RoundedCornerShape(17.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            IconButton(
                onClick = {

                }
            ){
                Image(
                    imageResource(R.drawable.ic_twitter),
                    modifier = Modifier
                        .preferredSize(22.dp)
                        .clip(shape = RoundedCornerShape(17.dp))
                )
            }
            IconButton(
                onClick = {

                }
            ){
                Image(
                    imageResource(R.drawable.ic_trends),
                    modifier = Modifier
                        .preferredSize(24.dp)
                        .clip(shape = RoundedCornerShape(17.dp))
                )
            }


        }
    }
}

