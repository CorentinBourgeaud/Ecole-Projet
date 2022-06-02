package com.example.Activités;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.Activités.model.Multiplication;
import com.example.Activités.model.TableMultiplication;

import com.example.projetandroid.R;

public class MultiplicationsTeteContreTable extends AppCompatActivity {

    // DATA
    TableMultiplication tableMultiplication;

    // VIEW
    LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplications_tete_contre_table);

        // 1. Initialiser les données
        tableMultiplication = new TableMultiplication(8, 10);

        // 2. Récupérer les éléments graphiques
        linear = findViewById(R.id.inflate_linear);

        // 3. Mettre à jour l'interface utilisateur
        miseAJourUI();
    }

    //
    private void miseAJourUI() {

        // 1. Boucler pour générer la table
        for (Multiplication multiplication : tableMultiplication.getMultiplications()) {

            // 2. Création de la ligne temporaire
            LinearLayout linearTMP = (LinearLayout) getLayoutInflater().inflate(R.layout.template_multiplication, null);

            // 3. Création du texte décrivant l'opération
            TextView calcul = linearTMP.findViewById(R.id.template_calcul);
            calcul.setText(multiplication.getOperande1() + " x " + multiplication.getOperande2() + " = ");

            // 4. Récupération de l'editText permettant d'interagir avec l'utilisateur
            EditText resultat = linearTMP.findViewById(R.id.template_resultat);
            // A FAIRE
            resultat.setHint("?");
            resultat.setInputType(2);

            // 5. Ajout au linear principal
            linear.addView(linearTMP);
        }

    }
}