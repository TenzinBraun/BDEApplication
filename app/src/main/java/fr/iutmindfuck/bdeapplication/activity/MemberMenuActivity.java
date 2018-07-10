package fr.iutmindfuck.bdeapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import fr.iutmindfuck.bdeapplication.R;

public class MemberMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_menu);
    }

    public void onAddEventButtonClick(View view) {
        startActivity(new Intent(MemberMenuActivity.this, AddArticleActivity.class));
    }
}
