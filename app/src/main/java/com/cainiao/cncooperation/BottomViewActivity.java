package com.cainiao.cncooperation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.cainiao.cncooperation.adapter.BottomViewPagerAdapter;
import com.cainiao.cncooperation.fragment.AttentionFragment;
import com.cainiao.cncooperation.fragment.DiscoveryFragment;
import com.cainiao.cncooperation.fragment.HomeFragment;
import com.cainiao.cncooperation.fragment.ProfileFragment;
import com.cainiao.cncooperation.fragment.ShoppingCartFragment;
import com.cainiao.cncooperation.util.BottomNavigationViewHelper;

public class BottomViewActivity extends AppCompatActivity {

    public BottomNavigationView mBottomNavigationView;
    public ViewPager mViewPager;
    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_navigation_bar);
        initView();
    }


    /***
     * 初始化主界面的布局
     */
    private void initView() {

        mBottomNavigationView  = (BottomNavigationView) findViewById(R.id.navigation);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
        mBottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_home:
                                mViewPager.setCurrentItem(0);
                                break;
                            case R.id.menu_discovery:
                                mViewPager.setCurrentItem(1);
                                break;
                            case R.id.menu_attention:
                                mViewPager.setCurrentItem(2);
                                break;
                            case R.id.menu_profile:
                                mViewPager.setCurrentItem(3);
                                break;
                            case R.id.menu_shopping_cart:
                                mViewPager.setCurrentItem(4);
                                break;
                        }
                        return false;
                    }
                });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    mBottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = mBottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


/*      //禁止viewpager的滑动事件
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
*/
        setupViewPager(mViewPager);

    }


    private void setupViewPager(ViewPager viewPager) {
        BottomViewPagerAdapter adapter = new BottomViewPagerAdapter(getSupportFragmentManager());

<<<<<<< HEAD
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new DiscoveryFragment());
        adapter.addFragment(new AttentionFragment());
        adapter.addFragment(new ProfileFragment());
        adapter.addFragment(new ShoppingCartFragment());
=======
        adapter.addFragment(HomeFragment.newInstance("主页"));
        adapter.addFragment(DiscoveryFragment.newInstance("发现"));
        adapter.addFragment(AttentionFragment.newInstance("关注"));
        adapter.addFragment(ProfileFragment.newInstance("我的"));
>>>>>>> aa886f77a6f23efcb9945a91e781e3c106c34ebc
        viewPager.setAdapter(adapter);
    }

}
