package com.srjlove.customviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.srjlove.customviews.custom_view.VersionView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // define here your custom views before setcontentview()
        VersionView mView = new VersionView(this);
        setContentView(R.layout.activity_main);

      /*  Intent mIntent = new Intent();
        mIntent.putExtra("id", 1);
        mIntent.putExtra("ur_name", "Akshay");
        mIntent.putExtra("my_name", "Srj");

        startActivity(mIntent);*/
    }

}
