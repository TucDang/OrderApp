package com.example.congvu.adapter;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.congvu.demo1.R;
import com.example.congvu.model.danhMuc;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ThanhToanAdapter extends ArrayAdapter<danhMuc> {

    Activity context;
    int resource;
    List<danhMuc> objects;
    public ThanhToanAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List<danhMuc> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);
        ImageView imgAnhThanhToan = (ImageView) row.findViewById(R.id.imgAnhThanhToan);
        TextView txtTenMonThanhToan = (TextView) row.findViewById(R.id.txtTenMonThanhToan);
        TextView txtGiaThanhToan = (TextView) row.findViewById(R.id.txtGiaThanhToan);

        final danhMuc danhmuc = this.objects.get(position);
        txtTenMonThanhToan.setText(danhmuc.getTenMon());
        txtGiaThanhToan.setText(danhmuc.gia + "đồng/phần");
        Picasso.with(context).load(objects.get(position).linkHinh).into(imgAnhThanhToan);
        return row;
    }
}
