package com.example.WebView;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.*;
import android.widget.EditText;

public class MainActivity extends Activity {
    private EditText etUrl;
    private Button btnGo;
    private WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViews();
    }

    public void findViews() {
        etUrl = (EditText) findViewById(R.id.etUrl);
        int start = "http://".length();
        int stop = etUrl.getText().toString().length();
        etUrl.setSelection(start, stop);
        btnGo = (Button)findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //etUrl.getText(); is an Object Type.
                String url = etUrl.getText().toString();
                //.loadUrl(String Type); So etUrl.getText() must become String type.
                webView.loadUrl(url);
            }
        });
        webView = (WebView)findViewById(R.id.webView);
        //Set JavaScript Enable
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(getString(R.string.Url));
        webView.setWebViewClient(new MyWebViewClient());

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK && webView.canGoBack()){
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
