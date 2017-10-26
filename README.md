# SimplePagination
It's a Pagination Library, which provide Numbering pagination i,e 1,2,3....
User can hit 1, 2 and 3 buttons and also hit previous and next button. Each and every time it gives response.

## Developed
[![Sandip](https://avatars1.githubusercontent.com/u/31722942?v=4&u=18643bfaaba26114584d27693e9891db26bcb582&s=39) Sandip](https://github.com/SandipLayek27)  
[![Arunava](https://avatars2.githubusercontent.com/u/31703258?v=4&s=40) Arunava](https://github.com/ghosharunava)

# ★ Screen
https://github.com/SandipLayek27/SimplePagination/blob/master/paginationlibrary/src/main/assets/pagination_screens.png

# ★ Gradle Dependency
Add Gradle dependency in the build.gradle file of your application module (app in the most cases) :
First Tab:

```sh
allprojects{
    repositories{
        jcenter()
        maven {
            url 'https://jitpack.io'
        }
    }
}
```

AND

```sh
dependencies {
    compile 'com.github.SandipLayek27:SimplePagination:1.1'
}
```
# ★ Uses of this features.
```sh
❆ activity_main.xml PAGE:-
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.sandiplayek.simplepaginationlibrary.MainActivity">
    <LinearLayout
        android:layout_weight="1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/ll_view"
        android:gravity="center"
        android:orientation="horizontal">
        //YOUR MAIN CONTENT WHICH IS DEPENDENT BY PAGINATION
    </LinearLayout>
    <LinearLayout
        android:orientation="vertical"
        android:id="@+id/ll_fragment_container"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        //PAGINATION CONTAINER
    </LinearLayout>
</LinearLayout>
----------------------------------------------------------------------------------------------------------
❆ MainActivity.java PAGE:-
package com.sandiplayek.simplepaginationlibrary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.sandiplayek.paginationlibrary.PaginationFooterFragment;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = new Bundle();
        bundle.putString("PAGE NUMBER","20");  //Passing page number
        bundle.putInt("PAGINATION COLOR",R.drawable.gradient_background);   //Pagination background Color
        PaginationFooterFragment paginationFooterFragment = new PaginationFooterFragment();
        paginationFooterFragment.setArguments(bundle);

        //showing the dynamic fragment to the activity
        getFragmentManager().beginTransaction().replace(R.id.ll_fragment_container, paginationFooterFragment).commit();

        //clicking on the pagination button 
        paginationFooterFragment.setOnFragmentBClickListener(new PaginationFooterFragment.OnButtonClickListener() {
            @Override
            public void onFirstPositionClick(int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                //When 1st position click then this case fire. here you can hit whebservice respect 1st position.
            }
            @Override
            public void onMiddlePositionClick(int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                //When middle position click then this case fire. here you can hit whebservice respect middle position.
            }
            @Override
            public void onLastPositionClick(int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                //When last position click then this case fire. here you can hit whebservice respect last position.
            }
            @Override
            public void onPrevButtonClick(int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                //When previous position click then this case fire. here you can hit whebservice respect previous position.
            }
            @Override
            public void onNextPositionClick(int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                //When next position click then this case fire. here you can hit whebservice respect next position.
            }
            @Override
            public void onSearchingPositionClick(int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                //When search button click then this case fire. here you can hit whebservice respect searching page number.
            }
        });
    }
}



```
