package com.example.animate;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.Glide;

public class BindingAdapters {

    @BindingAdapter("imageResId")
    public static void loadImage(ImageView view, Integer resId) {
        if (resId != null) {
            Glide.with(view.getContext())
                    .load(resId)
                    .into(view);
        }
    }
}
