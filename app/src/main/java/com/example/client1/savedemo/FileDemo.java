package com.example.client1.savedemo;

import android.Manifest;
import android.app.Activity;
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

    /** Called when the activity is first created. */

    private final static String STORETEXT="storetext.txt";
  Context context;

    Button read;

    EditText e2,e3,e4,e1;
    TextView t2,t3,t4,t1,reusltRextView;
    boolean hasPermission;

    @Override

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //getpermission();
        initView();


    }

    public void initView()
    {
        read=(Button)findViewById(R.id.buttonRead);

        reusltRextView=(TextView)findViewById(R.id.resultTextView);


        e1 =(EditText)findViewById(R.id.textbox);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
        e4=(EditText)findViewById(R.id.editText4);

        t2=(TextView)findViewById(R.id.textview2);
        t3=(TextView)findViewById(R.id.textView3);
        t4=(TextView)findViewById(R.id.textView4);
        t1=(TextView)findViewById(R.id.textview1);

        setListener();

    }

    public void setListener()
    {
        read.setOnClickListener(this);
    }

    public void saveClicked(View v)
    {

        try
        {

            File logFile = new File("sdcard/vinod.txt");
            if (!logFile.exists())
            {
                try
                {
                    logFile.createNewFile();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            try
            {
                //BufferedWriter for performance, true to set append to file flag
                BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));
                buf.append(t1.getText().toString());
                buf.append("\t\t");
                buf.append(e1.getText().toString());
                buf.append("\n\n");
                buf.append(t2.getText().toString());
                buf.append("\t\t");
                buf.append(e2.getText().toString());
                buf.append("\n\n");
                buf.append(t3.getText().toString());
                buf.append("\t\t");
                buf.append(e3.getText().toString());
                buf.append("\n\n");
                buf.append(t4.getText().toString());
                buf.append("\t\t");
                buf.append(e4.getText().toString());
                buf.append("\n\n");
                buf.close();
            }
            catch (IOException e)
            {
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
        }
        catch (Throwable t)
        {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }
    public void readFileInEditor()
    {
        try {
            InputStream in = openFileInput("sdcard/vinod.txt");
            if (in != null)
            {
                InputStreamReader tmp=new InputStreamReader(in);
                BufferedReader reader=new BufferedReader(tmp);
                String str;
                StringBuilder buf=new StringBuilder();
                while ((str = reader.readLine()) != null)
                {
                    buf.append(str+"\n");
                }
                in.close();
                reusltRextView.setText(buf.toString());
            }
        }
        catch (java.io.FileNotFoundException e)
        {

             // that's OK, we probably haven't created it yet
        }
        catch (Throwable t)
        {
            Toast.makeText(this, "Exception: "+t.toString(), Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.buttonRead:
                readFileInEditor();
                break;

            case R.id.save:
                saveClicked(view);

        }

    }


    private static final int REQUEST_WRITE_STORAGE = 112;
    public void getpermission()
    {
        hasPermission = (ContextCompat.checkSelfPermission(FileDemo.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
        if (!hasPermission)
        {
            ActivityCompat.requestPermissions(FileDemo.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_WRITE_STORAGE);

        }
    }


}
