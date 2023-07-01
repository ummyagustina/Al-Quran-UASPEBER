package com.example.al_quran_uaspeber.Adapter;

import android.app.Activity;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.al_quran_uaspeber.R;
import com.example.al_quran_uaspeber.dialogAudio.DialogAudio;
import com.example.al_quran_uaspeber.dialogAyat.BottomSheetDialogDetailAyat;
import com.example.al_quran_uaspeber.model.DataAyatItem;
import com.example.al_quran_uaspeber.model.DataSurahItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.al_quran_uaspeber.R;
import com.example.al_quran_uaspeber.model.DataSurahItem;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.viewHolder> {
    List<DataSurahItem> listSurah;
    Activity activity;

    public SurahAdapter(List<DataSurahItem> listSurah, MainActivity activity) {
        this.listSurah = listSurah;
        this.activity = activity;

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_list_surah, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.Bind(listSurah.get(position));
    }

    @Override
    public int getItemCount() {
        return listSurah.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.ibPlay)
        ImageButton ibPlay;
        @BindView(R.id.tvNumberSurah)
        TextView tvNumberSurah;
        @BindView(R.id.tvNameSurahArab)
        TextView tvNameSurahArab;
        @BindView(R.id.tvNameSurah)
        TextView tvNameSurah;
        @BindView(R.id.tvKota)
        TextView tvKota;
        @BindView(R.id.tvNomorAyat)
        TextView tvNomorAyat;
        @BindView(R.id.llSurah)
        LinearLayout llSurah;
        private DataSurahItem dataSurahItem;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            llSurah.setOnClickListener(this);
            ibPlay.setOnClickListener(this);
        }

        public void Bind(DataSurahItem data) {
            tvNumberSurah.setText(data.getNomor());
            tvNameSurahArab.setText(data.getAsma());
            tvNameSurah.setText(data.getNama());
            tvKota.setText(data.getType());
            tvNomorAyat.setText(String.valueOf(data.getAyat()));
            dataSurahItem = data;
        }

        @Override
        public void onClick(View view) {
            if (view == llSurah){
            BottomSheetDialogDetailAyat dialog = new BottomSheetDialogDetailAyat(activity, dataSurahItem) {
                @Override
                public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, @Nullable Menu menu, int deviceId) {
                    super.onProvideKeyboardShortcuts(data, menu, deviceId);
                }

                @Override
                public void onPointerCaptureChanged(boolean hasCapture) {
                    super.onPointerCaptureChanged(hasCapture);
                }

                @Override
                public void onGetDataAyat(List<DataAyatItem> data) {

                }
            };
            dialog.show();
            dialog.setCanceledOnTouchOutside(false);
            }
            else if (view == ibPlay){
                DialogAudio dialogAudio = new DialogAudio(activity, dataSurahItem);
                dialogAudio.show();
                dialogAudio.setCanceledOnTouchOutside(false);
            }
        }
    }
}
