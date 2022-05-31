package model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ProfilRepository {

    private ProfilDAO profilDAO;
    private LiveData<List<Profil>> allProfiles;

    public ProfilRepository(Application application){
        ProfilDatabase database = ProfilDatabase.getInstance(application);
        profilDAO = database.profilDao();
        allProfiles = profilDAO.getAllProfil();
    }

    public void insert(Profil profil){

    }

    public void update(Profil profil){

    }

    public void delete(Profil profil){

    }

    public void deleteAllProfiles(){

    }

    public LiveData<List<Profil>> getAllProfiles(){
        return allProfiles;
    }

    private static class InsertProfilAsyncTask extends AsyncTask<Profil, Void, Void>{
        private ProfilDAO profilDAO;

        private void InsertNoteAsyncTask(ProfilDAO profilDao){
            this.profilDAO = profilDao;
        }

        @Override
        protected Void doInBackground(Profil... profils){
            ProfilDAO.insert(profils[0]);
            return null;
        }
    }
}
