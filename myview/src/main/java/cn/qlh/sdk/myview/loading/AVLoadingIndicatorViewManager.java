package cn.qlh.sdk.myview.loading;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.wang.avi.AVLoadingIndicatorView;

import cn.qlh.sdk.myview.R;

/**
 * 作者：Administrator on 2017/5/8 15:14
 * 描述：设置各种样式的loading
 */

public class AVLoadingIndicatorViewManager {

    private View mView;
    private AVLoadingIndicatorView mAvLoadingIndicatorView = null;
    private Dialog mAlertDialog;
    private static int mWhichStyle = 0;
    //全部样式
    public static final int BALL_PULSE_INDICATOR = 0;
    public static final int BALL_GRID_PULSE_INDICATOR = 1;
    public static final int BALL_CLIP_ROTATE_INDICATOR = 2;
    public static final int BALL_CLIP_ROTATE_PULSE_INDICATOR = 3;
    public static final int SQUARE_SPIN_INDICATOR = 4;
    public static final int BALL_CLIP_ROTATE_MULTIPLE_INDICATOR = 5;
    public static final int BALL_PULSE_RISE_INDICATOR = 6;
    public static final int BALL_ROTATE_INDICATOR = 7;
    public static final int CUBE_TRANSITION_INDICATOR = 8;
    public static final int BALL_ZIGZAG_INDICATOR = 9;
    public static final int BALL_ZIGZAG_DEFLECT_INDICATOR = 10;
    public static final int BALL_TRIANGLE_PATH_INDICATOR = 11;
    public static final int BALL_SCALE_INDICATOR = 12;
    public static final int LINE_SCALE_INDICATOR = 13;
    public static final int LINE_SCALE_PARTY_INDICATOR = 14;
    public static final int BALL_SCALE_MULTIPLE_INDICATOR = 15;
    public static final int BALL_PULSE_SYNC_INDICATOR = 16;
    public static final int BALL_BEAT_INDICATOR = 17;
    public static final int LINE_SCALE_PULSE_OUT_INDICATOR = 18;
    public static final int LINE_SCALE_PULSE_OUT_RAPID_INDICATOR = 19;
    public static final int BALL_SCALE_RIPPLE_INDICATOR = 20;
    public static final int BALL_SCALE_RIPPLE_MULTIPLE_INDICATOR = 21;
    public static final int BALL_SPIN_FADE_LOADER_INDICATOR = 22;
    public static final int LINE_SPIN_FADE_LOADER_INDICATOR = 23;
    public static final int TRIANGLE_SKEW_SPIN_INDICATOR = 24;
    public static final int PACMAN_INDICATOR = 25;
    public static final int BALL_GRID_BEAT_INDICATOR = 26;
    public static final int SeMI_CIRCLE_SPIN_INDICATOR = 27;
    public static final int MYCUSTOMINDICATOR = 28;



    public AVLoadingIndicatorViewManager(Activity activity) {

        mView = LayoutInflater.from(activity).inflate(R.layout.avl_loading_indicator_view_manager, null);
        mAlertDialog = new Dialog(activity, R.style.customDialog);
        mAlertDialog.setCancelable(true);
        mAlertDialog.setCanceledOnTouchOutside(false);
        mAlertDialog.setContentView(mView, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        mAvLoadingIndicatorView = (AVLoadingIndicatorView) mView.findViewById(R.id.indicator);
    }
    /**
     * 设置进度效果,如果不设置，默认BallPulseIndicator
     * */
    public void setAvLoadingIndicatorViewStyle(int intStyle){
        mWhichStyle = intStyle;}
    private void initView(){
        String indicator = INDICATORS[mWhichStyle];
        mAvLoadingIndicatorView.setIndicator(indicator);
    }
    public void show(){
        initView();
        mAvLoadingIndicatorView.show();
        mAlertDialog.show();
    }
    public void dismiss(){
        mAvLoadingIndicatorView.hide();
        if (mAlertDialog != null && mAlertDialog.isShowing()) {
            mAlertDialog.dismiss();
        }
    }

    private static final String[] INDICATORS=new String[]{
            "BallPulseIndicator",
            "BallGridPulseIndicator",
            "BallClipRotateIndicator",
            "BallClipRotatePulseIndicator",
            "SquareSpinIndicator",
            "BallClipRotateMultipleIndicator",
            "BallPulseRiseIndicator",
            "BallRotateIndicator",
            "CubeTransitionIndicator",
            "BallZigZagIndicator",
            "BallZigZagDeflectIndicator",
            "BallTrianglePathIndicator",
            "BallScaleIndicator",
            "LineScaleIndicator",
            "LineScalePartyIndicator",
            "BallScaleMultipleIndicator",
            "BallPulseSyncIndicator",
            "BallBeatIndicator",
            "LineScalePulseOutIndicator",
            "LineScalePulseOutRapidIndicator",
            "BallScaleRippleIndicator",
            "BallScaleRippleMultipleIndicator",
            "BallSpinFadeLoaderIndicator",
            "LineSpinFadeLoaderIndicator",
            "TriangleSkewSpinIndicator",
            "PacmanIndicator",
            "BallGridBeatIndicator",
            "SemiCircleSpinIndicator",
            "com.wang.avi.sample.MyCustomIndicator"
    };

}
