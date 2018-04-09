# CustomView

## 简介

本库主要用于自己的项目，收集很多优秀开源的组件，对其进行封装和归纳，方便使用，再此感谢，各位小伙伴也可以使用或者修改维护自己的库，喜欢的可以打个星。

## 模块分类

**进度加载类**
  * Loading:主要是一些加载进度对话框
**输入框**
  * ClearEditText：可以自己自定义右边删除图标以及它的宽高
**复选框**
  * SmoothCheckBox：可以自定义颜色

## 效果介绍
### Loading   开源地址：https://github.com/ybq/Android-SpinKit
![](https://github.com/wzgl5533/CustomView/blob/master/myview/src/main/java/cn/qlh/sdk/myview/loading/spinkit_view.gif)

#### Use 使用方法
```
SpinKitViewManager loading = new SpinKitViewManager(this);
loading.setProgressBarStyle(SpinKitViewManager.CUBE_GRID)
                .setDlgBg(Color.parseColor("#18AD5C"))
                .setTipsTxt("欢迎...")
                .show();
```
![](https://github.com/wzgl5533/CustomView/blob/master/screenshot/Screenshot_2018-03-02-13-29-07.jpeg)

----

### ClearEditText

#### Use 使用方法
```
<cn.qlh.sdk.myview.edittext.MyClearEditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:edt_delete_icon_width="@dimen/x100"
            app:edt_delete_icon_height="@dimen/x100" />       
```
#### Attrs 属性
|attr|format|description|
|---|:---|:---:|
|edt_delete_icon_width|dimension|右边删除图标宽度|
|edt_delete_icon_height|dimension|右边删除图标高度|

---

### SmoothCheckBox  开源地址: https://github.com/andyxialm/SmoothCheckBox

#### Use 使用方法
```
<cn.qlh.sdk.myview.checkbox.SmoothCheckBox
        android:layout_width="40dp"
         android:layout_height="40dp"
         app:stroke_width="2dp"
         app:color_checked="@color/colorAccent"
         app:color_unchecked="@color/blue"
         app:color_unchecked_stroke="#00FF00"
         app:color_tick="#FF0000"/>     
```

![](https://github.com/andyxialm/SmoothCheckBox/blob/master/art/smoothcb.gif?raw=true)
### Attrs 属性
|attr|format|description|
|---|:---|:---:|
|duration|integer|动画持续时间|
|stroke_width|dimension|未选中时边框宽度|
|color_tick|color|对勾颜色|
|color_checked|color|选中时填充颜色|
|color_unchecked|color|未选中时填充颜色|
|color_unchecked_stroke|color|未选中时边框颜色|

---

