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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;


/**
 * Cette classe construit l'interface qui
 * présente les rubriques d'informations disponibles
 * pour chacune des provinces
 */

public class LoadProgram extends AppCompatActivity {


    RingProgressBar mRingProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_program);
        final ImageView imageDemar = (ImageView) findViewById(R.id.image_demar);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_demar);
        imageDemar.startAnimation(animation);

        // Set la barre de progress bar

        Thread temp = new Thread() {

            @Override
            public void run() {

                try {
                    sleep(3000);

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                super.run();
            }
        };
        temp.start();


    }
}
