package com.example.roomdatabase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase.OnclickRecycler;
import com.example.roomdatabase.R;
import com.example.roomdatabase.room.Mahasiswa;

import java.util.List;

import static com.example.roomdatabase.AppApplication.db;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder>implements OnclickRecycler {
    private Context mContext;
    private List<Mahasiswa> myList;
    OnclickRecycler onclickRecycler = this;

    public RecycleAdapter(Context mContext, List<Mahasiswa> albumList) {
        this.mContext = mContext;
        this.myList = albumList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_mahasiswa, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final Mahasiswa album = myList.get(i);
        myViewHolder.tvNama.setText(album.getNama());
        myViewHolder.tvNim.setText(album.getNim());
        myViewHolder.tvKejuruan.setText(album.getKejuruan());
        myViewHolder.tvAlamat.setText(album.getAlamat());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    @Override
    public void onItemDismiss(int position) {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setId(myList.get(position).getId());
        db.userDao().deleteUsers(mahasiswa);

        myList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void updateListener(int id, Mahasiswa mahasiswa) {
        myList.get(id).setAlamat(mahasiswa.getAlamat());
        myList.get(id).setKejuruan(mahasiswa.getKejuruan());
        myList.get(id).setNama(mahasiswa.getNama());
        myList.get(id).setNim(mahasiswa.getNim());
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvAlamat;
        public TextView tvKejuruan;
        public TextView tvNama;
        public TextView tvNim;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvKejuruan = itemView.findViewById(R.id.tvKejuruan);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvNama = itemView.findViewById(R.id.tvNama);
        }
    }


}
