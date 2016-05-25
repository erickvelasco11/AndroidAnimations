package com.mileapps.androidanimations.animations;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.mileapps.androidanimations.R;
import com.mileapps.androidanimations.common.Utilities;
import com.mileapps.androidanimations.fragments.ScreenSlidePageFragment;

import java.util.ArrayList;

public class ScreenSlideActivity extends AppCompatActivity {

    private ViewPager vwPgrPages;
    private ScreenSlidePagerAdapter pgrAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);
        Utilities.makeToolbar(this, true, "Screen slide");
        vwPgrPages = (ViewPager) findViewById(R.id.vwPgrPages);
        pgrAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), createPages());
        vwPgrPages.setAdapter(pgrAdapter);

    }

    private ArrayList<ScreenSlidePageFragment> createPages() {
        ArrayList<ScreenSlidePageFragment> pages = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            pages.add(ScreenSlidePageFragment.create(i));
        }
        return pages;
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

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        private ArrayList<ScreenSlidePageFragment> pages;

        public ScreenSlidePagerAdapter(FragmentManager fm, ArrayList<ScreenSlidePageFragment> pages) {
            super(fm);
            this.pages = pages;
        }

        @Override
        public Fragment getItem(int position) {
            return pages.get(position);
        }

        @Override
        public int getCount() {
            return pages.size();
        }
    }
}
