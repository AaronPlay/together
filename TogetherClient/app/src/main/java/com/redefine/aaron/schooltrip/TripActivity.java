package com.redefine.aaron.schooltrip;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;

import com.redefine.aaron.schooltrip.adapter.CommentAdapter;
import com.redefine.aaron.schooltrip.adapter.PhotoAdapter;
import com.redefine.aaron.schooltrip.bean.Comment;

import java.util.ArrayList;


public class TripActivity extends Activity {
    private GridView photoGirdView;
    private ListView commentlistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);

        photoGirdView = (GridView) findViewById(R.id.photo_wall);
        commentlistView = (ListView) findViewById(R.id.comment_wall);

        PhotoAdapter photoAdapter = new PhotoAdapter(this,0,Images.imageThumbUrls,photoGirdView);
        photoGirdView.setAdapter(photoAdapter);
        CommentAdapter commentAdapter = testAdapter();
        commentlistView.setAdapter(commentAdapter);

    }

    private CommentAdapter testAdapter() {
        ArrayList<Comment> list = new ArrayList<Comment>();
        Comment c = new Comment();
        c.setUsername("Aaron");
        c.setContent("好玩吗？");
        list.add(c);
        c = new Comment();
        c.setUsername("安然");
        c.setContent("好玩，强烈推荐");
        list.add(c);

        return new CommentAdapter(this,list);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_trip, menu);
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
