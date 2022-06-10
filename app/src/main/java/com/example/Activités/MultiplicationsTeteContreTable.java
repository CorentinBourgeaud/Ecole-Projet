package com.example.Activités;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

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
    public static final String VAL_ERREUR = "val_erreur";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplications_tete_contre_table);

        //Récupérer les éléments graphiques
        linear = findViewById(R.id.inflate_linear);

        ArrayList test = getIntent().getIntegerArrayListExtra(VAL_ERREUR);
        System.out.println(test);

        if (getIntent().getIntegerArrayListExtra(VAL_ERREUR) == null) {

            // 1. Initialiser les données
            tableMultiplication = new TableMultiplication(getIntent().getIntExtra(TABLE_KEY, 0), 10);

            // 2. Mettre à jour l'interface utilisateur
            miseAJourUI();
        }
        else{
            miseAJourUIBis();
        }
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

    private void miseAJourUIBis() {

        // 1. Boucler pour générer la table
        ArrayList<Integer> ListeCalcule = getIntent().getIntegerArrayListExtra(VAL_ERREUR);
        for (int i = 0; i < ListeCalcule.size(); i++) {

            Multiplication multiplication = new Multiplication(ListeCalcule.get(i)  ,  getIntent().getIntExtra(TABLE_KEY, 0));

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

        ArrayList<Integer> val_erreur = new ArrayList<Integer>();

        int erreur = 0;

        //récupère le chiffre de la table
        int table = tableMultiplication.getNombre();
        String res;
        //vérifie chaque réponse
        for (int i = 1 ; i <= 10 ; i++){
            EditText resultat = findViewById(i);
            //passe la valeur de l'EditText en String puis la String en Int
            res = resultat.getText().toString().trim();

            if(!res.isEmpty()) {

                int reponse = Integer.parseInt(resultat.getText().toString());

                if (reponse != table * i) {
                    val_erreur.add(i);
                    erreur++;
                }
            }
            else{
                resultat.setError("Rentrez un entier");
            }
        }
        if (val_erreur.isEmpty()){
            Intent intent = new Intent(this, ReussiteTeteContreTable.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, ErreurTeteContreTable.class);
            intent.putExtra(ErreurTeteContreTable.TABLE_KEY, getIntent().getIntExtra(TABLE_KEY, 0));
            intent.putExtra(ErreurTeteContreTable.VAL_ERREUR,val_erreur);
            startActivity(intent);
        }
    }

    public void retour (View view){
        super.finish();
    }
}