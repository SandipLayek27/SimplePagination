package com.sandiplayek.simplepaginationlibrary;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sandiplayek.paginationlibrary.PageDetails;
import com.sandiplayek.paginationlibrary.PaginationFooterFragment;

public class MainActivity extends AppCompatActivity implements PaginationFooterFragment.OnButtonClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PageDetails.totalPageNumber="2";
        ((PaginationFooterFragment)getFragmentManager().findFragmentByTag("PaginationFooterFragment")).setOnFragmentBClickListener(this);
        PageDetails.totalPageNumber="6";


    }

    @Override
    public void onFirstPositionClick(int position) {
        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMiddlePositionClick(int position) {
        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLastPositionClick(int position) {
        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPrevButtonClick(int position) {
        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNextPositionClick(int position) {
        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSearchingPositionClick(int position) {
        Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();
    }
}
