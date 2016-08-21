package com.example.patryk.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Wszyscy zostali oszukani!!!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);
        //int message = intent.getIntExtra(MyActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        int dzieci = Integer.valueOf(message);
        int dotacja = 500;
        int nieuprawnioneDzieci = 1;
        int uprawnioneDzieci = dzieci - nieuprawnioneDzieci;
        int realnieNaDziecko = (dotacja * uprawnioneDzieci) / dzieci;
        int dokladasz = 500 - realnieNaDziecko;
        textView.setText("Przy " + dzieci + " dzieci dotacja wynosi " + realnieNaDziecko +
                " na dziecko. Żeby każde miało 500 to sam dokładasz " + dokladasz + " na każde z dzieci.");
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);
    }

}
