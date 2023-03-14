package com.universalsompo.meta.metaapp.intefaces;

import android.graphics.Bitmap;

import com.android.volley.VolleyError;

public interface ImageListenerInterface {
    void getImageBitmap(Bitmap bitmap,int Tag);
    void getImageBitmapError(VolleyError error, int Tag);

}
