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
  
**按钮**
* TimeButton：倒计时按钮

**圆形图片**
* CircleImageView：带边框的圆形图片

## 效果介绍

----

## 进度加载类：

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

## 输入框类：

### ClearEditText

#### Use 使用方法
```
<cn.qlh.sdk.myview.edittext.ClearEditText
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

## 复选框类：

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
|sc_stroke_width|dimension|未选中时边框宽度|
|sc_color_tick|color|对勾颜色|
|sc_color_checked|color|选中时填充颜色|
|sc_color_unchecked|color|未选中时填充颜色|
|sc_color_unchecked_stroke|color|未选中时边框颜色|

---

## 按钮类：

### TimeButton

#### Use 使用方法
```
<cn.qlh.sdk.myview.button.TimeButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:tb_before_text="获取"
            app:tb_after_text="秒后获取"
            app:tb_time_span="10"/>
```

![]()
### Attrs 属性
|attr|format|description|
|---|:---|:---:|
|tb_before_text|string|点击之前显示文本|
|tb_after_text|string|点击之后显示文本|
|tb_time_span|integer|倒计时时间|

---

## 图片类：

### CircleImageView

#### Use 使用方法
```
<cn.qlh.sdk.myview.imageview.CircleImageView
            android:layout_width="@dimen/x200"
            android:layout_height="@dimen/x200"
            app:civ_border_color="@color/black"
            app:civ_border_width="@dimen/x10"
            app:civ_border_overlay="false"
            app:civ_fill_color="@color/blue"
           android:src="@drawable/arrow"/>
```

![]()
### Attrs 属性
|attr|format|description|
|---|:---|:---:|
|civ_border_width|dimension|边框宽度|
|civ_border_color|color|边框颜色|
|civ_border_overlay|boolean|边框覆盖|
|civ_fill_color|color|图片过小时，周围的填充色|
