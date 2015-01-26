package com.example.recyclerview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.recyclerview.adapter.CustomRecyclerAdapter;
import com.example.recyclerview.model.Data;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private CustomRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private EditText mText;
    private EditText mColor;

    private List<Data> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing views.
        mText = (EditText) findViewById(R.id.textEt);
        mColor = (EditText) findViewById(R.id.colorEt);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);

        // If the size of views will not change as the data changes.
        mRecyclerView.setHasFixedSize(true);

        // Setting the LayoutManager.
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Setting the adapter.
        mAdapter = new CustomRecyclerAdapter();
        mRecyclerView.setAdapter(mAdapter);

    }

    // Called when add button is clicked.
    public void addItem(View view) {

        // Add data locally to the list.
        Data dataToAdd = new Data(
                mText.getText().toString(),
                mColor.getText().toString());
        mData.add(dataToAdd);

        // Update adapter.
        mAdapter.addItem(mData.size()-1, dataToAdd);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
