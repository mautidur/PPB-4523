package com.sleep.tugasakhir.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sleep.tugasakhir.R;
import com.sleep.tugasakhir.model.Data;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> lists;

    public Adapter(Activity activity, List<Data> lists){
        this.activity = activity;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null && inflater !=null){
            view = inflater.inflate(R.layout.list_users, null);
        }
        if (view != null) {
            TextView name = view.findViewById(R.id.names);
            TextView harga = view.findViewById(R.id.hargas);
            TextView jenis = view.findViewById(R.id.jenis);
            Data data = lists.get(i);
            name.setText(data.getName());
            harga.setText(data.getHarga());
            jenis.setText(data.getJenis());
        }
        return view;
    }
}
