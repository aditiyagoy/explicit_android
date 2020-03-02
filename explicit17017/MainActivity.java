package com.example.explicit17017;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton imgbtnPhone;
    private ImageButton imgbtnUsia;
    private TextView tvUsia;
    private int REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgbtnPhone = (ImageButton) findViewById(R.id.imgbtn_phone);
        imgbtnPhone.setOnClickListener(this);
        imgbtnUsia = (ImageButton) findViewById(R.id.imgbtn_usia);
        imgbtnUsia.setOnClickListener(this);
        tvUsia = (TextView)findViewById(R.id.tv_usia );
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.imgbtn_phone :
                String phoneNumber = "081234567890";
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:"+phoneNumber));
                startActivity(phoneIntent);
                break;
            case R.id.imgbtn_usia:
                Intent tebakUsiaIntent = new Intent(MainActivity.this,
                        TebakUsiaActivity.class);
                startActivityForResult(tebakUsiaIntent,REQUEST_CODE);
                break;

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if ((requestCode == REQUEST_CODE)){
            if (resultCode == TebakUsiaActivity.RESULT_CODE){
                int selectedValue =
                        data.getIntExtra(TebakUsiaActivity.EXTRA_SELECTED_VALUE, 0);
                tvUsia.setText("Tebakan: "+selectedValue);
            }
        }
    }
}
