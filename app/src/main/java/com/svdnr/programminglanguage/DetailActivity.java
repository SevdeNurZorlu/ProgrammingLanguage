package com.svdnr.programminglanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class DetailActivity extends AppCompatActivity {

    ImageView detailImage;
    TextView title, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailImage = findViewById(R.id.detailimageView);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        description.setMovementMethod(new ScrollingMovementMethod());
        getData();
    }

    private void getData() {

        if (getIntent().hasExtra("images") &&
                getIntent().hasExtra("data1") &&
                getIntent().hasExtra("data3")) {

            title.setText(getIntent().getStringExtra("data1"));
            description.setText(getIntent().getStringExtra("data3"));
            detailImage.setImageResource(getIntent().getIntExtra("images", 1));

        } else {

            Toast.makeText(this, "Veri Yok", Toast.LENGTH_SHORT).show();
        }
    }
}