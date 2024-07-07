package com.example.sicalculator;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView SI_text1,SI_text2;
    EditText SI_editText1,SI_editText2,SI_editText3;
    Button SI_Btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        SI_text1=findViewById(R.id.SI_text1);
        SI_text2=findViewById(R.id.SI_text2);
        SI_editText1=findViewById(R.id.SI_editText1);
        SI_editText2=findViewById(R.id.SI_editText2);
        SI_editText3=findViewById(R.id.SI_editText3);
        SI_Btn1=findViewById(R.id.SI_Btn1);
        SI_Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // getting Input from the user and converting into Double



                Double Principle=Double.parseDouble(SI_editText1.getText().toString());
                Double Interest=Double.parseDouble(SI_editText2.getText().toString());
                Double years=Double.parseDouble(SI_editText3.getText().toString());



                // calling a method SICALCULATOR and assigning the value of p , r , and t
                Double SI=SICALCULATOR(Principle,Interest,years);
                SI_text2.setText(" "+SI);


            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemID= item.getItemId();
        if(itemID==R.id.ACTION_Like){
            Toast.makeText(this,
                    "Thanks for giving a like",
                    Toast.LENGTH_LONG).show();
        } else if (itemID==R.id.ACTION_Dislike) {
            Toast.makeText(this,
                    "oops! Sorry we give a update soon ",
                    Toast.LENGTH_LONG).show();

        }
        return super.onOptionsItemSelected(item);
    }

    public double SICALCULATOR(Double Principle, Double Interest, Double years){

        // calculating SI with formula of si=(p*r*t)/100
        Double SimpleInterest=(Principle*Interest*years)/100;

        return SimpleInterest;
    }


}