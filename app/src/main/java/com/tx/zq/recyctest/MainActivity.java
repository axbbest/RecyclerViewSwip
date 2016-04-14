package com.tx.zq.recyctest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import com.tx.zq.recyctest.Base.Main2Activity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemTouchHelperAdapter {

    private helper callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //安小贝


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.re);
        ArrayList<String> s = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            s.add(i + "");
        }
        LinearLayoutManager l = new LinearLayoutManager(this);
        GridLayoutManager g = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(l);
        RecycAdapter recycAdapter = new RecycAdapter(this, s);
        recyclerView.setAdapter(recycAdapter);
        callback = new helper(recycAdapter,this);

        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);

        touchHelper.attachToRecyclerView(recyclerView);

    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Toast.makeText(MainActivity.this, toPosition + "", 0).show();

    }

    @Override
    public void onItemDismiss(int position) {
        startActivity(new Intent(MainActivity.this,Main2Activity.class));
    }
}
