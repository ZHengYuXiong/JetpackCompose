package com.example.jetpackcomposedemo.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState

/**
 * 主页利用脚手架 Scaffold 进行页面布局
 */

@Composable
fun Home() {
    /* 使用rememberScaffoldState()修改抽屉的状态，并创建一个变量接收 */
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState, // 将状态传给Scaffold

        /* 使用组件化开发方式，将组件模块传递给页面的对应插槽位置 */
        drawerContent = { AppDrawer() },

        /*
        * 当前的bodyContent中包含两部分内容，一是顶部导航栏，二是内容主题部分
        * 传入的 scaffoldState 用于记录抽屉的状态，该状态给顶部栏组件的某一功能模块，对侧边栏进行展示与隐藏
        */
        bodyContent = { Content(scaffoldState = scaffoldState) },

        floatingActionButton = { Fab() },
        bottomBar = { BottomBar()}
    )
}

