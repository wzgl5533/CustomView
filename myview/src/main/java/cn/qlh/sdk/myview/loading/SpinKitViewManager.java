package cn.qlh.sdk.myview.loading;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

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
    private TextView tipsTv;
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


    public SpinKitViewManager(Context context){
        view = LayoutInflater.from(context).inflate(R.layout.spinkit_view_manager,null);
        alertDialog = new Dialog(context, R.style.customDialog);
        alertDialog.setCancelable(true);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setContentView(view, new LinearLayout.LayoutParams(
                (int) context.getResources().getDimension(R.dimen.progress_ly_size),
                (int) context.getResources().getDimension(R.dimen.progress_ly_size)));
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        tipsTv = (TextView) view.findViewById(R.id.tips_tv);
    }

    /**
     * 设置进度效果,如果不设置，默认ROTATING_PLANE
     * */
    public SpinKitViewManager setProgressBarStyle(int intStyle){
        whichStyle = intStyle;
        return this;
    }
    /**
     * 设置进度对话框背景颜色
     * **/
    public SpinKitViewManager setDlgBg(int color){

        view.setBackgroundColor(color);
        return this;
    }
    /**
     * 设置提示语内容
     * **/
    public SpinKitViewManager setTipsTxt(String content){

        tipsTv.setText(content);
        return this;
    }
    /**
     * 设置提示语颜色
     * **/
    public SpinKitViewManager setTipsColor(int color){
        tipsTv.setTextColor(color);
        return this;
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
