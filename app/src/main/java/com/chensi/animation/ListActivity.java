package com.chensi.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends Activity {
    private ListView lvListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lvListView = (ListView) findViewById(R.id.lvListView);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
                list.add("慕课网" + i);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        lvListView.setAdapter(arrayAdapter);
        LayoutAnimationController lac = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
        lvListView.setLayoutAnimation(lac);
        lvListView.startLayoutAnimation();
    }
}
