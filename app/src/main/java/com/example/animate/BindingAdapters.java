package com.example.animate;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;

public class BindingAdapters {

    @BindingAdapter({"app:srcCompat"})
    public static void setImageViewResource(ImageView imageView, String resourceName) {
        if (resourceName != null) {
            int resourceId = imageView.getContext().getResources().getIdentifier(resourceName, "drawable", imageView.getContext().getPackageName());
            if (resourceId != 0) {
                imageView.setImageResource(resourceId);
            }
        }
    }
}

