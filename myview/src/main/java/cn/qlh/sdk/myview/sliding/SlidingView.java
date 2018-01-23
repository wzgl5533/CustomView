package cn.qlh.sdk.myview.sliding;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Scroller;

public class SlidingView extends ViewGroup {

	private FrameLayout mContainer;
	private Scroller mScroller;
	private VelocityTracker mVelocityTracker;
	private int mTouchSlop;
	private float mLastMotionX;
	private float mLastMotionY;
	private static final int SNAP_VELOCITY = 1000;
	private View mLeftView;
	private View mRightView;

	public SlidingView(Context context) {
		super(context);
		init();
	}

	public SlidingView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public SlidingView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		mContainer.measure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		final int width = r - l;
		final int height = b - t;
		mContainer.layout(0, 0, width, height);
	}

	private void init() {
		mContainer = new FrameLayout(getContext());
		mContainer.setBackgroundColor(0xff000000);
		mScroller = new Scroller(getContext());
		mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
		super.addView(mContainer);
	}

	public void setView(View v) {
		if (mContainer.getChildCount() > 0) {
			mContainer.removeAllViews();
		}
		mContainer.addView(v);
	}

	@Override
	public void scrollTo(int x, int y) {
		super.scrollTo(x, y);
		postInvalidate();
	}

	@Override
	public void computeScroll() {
		if (!mScroller.isFinished()) {
			if (mScroller.computeScrollOffset()) {
				int oldX = getScrollX();
				int oldY = getScrollY();
				int x = mScroller.getCurrX();
				int y = mScroller.getCurrY();
				if (oldX != x || oldY != y) {
					scrollTo(x, y);
				}
				// Keep on drawing until the animation has finished.
				invalidate();
			} else {
				clearChildrenCache();
			}
		} else {
			clearChildrenCache();
		}
	}

	private boolean mIsBeingDragged;


	/**
	 * 实现了onTouch的分发拦截
	 */
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {

		final int action = ev.getAction();
		final float x = ev.getX();
		final float y = ev.getY();

		switch (action) {
		case MotionEvent.ACTION_DOWN:
			mLastMotionX = x;
			mLastMotionY = y;
			mIsBeingDragged = false;
			break;

		case MotionEvent.ACTION_MOVE:
			final float xDiff = Math.abs(x - mLastMotionX);
			final float yDiff = Math.abs(y - mLastMotionY);
			if (xDiff > mTouchSlop && xDiff > yDiff) {
				mIsBeingDragged = true;
				mLastMotionX = x;
			}
			Log.d("Sliding", "SlidingView_Touch:"+x+"|"+y);
			Log.d("Sliding", "SlidingView_Touch:"+xDiff+"|"+mTouchSlop+"|"+yDiff+"|"+mLastMotionY);
			Log.d("Sliding", "SlidingView_Touch:"+mIsBeingDragged);
			break;

		}
		return mIsBeingDragged;
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {

		if (mVelocityTracker == null) {
			mVelocityTracker = VelocityTracker.obtain();
		}
		mVelocityTracker.addMovement(ev);

		final int action = ev.getAction();
		final float x = ev.getX();
		final float y = ev.getY();

		switch (action) {
		case MotionEvent.ACTION_DOWN:
			if (!mScroller.isFinished()) {
				mScroller.abortAnimation();
			}
			mLastMotionX = x;
			mLastMotionY = y;
			if (getScrollX() == -getLeftMenuWidth()
					&& mLastMotionX < getLeftMenuWidth()) {
				return false;
			}

			if (getScrollX() == getRightMenuWidth()
					&& mLastMotionX > getLeftMenuWidth()) {
				return false;
			}

			break;
		case MotionEvent.ACTION_MOVE:
			if (mIsBeingDragged) {
				enableChildrenCache();
				final float deltaX = mLastMotionX - x;
				mLastMotionX = x;
				float oldScrollX = getScrollX();
				float scrollX = oldScrollX + deltaX;

				if (deltaX < 0 && oldScrollX < 0) { // left view
					final float leftBound = 0;
					final float rightBound = -getLeftMenuWidth();
					if (scrollX > leftBound) {
						scrollX = leftBound;
					} else if (scrollX < rightBound) {
						scrollX = rightBound;
					}
				} else if (deltaX > 0 && oldScrollX > 0) { // right view
					final float rightBound = getRightMenuWidth();
					final float leftBound = 0;
					if (scrollX < leftBound) {
						scrollX = leftBound;
					} else if (scrollX > rightBound) {
						scrollX = rightBound;
					}
				}

				scrollTo((int) scrollX, getScrollY());
				if (scrollX > 0) {
					mLeftView.setVisibility(View.GONE);
					mLeftView.clearFocus();
					mRightView.setVisibility(View.VISIBLE);
					mRightView.requestFocus();
				} else {
					mLeftView.setVisibility(View.VISIBLE);
					mLeftView.requestFocus();
					mRightView.setVisibility(View.GONE);
					mRightView.clearFocus();
				}
			}
			break;
		case MotionEvent.ACTION_CANCEL:
		case MotionEvent.ACTION_UP:
			if (mIsBeingDragged) {
				final VelocityTracker velocityTracker = mVelocityTracker;
				velocityTracker.computeCurrentVelocity(1000);
				int velocityX = 0;
				int oldScrollX = getScrollX();
				int dx = 0;
				if (oldScrollX < 0) {
					// 左边
					if (oldScrollX < -getLeftMenuWidth() / 2
							|| velocityX > SNAP_VELOCITY) {
						// 左侧页面划出
						dx = -getLeftMenuWidth() - oldScrollX;

					} else if (oldScrollX >= -getLeftMenuWidth() / 2
							|| velocityX < -SNAP_VELOCITY) {
						// 左侧页面关闭
						dx = -oldScrollX;
					}
				} else {
					// 右边
					if (oldScrollX > getRightMenuWidth() / 2
							|| velocityX < -SNAP_VELOCITY) {
						// 右侧页面划出
						dx = getRightMenuWidth() - oldScrollX;

					} else if (oldScrollX <= getRightMenuWidth() / 2
							|| velocityX > SNAP_VELOCITY) {
						// 右侧页面关闭
						dx = -oldScrollX;
					}
				}

				smoothScrollTo(dx);
				clearChildrenCache();

			}

			break;

		}
		if (mVelocityTracker != null) {
			mVelocityTracker.recycle();
			mVelocityTracker = null;
		}
		return true;
	}

	private int getLeftMenuWidth() {
		if (mLeftView == null) {
			return 0;
		}
		return mLeftView.getWidth();
	}

	private int getRightMenuWidth() {
		if (mRightView == null) {
			return 0;
		}
		return mRightView.getWidth();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	}

	public View getRightView() {
		return mRightView;
	}

	public void setRightView(View mRightView) {
		this.mRightView = mRightView;
	}

	public View getMenuView() {
		return mLeftView;
	}

	public void setLeftView(View mLeftView) {
		this.mLeftView = mLeftView;
	}

	void toggle() {
		int menuWidth = mLeftView.getWidth();
		int oldScrollX = getScrollX();
		if (oldScrollX == 0) {
			smoothScrollTo(-menuWidth);
		} else if (oldScrollX == -menuWidth) {
			smoothScrollTo(menuWidth);
		}
	}
	/**
	 * 打开（关闭）左侧页面
	 */
	public void showLeftView() {
		mLeftView.setVisibility(View.VISIBLE);
		mRightView.setVisibility(View.GONE);
		int menuWidth = mLeftView.getWidth();
		int oldScrollX = getScrollX();
		if (oldScrollX == 0) {
			smoothScrollTo(-menuWidth);
		} else if (oldScrollX == -menuWidth) {
			smoothScrollTo(menuWidth);
		}
	}

	/**
	 * 打开（关闭）右侧页面
	 */
	public void showRightView() {
		mLeftView.setVisibility(View.GONE);
		mLeftView.clearFocus();
		mRightView.setVisibility(View.VISIBLE);
		mRightView.requestFocus();
		int menuWidth = mRightView.getWidth();
		int oldScrollX = getScrollX();
		if (oldScrollX == 0) {
			smoothScrollTo(menuWidth);
		} else if (oldScrollX == menuWidth) {
			smoothScrollTo(-menuWidth);
		}
	}

	/**
	 * 显示中间页面
	 */
	public void showCenterView() {
		int menuWidth = mRightView.getWidth();
		int oldScrollX = getScrollX();
		if (oldScrollX == menuWidth) {
			showRightView();
		} else if (oldScrollX == -menuWidth) {
			showLeftView();
		}
	}

	void smoothScrollTo(int dx) {
		int duration = 500;
		int oldScrollX = getScrollX();
		mScroller.startScroll(oldScrollX, getScrollY(), dx, getScrollY(),
				duration);
		invalidate();
	}

	void enableChildrenCache() {
		final int count = getChildCount();
		for (int i = 0; i < count; i++) {
			final View layout = getChildAt(i);
			layout.setDrawingCacheEnabled(true);
		}
	}

	void clearChildrenCache() {
		final int count = getChildCount();
		for (int i = 0; i < count; i++) {
			final View layout = getChildAt(i);
			layout.setDrawingCacheEnabled(false);
		}
	}

}
