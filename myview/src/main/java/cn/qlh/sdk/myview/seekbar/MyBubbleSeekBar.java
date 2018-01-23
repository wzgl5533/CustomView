package cn.qlh.sdk.myview.seekbar;

import android.content.Context;
import android.util.AttributeSet;

import com.xw.repo.BubbleSeekBar;

/**
 * 作者：Administrator on 2017/5/11 14:14
 * 描述：带气泡提示的滑动条
 * 参考资料：https://github.com/woxingxiao/BubbleSeekBar/blob/master/README_zh.md
 */

public class MyBubbleSeekBar extends BubbleSeekBar{
    public MyBubbleSeekBar(Context context) {
        super(context);
    }

    public MyBubbleSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyBubbleSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
