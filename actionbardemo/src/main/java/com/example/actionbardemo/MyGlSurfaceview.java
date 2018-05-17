package com.example.actionbardemo;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2018/1/29 0029.
 */

public class MyGlSurfaceview extends GLSurfaceView {
    public MyGlSurfaceview(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        MyGlRender render = new MyGlRender();
        setRenderer(render);
    }

    public MyGlSurfaceview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
