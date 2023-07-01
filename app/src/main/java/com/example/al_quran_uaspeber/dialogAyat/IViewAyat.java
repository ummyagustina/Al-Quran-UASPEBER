package com.example.al_quran_uaspeber.dialogAyat;

import com.example.al_quran_uaspeber.model.DataAyatItem;

import java.util.List;

import tam.pa.alquran.model.DataAyatItem;

public interface IViewAyat {
    void onGetDataAyat(List<DataAyatItem> data);

    void onGetDataAyatt(List<DataAyatItem> data);

    void onErrorMsg(String msg);
}
