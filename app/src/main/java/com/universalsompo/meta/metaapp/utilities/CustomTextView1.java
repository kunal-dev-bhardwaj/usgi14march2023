package com.universalsompo.meta.metaapp.utilities;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class CustomTextView1 extends androidx.appcompat.widget.AppCompatTextView {

    public CustomTextView1(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public CustomTextView1(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public CustomTextView1(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("fonts/Montserrat-Regular.ttf", context);
        setTypeface(customFont);
    }
}
