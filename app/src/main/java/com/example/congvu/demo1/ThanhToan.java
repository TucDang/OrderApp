package com.example.congvu.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.congvu.adapter.ThanhToanAdapter;
import com.example.congvu.model.danhMuc;
import com.example.congvu.model.kbBanAn;
import com.google.firebase.database.DatabaseReference;
import java.text.NumberFormat;


import java.util.ArrayList;
import java.util.Map;

public class ThanhToan extends AppCompatActivity {

    DatabaseReference mData;

    TextView txtTongTien;
    TextView txtTenBanAn;
    ListView lvThanhToan;
    ArrayList<danhMuc> dsThanhToan;
    ThanhToanAdapter thanhToanAdapter;
    Intent intent;
    double tongTien;
    kbBanAn tenBanAn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtTongTien = (TextView) findViewById(R.id.txtTongTien);
        txtTenBanAn = (TextView) findViewById(R.id.txtTenBanAn);
        lvThanhToan = (ListView) findViewById(R.id.lvThanhToan);

        dsThanhToan = new ArrayList<>();
        setDSThanhToan();
        thanhToanAdapter = new ThanhToanAdapter(ThanhToan.this, R.layout.layout_thanh_toan, dsThanhToan);
        lvThanhToan.setAdapter(thanhToanAdapter);


        NumberFormat nbf = NumberFormat.getCurrencyInstance();
        txtTongTien.append(nbf.format(tongTien));

    }
    public void setDSThanhToan()
    {
        intent = getIntent();
        Bundle bundle = intent.getBundleExtra("DANHMUC");
        ArrayList<danhMuc> dsMon = (ArrayList<danhMuc>) bundle.get("dsMon");
        ArrayList<danhMuc> dsDoUong = (ArrayList<danhMuc>) bundle.get("dsDoUong");
        ArrayList<danhMuc> dsSinhTo = (ArrayList<danhMuc>) bundle.get("dsSinhTo");

        for (Map.Entry<String, Integer> entry:DanhMucActivity.lMonUserSelect.entrySet() ){
            boolean monXuly = false;
            for (int j = 0; j < dsMon.size(); j++)
            {
                if (entry.getKey().equals("" + dsMon.get(j).getMa())){
                    dsThanhToan.add(dsMon.get(j));
                    monXuly = true;
                    tongTien += dsMon.get(j).getGia();
                }
            }
            if (!monXuly){
                for (int j = 0; j < dsDoUong.size(); j++)
                {
                    if (entry.getKey().equals("" + dsDoUong.get(j).getMa())){
                        dsThanhToan.add(dsDoUong.get(j));
                        monXuly = true;
                        tongTien += dsDoUong.get(j).getGia();
                    }
                }
            }
            if (!monXuly){
                for (int j = 0; j < dsSinhTo.size(); j++)
                {
                    if (entry.getKey().equals("" + dsSinhTo.get(j).getMa())){
                        dsThanhToan.add(dsSinhTo.get(j));
                        monXuly = true;
                        tongTien += dsSinhTo.get(j).getGia();
                    }
                }
            }

        }
    }


}

