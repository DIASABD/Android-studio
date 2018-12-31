package com.example.sarr.canadaapp;

/**
 * Ce Programme est une intervalle est une application android qui fourni
 * des informations générales sur les provinces du Canada.
 * Il a été élaboré par des étudiants au Baccalauréat en Informatique
 * de l'Université de Montréal . Hiver 2018.
 * Willy FOADJO:  Matricule :20059876
 * Abdramane Diasso: Matricule 20057513
 * Mohamed Sarr : Matricule 20050326
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;


/**
 * Cette classe les details
 * conténu dans le JSON de notre API pour l'activité Actualités
 */

public class DetailsActu extends AppCompatActivity {
    // attributs
    WebView webView;
    // barre de progression
    ProgressBar loader;
    // initialisation de l'url
    static String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_actu);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        loader = (ProgressBar) findViewById(R.id.loader_actu);
        webView = (WebView) findViewById(R.id.webView_actu);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.loadUrl(url);


        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    loader.setVisibility(View.GONE);
                } else {
                    loader.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
