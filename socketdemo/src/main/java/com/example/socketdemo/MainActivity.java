package com.example.socketdemo;

import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private static final String HOST = "192.168.33.93";
    private static final int PORT = 8899;
    private StringBuffer stringBuffer;
    private Socket socket;

    private EditText etSend, etReceive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSend = findViewById(R.id.et_send);
        etReceive = findViewById(R.id.et_receive);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket(HOST, PORT);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

   /* ServerSocket serverSocket = new ServerSocket(8899);
    Socket socket = serverSocket.accept();
    OutputStream oStream = null;
    InputStream iStream = null;
		System.out.println("server ready to connection");

    iStream = socket.getInputStream();

    byte[] bytes = new byte[1024];
    int len;

    StringBuffer sbuffer = new StringBuffer();
		while ((len = iStream.read(bytes)) != -1) {
        sbuffer.append(new String(bytes, 0, len, "UTF-8"));
        System.out.println("内容是：" + sbuffer);

        oStream = socket.getOutputStream();
        oStream.write(new String(bytes, 0, len, "UTF-8").getBytes("UTF-8"));
        System.out.println("send message " + new String(bytes, 0, len, "UTF-8"));
    }*/

    public void Send(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OutputStream os = null;
                //写数据
                try {
                    os = socket.getOutputStream();
                    String message = etSend.getText().toString();
                    Log.i("Blues", message);
                    os.write(message.getBytes(StandardCharsets.UTF_8));

                    InputStream is = socket.getInputStream();
                    byte[] bytes = new byte[1024];
                    int len;
                    stringBuffer = new StringBuffer();
                    while ((len = is.read(bytes)) != -1) {
                        Log.i("Blues", "len: " + len);
                        stringBuffer.append(new String(bytes, 0, len, StandardCharsets.UTF_8));
                        Log.i("Blues", String.valueOf(stringBuffer));

                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                etReceive.setText(stringBuffer);
                            }
                        });
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (socket != null)  socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
