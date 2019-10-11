package com.debby.debby;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.debby.debby.Colors.okorite;
import static com.debby.debby.Colors.white;
import static com.debby.debby.Variables.link;
import static com.debby.debby.Variables.page_title;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        */

        LinearLayout ll =(LinearLayout) findViewById(R.id.debby);

        LinearLayout lkk =(LinearLayout) findViewById(R.id.ruth);


        TextView tv = new TextView(this);

        tv.setText("Welcome to ALC 4.0");
        tv.setTextSize(30);
        tv.setTextColor(okorite);
        tv.setTypeface(ResourcesCompat.getFont(this, R.font.kaushanscript_regular));

        tv.setGravity(Gravity.CENTER);


        Button b1 = new Button(this);
        b1.setText("About ALC");
        b1.setTypeface(ResourcesCompat.getFont(this, R.font.kaushanscript_regular));

        b1.setBackgroundColor(okorite);
        b1.setGravity(Gravity.CENTER);
        b1.setTextColor(white);
        b1.setPadding(3,3,3,3);
        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                link  = "https://andela.com/alc";
                page_title  = R.string.about_alc;
                Intent i = new Intent(getApplicationContext(),
                        AboutALC.class);
                startActivity(i);
                finish();
            }
        });


        Button b2 = new Button(this);
        b2.setText("My Profile");
        b2.setTypeface(ResourcesCompat.getFont(this, R.font.kaushanscript_regular));

        b2.setTextColor(white);
        b2.setPadding(3,3,3,3);
        b2.setBackgroundColor(okorite);
        b2.setGravity(Gravity.CENTER);
        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        MyProfile.class);
                startActivity(i);
                finish();
            }
        });

        ll.addView(tv);

        RelativeLayout rr = new RelativeLayout(this);

        LinearLayout lk = new LinearLayout(this);
        lk.setOrientation(LinearLayout.VERTICAL);

        rr.addView(lk);

        lk.setGravity(Gravity.CENTER);
        RelativeLayout.LayoutParams layoutParams =
                (RelativeLayout.LayoutParams)lk.getLayoutParams();
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

        lk.setLayoutParams(layoutParams);

        lkk.addView(rr);
        lk.addView(b1);
        lk.addView(b2);

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
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
            link  = "https://facebook.com";
            page_title  = R.string.page;
            Intent i = new Intent(getApplicationContext(),
                    AboutALC.class);
            startActivity(i);
            finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
