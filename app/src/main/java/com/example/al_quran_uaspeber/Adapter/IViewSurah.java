package com.example.al_quran_uaspeber.Adapter;

import com.example.al_quran_uaspeber.model.DataSurahItem;

import java.util.List;

import com.example.al_quran_uaspeber.model.DataSurahItem;

public interface IViewSurah {
    void getDetailSurah(List<DataSurahItem> data);
    void onErrorMsg(String msg);
}
