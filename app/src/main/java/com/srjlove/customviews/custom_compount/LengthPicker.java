package com.srjlove.customviews.custom_compount;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.srjlove.customviews.R;

/**
 * Created by Suraj on 1/21/2018.
 */

public class LengthPicker extends LinearLayout {

    private static final String KEY_INCHES = "mInches";
    private static final String KEY_PARCELABLE = "key_parcel";
    private Button btn_minus, btn_plus;
    private TextView text;
    private int mNumInches = 0;

    public LengthPicker(Context context) {      // use in java
        super(context);
        init();
    }

    public LengthPicker(Context context, @Nullable AttributeSet attrs) {    // use in XML
        super(context, attrs);
        init();
    }

    private void init() {
       final LayoutInflater mInflater =  LayoutInflater.from(getContext());
       mInflater.inflate(R.layout.length_picker, this);
       // setContentView(R.layout.activity_main); instead of this use LayoutInflater

        btn_minus = findViewById(R.id.minus);
        btn_plus = findViewById(R.id.plus);
        text = findViewById(R.id.text);

        updateControls();

        View.OnClickListener mListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.minus:
                        if (mNumInches > 0) {
                            mNumInches--;
                            updateControls();
                        }
                        break;
                    case R.id.plus:
                        mNumInches++;
                        updateControls();
                        break;
                }
            }
        };
        btn_plus.setOnClickListener(mListener);
        btn_minus.setOnClickListener(mListener);
    }

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle mBundle = new Bundle();
        mBundle.putParcelable(KEY_PARCELABLE, super.onSaveInstanceState());
        mBundle.putInt(KEY_INCHES, mNumInches);
        return mBundle;
    }


    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        // restoring all from parcelable
        if (state instanceof Bundle ){
            Bundle mBundle = (Bundle) state;
            super.onRestoreInstanceState(mBundle.getParcelable(KEY_PARCELABLE));
            mNumInches = mBundle.getInt(KEY_INCHES);
        }else {
            super.onRestoreInstanceState(state);
        }
        updateControls();

    }

    private void updateControls() {

        int feet = mNumInches / 12;
        int inches = mNumInches % 12;

        String t = String.valueOf(feet + inches);

        if (feet == 0) t = String.valueOf(inches);
        else {
            if (inches == 0) {
                t = String.valueOf(feet);
            }
        }
        text.setText(t);
        btn_minus.setEnabled(mNumInches > 0);
    }
}
