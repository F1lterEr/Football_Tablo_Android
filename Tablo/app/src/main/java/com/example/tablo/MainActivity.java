package com.example.tablo;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int juventusCount = 0;
    int barcelonaCount = 0;

    Button Juventus, Barcelona, Reset;
    TextView juventus, barcelona, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Juventus = (Button)findViewById(R.id.Juventus);
        juventus = (TextView)findViewById(R.id.juventus);
        Barcelona = (Button)findViewById(R.id.Barcelona);
        barcelona = (TextView)findViewById(R.id.barcelona);
        Reset = (Button)findViewById(R.id.Reset);
        reset = (TextView)findViewById(R.id.reset);
        JuventusClick();
        BarcelonaClick();
        ResetClick();

    }

    void JuventusClick(){
        Juventus.setOnClickListener(view -> {
            juventusCount++;
            juventus.setText(String.valueOf(juventusCount));
            juventus.setText(juventusCount+"");
            });
    }
    void BarcelonaClick(){
        Barcelona.setOnClickListener(view -> {
            barcelonaCount++;
            barcelona.setText(String.valueOf(barcelonaCount));
            barcelona.setText(barcelonaCount+"");
        });
    }
    void ResetClick(){
        Reset.setOnClickListener(view -> {
            juventusCount=0;
            barcelonaCount=0;

            resetUI();
        });
    }
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", (int) juventusCount);
        outState.putInt("count1", (int) barcelonaCount);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        juventusCount = savedInstanceState.getInt("count");
        barcelonaCount = savedInstanceState.getInt("count1");
        resetUI();
    }
    private void resetUI() {
        juventus.setText(String.valueOf(juventusCount));
        juventus.setText(juventusCount+"");
        barcelona.setText(String.valueOf(barcelonaCount));
        barcelona.setText(barcelonaCount+"");
        Log.d(TAG, "resetUI");
    }
}