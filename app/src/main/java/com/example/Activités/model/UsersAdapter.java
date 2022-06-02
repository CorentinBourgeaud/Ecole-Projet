package com.example.Activités.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.projetandroid.R;

import java.util.List;



public class UsersAdapter extends ArrayAdapter<User> {


    public UsersAdapter(Context mCtx, List<User> taskList) {
        super(mCtx, R.layout.template_task, taskList);
    }

    /**
     * Remplit une ligne de la listView avec les informations de la multiplication associée
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Récupération de la multiplication
        final User user = getItem(position);

        // Charge le template XML
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.template_task, parent, false);

        // Récupération des objets graphiques dans le template
        TextView textViewLogin = (TextView) rowView.findViewById(R.id.textViewLogin);
        TextView textViewPassword = (TextView) rowView.findViewById(R.id.textViewPassword);

        //
        textViewLogin.setText(user.getLogin());
        textViewPassword.setText(user.getPassword());


        //
        return rowView;
    }

}