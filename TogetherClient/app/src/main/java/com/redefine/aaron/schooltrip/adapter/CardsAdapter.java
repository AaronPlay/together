package com.redefine.aaron.schooltrip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.redefine.aaron.schooltrip.R;

import java.util.List;

/**
 * Created by aaron on 14-11-19.
 */
public class CardsAdapter extends BaseAdapter {


    private  View.OnClickListener itemButtonClickListener;
    private  Context context;
    private  List<String> items;
    

    public CardsAdapter(Context context, List<String> items, View.OnClickListener itemButtonClickListener) {
        this.context = context;
        this.items = items;
        this.itemButtonClickListener = itemButtonClickListener;
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
        ViewHolder holder;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_card,null);

            holder = new ViewHolder();
            holder.tilte = (TextView) view.findViewById(R.id.title_item);
            holder.content = (TextView) view.findViewById(R.id.detail_item);
            holder.goodButton = (TextView) view.findViewById(R.id.good_btn);
            holder.comment = (TextView) view.findViewById(R.id.comment_btn);
            view.setTag(holder);
        }

        return view;
    }

    private static class ViewHolder{
        private TextView tilte;
        private TextView content;
        private TextView goodButton;
        private TextView comment;
    }
}
