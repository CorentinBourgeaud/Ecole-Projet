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

    //Clé
    public static final String TABLE_KEY = "table_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplications_tete_contre_table);

        // 1. Initialiser les données
        tableMultiplication = new TableMultiplication(getIntent().getIntExtra(TABLE_KEY, 0), 10);

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
            resultat.setId(multiplication.getOperande1());

            // 5. Ajout au linear principal
            linear.addView(linearTMP);
        }

    }
    public void TCT_valider_reponse(View view){

        int bonne_reponse = 0;
        int mauvaise_reponse = 0;

        //test verif recupération des erreurs dans un tableau
        //int dix = 10;
        //EditText lignedix = findViewById(dix);

        TextView test = findViewById(R.id.test);
        String text = test.getText().toString();

        //récupère le chiffre de la table
        int table = tableMultiplication.getNombre();

        //vérifie chaque réponse
        for (int i = 1 ; i < 10 ; i++){
            EditText resultat = findViewById(i);
            //passe la valeur de l'EditText en String puis la String en Int
            int reponse = Integer.parseInt(resultat.getText().toString());
            // pas de reponse fait crache le jeu
            System.out.println("-> " + reponse);

            if(reponse == table * i){
                bonne_reponse++;
            }else{
                text = text + " " + i;
                mauvaise_reponse++;
            }
        }
        test.setText(text);
    }

    public void retour (View view){
        super.finish();
    }
}