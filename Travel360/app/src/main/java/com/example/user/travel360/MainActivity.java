package com.example.user.travel360;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{

    //2016-07-23 PM 10:09
    // 오탁은
    // 수정사항
    // 1)기존의 fab로 존재했었던 메시지 버튼을 삭제하고 관련 코드를 삭제했습니다.
    // 2)네비게이션 드로어의 xml 파일을 수정했습니다. 기존 네비게이션 드로어의 항목들을 바꾸었습니다.
    // 수정된 파일 : MainActivity.java, content_main.xml, nav_header_main.xml

    //oncreate 함수 내에 존재했었던 fab 관련 코드를 삭제했습니다.
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // 툴바
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
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) // 드로어가 열렸으면 닫기
        {
            drawer.closeDrawer(GravityCompat.START);
        } else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //네비게이션 드로어에 항목을 추가하기 위해 코드를 추가했습니다.
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) // 네비게이션 항목이 선택되면 불리는 함수
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera)
        {
            // Handle the camera action
        } else if (id == R.id.nav_gallery)
        {

        } else if (id == R.id.nav_slideshow)
        {

        } else if (id == R.id.nav_manage)
        {

        }
        // 여기서부터 추가한 사항들입니다. 그냥 그대로 추가했습니다.
        else if (id == R.id.nav_notifications)
        {

        }
        else if (id == R.id.nav_question)
        {

        }
        else if (id == R.id.nav_connectVR)
        {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
