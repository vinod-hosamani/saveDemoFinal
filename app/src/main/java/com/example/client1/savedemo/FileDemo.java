package com.example.client1.savedemo;

import android.Manifest;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileDemo extends Activity implements View.OnClickListener {

    /**
     * Called when the activity is first created.
     */

    private final static String STORETEXT = "storetext.txt";
    Context context;

    Button copy;

    private ClipboardManager myClipboard;
    private ClipData myClip;


    EditText e2, e3, e4, e1, e5, e6, e7, e8, e9;
    TextView t2, t3, t4, t1, reusltRextView, t5, t6, t7, t8, t9;
    boolean hasPermission;

    @Override

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getpermission();
        initView();


        copy.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // String text;
                String  text = e1.getText().toString();
                myClip = ClipData.newPlainText("text", text);
                myClipboard.setPrimaryClip(myClip);

                String  text2 = e2.getText().toString();
                myClip = ClipData.newPlainText("text", text2);
                myClipboard.setPrimaryClip(myClip);

                String  text3 = e3.getText().toString();
                myClip = ClipData.newPlainText("text", text3);
                myClipboard.setPrimaryClip(myClip);

                String  text4 = e4.getText().toString();
                myClip = ClipData.newPlainText("text", text4);
                myClipboard.setPrimaryClip(myClip);

                String  text5 = e5.getText().toString();
                myClip = ClipData.newPlainText("text", text5);
                myClipboard.setPrimaryClip(myClip);

                String  text6 = e6.getText().toString();
                myClip = ClipData.newPlainText("text", text6);
                myClipboard.setPrimaryClip(myClip);

                String  text7 = e7.getText().toString();
                myClip = ClipData.newPlainText("text", text7);
                myClipboard.setPrimaryClip(myClip);

                String  text8 = e8.getText().toString();
                myClip = ClipData.newPlainText("text", text8);
                myClipboard.setPrimaryClip(myClip);

                String  text9 = e9.getText().toString();
                myClip = ClipData.newPlainText("text", text9);
                myClipboard.setPrimaryClip(myClip);


                Toast.makeText(getApplicationContext(), "Text Copied successfully", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void initView() {
         copy=(Button)findViewById(R.id.copy);

        reusltRextView = (TextView) findViewById(R.id.resultTextView);

        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);


        e1 = (EditText) findViewById(R.id.textbox);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        e4 = (EditText) findViewById(R.id.editText4);
        e5 = (EditText) findViewById(R.id.editText5);
        e6 = (EditText) findViewById(R.id.editText6);
        e7 = (EditText) findViewById(R.id.editText7);
        e8 = (EditText) findViewById(R.id.editText8);
        e9 = (EditText) findViewById(R.id.editText9);


        t2 = (TextView) findViewById(R.id.textview2);
        t3 = (TextView) findViewById(R.id.textView3);
        t4 = (TextView) findViewById(R.id.textView4);
        t1 = (TextView) findViewById(R.id.textview1);
        t5 = (TextView) findViewById(R.id.textView5);
        t6 = (TextView) findViewById(R.id.textView6);
        t7 = (TextView) findViewById(R.id.textview7);
        t8 = (TextView) findViewById(R.id.textview8);
        t9 = (TextView) findViewById(R.id.textview9);

        setListener();

    }

    public void setListener()
    {
        //read.setOnClickListener(this);
    }

    public void saveClicked(View v) {
        try {
            File logFile = new File("sdcard/vinod.txt");
            if (!logFile.exists()) {
                try {
                    logFile.createNewFile();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            try {
                //BufferedWriter for performance, true to set append to file flag
                BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));
                buf.append(t1.getText().toString());
                buf.append("---->" + "\t");
                buf.append(e1.getText().toString());
                buf.append("\n\n");
                buf.append(t2.getText().toString());
                buf.append("---->" + "\t");
                buf.append(e2.getText().toString());
                buf.append("\n\n");
                buf.append(t3.getText().toString());
                buf.append("---->" + "\t");
                buf.append(e3.getText().toString());
                buf.append("\n\n");
                buf.append(t4.getText().toString());
                buf.append("---->" + "\t");
                buf.append(e4.getText().toString());
                buf.append("\n\n");

                buf.append(t5.getText().toString());
                buf.append("---->" + "\t");
                buf.append(e5.getText().toString());
                buf.append("\n\n");
                buf.append(t6.getText().toString());
                buf.append("---->" + "\t");
                buf.append(e6.getText().toString());
                buf.append("\n\n");
                buf.append(t7.getText().toString());
                buf.append("---->" + "\t");
                buf.append(e7.getText().toString());
                buf.append("\n\n");
                buf.append(t8.getText().toString());
                buf.append("---->" + "\t");
                buf.append(e8.getText().toString());
                buf.append("\n\n");
                buf.append(t9.getText().toString());
                buf.append("---->" + "\t");
                buf.append(e9.getText().toString());
                buf.append("\n\n");


                buf.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            // OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
            // File logFile = new File("sdcard/Foodgenielog.txt");
//            OutputStreamWriter out = new OutputStreamWriter(openFileOutput(STORETEXT, 0));
//            out.write(t1.getText().toString());
//            out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
//            out.write(e1.getText().toString());
//            out.write("\n\n");
//            out.write(t2.getText().toString());
//            out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
//            out.write(e2.getText().toString());
//            out.write("\n\n");
//            out.write(t3.getText().toString());
//            out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
//            out.write(e3.getText().toString());
//            out.write("\n\n");
//            out.write(t4.getText().toString());
//            out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
//            out.write(e4.getText().toString());
//            out.write("\n\n");
//
//            out.close();
            Toast.makeText(this, "The contents are saved in the file.", Toast.LENGTH_LONG).show();
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public void readFileInEditor() {
        try {
            InputStream in = openFileInput("sdcard/vinod.txt");
            if (in != null) {
                InputStreamReader tmp = new InputStreamReader(in);
                BufferedReader reader = new BufferedReader(tmp);
                String str;
                StringBuilder buf = new StringBuilder();
                while ((str = reader.readLine()) != null) {
                    buf.append(str + "\n");
                }
                in.close();
                reusltRextView.setText(buf.toString());
            }
        } catch (java.io.FileNotFoundException e) {

            // that's OK, we probably haven't created it yet
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
           /* case R.id.buttonRead:
                readFileInEditor();
                break;*/

            case R.id.save:
                saveClicked(view);

        }

    }


    private static final int REQUEST_WRITE_STORAGE = 112;

    public void getpermission() {
        hasPermission = (ContextCompat.checkSelfPermission(FileDemo.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
        if (!hasPermission) {
            ActivityCompat.requestPermissions(FileDemo.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_WRITE_STORAGE);

        }
    }


}
