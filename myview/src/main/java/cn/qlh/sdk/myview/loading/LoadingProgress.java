package cn.qlh.sdk.myview.loading;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.qlh.sdk.myview.R;

/**
 * 作者：Administrator on 2017/3/27 14:09
 * 描述：直接生成对象使用，直接效果请参考有道云笔记：[Progress Loading  进度提示] 板块
 */

public class LoadingProgress {

    private View view;
    private Dialog alertDialog;

    public LoadingProgress(Activity activity) {

        view = activity.getLayoutInflater().inflate(R.layout.progress_loading, null);

        alertDialog = new Dialog(activity, R.style.customDialog);
        alertDialog.setCancelable(true);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setContentView(view, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    public void show() {
        alertDialog.show();

        alertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
                    setTip("请稍后……");
                    alertDialog.dismiss();
                }
                return false;
            }
        });
    }

    public void dismiss() {
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }

    /**
     * 设置提示内容
     * @param tip 内容
     * **/
    public LoadingProgress setTip(String tip) {

        TextView textView = (TextView) alertDialog.getWindow().findViewById(R.id.tips);
        textView.setText(tip);
        return this;
    }

    /**
     * 设置字体大小
     * @param unit     字体的单位 小于0是默认单位sp
     * @param textSize 字体大小
     */
    public LoadingProgress setTextSize(int unit, int textSize) {

        TextView textView = (TextView) alertDialog.getWindow().findViewById(R.id.tips);
        if (unit < 0){
            unit = TypedValue.COMPLEX_UNIT_SP;
        }
            textView.setTextSize(unit, textSize);
        return this;
    }

    /**
     * 设置提示内容
     * @param color 颜色
     * **/
    public LoadingProgress setTextColor(String color) {

        TextView textView = (TextView) alertDialog.getWindow().findViewById(R.id.tips);
        textView.setTextColor(Color.parseColor(color));
        return this;
    }

    /**
     * 设置字体
     * @param typeFace 字体
     * **/
    public LoadingProgress setTypeFace(Typeface typeFace) {


        TextView textView = (TextView) alertDialog.getWindow().findViewById(R.id.tips);
        textView.setTypeface(typeFace);
        return this;
    }
}
