package com.example.congvu.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.congvu.adapter.DanhMucAdapter;
import com.example.congvu.model.danhMuc;
import com.example.congvu.model.kbBanAn;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DanhMucActivity extends AppCompatActivity {

    DatabaseReference mData;

    Button btnback;
    TextView txtThongTinBan;
    Button btnOrder;

    ListView lvMonAnChinh;
    ArrayList<danhMuc> dsMon;
    DanhMucAdapter adapterDanhSachMon;

    ListView lvDoUong;
    ArrayList<danhMuc> dsDoUong;
    DanhMucAdapter adapterDoUong;

    ListView lvSinhTo;
    ArrayList<danhMuc> dsSinhTo;
    DanhMucAdapter adapterSinhTo;

    TabHost tabHost;

    kbBanAn thongTinBan;
    public static Map<String,Integer> lMonUserSelect = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_muc);

        btnback = (Button) findViewById(R.id.btnback);
        txtThongTinBan = (TextView) findViewById(R.id.txtThongTinBan);
        btnOrder = (Button) findViewById(R.id.btnOrder);

        lvMonAnChinh = (ListView) findViewById(R.id.lvMonAnChinh);
        dsMon = new ArrayList<>();
        adapterDanhSachMon = new DanhMucAdapter(DanhMucActivity.this, R.layout.layout_danhmuc, dsMon);
        lvMonAnChinh.setAdapter(adapterDanhSachMon);

        lvDoUong = (ListView) findViewById(R.id.lvDoUong);
        dsDoUong = new ArrayList<>();
        adapterDoUong = new DanhMucAdapter(DanhMucActivity.this, R.layout.layout_danhmuc, dsDoUong);
        lvDoUong.setAdapter(adapterDoUong);

        lvSinhTo = (ListView) findViewById(R.id.lvSinhTo);
        dsSinhTo = new ArrayList<>();
        adapterSinhTo = new DanhMucAdapter(DanhMucActivity.this, R.layout.layout_danhmuc, dsSinhTo);
        lvSinhTo.setAdapter(adapterSinhTo);

        mData = FirebaseDatabase.getInstance().getReference();

        addControls();
        addEvents();

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentQuayVe = new Intent(DanhMucActivity.this, ChonBanAn.class);
                startActivity(intentQuayVe);
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentThanhToan = new Intent(DanhMucActivity.this, ThanhToan.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("dsMon",dsMon);
                bundle.putSerializable("dsDoUong",dsDoUong);
                bundle.putSerializable("dsSinhTo",dsSinhTo);
                intentThanhToan.putExtra("DANHMUC", bundle);
                startActivity(intentThanhToan);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void addEvents() {

    }

    private void addControls() {

        Intent intent = getIntent();
        thongTinBan = (kbBanAn) intent.getSerializableExtra("ThongTinBan");
        txtThongTinBan.setText(thongTinBan.getTen());

        mData.child("MonAn").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                danhMuc monAn = dataSnapshot.getValue(danhMuc.class);
                dsMon.add(new danhMuc(monAn.ma, monAn.tenMon, monAn.gia, monAn.linkHinh ));
                adapterDanhSachMon.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mData.child("DoUong").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                danhMuc doUong = dataSnapshot.getValue(danhMuc.class);
                dsDoUong.add(new danhMuc(doUong.ma, doUong.tenMon, doUong.gia, doUong.linkHinh ));
                adapterDoUong.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mData.child("SinhTo").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                danhMuc sinhTo = dataSnapshot.getValue(danhMuc.class);
                dsSinhTo.add(new danhMuc(sinhTo.ma, sinhTo.tenMon, sinhTo.gia, sinhTo.linkHinh ));
                adapterSinhTo.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1 =  tabHost.newTabSpec("t1");
        tab1.setIndicator("Món Ăn Chính");
        tab1.setContent(R.id.tab1);
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 =  tabHost.newTabSpec("t2");
        tab2.setIndicator("Đồ Uống");
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);

        TabHost.TabSpec tab3 =  tabHost.newTabSpec("t3");
        tab3.setIndicator("Sinh Tố");
        tab3.setContent (R.id.tab3);
        tabHost.addTab(tab3);

    }

}
