package cn.qlh.sdk.myview.sliding;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import cn.qlh.sdk.myview.sliding.SlidingView;

public class SlidingMenu extends RelativeLayout {

	private SlidingView mSlidingView;
	private View mLeftView;
	private View mRightView;
	// menu width
	private int alignScreenWidth;

	public SlidingMenu(Context context) {
		super(context);
	}

	public SlidingMenu(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SlidingMenu(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public void setAlignScreenWidth(int alignScreenWidth) {
		this.alignScreenWidth = alignScreenWidth;
	}

	public void setLeftView(View view) {
		LayoutParams behindParams = new LayoutParams(alignScreenWidth,
				LayoutParams.MATCH_PARENT);
		addView(view, behindParams);
		mLeftView = view;
	}

	public void setRightView(View view) {
		LayoutParams behindParams = new LayoutParams(alignScreenWidth,
				LayoutParams.MATCH_PARENT);
		behindParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		addView(view, behindParams);
		mRightView = view;
	}

	public void setCenterView(View view) {
		LayoutParams aboveParams = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		mSlidingView = new SlidingView(getContext());
		addView(mSlidingView, aboveParams);
		mSlidingView.setView(view);
		mSlidingView.invalidate();
		mSlidingView.setLeftView(mLeftView);
		mSlidingView.setRightView(mRightView);
	}

	public void showLeftView() {
		mSlidingView.showLeftView();
	}

	public void showRightView() {
		mSlidingView.showRightView();
	}

	public void showCenterView() {
		mSlidingView.showCenterView();
	}

}
