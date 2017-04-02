package com.example.congvu.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.congvu.demo1.ChonBanAn;
import com.example.congvu.demo1.DanhMucActivity;
import com.example.congvu.demo1.R;
import com.example.congvu.model.kbBanAn;

import java.util.List;

/**
 * Created by CongVu on 3/13/2017.
 */
public class BanAn extends ArrayAdapter<kbBanAn>
{
    Activity context; //Màn hình sử dụng layout này (giao diện này)
    int resource; // Layout cho từng dòng muốn hiển thị
    List<kbBanAn> objects; // Danh sách nguồn dữ liệu muốn hiển thị lên giao diện

    public BanAn(Activity context, int resource, List<kbBanAn> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);

        TextView txtTenBanAn = (TextView) row.findViewById(R.id.txtTenBanAn);
        ImageButton btnBanAn = (ImageButton) row.findViewById(R.id.btnBanAn);

        // Trả về Bàn Ăn hiện tại muốn vẽ
        final kbBanAn kbBanAn = this.objects.get(position);
        txtTenBanAn.setText(kbBanAn.getTen());

        btnBanAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyChuyenDoiToDM(kbBanAn);
            }
        });

        return row;
    }

    private void xuLyChuyenDoiToDM(kbBanAn kbBanAn) {
        Intent intenttoDanhMuc = new Intent(this.context, DanhMucActivity.class);
        intenttoDanhMuc.putExtra("ThongTinBan", kbBanAn);
        this.context.startActivity(intenttoDanhMuc);

    }
}
