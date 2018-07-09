package fr.iutmindfuck.bdeapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import fr.iutmindfuck.bdeapplication.R;
import fr.iutmindfuck.bdeapplication.manager.UserSQLManager;
import fr.iutmindfuck.bdeapplication.service.SQLServices;

public class AuthentificationActivity extends AppCompatActivity {

    private UserSQLManager userSQLManager;
    private EditText passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);

        userSQLManager = new UserSQLManager(new SQLServices(this));
        passwordEdit = findViewById(R.id.auth_edit);

    }

    public void onConnexionButtonClick(View view) {
        String password = passwordEdit.getText().toString();

        if (userSQLManager.isPasswordCorrectFor(password)){
            launchPanelFor();
        }
        else{
            ((TextView)findViewById(R.id.auth_error))
                    .setText(getResources().getText(R.string.auth_error));
        }
    }

    private void launchPanelFor() {
        startActivity(new Intent(AuthentificationActivity.this, MemberMenuActivity.class));

    }
}
