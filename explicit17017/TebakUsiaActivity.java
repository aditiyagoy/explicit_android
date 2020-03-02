package com.example.explicit17017;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class TebakUsiaActivity extends AppCompatActivity implements
        View.OnClickListener {
    private Button btnTebak;
    private RadioGroup rgUsia;
    public static String EXTRA_SELECTED_VALUE = "extra_selected_value";
    public static int RESULT_CODE​ = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tebak_usia);

        btnTebak = (Button) findViewById(R.id.btn_tebak);
        btnTebak.setOnClickListener(this);
        rgUsia = (RadioGroup) findViewById(R.id.rg_usia);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_tebak) {
            if (rgUsia.getCheckedRadioButtonId() != 0) {
                int value = 0;
                switch (rgUsia.getCheckedRadioButtonId()) {
                    case R.id.rb_18:
                        value = 18;
                        break;
                    case R.id.rb_19:
                        value = 19;
                        break;
                    case R.id.rb_20:
                        value = 20;
                        break;
                    case R.id.rb_21:
                        value = 21;
                        break;
                }
                Intent tebakIntent = new Intent();
                tebakIntent.putExtra(EXTRA_SELECTED_VALUE, value);
                setResult(RESULT_CODE​, tebakIntent);
                finish();
            }
        }

    }
}