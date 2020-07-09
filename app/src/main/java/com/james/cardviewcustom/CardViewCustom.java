package com.james.cardviewcustom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import java.util.Random;

public class CardViewCustom extends CardView {
    private GradientDrawable shape;
    private LayoutParams params;

    public CardViewCustom(@NonNull Context context) {
        this(context,null);
    }

    @SuppressLint("PrivateResource")
    public CardViewCustom(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, R.attr.cardViewStyle);
    }

    public CardViewCustom(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CardViewCustom, defStyleAttr,
                R.style.CardViewCustom);


        int colorMain = a.getColor(R.styleable.CardViewCustom_mainColor,0);
        boolean isRandomBgColorCv = a.getBoolean(R.styleable.CardViewCustom_mainColor,false);

        float marginLeft = a.getDimension(R.styleable.CardViewCustom_mainMarginLeft,0);
        float marginRight = a.getDimension(R.styleable.CardViewCustom_mainMarginRight,0);
        float marginTop = a.getDimension(R.styleable.CardViewCustom_mainMarginTop,0);
        float marginBottom = a.getDimension(R.styleable.CardViewCustom_mainMarginBottom,0);

        float radius = a.getDimension(R.styleable.CardViewCustom_mainCornerRadius,0);
        float radiusTopLeft = a.getDimension(R.styleable.CardViewCustom_mainRadiusTopLeft,0);
        float radiusBottomLeft = a.getDimension(R.styleable.CardViewCustom_mainRadiusBottomLeft,0);
        float radiusTopRight = a.getDimension(R.styleable.CardViewCustom_mainRadiusTopRight,0);
        float radiusBottomRight = a.getDimension(R.styleable.CardViewCustom_mainRadiusBottomRight,0);

        if(isRandomBgColorCv){
            setRandomBackgroundColorCardView();
        }

        // Set the CardView layoutParams
        params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT
        );

        params.setMargins((int)marginLeft,(int)marginTop,(int)marginRight,(int)marginBottom);

        shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);

        //Set radius
        if(radius != 0){
            shape.setCornerRadius(radius);
        }else{
            shape.setCornerRadii(new float[]{radiusTopLeft, radiusTopLeft, radiusTopRight, radiusTopRight, radiusBottomRight, radiusBottomRight, radiusBottomLeft, radiusBottomLeft});
        }

        shape.setColor(colorMain);

        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackground(shape);
        frameLayout.setLayoutParams(params);

        addView(frameLayout);
    }

    public void setBackgroundColorCardView(int color){
        setCardBackgroundColor(color);
    }

    public void setBackgroundColorMain(int color){
        shape.setColor(color);
    }

    public void setRandomBackgroundColorCardView(){
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        setBackgroundColorCardView(color);
    }

    public void setMarginMain(int left, int top, int right, int bottom ){
        params.setMargins(left,top,right,bottom);
    }

    public void setCornerRadiusMain(float radiusTopLeft, float radiusBottomLeft, float radiusTopRight, float radiusBottomRight){
        shape.setCornerRadii(new float[]{radiusTopLeft, radiusTopLeft, radiusTopRight, radiusTopRight, radiusBottomRight, radiusBottomRight, radiusBottomLeft, radiusBottomLeft});
    }

    public void setCornerRadiusMain(float radius){
        shape.setCornerRadius(radius);
    }

}
