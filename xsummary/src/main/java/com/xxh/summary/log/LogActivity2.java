package com.xxh.summary.log;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.xxh.summary.R;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class LogActivity2 extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "LogActivity";
    String cmds = "";
    StringBuilder Sb = new StringBuilder("this is log");
    private BufferedReader mReader = null;
    private Process exec;
    private int mPId;
    private String mPID;
    private boolean mRunning = true;
    EditText etlog, etlog2;
    Button btnStop, btnSave, btnClear;
    RandomAccessFile randomFile = null;
    private String DIR;
    String currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        etlog = findViewById(R.id.et_logs);
        btnStop = findViewById(R.id.btn_stop);
        btnStop.setOnClickListener(this);
        btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);
        btnClear = findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(this);
        mPId = android.os.Process.myPid();
        mPID = String.valueOf(mPId);
        // cmds = "logcat  *:e *:d | grep \"(" + mPID + ")\"";
        cmds = "logcat  *:e *:d | grep \"(" + "com.xxh.application" + ")\"";
        DIR = Objects.requireNonNull(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)).toString();
       /* Log.e(TAG, "目录: dir=" + DIR);
        Date date=new Date();
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
        currentTime=dateFormat.format(new Date());
        Log.e(TAG, "onCreate currentTime="+currentTime);*/

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-ddHHmmss", Locale.CHINA);
        String date = format1.format(new Date(System.currentTimeMillis()));
        String path = DIR + "/" + date + ".log";
        try {
            randomFile = new RandomAccessFile(path, "rw");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
        try {
            String[] cs = new String[]{"logcat", "*:V"};
            exec = Runtime.getRuntime().exec(cs);
            mReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String line = "";
                    try {
                        while ((line = mReader.readLine()) != null) {
                            //关闭日志打印
                           // if(line.c)
                            if (!mRunning) {
                                if (exec != null) {
                                    exec.destroy();
                                    Log.e(TAG, "日志打印结束");
                                }
                                if (mReader != null) {
                                    try {
                                        mReader.close();
                                        mReader = null;
                                    } catch (IOException e) {

                                    }
                                }
                                break;
                            }
                            Sb.append(line);
                           // randomFile.write(line.getBytes());
                            if (line.length() == 0) {
                                continue;
                            }
                            final Message msg = Message.obtain();
                            msg.what = 2;
                            msg.obj = line + "\n";
                            mhandler.sendMessage(msg);
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        Log.e(TAG, e.toString());
                    } finally {
                        Log.e(TAG, "finally");
                        Log.e(TAG, "" + mRunning);
                        if (line == null) {
                            Log.e(TAG, "line is null");
                        }
                        if (exec != null) {
                            exec.destroy();
                        }
                        if (mReader != null) {
                            try {
                                mReader.close();
                                mReader = null;
                            } catch (IOException e) {
                            }
                        }
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //startShowLog();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRunning = false;
        if (exec != null) {
            exec.destroy();
        }
        if (mReader != null) {
            try {
                mReader.close();
                mReader = null;
            } catch (IOException e) {
            }
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_stop){
            mRunning = false;
        }else if(v.getId()==R.id.btn_save){
            try {
                if (DIR != null) {
                    randomFile.write(etlog.getText().toString().getBytes());
                    Toast t = Toast.makeText(this, "日志保存成功,path=" , Toast.LENGTH_SHORT);
                    t.show();
                }
            } catch (IOException e) {
                //e.printStackTrace();
                Log.d(TAG, e.toString());
            }
        }else if(v.getId()==R.id.btn_clear){
            etlog.setText("");
            etlog2.setText("");
        }
    }


    @SuppressLint("HandlerLeak")
    Handler mhandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    break;
                case 2:
                    //显示日志
                   // etlog.setMovementMethod(ScrollingMovementMethod.getInstance());
                    //etlog.setSelection(etlog.getText().length(), etlog.getText().length());
                    etlog.setText(etlog.getText().append(msg.obj.toString()));
                    break;
            }
        }
    };
}