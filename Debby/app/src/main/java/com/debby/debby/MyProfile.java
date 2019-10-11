package com.debby.debby;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Map;


public class MyProfile extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);

        LinearLayout lp = new LinearLayout(this);
        lp.setGravity(Gravity.CENTER);

      //  actionBarIdForAll(this,R.string.profile);


        ImageView im = new ImageView(this);
        im.setImageResource(R.drawable.debby);
        im.setLayoutParams(new LinearLayout.LayoutParams(300, 300));

        lp.addView(im);
        ll.addView(lp);

        TextView  tv = new TextView(this);
        tv.setText("Briggs Deborah Okorite");
        tv.setTextSize(25);
        tv.setTypeface(ResourcesCompat.getFont(this, R.font.kaushanscript_regular));

        tv.setGravity(Gravity.CENTER);
        ll.addView(tv);

        for(Map.Entry<String, String> pf : Profiles.Debby().entrySet())
        {
            TextView tv_key =new TextView(this);
            TextView tv_value =new TextView(this);
            tv_key.setTextSize(20);
            tv_value.setTextSize(20);
            tv_key.setTypeface(ResourcesCompat.getFont(this, R.font.kaushanscript_regular));
            tv_value.setTypeface(ResourcesCompat.getFont(this, R.font.kaushanscript_regular));
            LinearLayout lv = new LinearLayout(this);
            lv.setOrientation(LinearLayout.HORIZONTAL);

            tv_key.setText(pf.getKey());
            tv_value.setText(" "+pf.getValue());

            lv.addView(tv_key);
            lv.addView(tv_value);
            ll.addView(lv);
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(),
                MainActivity.class);
        startActivity(i);
        finish();
    }

}
