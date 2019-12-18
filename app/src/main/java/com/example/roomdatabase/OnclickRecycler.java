package com.example.roomdatabase;

import com.example.roomdatabase.room.Mahasiswa;

/**
 * Created by khoiron on 11/02/18.
 */

public interface OnclickRecycler {
    void onItemDismiss(int position);
    void updateListener(int id, Mahasiswa mahasiswa);
}
