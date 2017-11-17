package com.animeshjain.assignment71;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText searchKeyEDT;
    Button resetBtn, searchBtn;
    String searchKeyStr, url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchKeyEDT= (EditText)findViewById(R.id.searchBoxEDT);
        resetBtn = (Button)findViewById(R.id.resetButton);
        searchBtn= (Button)findViewById(R.id.searchButton);

        //initializing the search button

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //run a check to see weather search box contaions something and not empty

                if (!searchKeyEDT.getText().toString().isEmpty()) {

                    searchKeyStr = searchKeyEDT.getText().toString();

                    Toast.makeText(MainActivity.this, "Showing result for " + searchKeyStr, Toast.LENGTH_SHORT).show();

                    //Creating URL for Google Seaech with the search keyword attached

                    url = "https://www.google.co.in/search?q=" + searchKeyStr;

                    //Making intent to go to the URL

                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(i);

                }else{

                    Toast.makeText(MainActivity.this, "Search Box Empty, Please Try Again",Toast.LENGTH_LONG).show();
                }
            }
        });

        // Reset Button:: if user wants to clear the search Field

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchKeyEDT.setText("");

                Toast.makeText(MainActivity.this, "You Just Pressed The Reset Button",Toast.LENGTH_SHORT).show();
            }
        });

    }


}
