package org.pltw.examples.collegeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.ArrayList;

import static android.R.attr.queryActionMsg;
import static android.R.attr.x;

public class ApplicantActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    String APP_ID = "1243E1F9-2DE8-66B9-FF87-65D8F17F3700";
    String ANDROID_API_KEY = "F29AFC2E-A949-A0AC-FF7B-553CB706AC00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant);


        /*ArrayList<User> users = new ArrayList<>();
        String[] fname = new String[]{"Camryn", "Jason", "Big", "Lil'"};
        String[] lname = new String[]{"Byrd", "Bourne", "Mike", "Pump"};
        String[] gname1 = new String[]{"Travis", "John", "Papi", "Big Groove"};
        String[] gname2 = new String[]{"Latifah", "Patrick", "Mami", "Gazzy"};

        for (int x = 0, x<4, x++){
            Profile profile = new Profile(fname[x], lname[x]);
            Guardian guardian1 = new Guardian(gname1[x], gname2[x]);
            Guardian guardian2 = new Guardian(gname1[x], gname2[x]);
            User user = new User("User"+String.valueOf(x+1), "Password"+String.valueOf(x+1), profile, guardian1, guardian2,);
            users.add(user);
        }*/

        Backendless.initApp(this, APP_ID, ANDROID_API_KEY);
        BackendlessUser user = new BackendlessUser();
        user.setEmail("clwclw3@gmail.com");
        user.setPassword("bonk");

        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>(){
            @Override
            public void handleResponse(BackendlessUser backendlessUser){
                Log.i( "User ", backendlessUser.getEmail() + " successfully registered" );
            }
            @Override
            public void handleFault(BackendlessFault backendlessFault) {
                Log.e( "Backendless reg error! ", backendlessFault.getMessage());
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.applicant, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment contentFragment = null;

        if (id == R.id.family_member) {
            contentFragment = new GuardianFragment();
        }

        else if (id == R.id.profile) {
            contentFragment = new ProfileFragment();
        }

        if (contentFragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, contentFragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
