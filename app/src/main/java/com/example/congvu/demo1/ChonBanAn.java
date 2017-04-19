package com.example.congvu.demo1;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.TextView;

import com.example.congvu.adapter.BanAn;
import com.example.congvu.model.kbBanAn;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ChonBanAn extends AppCompatActivity {


    GridView gvChonBanAn;
    ArrayList<kbBanAn> dsBanAn;
    BanAn banAnAdapter;
    Typeface face;
    //ArrayList<String> mangBanAn;
    //ArrayAdapter arrayAdapter = null;
    TextView textView;
    DatabaseReference mData;
    //Firebase myFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_ban_an);

        textView = (TextView) findViewById(R.id.textView);
        gvChonBanAn = (GridView) findViewById(R.id.gvChonBanAn);
        dsBanAn = new ArrayList<kbBanAn>();
        face = Typeface.createFromAsset(getAssets(),"fonts/VNF-Sofia Regular.ttf");
        textView.setTypeface(face);



        banAnAdapter = new BanAn(
                ChonBanAn.this,
                R.layout.layout_banan,
                dsBanAn);
        gvChonBanAn.setAdapter(banAnAdapter);

        mData = FirebaseDatabase.getInstance().getReference();
        mData.child("BanAn").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                kbBanAn banAn = dataSnapshot.getValue(kbBanAn.class);
                //mangBanAn.add(banAn.ma + "-" +banAn.ten);
                //arrayAdapter.notifyDataSetChanged();
                dsBanAn.add(new kbBanAn(banAn.ma, banAn.ten));

                banAnAdapter.notifyDataSetChanged();
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


        //addControls();
        //addEvents();



    /*private void addEvents() {

    }

    private void addControls() {

        gvChonBanAn = (GridView) findViewById(R.id.gvChonBanAn);

        dsBanAn = new ArrayList<kbBanAn>();
       /* dsBanAn.add(new kbBanAn(1, "Bàn Ăn 1"));
        dsBanAn.add(new kbBanAn(2, "Bàn Ăn 2"));
        dsBanAn.add(new kbBanAn(3, "Bàn Ăn 3"));
        dsBanAn.add(new kbBanAn(4, "Bàn Ăn 4"));
        dsBanAn.add(new kbBanAn(5, "Bàn Ăn 5"));
        dsBanAn.add(new kbBanAn(6, "Bàn Ăn 6"));
        dsBanAn.add(new kbBanAn(7, "Bàn Ăn 7"));
        dsBanAn.add(new kbBanAn(8, "Bàn Ăn 8"));
        dsBanAn.add(new kbBanAn(9, "Bàn Ăn 9"));
        dsBanAn.add(new kbBanAn(10, "Bàn Ăn 10"));
        dsBanAn.add(new kbBanAn(11, "Bàn Ăn 11"));
        dsBanAn.add(new kbBanAn(12, "Bàn Ăn 12"));

        ChildEventListener childEventListener = mData.child("BanAn").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                kbBanAn banAn = dataSnapshot.getValue(kbBanAn.class);
                dsBanAn.add(new kbBanAn(banAn.ma, banAn.ten));
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

        banAnAdapter = new BanAn(
                ChonBanAn.this,
                R.layout.layout_banan,
                dsBanAn);

        gvChonBanAn.setAdapter(banAnAdapter);
        banAnAdapter.notifyDataSetChanged();

    }*/
    }
}
