package ru.atc.devintensive.ui.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ru.atc.devintensive.R;
import ru.atc.devintensive.utils.ConstantManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected EditText mEditText;
    protected Button mButtonGreen;
    protected Button mButtonBlue;
    protected int mColorMode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.edit_text);
        mButtonGreen = (Button) findViewById(R.id.bttn_green);
        mButtonBlue = (Button) findViewById(R.id.bttn_blue);

        mButtonGreen.setOnClickListener(this);
        mButtonBlue.setOnClickListener(this);

        if (savedInstanceState == null) {
//            First launch activity.
        } else {
//            Second or more.
            mColorMode = savedInstanceState.getInt(ConstantManager.COLOR_MODE_STATE);

            if (mColorMode == Color.BLUE){
                mEditText.setBackgroundColor(Color.BLUE);
            } else if (mColorMode == Color.GREEN)
                mEditText.setBackgroundColor(mColorMode);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(ConstantManager.COLOR_MODE_STATE, mColorMode);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bttn_blue:
                mColorMode = Color.BLUE;
                mEditText.setBackgroundColor(mColorMode);
                break;
            case R.id.bttn_green:
                mColorMode = Color.GREEN;
                mEditText.setBackgroundColor(mColorMode);
                break;
        }
    }
}
