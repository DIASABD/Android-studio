
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

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Cette classes crée un adpater pour la listView de l'activité Actualités.
 */

public class ListActuAdapter extends BaseAdapter {

    private Activity activite;
    private ArrayList<HashMap<String, String>> data;

    public ListActuAdapter(Activity acti, ArrayList<HashMap<String, String>> d) {
        activite = acti;
        data = d;
    }

    // Retourne la taille de la liste
    public int getCount() {
        return data.size();
    }

    // Retour un objet item de la liste
    public Object getItem(int position) {
        return position;
    }

    // retourne un id de l'item de la liste
    public long getItemId(int position) {
        return position;
    }

    /**
     * @param position    :position dans la liste
     * @param convertView : objet view
     * @param parent      : nom du viewGroup
     * @return : valeur de retour
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        ListActuViewHolder holder = null;
        if (convertView == null) {
            holder = new ListActuViewHolder();
            convertView = LayoutInflater.from(activite).inflate(
                    R.layout.liste_actu, parent, false);
            holder.galleryImage = (ImageView) convertView.findViewById(R.id.galleryImage);
            ;
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.sdetails = (TextView) convertView.findViewById(R.id.sdetails);
            convertView.setTag(holder);
        } else {
            holder = (ListActuViewHolder) convertView.getTag();
        }
        holder.galleryImage.setId(position);
        holder.title.setId(position);
        holder.sdetails.setId(position);
        HashMap<String, String> song = new HashMap<String, String>();
        song = data.get(position);

        try {
            //  Titre de l'actualié
            holder.title.setText(song.get(Actualite.KEY_TITLE));
            //Description de l'actualité
            holder.sdetails.setText(song.get(Actualite.KEY_DESCRIPTION));

            if (song.get(Actualite.KEY_URLTOIMAGE).toString().length() < 5) {
                holder.galleryImage.setVisibility(View.GONE);
            } else {
                Picasso.with(activite)
                        .load(song.get(Actualite.KEY_URLTOIMAGE).toString())
                        .resize(300, 200)
                        .into(holder.galleryImage);
            }
        } catch (Exception e) {
        }
        return convertView;
    }
}


/**
 * Cette classe construit les items de la listView de l'activité Actualite
 */
class ListActuViewHolder {
    ImageView galleryImage;
    TextView title, sdetails;
}
