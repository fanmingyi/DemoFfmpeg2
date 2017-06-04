package com.example.demoffmpeg;

import android.content.Context;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * Created by FMY on 2017/6/3.
 */

public class VideoView extends SurfaceView {

    public VideoView(Context context) {
        this(context, null);
    }

    public VideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //初始化设置格式
        init();
    }

    //初始化设置格式
    private void init() {
        getHolder().setFormat(PixelFormat.RGBA_8888);
    }


}
