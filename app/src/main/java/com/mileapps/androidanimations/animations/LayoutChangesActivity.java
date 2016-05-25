package com.mileapps.androidanimations.animations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mileapps.androidanimations.R;
import com.mileapps.androidanimations.common.Utilities;

public class LayoutChangesActivity extends AppCompatActivity {

    private static final String[] COUNTRIES = new String[]{
            "Belgium", "France", "Italy", "Germany", "Spain",
            "Austria", "Russia", "Poland", "Croatia", "Greece",
            "Ukraine",
    };

    private ViewGroup mContainerView;
    private ImageButton imgBtnToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_changes);
        Utilities.makeToolbar(this, true);
        imgBtnToolbar = (ImageButton)findViewById(R.id.imgBtnToolbar);
        mContainerView = (ViewGroup) findViewById(R.id.container);

        imgBtnToolbar.setBackgroundResource(android.R.drawable.ic_menu_add);
        imgBtnToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
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

    private void addItem() {
        final ViewGroup newView = (ViewGroup) LayoutInflater.from(this).inflate(
                R.layout.item_list_layout_changes, mContainerView, false);

        ((TextView) newView.findViewById(R.id.txtText)).setText(
                COUNTRIES[(int) (Math.random() * COUNTRIES.length)]);

        newView.findViewById(R.id.imgBtnDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContainerView.removeView(newView);
                if (mContainerView.getChildCount() == 0) {
                    findViewById(R.id.txtEmpty).setVisibility(View.VISIBLE);
                }
            }
        });

        mContainerView.addView(newView, 0);

        if (mContainerView.getChildCount() > 0) {
            findViewById(R.id.txtEmpty).setVisibility(View.INVISIBLE);
        }
    }
}
