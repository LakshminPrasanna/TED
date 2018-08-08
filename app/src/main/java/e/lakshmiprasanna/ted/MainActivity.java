package e.lakshmiprasanna.ted;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private TabLayout mtablayout;
    private ViewPager mviewPager;
    Context context;
    int tabIconColor;


    private int[] tabIcons={
            R.drawable.ic_list_black_24dp,
            R.drawable.ic_subscriptions_black_24dp,
            R.drawable.ic_headset_black_24dp,
            R.drawable.ic_lightbulb_outline_black_24dp,
            R.drawable.ic_account_circle_black_24dp

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = getApplicationContext();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });

        mviewPager = (ViewPager) findViewById(R.id.view_pager);
        addTabs(mviewPager);


        mtablayout = (TabLayout) findViewById(R.id.tabs);
        mtablayout.setupWithViewPager(mviewPager);
        mviewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mtablayout));

        setupTabIcons();
        }
        private void setupTabIcons() {
            mtablayout.getTabAt(0).setIcon(tabIcons[0]);
            mtablayout.getTabAt(1).setIcon(tabIcons[1]);
            mtablayout.getTabAt(2).setIcon(tabIcons[2]);
            mtablayout.getTabAt(3).setIcon(tabIcons[3]);
            mtablayout.getTabAt(4).setIcon(tabIcons[4]);

            mtablayout.addOnTabSelectedListener(
                    new TabLayout.ViewPagerOnTabSelectedListener(mviewPager) {

                        @Override
                        public void onTabSelected(TabLayout.Tab tab) {
                            super.onTabSelected(tab);
                            tabIconColor = ContextCompat.getColor(context, R.color.colorPrimaryDark);
                            tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);

                        }

                        @Override
                        public void onTabUnselected(TabLayout.Tab tab) {
                            super.onTabUnselected(tab);
                            tabIconColor = ContextCompat.getColor(context, R.color.black);
                            tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        }

                        @Override
                        public void onTabReselected(TabLayout.Tab tab) {
                            super.onTabReselected(tab);

                        }
                    }
            );

        }
        private void addTabs(ViewPager mviewPager) {
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new FragmentTalks());
        adapter.addFrag(new FragmentPlaylists());
        adapter.addFrag(new FragmentPodcasts());
        adapter.addFrag(new FragmentSurprise());
        adapter.addFrag(new FragmentMyTalks());
        mviewPager.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.action_Login)
        {
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.action_feedback)
        {
            Intent intent = new Intent(MainActivity.this,FeedbackActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.action_privacy)
        {
            return true;
        }
            return super.onOptionsItemSelected(item);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount()
        {
            return mFragmentList.size();
        }
        private void addFrag(Fragment fragment)
        {
            mFragmentList.add(fragment);
        }

    }
    public void setActionBarTitle(String title) {

        getSupportActionBar().setTitle(title);
    }
}
