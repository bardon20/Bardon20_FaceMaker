package com.bardon20.bardon20_facemaker;

import android.graphics.Canvas;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by rbard on 2/10/2018.
 */

public class FacePainter extends SurfaceView {

    public FacePainter(Context context) {
        super(context);
        generalInit();
    }

    public FacePainter(Context context, AttributeSet attrs) {
        super(context, attrs);
        generalInit();
    }

    public FacePainter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        generalInit();
    }

    private void generalInit() {
        setWillNotDraw(false);
    }



    @Override
    public void onDraw(Canvas canvas) {
        new FaceMaker().draw(canvas);
        //only works here, cannot get to draw from button


        //Facemaker(red, green, blue, feature, hairstyle) does not work.
        // I got nothing
        //therefore does not update after click events

    }



}

