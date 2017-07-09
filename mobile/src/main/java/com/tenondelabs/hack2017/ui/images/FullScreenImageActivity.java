package com.tenondelabs.hack2017.ui.images;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.tenondelabs.hack2017.R;
import com.tenondelabs.hack2017.ui.util.Util;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FullScreenImageActivity extends AppCompatActivity {

    @Bind(R.id.my_image) ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.full_screen_image);
        ButterKnife.bind(this);
        setupImage();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @OnClick(R.id.my_image)
    public void cerrar(){
        finish();
    }

    private void setupImage() {
        String url = getIntent().getStringExtra(Util.IMAGE_URL);
        Picasso.with(this).load(url).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (width>height){
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }else {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                imgView.setImageBitmap(bitmap);
            }
            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
            }
            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
            }
        });
    }
}
