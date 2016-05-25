package com.mileapps.androidanimations;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mileapps.androidanimations.animations.CardFlipActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lstAnimations;
    private ListAdapter lstAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lstAnimations = (ListView) findViewById(R.id.lstAnimations);
        lstAdapter = new ListAdapter(animations());
        lstAnimations.setAdapter(lstAdapter);

        lstAnimations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(getApplicationContext(), CardFlipActivity.class));
                        break;
                }
            }
        });
    }

    private ArrayList<String> animations() {
        ArrayList<String> myAnimations = new ArrayList<>();
        myAnimations.add("Card flip");
        return myAnimations;
    }

    class ListAdapter extends BaseAdapter {

        private ArrayList<String> animations;

        public ListAdapter(ArrayList<String> animations) {
            this.animations = animations;
        }

        @Override
        public int getCount() {
            return animations.size();
        }

        @Override
        public Object getItem(int position) {
            return animations.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.item_list_animations, null);
            }
            TextView txtAnimationName = (TextView) view.findViewById(R.id.txtAnimationName);
            txtAnimationName.setText(animations.get(position));
            return view;
        }
    }

}
