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

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Cette classe construit l'interface de l'activité taxe
 */
public class Taxe extends AppCompatActivity {

    double[] taux_taxe = {0.05, 0.12, 0.15, 0.13, 0.15, 0.15, 0.05, 0.13, 0.1498, 0.11, 0.15, 0.05, 0.05};

    // attributs
    TextView result_taxe, result_total;
    Button calculer;
    EditText montant;
    MainActivity actualite = new MainActivity();
    Options options = new Options();
    String[] mesProvinces = actualite.nomProvinces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxe);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorRed)));
        getSupportActionBar().setTitle("Taxes");

        // Instanciaton des objets
        result_total = (TextView) findViewById(R.id.resultat_total);
        result_taxe = (TextView) findViewById(R.id.result_taxe);
        calculer = (Button) findViewById(R.id.boutton_taxe);
        montant = (EditText) (findViewById(R.id.editText_taxe));
        // index du view cliqué dans la classe MainActivity
        int i = actualite.getIndexClick();
        // Calcul de la taxe
        result_taxe.setText(taux_taxe[i] + " % ");

        // evenement calculer la valeur de la taxe
        calculer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double resultat = Double.parseDouble(montant.getText().toString());
                String provActive = options.getProvince_Choisie();
                double valeur = 0.0;
                int i = actualite.getIndexClick();
                //double taux_courant = taux_taxe[i];
                DecimalFormat df = new DecimalFormat();
                df.setMaximumFractionDigits(2);
                valeur = resultat + (resultat * taux_taxe[i]);
                result_total.setText(df.format(valeur) + " $ ");


            }
        });

    }

}
