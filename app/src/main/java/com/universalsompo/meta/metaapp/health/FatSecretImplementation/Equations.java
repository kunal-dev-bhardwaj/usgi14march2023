package com.universalsompo.meta.metaapp.health.FatSecretImplementation;

import android.content.Context;

public class Equations {
    public static int dpToPx(Context context, float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((dp * scale) + 0.5f);
    }
}
