package com.srjlove.customviews.custom_view;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.srjlove.customviews.R;

/**
 * Created by Suraj on 1/21/2018.
 */

public class VersionView extends android.support.v7.widget.AppCompatTextView {

    public VersionView(Context context) {
        super(context);
        versionView();
    }

    public VersionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        versionView();
    }
    public VersionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        versionView();
    }

    public void versionView(){
        try{
            PackageInfo mPackageInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);
            setText(mPackageInfo.versionName); // will give me a package version in string
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }

        setBackgroundColor(getResources().getColor(R.color.colorAccent));

    }
}
