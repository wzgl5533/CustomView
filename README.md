# CustomView

# 简介

本库主要用于自己的项目，收集很多优秀开源的组件，对其进行封装和归纳，方便使用，再此感谢，各位小伙伴也可以使用或者修改维护自己的库，喜欢的可以打个星。

# 模块分类

* Loading:主要是一些加载进度对话框


# 效果介绍
### Loading   开源地址：https://github.com/ybq/Android-SpinKit
![](https://github.com/wzgl5533/CustomView/blob/master/myview/src/main/java/cn/qlh/sdk/myview/loading/spinkit_view.gif)

使用方法：
\\\
SpinKitViewManager loading = new SpinKitViewManager(this);
        loading.setProgressBarStyle(SpinKitViewManager.CUBE_GRID)
                .setDlgBg(Color.parseColor("#18AD5C"))
                .setTipsTxt("欢迎...")
                .show();
\\\

