package com.example.tryintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.displayText:{
                Toast toast = Toast.makeText(this, "Editing", Toast.LENGTH_LONG);
                View toastView = toast.getView();
                toastView.setBackgroundColor(Color.YELLOW);
                toast.setView(toastView);
                toast.setText("Editing.........");
                toast.show();
            }

                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHello = findViewById(R.id.btnHello);
        Button btnPass = findViewById(R.id.btnPass);
        Button btnChoose = findViewById(R.id.btnChoose);
        EditText edtSearch = findViewById(R.id.edtSearch);
        TextView displayText = findViewById(R.id.displayText);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Button btnNotification = findViewById(R.id.btnNotification);

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                displayText.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        displayText.setOnClickListener(this);

        btnHello.setOnClickListener(v -> {
            if (!edtSearch.getText().toString().isEmpty()) {
                String q = edtSearch.getText().toString();
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, q);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Empty Search", Toast.LENGTH_SHORT).show();
            }
        });

        btnPass.setOnClickListener(v -> {
            Intent i = new Intent(this, Activity2.class);
            Bundle bundle = new Bundle();
            bundle.putString("Message", edtSearch.getText().toString());
            i.putExtras(bundle);
            startActivity(i);
        });

        btnChoose.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + 911));
            startActivity(intent);
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.Male:
                        Toast.makeText(MainActivity.this, "Male", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Female:
                        Toast.makeText(MainActivity.this, "Female", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        btnNotification.setOnClickListener(v -> {
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

            mBuilder.setSmallIcon(R.drawable.baseline_notifications_24);
            mBuilder.setContentTitle("Notification Alert, Click Me!");
            mBuilder.setContentText("Hi, This is Android Notification Detail!");
        });


        View layout = getLayoutInflater().inflate(R.layout.activity_2, findViewById(R.id.textView));
        Toast t = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        t.setView(layout);
        t.show();

    }

}