package br.ufrn.eaj.tads.webviewexample;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    WebView webview;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = (WebView) findViewById(R.id.webView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        webview.loadUrl("http://tads.eaj.ufrn.br");
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView v, String url, Bitmap icon) {
                progressBar.setVisibility(WebView.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView v, String url){
                progressBar.setVisibility(WebView.INVISIBLE);
            }

        });
        /*
         * Habilitando o webview para criar um HTML na mão.
         */
        //webview.loadDataWithBaseURL("", "<font color ='blue'> Teste HTML<font>", "text/html", "UTF-8", "");

        //*****************************************************

        /*
        * Habilitando o webview do tipo WebChromeClient para executar javascript.
         */

        webview.setWebChromeClient(new WebChromeClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("javascript:alert('Olá mundo');");
    }
}
