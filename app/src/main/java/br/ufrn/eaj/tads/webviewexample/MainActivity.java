package br.ufrn.eaj.tads.webviewexample;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    WebView webview;
    ProgressBar progressBar;
    SeekBar sbDiscrete;
    SeekBar sbNormal;
    RatingBar ratingBar;

    TextView tvDiscrete;
    TextView tvNormal;
    TextView tvRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = (WebView) findViewById(R.id.webView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        sbDiscrete = (SeekBar) findViewById(R.id.seekBarDiscrete);
        sbNormal = (SeekBar) findViewById(R.id.seekBarNormal);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        tvDiscrete = (TextView) findViewById(R.id.textViewDiscrete);
        tvNormal = (TextView) findViewById(R.id.textViewNormal);
        tvRating = (TextView) findViewById(R.id.textViewRating);

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

        //***********************************************************************

        sbDiscrete.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvDiscrete.setText(""+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbNormal.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvNormal.setText(""+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                tvRating.setText(""+v);
            }
        });

    }
}
