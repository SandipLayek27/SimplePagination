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
        bundle.putString("PAGE NUMBER","20");
        bundle.putInt("PAGINATION COLOR",R.drawable.gradient_background);
        PaginationFooterFragment paginationFooterFragment = new PaginationFooterFragment();
        paginationFooterFragment.setArguments(bundle);

        //showing the dynamic fragment to the activity
        getFragmentManager().beginTransaction().replace(R.id.ll_fragment_container, paginationFooterFragment).commit();

        //clicking on the pagignation button
        paginationFooterFragment.setOnFragmentBClickListener(new PaginationFooterFragment.OnButtonClickListener() {
            @Override
            public void onFirstPositionClick(int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onMiddlePositionClick(int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onLastPositionClick(int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onPrevButtonClick(int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNextPositionClick(int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onSearchingPositionClick(int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
