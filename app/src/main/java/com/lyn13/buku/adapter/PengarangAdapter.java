package com.lyn13.buku.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.lyn13.buku.CetakHapusActivity;
import com.lyn13.buku.CetakPengarangActivity;
import com.lyn13.buku.EditActivity;
import com.lyn13.buku.R;
import com.lyn13.buku.crud.pengarangCRUD;
import com.lyn13.buku.crud.userCRUD;
import com.lyn13.buku.model.Buku;
import com.lyn13.buku.model.Pengarang;

import java.util.List;

public class PengarangAdapter extends ArrayAdapter<Pengarang> {

    private Activity mActivity;

    public PengarangAdapter(Context context, List<Pengarang> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pengarang pengarang = getItem(position);
        if(convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_listviewpengarang, parent, false);
        }

        TextView txvIdPengarang = (TextView) convertView.findViewById(R.id.txvIdPengarang);
        TextView txvJNamaPengarang= (TextView) convertView.findViewById(R.id.txvJNamaPengarang);
        TextView txvAlamatPengarang= (TextView) convertView.findViewById(R.id.txvAlamatPengarang);


        txvIdPengarang.setText(pengarang.getIdPengarang().toString());
        txvJNamaPengarang.setText(pengarang.getNama());
        txvAlamatPengarang.setText(pengarang.getAlamat());


        ImageButton imgBtnEditPengarang= (ImageButton) convertView.findViewById(R.id.imgBtnEditPengarang);
        imgBtnEditPengarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), EditActivity.class);
                intent.putExtra("idpengarang", pengarang.getIdPengarang().toString());
                intent.putExtra("nama", pengarang.getNama());
                intent.putExtra("alamat", pengarang.getAlamat());
                getContext().startActivity(intent);
            }
        });

        ImageButton imgBtnDeletePengarang= (ImageButton) convertView.findViewById(R.id.imgBtnDeletePengarang);
        imgBtnDeletePengarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pengarangCRUD pengarangcrud = new pengarangCRUD();
                pengarangcrud.deleteDataPengarang(pengarang.getIdPengarang());

                ((CetakPengarangActivity) getmActivity()).refreshListView();

                notifyDataSetChanged();
            }
        });

        return convertView;

    }

    public Activity getmActivity() {
        return mActivity;
    }

    public void setmActivity(Activity mActivity) {
        this.mActivity = mActivity;
    }
}
