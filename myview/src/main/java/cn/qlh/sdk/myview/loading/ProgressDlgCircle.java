/**
 * @项目名称: EnjoyRunApp
 * @文件名称: EJRAlertDlg.java
 * @版权声明: 本文件仅限于合肥寰景信息科技有限公司内部传阅，禁止外泄以及用于其他商业目的。
 * @copyRight: 2013 www.vrview.cn Inc. All rights reserved. 
 */

package cn.qlh.sdk.myview.loading;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.qlh.sdk.myview.R;


/**
 * @描述:自定义的进度对话框
 * @创建者: QLH
 * @创建日期: 2017-3-27
 * 直接生成对象使用
 */

@SuppressLint("InflateParams")
public class ProgressDlgCircle {

	public Dialog alertDialog;

	public ProgressDlgCircle(Activity activity) {

		View v = activity.getLayoutInflater().inflate(R.layout.dialog_process, null);

		LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);
		ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
		// 加载动画
		Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(activity, R.anim.animation);
		// 使用ImageView显示动画
		spaceshipImage.startAnimation(hyperspaceJumpAnimation);

		alertDialog = new Dialog(activity, R.style.customDialog);
		alertDialog.setCancelable(true);
		alertDialog.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失
		alertDialog.setContentView(layout, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));
	}
	public void show() {
		alertDialog.show();
		alertDialog.setOnKeyListener(new OnKeyListener() {
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

	public ProgressDlgCircle setTip(String tip) {
		TextView tipView = (TextView) alertDialog.getWindow().findViewById(R.id.tip);
		tipView.setText(tip);
		return this;
	}
}
