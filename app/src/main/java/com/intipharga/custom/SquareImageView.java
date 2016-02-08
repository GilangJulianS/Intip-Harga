package com.intipharga.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.intipharga.activity.R;

/**
 * Created by gilang on 21/11/2015.
 */
public class SquareImageView extends ImageView {

	public static final int REFERENCE_WIDTH = 0;
	public static final int REFERENCE_HEIGHT = 1;
	private int reference;

	public SquareImageView(Context context) {
		super(context);
	}

	public SquareImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SquareImageView, 0, 0);
		reference = a.getInteger(R.styleable.SquareImageView_reference, REFERENCE_WIDTH);
	}

	public SquareImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		if(reference == REFERENCE_WIDTH) {
			int width = getMeasuredWidth();
			setMeasuredDimension(width, width);
		}else if(reference == REFERENCE_HEIGHT){
			int height = getMeasuredHeight();
			setMeasuredDimension(height, height);
		}


	}



}
