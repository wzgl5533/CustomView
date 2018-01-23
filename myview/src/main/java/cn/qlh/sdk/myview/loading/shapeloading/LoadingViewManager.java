package cn.qlh.sdk.myview.loading.shapeloading;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import cn.qlh.sdk.myview.R;

/**
 * 作者：Administrator on 2017/5/8 16:44
 * 描述：设置LoadingView
 */

public class LoadingViewManager {

    private View view;
    private Dialog alertDialog;
    private LoadingView loadingView;

    public LoadingViewManager(Activity activity) {

        view = LayoutInflater.from(activity).inflate(R.layout.loading_view_manager, null);
        alertDialog = new Dialog(activity, R.style.customDialog);
        alertDialog.setCancelable(true);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setContentView(view, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        loadingView = (LoadingView) view.findViewById(R.id.loadView);
    }
    public void setLoadingViewText(String text){
        loadingView.setLoadingText(text);
    }
    public void setLoadingViewTextColor(String color){
        loadingView.setLoadingTextColor(color);
    }
    public void setLoadingViewTextSize(int unit ,int size ){
        loadingView.setLoadingTextSize(unit,size);
    }
    public void show(){
        alertDialog.show();
    }
    public void dismiss() {
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }
}
