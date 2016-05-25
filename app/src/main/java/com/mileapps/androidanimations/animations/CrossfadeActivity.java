
package com.mileapps.androidanimations.animations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.mileapps.androidanimations.MainActivity;
import com.mileapps.androidanimations.R;
import com.mileapps.androidanimations.common.Utilities;

public class CrossfadeActivity extends AppCompatActivity {

    private int mShortAnimationDuration;
    private ImageButton imgBtnToolbar;
    private View loading;
    private View content;
    private boolean viewLoading = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crossfade);
        Utilities.makeToolbar(this, true);
        imgBtnToolbar = (ImageButton) findViewById(R.id.imgBtnToolbar);
        content = findViewById(R.id.content);
        loading = findViewById(R.id.loading_spinner);

        imgBtnToolbar.setBackgroundResource(R.drawable.ic_flip);
        content.setVisibility(View.GONE);

        mShortAnimationDuration = getResources().getInteger(android.R.integer.config_shortAnimTime);

        imgBtnToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewLoading) {
                    showContentOrLoadingIndicator(loading, content);
                }else{
                    showContentOrLoadingIndicator(content, loading);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showContentOrLoadingIndicator(final View hideView, final View showView) {
        showView.setAlpha(0f);
        showView.setVisibility(View.VISIBLE);
        showView.animate()
                .alpha(1f)
                .setDuration(mShortAnimationDuration)
                .setListener(null);
        hideView.animate()
                .alpha(0f)
                .setDuration(mShortAnimationDuration)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        hideView.setVisibility(View.GONE);
                    }
                });
        viewLoading = !viewLoading;
    }
}
