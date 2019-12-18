package com.example.roomdatabase;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;

import com.example.roomdatabase.room.Mahasiswa;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.roomdatabase.AppApplication.db;

@SuppressLint("ValidFragment")
public class Update_Dialog extends DialogFragment {

    private Bundle bundle;
    private int id,idList;
    OnclickRecycler mOnclickRecycler;

    @BindView(R.id.etAlamatDialog) EditText alamat;
    @BindView(R.id.etKejuruanDialog)EditText kejuruan;
    @BindView(R.id.etNamaDialog)EditText nama;
    @BindView(R.id.etNimDialog)EditText nim;

    public Update_Dialog(OnclickRecycler onclickRecycler) {
        mOnclickRecycler = onclickRecycler;

    }

    @OnClick(R.id.btUpdateDialog)void upDate(){

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setId(id);
        mahasiswa.setNim(nim.getText().toString());
        mahasiswa.setNama(nama.getText().toString());
        mahasiswa.setKejuruan(kejuruan.getText().toString());
        mahasiswa.setAlamat(alamat.getText().toString());
        db.userDao().update(mahasiswa);
        mOnclickRecycler.updateListener(idList,mahasiswa);
        dismiss();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_update__dialog, container, false);
        ButterKnife.bind(this,rootView);

        bundle = getArguments();
        id = bundle.getInt("id");
        idList = bundle.getInt("id_list");
        Log.e("dialog",""+id);

        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        return rootView;
    }

}