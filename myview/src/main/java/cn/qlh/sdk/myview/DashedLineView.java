package cn.qlh.sdk.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;

/**
 * 虚线（自己可以修改宽度）
 * */
public class DashedLineView extends View
{
  private Paint paint;
  private Path path;
  private PathEffect c;
  private final float scale = 3.0F;

  public DashedLineView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public DashedLineView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public DashedLineView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    this.paint = new Paint();
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setStrokeWidth(scale * getResources().getDisplayMetrics().density);
    this.paint.setColor(getResources().getColor(R.color.color_d2));
    this.paint.setAntiAlias(true);
    this.path = new Path();
    float f = 1.0F * getResources().getDisplayMetrics().density;
    this.c = new DashPathEffect(new float[] { f, f, f, f }, 0.0F);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.paint.setPathEffect(this.c);
    int i = getMeasuredHeight();
    int j = getMeasuredWidth();
    this.path.moveTo(0.0F, 0.0F);
    if (i <= j)
      this.path.lineTo(j, 0.0F);
    while (true)
    {
      paramCanvas.drawPath(this.path, this.paint);
      path.lineTo(0.0F, i);
      return;
    }
  }
}