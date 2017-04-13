package com.example.congvu.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.congvu.demo1.DanhMucActivity;
import com.example.congvu.demo1.R;
import com.example.congvu.model.danhMuc;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by CongVu on 3/15/2017.
 */
public class DanhMucAdapter extends ArrayAdapter<danhMuc> {
    Activity context;
    int resource;
    List<danhMuc> objects;
    public DanhMucAdapter(Activity context, int resource, List<danhMuc> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);
        ImageView imgAnh = (ImageView) row.findViewById(R.id.imgAnh);
        TextView txtTenMon = (TextView) row.findViewById(R.id.txtTenMon);
        TextView txtGia = (TextView) row.findViewById(R.id.txtGia);
        final CheckBox chkChon = (CheckBox) row.findViewById(R.id.chkChon);

        final danhMuc danhmuc = this.objects.get(position);
        txtTenMon.setText(danhmuc.getTenMon());
        txtGia.setText(danhmuc.gia + " đồng/phần");
        Picasso.with(context).load(objects.get(position).linkHinh).into(imgAnh);
        chkChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chkChon.isChecked()){
                    if ( !DanhMucActivity.lMonUserSelect.containsKey(""+danhmuc.getMa()))
                    {
                        DanhMucActivity.lMonUserSelect.put("" + danhmuc.getMa(), position);
                    }
                }
                else {
                    if (DanhMucActivity.lMonUserSelect.containsKey("" + danhmuc.getMa()))
                    {
                        DanhMucActivity.lMonUserSelect.remove(""+ danhmuc.getMa());
                    }

                }
            }
        });

        return row;
    }
}

