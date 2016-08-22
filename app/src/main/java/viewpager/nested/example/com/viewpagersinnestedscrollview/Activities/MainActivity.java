package viewpager.nested.example.com.viewpagersinnestedscrollview.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import viewpager.nested.example.com.viewpagersinnestedscrollview.Fragments.FragmentBottom;
import viewpager.nested.example.com.viewpagersinnestedscrollview.Fragments.FragmentTop;
import viewpager.nested.example.com.viewpagersinnestedscrollview.R;
import viewpager.nested.example.com.viewpagersinnestedscrollview.Utilities.Constants;

public class MainActivity extends AppCompatActivity {

    private NestedScrollView mNestedScrollView;

    private ViewPager viewPagerTop;
    private ViewPager viewPagerBottom;
    private PageAdapterTop pageAdapterTop;
    private PageAdapterBottom pageAdapterBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Constants.buildGlobalArrayList();

        mNestedScrollView = (NestedScrollView) findViewById(R.id.nestedscrollview);
        viewPagerTop = (ViewPager) findViewById(R.id.viewpager_top);
        viewPagerBottom = (ViewPager) findViewById(R.id.viewpager_bottom);

        setUpViewPager();

        mNestedScrollView.smoothScrollTo(0, 0);
    }

    private void setUpViewPager() {
        pageAdapterTop = new PageAdapterTop(getSupportFragmentManager());
        viewPagerTop.setAdapter(pageAdapterTop);

        pageAdapterBottom = new PageAdapterBottom(getSupportFragmentManager());
        viewPagerBottom.setAdapter(pageAdapterBottom);

        viewPagerTop.setCurrentItem(0);
        viewPagerBottom.setCurrentItem(0);

        viewPagerTop.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // Set the proper scrolling here
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPagerBottom.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // Set the proper scrolling here
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public class PageAdapterTop extends FragmentStatePagerAdapter {

        public PageAdapterTop(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            Fragment fragment;
            Bundle bundle = new Bundle();

            switch (pos) {
                case 0:
                    fragment = new FragmentTop();
                    bundle.putString(Constants.TEXT, "View pager 1 Top");
                    fragment.setArguments(bundle);
                    break;
                case 1:
                    fragment = new FragmentTop();
                    bundle.putString(Constants.TEXT, "View pager 2 Top");
                    fragment.setArguments(bundle);
                    break;
                default:
                    fragment = new Fragment();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    public class PageAdapterBottom extends FragmentStatePagerAdapter {

        public PageAdapterBottom(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            Fragment fragment;

            switch (pos) {
                case 0:
                    fragment = new FragmentBottom();
                    break;
                case 1:
                    fragment = new FragmentBottom();
                    break;
                default:
                    fragment = new Fragment();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
