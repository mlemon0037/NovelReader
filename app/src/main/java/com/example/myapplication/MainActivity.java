package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import java.io.*;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void load(View v) throws IOException {
        String line;

        LinearLayout library = findViewById(R.id.library);

        String path = "libinfo.nvl";
        // Create the parent path
//        File file = new File(getFilesDir(), path);
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
//
//        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
//        bufferedWriter.write("The Legendary Mechanic&https://readlightnovels.net/the-legendary-mechanic.html&384\nForty Millenniums of Cultivation&https://readlightnovels.net/forty-millenniums-of-cultivation.html&355");
//        bufferedWriter.flush();
//        bufferedWriter.close();

        Context ctx = getApplicationContext();

        FileInputStream fileInputStream = ctx.openFileInput(path);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader br = new BufferedReader(inputStreamReader);

        while((line = br.readLine())!= null) {
            Button novel = new Button(this);

            Log.d("newbtn", line);
            String[] data = line.split("&");
            Log.d("debug", data[0]);
            Log.d("debug", data[1]);
            Log.d("debug", data[2]);

            String btnText = String.format("%s\n%s Unread Chapters", data[0], data[2]);
            novel.setText(btnText);
            library.addView(novel);
        }
        br.close();
    }
}
