package com.amadeus.amadeuspayment.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.amadeus.amadeuspayment.R;

import java.util.ArrayList;

public class ModeAdapter extends ArrayAdapter<ModeItem> {

    public ModeAdapter(Context context, ArrayList<ModeItem> ModeList) {
        super(context, 0, ModeList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.mode_spinner, parent, false
            );
        }

        ImageView imageViewMode = convertView.findViewById(R.id.imageView_euro);
        TextView textViewName = convertView.findViewById(R.id.textView_euro);

        ModeItem modeItem = getItem(position);

        if (modeItem != null) {
            imageViewMode.setImageResource(modeItem.getModeImage());
            textViewName.setText(modeItem.getModeName());
        }
        return convertView;
    }
}
