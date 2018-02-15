package com.bardon20.bardon20_facemaker;


import android.graphics.Canvas;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

/**
 * Created by rbard on 2/10/2018.
 */

public class MainActivity extends AppCompatActivity {

    protected Canvas canvas = new Canvas();
    protected int red = 255;
    protected int green = 204;
    protected int blue = 153;
    protected String feature = "eyes";
    protected int hairStyle = 1;

    protected SeekBar redValSeekBar;
    protected SeekBar greenValSeekBar;
    protected SeekBar blueValSeekBar;

    private String[] hairStyles = {"Smooth", "Boxy", "Balding"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout faceSurface = (LinearLayout) findViewById(R.id.faceSurfaceView);
        faceSurface.addView(new FacePainter(this));


        //radio buttons
        RadioGroup eyeSkinHair = (RadioGroup) findViewById(R.id.eyeSkinHair);
        eyeSkinHair.setOnCheckedChangeListener(new radioButtonListener());


        //seek bars
        redValSeekBar = (SeekBar) findViewById(R.id.redSeekBarVal);
        redValSeekBar.setOnSeekBarChangeListener(new seekBarListener());
        red = redValSeekBar.getProgress();
        greenValSeekBar = (SeekBar) findViewById(R.id.greenSeekBarVal);
        greenValSeekBar.setOnSeekBarChangeListener(new seekBarListener());
        green = greenValSeekBar.getProgress();
        blueValSeekBar = (SeekBar) findViewById(R.id.blueSeekBarVal);
        blueValSeekBar.setOnSeekBarChangeListener(new seekBarListener());
        blue = blueValSeekBar.getProgress();


        //spinner
        ArrayAdapter<String> hairAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, hairStyles);
        Spinner hairSpinner = (Spinner) findViewById(R.id.hairStyleSpinner);
        hairSpinner.setAdapter(hairAdapter);

        hairSpinner.setOnItemSelectedListener(new spinnerListener());


        //random face button
        Button randButton = (Button) findViewById(R.id.randomFaceButton);
        randButton.setOnClickListener(new randomFaceListener());


    }

    private class radioButtonListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            if (checkedId == R.id.hairRadioButton) {
                feature = "hair";
            } else if (checkedId == R.id.eyeRadioButton) {
                feature = "eyes";
            } else if (checkedId == R.id.skinRadioButton) {
                feature = "skin";
            }

        }
    }


    private class seekBarListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            red = redValSeekBar.getProgress();
            green = greenValSeekBar.getProgress();
            blue = blueValSeekBar.getProgress();

            //new FaceMaker(red, green, blue, feature, hairStyle).draw(canvas);
            //doesnt work
            //crashes


        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    public class randomFaceListener implements Button.OnClickListener {
        public void onClick(View button) {

            new FaceMaker().draw(canvas);
            //goes into FaceMaker but does not draw new face
            //I got nothing

        }
    }

    public class spinnerListener implements Spinner.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            parent.getAdapter().getItem(position);

            if (parent.getAdapter().getItem(position).equals("Smooth")) {
                hairStyle = 1;
            } else if (parent.getAdapter().getItem(position).equals("Boxy")) {
                hairStyle = 2;
            } else if (parent.getAdapter().getItem(position).equals("Balding")) {
                hairStyle = 3;
            }


            //new FaceMaker(red, green, blue, feature, hairStyle).draw(canvas);
            //doesnt work
            //crashes


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }
}


/**
 * External Citation
 * Date: 2-10-2018
 * Problem: Could not properly instantiate my surface view
 * Resource:
 * https://stackoverflow.com/questions/10185624/surfaceview-in-layout
 * Solution: followed example in this post, adding a layout and creating the surface view within it.
 * <p>
 * External Citation
 * Date: 2-10-2018
 * Problem:listeners and set up
 * Resource: in class coding examples
 * Solution: followed in class cosing examples
 * <p>
 * External Citation
 * Date: 2-10-2018
 * Problem: differentiating between seekbars
 * Resource:
 * https://stackoverflow.com/questions/8719632/multiple-seekbars-listener
 * Solution: created variable at the top each seekbar
 * <p>
 * External Citation
 * Date: 2-10-2018
 * Problem: everyhting
 * Resource: looked up a lot of tings
 * Solution: none, nothing worked


/**
 External Citation
 Date: 2-10-2018
 Problem:listeners and set up
 Resource: in class coding examples
 Solution: followed in class cosing examples
 */

/**
 External Citation
 Date: 2-10-2018
 Problem: differentiating between seekbars
 Resource:
 https://stackoverflow.com/questions/8719632/multiple-seekbars-listener
 Solution: created variable at the top each seekbar
 */

/**
 External Citation
 Date: 2-10-2018
 Problem: everyhting
 Resource: looked up a lot of tings
 Solution: none, nothing worked
 */
