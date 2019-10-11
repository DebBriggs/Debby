package com.debby.debby;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static com.debby.debby.Variables.link;
import static com.debby.debby.Variables.page_title;

public class AboutALC extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



       // actionBarIdForAll(this, R.string.about_alc);

        final Drawable upArrow = getResources().getDrawable(R.drawable.home);
        upArrow.setColorFilter(getResources().getColor(R.color.grey), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);


        WebView wv= new WebView(this);
        WebViewClient wcc  = new WebViewClient();

     //   wv.setWebViewClient(wcc);
        String url=link;
        setTitle(page_title);
        // "https://facebook.com";// "https://andela.com/alc/";
    //    url="https://facebook.com";

        wv.setWebViewClient(new MyBrowser());
        wv.getSettings().setLoadsImagesAutomatically(true);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv.loadUrl(url);

        wv.loadUrl(url);
        setContentView(wv);
    }

    public void actionBarIdForAll(Activity activity, int tag)
    {
        int titleId = 0;

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB)
        {
            titleId =activity.getResources().getIdentifier("action_bar_title", "id", "android");
        }
        else
        {
            // This is the id is from your app's generated R class when ActionBarActivity is used for SupportActionBar

            titleId = R.id.action_bar_title;
        }

        if(titleId>0)
        {
            // Do whatever you want ? It will work for all the versions.

            // 1. Customize your fonts
            // 2. Infact, customize your whole title TextView

            TypefaceSpan typefaceSpan = new TypefaceSpan(ResourcesCompat.getFont(activity, R.font.kaushanscript_regular));
            SpannableString str = new SpannableString("toolbar_text");
            str.setSpan(typefaceSpan,0, str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            getSupportActionBar().setTitle(str);
            /*
            TextView titleView = (TextView)findViewById(titleId);
            titleView.setText(tag);
            titleView.setTypeface(ResourcesCompat.getFont(activity, R.font.courgette_regular));
            */
        }
    }


    private class CustomWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
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
