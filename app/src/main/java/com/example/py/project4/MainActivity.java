package com.example.py.project4;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends Activity {

    private final static String NAME = "name";
    private final static String CLASS_ID = "class_id";
    private final static String INFORMATION = "information";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] name = {"周建亭", "周一", "周二"};
        String[] class_id = {"班级：计科1505,学号：2015011385", "班级：计科1503班,学号：2015011111", "班级：计科1501班,学号：2015011356"};
        String[] information = {"男,13856434", "男,54664", "女,7777777"};

        List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();

        for (int i = 0; i < name.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put(NAME, name[i]);
            item.put(CLASS_ID, class_id[i]);
            item.put(INFORMATION, information[i]);
            items.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, items, R.layout.item, new String[]{NAME, CLASS_ID, INFORMATION}, new int[]{R.id.txtName, R.id.txtClassId, R.id.txtInformation});

        ListView list = (ListView) findViewById(R.id.list);

        list.setAdapter(adapter);
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
