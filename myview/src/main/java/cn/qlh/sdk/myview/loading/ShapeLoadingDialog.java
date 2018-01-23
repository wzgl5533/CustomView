package cn.qlh.sdk.myview.loading;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;

import cn.qlh.sdk.myview.R;
import cn.qlh.sdk.myview.loading.shapeloading.LoadingView;


/**
 * Created by zzz40500 on 15/6/15.
 * 直接生成对象使用,主要是一个对话框窗口，默认的是白色背景，
 * 可以自己定义背景的形状、颜色等
 *ShapeLoadingDialog shapeLoadingDialog = new ShapeLoadingDialog(this);
 *shapeLoadingDialog.show();
 *
 */
public class ShapeLoadingDialog {



    private Context mContext;
    private Dialog mDialog;
    private LoadingView mLoadingView;
    private View mDialogContentView;


    public ShapeLoadingDialog(Context context) {
        this.mContext=context;
        init();
    }

    private void init() {
        mDialog = new Dialog(mContext, R.style.custom_dialog);
        mDialogContentView= LayoutInflater.from(mContext).inflate(R.layout.layout_dialog,null);


        mLoadingView= (LoadingView) mDialogContentView.findViewById(R.id.loadView);
        mDialog.setContentView(mDialogContentView);
        mDialog.setCanceledOnTouchOutside(false);
    }

    public void setBackground(int color){
        GradientDrawable gradientDrawable= (GradientDrawable) mDialogContentView.getBackground();
        gradientDrawable.setColor(color);
    }

    public void setLoadingText(CharSequence charSequence){
        mLoadingView.setLoadingText(charSequence);
    }

    public void show(){
        mDialog.show();

    }

    public void dismiss(){
        mDialog.dismiss();
    }

    public Dialog getDialog(){
        return  mDialog;
    }

    public void setCanceledOnTouchOutside(boolean cancel){
        mDialog.setCanceledOnTouchOutside(cancel);
    }
}
