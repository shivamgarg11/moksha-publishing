package com.vrishankgupta.chatting.SubEvents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.vrishankgupta.chatting.EventsActivityDance;
import com.vrishankgupta.chatting.HomeActivity;
import com.vrishankgupta.chatting.R;

public class Zephyr extends AppCompatActivity {

    Button regButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zephyr_details);
        regButton = (Button) findViewById(R.id.regButton);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://play.google.com/store/apps/details?id=com.a99cherries.eventful.free";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        ImageView signOut,homeIcon;
        signOut = (ImageView) findViewById(R.id.sign_out_icon);
        homeIcon = (ImageView) findViewById(R.id.home_icon);

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AuthUI.getInstance().signOut(Zephyr.this).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getApplicationContext(),"Signed Out",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }
        });

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                finish();
            }
        });
    }
}
