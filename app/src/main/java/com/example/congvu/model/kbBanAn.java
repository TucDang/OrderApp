package com.example.congvu.model;

import java.io.Serializable;

/**
 * Created by CongVu on 3/14/2017.
 */
public class kbBanAn implements Serializable {
    public int ma;
    public String ten;

    public kbBanAn(String ten) {
    }

    public kbBanAn() {
    }

    public kbBanAn(int ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
