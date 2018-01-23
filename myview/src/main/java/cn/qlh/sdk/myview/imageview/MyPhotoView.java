package cn.qlh.sdk.myview.imageview;

import android.content.Context;
import android.util.AttributeSet;

import com.github.chrisbanes.photoview.PhotoView;

/**
 * 作者：Administrator on 2017/5/11 17:58
 * 描述：支持缩放，双击等效果
 * 参考资料：https://github.com/chrisbanes/PhotoView
 */

public class MyPhotoView extends PhotoView {
    public MyPhotoView(Context context) {
        super(context);
    }

    public MyPhotoView(Context context, AttributeSet attr) {
        super(context, attr);
    }

    public MyPhotoView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
    }

    public MyPhotoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
