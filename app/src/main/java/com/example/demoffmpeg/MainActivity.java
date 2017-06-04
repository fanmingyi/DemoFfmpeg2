package com.example.demoffmpeg;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private SurfaceView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        sv = (SurfaceView) findViewById(R.id.sv);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native void plays(String videoPath, Surface surface);

    //点击播放视频
    public void onClick(View view) {
        final File inputFile = new File(Environment.getExternalStorageDirectory(),"a.mp4");
        //由于是耗时操作 所以开了个线程
        new Thread(){
            public void run() {
                plays(inputFile.getAbsolutePath(),sv.getHolder().getSurface() );
            };
        }.start();

    }
}
