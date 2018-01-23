package cn.qlh.sdk.myview.navigation;

import android.content.Context;
import android.util.AttributeSet;

import devlight.io.library.ntb.NavigationTabBar;

/**
 * 作者：Administrator on 2017/5/12 09:24
 * 描述：底部导航，导航可以在Bottom、Left、Top、Right四个方向上，具体参考文档
 * 参考资料：https://github.com/Devlight/NavigationTabBar
 */

public class MyNavigationTabBar extends NavigationTabBar {
    public MyNavigationTabBar(Context context) {
        super(context);
    }

    public MyNavigationTabBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyNavigationTabBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
