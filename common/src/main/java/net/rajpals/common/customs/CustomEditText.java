package net.rajpals.common.customs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import androidx.appcompat.widget.AppCompatEditText;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.MotionEvent;

import net.rajpals.common.R;
import net.rajpals.common.customs.fonts.FontCache;



public class CustomEditText extends AppCompatEditText {
    private OnTouchListener mListener;

    public interface OnTouchListener {
        public abstract void onTouch();
    }

    private static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            applyCustomFont(context, attrs, 0);
        }
    }

    public CustomEditText(Context context) {
        super(context);
        if (!isInEditMode()) {
            applyCustomFont(context, null, 0);
        }
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode()) {
            applyCustomFont(context, attrs, defStyle);
        }
    }

    private void applyCustomFont(Context context, AttributeSet attrs, int defStyle) {
        TypedArray attributeArray = context.obtainStyledAttributes(attrs, R.styleable.CustomEditText);

        String fontName = attributeArray.getString(R.styleable.CustomEditText_fontLegacy);
        int textStyle = attributeArray.getInteger(R.styleable.CustomEditText_textStyle, Typeface.NORMAL);

        if (fontName == null) {
            return;
        }

        // fetch type face :
        Typeface customFont = FontCache.getTypeface(context, fontName, textStyle);

        //Setting face
        setTypeface(customFont);
        // setting formation
        setTransformationMethod(null);
        attributeArray.recycle();
    }
    public void setListener(OnTouchListener listener) {
        mListener = listener;
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if(mListener == null )
            return super.dispatchTouchEvent(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mListener.onTouch();
                break;
            case MotionEvent.ACTION_UP:
                mListener.onTouch();
                break;
        }
        return super.dispatchTouchEvent(event);
    }

    public void setLength(int maxLength){
        setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
    }
}