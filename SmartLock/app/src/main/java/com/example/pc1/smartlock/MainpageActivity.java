package com.example.pc1.smartlock;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainpageActivity extends AppCompatActivity {


    private static final String TAG = "";
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    Switch switch1,switch2,switch3,switchlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

    }

    @Override
    protected void onStart() {
        super.onStart();

        switch1 = (Switch) findViewById(R.id.switch1);
        switch2 = (Switch) findViewById(R.id.switch2);
        switch3 = (Switch) findViewById(R.id.switch3);
        switchlock = (Switch) findViewById(R.id.switchlock);

        String str1;
        if (switchlock.isChecked())
            str1 = switchlock.getTextOn().toString();
        else
            str1 = switchlock.getTextOff().toString();

        switchlock.setText(str1);

        switch1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(MainpageActivity.this, ".....",
                        //Toast.LENGTH_SHORT).show();
                DocumentReference lightRef = db.collection("electronics").document("light");

                lightRef
                        .update("status", switch1.isChecked())
                        .addOnSuccessListener(new OnSuccessListener<Void>() {


                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully updated!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error updating document", e);
                            }
                        });

            }
        });

        switch2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(MainpageActivity.this, ".....",
                        //Toast.LENGTH_SHORT).show();
                DocumentReference lightRef = db.collection("electronics").document("TV");

                lightRef
                        .update("status", switch2.isChecked())
                        .addOnSuccessListener(new OnSuccessListener<Void>() {


                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully updated!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error updating document", e);
                            }
                        });

            }
        });

        switch3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(MainpageActivity.this, ".....",
                        //Toast.LENGTH_SHORT).show();
                DocumentReference lightRef = db.collection("electronics").document("Air");

                lightRef
                        .update("status", switch3.isChecked())
                        .addOnSuccessListener(new OnSuccessListener<Void>() {


                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully updated!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error updating document", e);
                            }
                        });

            }
        });


        switchlock.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String str1;
                if (switchlock.isChecked())
                    str1 = switchlock.getTextOn().toString();
                else{
                    str1 = switchlock.getTextOff().toString();

                    if(switch1.isChecked()||switch2.isChecked()||switch3.isChecked())
                        Toast.makeText(MainpageActivity.this, "There is still some device working. \nYou might want to close that before leaving.",
                            Toast.LENGTH_LONG).show();

                }

                switchlock.setText(str1);

                //Toast.makeText(MainpageActivity.this, ".....",
                //Toast.LENGTH_SHORT).show();
                DocumentReference lightRef = db.collection("users").document("Pond");

                lightRef
                        .update("Active", switchlock.isChecked())
                        .addOnSuccessListener(new OnSuccessListener<Void>() {


                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully updated!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error updating document", e);
                            }
                        });

            }
        });


    }
}
