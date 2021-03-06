package com.example.project_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LstViewAdapter extends ArrayAdapter<String> {
    int groupid;
    String[] item_list;
    String[] item_list2;
    private Integer[] imageid;
    ArrayList<String> desc;
    Context context;
    public LstViewAdapter(Context context, int vg, int id, String[] item_list, String[] item_list2, Integer[] imageid){
        super(context,vg, id, item_list);
        this.context=context;
        groupid=vg;
        this.item_list=item_list;
        this.item_list2=item_list2;
        this.imageid = imageid;
    }
    // Hold views of the ListView to improve its scrolling performance
    static class ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public TextView textview1;
        public Button button;


    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        // Inflate the list_item.xml file if convertView is null
        if(rowView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView= inflater.inflate(groupid, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) rowView.findViewById(R.id.img);
            viewHolder.textView=(TextView)rowView.findViewById(R.id.txt);
            viewHolder.textview1= (TextView) rowView.findViewById(R.id.txt1);
            // viewHolder.button= (Button) rowView.findViewById(R.id.bt);
            rowView.setTag(viewHolder);

        }
        // Set text to each TextView of ListView item
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.imageView.setImageResource(imageid[position]);
        holder.textView.setText(item_list[position]);
        holder.textview1.setText(item_list2[position]);
        return rowView;
    }

}
