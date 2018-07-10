package fr.iutmindfuck.bdeapplication.activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import fr.iutmindfuck.bdeapplication.R;
import fr.iutmindfuck.bdeapplication.data.SessionData;

public class ConnexionActivity extends AppCompatActivity {
    private ImageView logo;
    private Button memberButton;
    private Button guestButton;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        logo = findViewById(R.id.logo_bigg);
        memberButton = findViewById(R.id.member_connexion_button);
        guestButton = findViewById(R.id.guest_connexion_button);

        context = this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        animateComponent();
    }

    public void onMemberButtonClick(View view){
        SessionData.createNewSession(true);
        startActivity(new Intent(ConnexionActivity.this, AuthentificationActivity.class));
    }
    public void onGuestButtonClick(View view){
        SessionData.createNewSession(false);
        startActivity(new Intent(ConnexionActivity.this, EventActivity.class));
    }

    private void animateComponent(){

        int startOffSet = 0;

        ArrayList<View> views = new ArrayList<>();
        views.add(logo);
        views.add(memberButton);
        views.add(guestButton);

        for (int i = 0; i < views.size(); i++) {
            final ObjectAnimator fadeAnimator = ObjectAnimator.ofFloat(views.get(i), "alpha", 0, 1);
            fadeAnimator.setDuration(700);
            fadeAnimator.setStartDelay(startOffSet);
            fadeAnimator.start();

            final ObjectAnimator translateAnimator = ObjectAnimator.ofFloat(views.get(i), "translationX", 0);
            translateAnimator.setDuration(800);
            translateAnimator.setStartDelay(startOffSet);
            translateAnimator.setInterpolator(new OvershootInterpolator());
            translateAnimator.start();

            final ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(views.get(i), "scaleX", 2.0f, 0.8f, 1.0f);
            scaleXAnimator.setDuration(500);
            scaleXAnimator.setStartDelay(startOffSet);
            scaleXAnimator.start();

            final ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(views.get(i), "scaleY", 2.0f, 0.8f, 1.0f);
            scaleYAnimator.setDuration(500);
            scaleYAnimator.setStartDelay(startOffSet);
            scaleYAnimator.start();

            startOffSet += 200;
        }
    }
}
