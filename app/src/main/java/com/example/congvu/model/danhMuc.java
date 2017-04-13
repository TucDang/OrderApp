package com.example.congvu.model;

import java.io.Serializable;

/**
 * Created by CongVu on 3/15/2017.
 */
public class danhMuc implements Serializable{

    public int ma;
    public String tenMon;
    public int gia;
    public String linkHinh;

    public danhMuc() {
    }

    public danhMuc(int ma, String tenMon, int gia, String linkHinh) {
        this.ma = ma;
        this.tenMon = tenMon;
        this.gia = gia;
        this.linkHinh = linkHinh;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getLinkHinh() {
        return linkHinh;
    }

    public void setLinkHinh(String linkHinh) {
        this.linkHinh = linkHinh;
    }
}
