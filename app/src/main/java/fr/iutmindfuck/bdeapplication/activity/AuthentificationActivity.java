package fr.iutmindfuck.bdeapplication.activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import fr.iutmindfuck.bdeapplication.R;
import fr.iutmindfuck.bdeapplication.manager.UserSQLManager;
import fr.iutmindfuck.bdeapplication.service.SQLServices;

public class AuthentificationActivity extends AppCompatActivity {

    private UserSQLManager userSQLManager;
    private EditText passwordEdit;
    private Button connect;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);

        userSQLManager = new UserSQLManager(new SQLServices(this));

        passwordEdit = findViewById(R.id.auth_edit);
        connect = findViewById(R.id.connexion_button);

        context = this;

        animateComponent();

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

    private void animateComponent(){

        float maxWidthScreen = getMaxWidthOfScreen();

        ObjectAnimator buttonMember = ObjectAnimator.ofFloat(passwordEdit,"translationX",-1000.0f,0.0f);
        buttonMember.setInterpolator(new AccelerateDecelerateInterpolator());
        buttonMember.setDuration(1000);
        buttonMember.start();

        ObjectAnimator buttonGuest = ObjectAnimator.ofFloat(connect,"translationX",1000.0f,0.0f);
        buttonGuest.setInterpolator(new AccelerateDecelerateInterpolator());
        buttonGuest.setDuration(1000);
        buttonGuest.start();
    }

    private int getMaxWidthOfScreen(){
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        assert windowManager != null;
        return windowManager.getDefaultDisplay().getWidth();
    }

    private float getAbsoluteCoordinateOfView(View view){
        int[] location = new int[2];
        view.getLocationInWindow(location);
        return (float) location[0];
    }
}
