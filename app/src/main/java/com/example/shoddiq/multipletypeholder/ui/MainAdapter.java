package com.example.shoddiq.multipletypeholder.ui;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.shoddiq.multipletypeholder.R;
import com.example.shoddiq.multipletypeholder.model.CustomField;
import com.example.shoddiq.multipletypeholder.model.FieldType;

import java.util.List;

/**
 * Created by shoddiq on 03/11/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MyHolder> {

    private Context context;
    private List<CustomField> fieldList;

    public MainAdapter(Context context, List<CustomField> fieldList) {
        this.context = context;
        this.fieldList = fieldList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == FieldType.TYPE_SINGLE) {
            view = LayoutInflater.from(context).inflate(R.layout.item_single, parent, false);
            return new SingleHolder(view);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.item_spinner, parent, false);
            return new SpinnerHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.bindType(fieldList.get(position));
    }

    @Override
    public int getItemCount() {
        return fieldList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return fieldList.get(position).getListItemType();
    }

    private class SingleHolder extends MyHolder {

        TextInputLayout tilSingle;

        SingleHolder(View itemView) {
            super(itemView);
            tilSingle = itemView.findViewById(R.id.til_single);
        }

        @Override
        public void bindType(CustomField field) {
            tilSingle.setHint(field.getName());
        }
    }

    private class SpinnerHolder extends MyHolder {

        TextView tvTitle;
        Spinner spinner;

        SpinnerHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_spinner_title);
            spinner = itemView.findViewById(R.id.spinner);
        }

        @Override
        public void bindType(CustomField field) {
            tvTitle.setText(field.getName());
            ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                    android.R.layout.simple_spinner_dropdown_item, field.getData());
            spinner.setAdapter(adapter);
        }
    }
}
