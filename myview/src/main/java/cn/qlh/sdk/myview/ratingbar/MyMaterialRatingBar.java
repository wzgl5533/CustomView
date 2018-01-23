package cn.qlh.sdk.myview.ratingbar;

import android.content.Context;
import android.util.AttributeSet;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

/**
 * 作者：Administrator on 2017/5/10 17:52
 * 描述：扁平化评分条，在xml布局中使用，具体参考下面的网址
 * 参考网址：https://github.com/DreaminginCodeZH/MaterialRatingBar/blob/master/sample/src/main/res/layout/main_activity.xml
 */

public class MyMaterialRatingBar extends MaterialRatingBar {
    public MyMaterialRatingBar(Context context) {
        super(context);
    }

    public MyMaterialRatingBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyMaterialRatingBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
