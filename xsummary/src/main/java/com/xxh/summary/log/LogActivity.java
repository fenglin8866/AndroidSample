package com.xxh.summary.log;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.xxh.summary.R;
import com.xxh.summary.feedback.log.LogService;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LogActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "LogActivity";
    EditText etlog, etlog2;
    Button btnStop, btnSave, btnClear;

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
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_stop){
            LogService.stopLogService(this);
        }else if(v.getId()==R.id.btn_save){
            LogService.startLogService(this);
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
                    etlog.setMovementMethod(ScrollingMovementMethod.getInstance());
                    etlog.setSelection(etlog.getText().length(), etlog.getText().length());
                    etlog.setText(etlog.getText().append(msg.obj.toString()));
                    break;
            }
        }
    };

    private void uploadFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            Toast.makeText(this, "文件不存在", Toast.LENGTH_SHORT).show();
            return;
        }

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(),
                        RequestBody.create(MediaType.parse("application/octet-stream"), file))
                .build();

        Request request = new Request.Builder()
                .url("")
                .post(requestBody)
                .build();

        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 处理上传失败情况
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // 处理上传成功情况
            }
        });
    }
}