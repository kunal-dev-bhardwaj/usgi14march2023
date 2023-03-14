package com.universalsompo.meta.metaapp.utilities;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;

import com.universalsompo.meta.metaapp.intefaces.KeyboardVisibilityListener;

public class KeyboardUtil {
    public static void setKeyboardVisibilityListener(Activity activity, final KeyboardVisibilityListener keyboardVisibilityListener) {
        final View contentView = activity.findViewById(android.R.id.content);
        contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            private int mPreviousHeight;

            @Override
            public void onGlobalLayout() {
                int newHeight = contentView.getHeight();
                if (mPreviousHeight != 0) {
                    if (mPreviousHeight > newHeight) {
                        keyboardVisibilityListener.onKeyboardVisibilityChanged(true);
                    } else if (mPreviousHeight < newHeight) {
                        keyboardVisibilityListener.onKeyboardVisibilityChanged(false);
                    }
                }
                mPreviousHeight = newHeight;
            }
        });
    }
}
