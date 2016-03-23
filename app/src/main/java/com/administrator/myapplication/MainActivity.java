package com.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)this.findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(tv, "李靖靖", Snackbar.LENGTH_LONG)
                        .setAction("小范", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                tv.setText("aleady click snackbar");
                                Intent intent = new Intent(MainActivity.this, SimpleActivity.class);
                                startActivity(intent);
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
