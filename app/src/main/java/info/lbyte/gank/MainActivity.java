package info.lbyte.gank;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.facebook.drawee.backends.pipeline.Fresco;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FragmentTransaction mFgTransaction;
    private Fragment mFuliFragment;
    private Fragment mAndroidFragment;
    private Fragment mIosFragment;
    private Fragment mHomeFragment;
    private Toolbar mToolBar;
    private BottomNavigationBar mBottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mFgTransaction = getSupportFragmentManager().beginTransaction();

        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        mBottomNavigationBar
                .setActiveColor(R.color.colorPrimary)
                .setInActiveColor("#FFFFFF")
                .setBarBackgroundColor("#ECECEC");
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "Home"))
                .addItem(new BottomNavigationItem(R.drawable.ic_tag_faces_white_24dp, "福利")).setActiveColor("#03A9F4")
                .addItem(new BottomNavigationItem(R.drawable.ic_android_white_24dp, "Android").setActiveColor("#00BCD4"))
                .addItem(new BottomNavigationItem(R.drawable.ic_phone_iphone_white_24dp, "iOS").setActiveColor("#009688"))
//                .addItem(new BottomNavigationItem(R.drawable.ic_android_white_24dp, "Games").setActiveColor("#3f51b5"))
                .initialise();
        mBottomNavigationBar.setTabSelectedListener(mOnTabSelectedListener);

        if (savedInstanceState == null) {
            mHomeFragment = new GankFragment();
            Bundle args = new Bundle();
            args.putString("type", "all");
            mHomeFragment.setArguments(args);
            mFgTransaction.add(R.id.root, mHomeFragment);
//            mFgTransaction.addToBackStack(null);
            mFgTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private BottomNavigationBar.OnTabSelectedListener mOnTabSelectedListener = new BottomNavigationBar.OnTabSelectedListener() {
        @Override
        public void onTabSelected(int position) {
            switch (position) {
                case 0:
                    replaceFragment(mHomeFragment);
                    setTitle("干货集中营");
//                    mToolBar.setBackgroundColor(getResources().getColor(R.color.color_home));
                    break;
                case 1:
                    if (mFuliFragment == null) {
                        mFuliFragment = new GankFragment();
                        Bundle args = new Bundle();
                        args.putString("type", "福利");
                        mFuliFragment.setArguments(args);
                    }
                    replaceFragment(mFuliFragment);
                    setTitle("福利");
                    break;
                case 2:
                    if (mAndroidFragment == null) {
                        mAndroidFragment = new GankFragment();
                        Bundle args = new Bundle();
                        args.putString("type", "Android");
                        mAndroidFragment.setArguments(args);
                    }
                    replaceFragment(mAndroidFragment);
                    setTitle("Android");
                    break;
                case 3:
                    if (mIosFragment == null) {
                        mIosFragment = new GankFragment();
                        Bundle args = new Bundle();
                        args.putString("type", "iOS");
                        mIosFragment.setArguments(args);
                    }
                    replaceFragment(mIosFragment);
                    setTitle("iOS");
                    break;
            }
        }

        @Override
        public void onTabUnselected(int position) {

        }

        @Override
        public void onTabReselected(int position) {

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.root, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.all) {
            // Handle the camera action

            replaceFragment(mHomeFragment);
        } else if (id == R.id.fuli) {
            if (mFuliFragment == null) {
                mFuliFragment = new GankFragment();
                Bundle args = new Bundle();
                args.putString("type", "福利");
                mFuliFragment.setArguments(args);
            }
            replaceFragment(mFuliFragment);


        } else if (id == R.id.android) {
            if (mAndroidFragment == null) {
                mAndroidFragment = new GankFragment();
                Bundle args = new Bundle();
                args.putString("type", "Android");
                mAndroidFragment.setArguments(args);
            }
            replaceFragment(mAndroidFragment);

        } else if (id == R.id.ios) {
            if (mIosFragment == null) {
                mIosFragment = new GankFragment();
                Bundle args = new Bundle();
                args.putString("type", "iOS");
                mIosFragment.setArguments(args);
            }
            replaceFragment(mIosFragment);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
