package fr.iutmindfuck.bdeapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import fr.iutmindfuck.bdeapplication.R;
import fr.iutmindfuck.bdeapplication.data.SessionData;

public class ConnexionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
    }


    public void onMemberButtonClick(View view){
        SessionData.createNewSession(true);
        startActivity(new Intent(ConnexionActivity.this, AuthentificationActivity.class));
    }
    public void onGuestButtonClick(View view){
        SessionData.createNewSession(false);
        startActivity(new Intent(ConnexionActivity.this, EventActivity.class));
    }
}
