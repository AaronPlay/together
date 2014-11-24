package com.redefine.aaron.schooltrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.redefine.aaron.schooltrip.adapter.CardsAdapter;

import java.util.ArrayList;


public class MainActivity extends Activity {
    private ListView cardlistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardlistview = (ListView) findViewById(R.id.card_list);

        ListAdapter adapter = createAdapter();

        cardlistview.setAdapter(adapter);

        cardlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListView listView = (ListView) adapterView;
                Intent intent = new Intent(MainActivity.this,TripActivity.class);
                Log.d("TTTTT", "ItemOnclick");
                startActivity(intent);
            }
        });
    }

    private void setupList() {

        
    }

    private ListAdapter createAdapter() {
        ArrayList<String> items = new ArrayList<String>();

        for(int i = 0; i<100; i++){
            items.add(i,"Text for List Item"+1);
        }

        return new CardsAdapter(getApplication(),items,null);
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
