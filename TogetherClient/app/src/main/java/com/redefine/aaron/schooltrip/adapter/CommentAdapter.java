package com.redefine.aaron.schooltrip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.redefine.aaron.schooltrip.R;
import com.redefine.aaron.schooltrip.bean.Comment;

import java.util.List;

/**
 * Created by aaron on 14-11-23.
 */
public class CommentAdapter extends BaseAdapter {

    private Context context;
    private List<Comment> items;
    private ViewHolder  viewHolder= new ViewHolder();

    public CommentAdapter(Context context,List<Comment> items){
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.comment_layout,null);
            viewHolder.username = (TextView) view.findViewById(R.id.coment_username);
            viewHolder.comment = (TextView) view.findViewById(R.id.coment_content);

            view.setTag(viewHolder);
        }

        viewHolder.username.setText(items.get(i).getUsername()+":");
        viewHolder.comment.setText(items.get(i).getContent());


        return view;

    }

    private static class ViewHolder{
        private TextView username;
        private TextView comment;
    }
}
