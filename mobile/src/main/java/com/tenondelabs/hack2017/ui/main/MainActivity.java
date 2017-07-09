package com.tenondelabs.hack2017.ui.main;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.tenondelabs.hack2017.R;
import com.tenondelabs.hack2017.ui.avances.AvanceListFragment;
import com.tenondelabs.hack2017.ui.entidad.EntidadListFragment;
import com.tenondelabs.hack2017.ui.gobernacion.GobernacionListFragment;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import butterknife.Bind;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar) Toolbar mToolbar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = AvanceListFragment.newInstance();
                    break;
                case R.id.navigation_dashboard:
                    fragment = GobernacionListFragment.newInstance();
                    break;
                case R.id.navigation_notifications:
                    fragment = EntidadListFragment.newInstance();
                    break;
            }

            if (fragment != null) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, fragment);
                fragmentTransaction.commit();
            }

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add code to print out the key hash
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.tenondelabs.hack2017",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.action_search) {
//            startActivity(new Intent(this, SearchActivity.class), ActivityAnimation.SLIDE_LEFT);
//            return true;
//        }
//        if (id == R.id.action_settings) {
//            startActivity(new Intent(this, SettingsActivity.class), ActivityAnimation.SLIDE_LEFT);
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

}
