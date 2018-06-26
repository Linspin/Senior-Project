package com.example.pc1.smartlock;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {


    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static final String EXTRA_MESSAGE = "com.example.smartlock.MESSAGE";

    public void login(View view) {
        Intent intent = new Intent(this, MainpageActivity.class);
        //EditText user = findViewById(R.id.editTextUser);
        EditText password = findViewById(R.id.editTextpass);
        //String usertxt = user.getText().toString();
        String passtxt = password.getText().toString();

        final String[] pass = new String[1];



        final Task<QuerySnapshot> users = db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    public static final String TAG = "";

                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                //Log.d(TAG, document.getString("Password"));
                                //pass[0] = document.getString("Password");
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });


        if(password.getText().toString().equals("admin")) {
                startActivity(intent);
        }
        else{
            Toast.makeText(MainActivity.this, "Wrong Password",
                    Toast.LENGTH_SHORT).show();
    //      }

    }


}
}
