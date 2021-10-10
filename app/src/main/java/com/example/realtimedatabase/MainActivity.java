package com.example.realtimedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    EditText name,age;
    Button save;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        save=findViewById(R.id.save);
        databaseReference= FirebaseDatabase.getInstance().getReference("Users");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveData();
            }
        });
    }

    private void saveData() {
        String nme = name.getText().toString().trim();
        String ag = age.getText().toString().trim();
        String key = databaseReference.push().getKey();
        Model model=new Model(nme,ag);
        databaseReference.child(key).setValue(model);
        Toast.makeText(getApplicationContext(),"Data store success",Toast.LENGTH_LONG).show();
    }
}