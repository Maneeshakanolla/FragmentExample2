package com.example.fragmentexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    MyPageViewAdapter myPageViewAdapter;
    ViewPager2 viewPager2;
    TabLayout tabLayout;

    @Override protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                tabLayout = findViewById(R.id.tablayout);
                myPageViewAdapter = new MyPageViewAdapter(getSupportFragmentManager(),getLifecycle());
                myPageViewAdapter.addFragment(new Fragment1());
                myPageViewAdapter.addFragment(new Fragment2());
                myPageViewAdapter.addFragment(new Fragment3());

                viewPager2 = findViewById(R.id.viewpage2);
                viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
                viewPager2.setAdapter(myPageViewAdapter);
                new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText("Fragment" + (position+1));
                    }
                }).attach();

            }
        }