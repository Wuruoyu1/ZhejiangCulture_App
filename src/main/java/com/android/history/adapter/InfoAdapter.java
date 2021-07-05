package com.android.history.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.history.R;
import com.android.history.bean.Info;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;


public class InfoAdapter extends ArrayAdapter<Info> {
    private int resourceId;
    private ItemListener mItemListener;
    public void setItemListener(ItemListener itemListener){
        this.mItemListener = itemListener;
    }
    public InfoAdapter(Context context, int textViewResourceId,
                       List<Info> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        Info info =getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.image =(ImageView)view.findViewById(R.id.image);
            viewHolder.name =(TextView)view.findViewById(R.id.name);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        Glide.with(parent.getContext())
                .asBitmap()
                .load(info.getImage())
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(viewHolder.image);
        viewHolder.name.setText(info.getName());

        return view;
    }
    class ViewHolder{
        ImageView image;
        TextView name;
    }
    public interface ItemListener{
        void ItemClick(Info info);
        void ItemLongClick(Info info);
    }
}
