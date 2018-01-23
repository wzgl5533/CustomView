package cn.qlh.sdk.myview.loading;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.SpriteFactory;
import com.github.ybq.android.spinkit.Style;
import com.github.ybq.android.spinkit.sprite.Sprite;

import cn.qlh.sdk.myview.R;

/**
 * 作者：QLH on 2017/5/8 10:43
 * 描述：设置各种样式的loading，这个和AVLoadingIndicatorView类似
 */

public class SpinKitViewManager {

    private ProgressBar progressBar;
    private static int whichStyle = 0;
    private Dialog alertDialog;
    private View view;
    //各种效果定义
    public static final int ROTATING_PLANE = 0;
    public static final int DOUBLE_BOUNCE = 1;
    public static final int WAVE = 2;
    public static final int WANDERING_CUBES = 3;
    public static final int PULSE = 4;
    public static final int CHASING_DOTS = 5;
    public static final int THREE_BOUNCE = 6;
    public static final int CIRCLE = 7;
    public static final int CUBE_GRID = 8;
    public static final int FADING_CIRCLE = 9;
    public static final int FOLDING_CUBE = 10;
    public static final int ROTATING_CIRCLE = 11;
    public static final int MULTIPLE_PULSE = 12;
    public static final int PULSE_RING = 13;
    public static final int MULTIPLE_PULSE_RING = 14;


    public SpinKitViewManager(Activity activity){
        view = activity.getLayoutInflater().inflate(R.layout.spinkit_view_manager,null);
        alertDialog = new Dialog(activity, R.style.customDialog);
        alertDialog.setCancelable(true);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setContentView(view, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
    }

    /**
     * 设置进度效果,如果不设置，默认ROTATING_PLANE
     * */
    public void setProgressBarStyle(int intStyle){
        whichStyle = intStyle;
    }
    public void show(){
        Style style = Style.values()[whichStyle];
        Sprite drawable = SpriteFactory.create(style);
        progressBar.setIndeterminateDrawable(drawable);

        alertDialog.show();
    }

    public void  dismiss(){
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }
}
