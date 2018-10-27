package com.example.kaerah.flashcardapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        String s1 = getIntent().getStringExtra("stringKey1"); // this string will be 'harry potter`
        String s2 = getIntent().getStringExtra("stringKey2"); // this string will be 'voldemort'
        findViewById(R.id.closeBtn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AddCardActivity.this, MainActivity.class);
                AddCardActivity.this.startActivityForResult(intent, 100);
            }
        });


        findViewById(R.id.saveBtn).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent data = new Intent(); // create a new Intent, this is where we will put our data
                data.putExtra("string1", ((EditText) findViewById(R.id.questionTextField)).getText().toString()); // puts one string into the Intent, with the key as 'string1'
                data.putExtra("string2", ((EditText) findViewById(R.id.answerTextField)).getText().toString()); // puts another string into the Intent, with the key as 'string2
                setResult(RESULT_OK, data); // set result code and bundle data for response
                finish(); // closes this activity and pass data to the original activity that launched this activity

            }
        });
    }

}
