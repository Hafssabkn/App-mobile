package com.example.montionnote;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText nomInput;
    private EditText note1Input;
    private EditText note2Input;
    private EditText note3Input;
    private EditText note4Input;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nomInput = findViewById(R.id.nom);
        note1Input = findViewById(R.id.note1);
        note2Input = findViewById(R.id.note2);
        note3Input = findViewById(R.id.note3);
        note4Input = findViewById(R.id.note4);
        resultText = findViewById(R.id.resultText);
        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateMontion();
            }
        });
    }

    private void calculateMontion() {
        String nomStr = nomInput.getText().toString();
        String note1Str = note1Input.getText().toString();
        String note2Str = note2Input.getText().toString();
        String note3Str = note3Input.getText().toString();
        String note4Str = note4Input.getText().toString();

        if (TextUtils.isEmpty(nomStr) || TextUtils.isEmpty(note1Str) || TextUtils.isEmpty(note2Str) || TextUtils.isEmpty(note3Str) || TextUtils.isEmpty(note4Str)) {
            Toast.makeText(this, "Please enter your nom and you notes", Toast.LENGTH_SHORT).show();
            return;
        }

        float note1 = Float.parseFloat(note1Str);
        float note2 = Float.parseFloat(note2Str);
        float note3 = Float.parseFloat(note3Str);
        float note4 = Float.parseFloat(note4Str);

        if (note1 < 0 || note2 < 0 || note3 < 0 || note4 < 0) {
            Toast.makeText(this, "Note should not be lower to 0", Toast.LENGTH_SHORT).show();
            return;
        }

        if (note1 > 20 || note2 > 20 || note3 > 20 || note4 > 20) {
            Toast.makeText(this, "Note should not be superior to 20", Toast.LENGTH_SHORT).show();
            return;
        }

        float resultNote = (note1 + note2 + note3 + note4) / 4;
        String Noteresult = interpetNote(resultNote);
        resultText.setText("Salut Ms/Mme " + nomStr + "\n"  +" your average is :" + resultNote + "\n"+ Noteresult);
    }

    private String interpetNote(float resultNote) {
        if (resultNote < 10) {
            return "Echec.";
        } else if (resultNote >= 10 && resultNote < 12) {
            return "Assez bien.";
        } else if (resultNote >= 12 && resultNote < 14) {
            return "Bien.";
        } else if (resultNote >= 14 && resultNote < 16) {
            return "Trés bien.";
        } else {
            return "Excellent.";
        }
    }
}
