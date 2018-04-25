package com.anubhav.android.customdialogbox;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.anubhav.android.customdialog.CustomDialog;
import com.transitionseverywhere.TransitionManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Activity thisActivity;
    private SharedPreferences mPreference;

    private ViewGroup layoutMain;
    private Button btnResetGuidePref;
    private TextView textChangeEnabled;

    private CustomDialog mCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thisActivity = this;
        mPreference  = getSharedPreferences(SharedPref.PREFERENCE_NAME, MODE_PRIVATE);

        layoutMain = (ViewGroup) findViewById(R.id.layout_main);

        Button btnShowBasicDialog = (Button) findViewById(R.id.btn_show_basic_dialog);
        btnShowBasicDialog.setOnClickListener(this);

        Button btnShowProgressDialog = (Button) findViewById(R.id.btn_show_progress_dialog);
        btnShowProgressDialog.setOnClickListener(this);

        Button btnShowGuideDialog = (Button) layoutMain.findViewById(R.id.btn_show_guide_dialog);
        btnShowGuideDialog.setOnClickListener(this);

        Button btnShowLongCustomDialog = (Button) findViewById(R.id.btn_show_long_custom_dialog);
        btnShowLongCustomDialog.setOnClickListener(this);

        textChangeEnabled = (TextView) layoutMain.findViewById(R.id.text_btn_change_enabled);

        setBtnGuideReset(false);
    }

    @Override
    protected void onPause() {
        super.onPause();

        resetGuidePref();
    }

    private void setBtnGuideReset(boolean enabled) {
        TransitionManager.beginDelayedTransition(layoutMain);
    }

    private void resetGuidePref() {
        SharedPreferences.Editor edit = mPreference.edit();
        edit.putBoolean(SharedPref.KEY_FIRST_WELCOME, SharedPref.FIRST_WELCOME_DEFAULT);
        edit.apply();
    }


    @Override
    public void onClick(View view) {
        switch ( view.getId() ) {
            case R.id.btn_show_basic_dialog:
                new CustomDialog.Builder(thisActivity)
                        .setTitle("Hello !")
                        .setContent("This is basic Dialog", 3)
                        .show();
                break;

            case R.id.btn_show_progress_dialog:
                new CustomDialog.Builder(thisActivity)
                        .setContent("This is progress Dialog", 7)
                        .showProgress(true)
                        .setBtnCancelText("Cancel")
                        .setBtnCancelTextColor("#2861b0")
                        .show();
                break;

            case R.id.btn_show_guide_dialog:
                new CustomDialog.Builder(thisActivity)
                        .setTitle("Welcome !", true)
                        .setContent("This is guide Dialog \n\n- You are seeing a Image !")
                        .setGuideImage(R.drawable.ic_launcher_background)
                        .setGuideImageSizeDp(150, 150)
                        .setPermanentCheck(SharedPref.PREFERENCE_NAME, SharedPref.KEY_FIRST_WELCOME)
                        .setBtnConfirmText("Confirm!")
                        .setBtnConfirmTextColor("#e6b115")
                        .showIfPermanentValueIsFalse();
                break;


            case R.id.btn_show_long_custom_dialog:
                new CustomDialog.Builder(thisActivity)
                        .setTitle("This is Title ")
                        .setCustomView(R.layout.dialog_test_layout_custom_long)
                        .setBtnConfirmText("Confirm!")
                        .setBtnConfirmTextSizeDp(16)
                        .setBtnConfirmTextColor("#1fd1ab")
                        .setBtnCancelText("Cancel", false)
                        .setBtnCancelTextColor("#555555")
                        .show();
                break;

        }
    }
}
