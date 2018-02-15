package com.bardon20.bardon20_facemaker;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by rbard on 2/10/2018.
 */

public class FaceMaker {

    protected Paint facePaint;
    protected Paint eyePaint;
    protected Paint hairPaint;
    protected boolean hairStyle1;
    protected boolean hairStyle2;
    protected boolean hairStyle3;


    public FaceMaker(){
        int color1 =
                Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));

        facePaint = new Paint();
        facePaint.setColor(color1);

        int color2 =
                Color.rgb((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));

        eyePaint = new Paint();
        eyePaint.setColor(color2);

        int color3 =
                Color.rgb((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));

        hairPaint = new Paint();
        hairPaint.setColor(color3);

        int hairStyle = (int)(Math.random()*4)-1;

        if (hairStyle == 1 )
        {
            hairStyle1 = true;
            hairStyle2 = false;
            hairStyle3 = false;
        }
        else if (hairStyle == 2 )
        {
            hairStyle1 = false;
            hairStyle2 = true;
            hairStyle3 = false;
        }
        else
        {
            hairStyle1 = false;
            hairStyle2 = false;
            hairStyle3 = true;
        }

    }

    //does not work
    public FaceMaker(int red, int green, int blue, String feature, int hairStyle) {

        if (feature.equalsIgnoreCase("skin"))
        {
            int color = Color.rgb(red, green, blue);
            facePaint = new Paint();
            facePaint.setColor(color);
        }
        if (feature.equalsIgnoreCase("eyes"))
        {
            int color = Color.rgb(red, green, blue);
            eyePaint = new Paint();
            eyePaint.setColor(color);
        }
        if (feature.equalsIgnoreCase("hair"))
        {
            int color = Color.rgb(red, green, blue);
            hairPaint = new Paint();
            hairPaint.setColor(color);
        }

        if (hairStyle == 1 )
        {
            hairStyle1 = true;
            hairStyle2 = false;
            hairStyle3 = false;
        }
        else if (hairStyle == 2 )
        {
            hairStyle1 = false;
            hairStyle2 = true;
            hairStyle3 = false;
        }
        else
        {
            hairStyle1 = false;
            hairStyle2 = false;
            hairStyle3 = true;
        }

        //draw(canvas);
    }

    public void draw(Canvas canvas)
    {
        Paint eyeWhites = new Paint();
        eyeWhites.setColor(Color.WHITE);
        Paint pupil = new Paint();
        pupil.setColor(Color.BLACK);


        //face
        facePaint.setStrokeWidth(5.0f);
        canvas.drawCircle(750.0f, 550.0f, 400.0f, facePaint);


        if(hairStyle1) {
            //hair style #1
            RectF hair1 = new RectF(450.0f, 350.0f, 1050.0f, 150.0f);
            canvas.drawOval(hair1, hairPaint);
        }
        else if(hairStyle2)
        {
            //hair style #2
            RectF hair2 = new RectF(420.0f, 325.0f, 1080.0f, 50.0f);
            canvas.drawRect(hair2, hairPaint);
        }
        else if(hairStyle3) {
            //hair stle #3
            canvas.drawCircle(350.0f, 400.0f, 50.0f, hairPaint);
            canvas.drawCircle(360.0f, 475.0f, 50.0f, hairPaint);
            canvas.drawCircle(390.0f, 350.0f, 50.0f, hairPaint);

            canvas.drawCircle(1150.0f, 400.0f, 50.0f, hairPaint);
            canvas.drawCircle(1150.0f, 475.0f, 50.0f, hairPaint);
            canvas.drawCircle(1090.0f, 350.0f, 50.0f, hairPaint);
        }


        //eyes
        canvas.drawCircle(575.0f, 500.0f, 75.0f, eyeWhites);
        canvas.drawCircle(925.0f, 500.0f, 75.0f, eyeWhites);
        //eye color
        canvas.drawCircle(575.0f, 500.0f, 50.0f, eyePaint);
        canvas.drawCircle(925.0f, 500.0f, 50.0f, eyePaint);
        canvas.drawCircle(575.0f, 500.0f, 25.0f, pupil);
        canvas.drawCircle(925.0f, 500.0f, 25.0f, pupil);

        //mouth
        canvas.drawCircle(750.0f, 750.0f, 80.0f, pupil);

    }



}