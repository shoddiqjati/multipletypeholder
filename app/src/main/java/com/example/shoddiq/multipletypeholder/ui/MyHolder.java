package com.example.shoddiq.multipletypeholder.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.shoddiq.multipletypeholder.model.CustomField;

/**
 * Created by shoddiq on 03/11/17.
 */

public abstract class MyHolder extends RecyclerView.ViewHolder {
    public MyHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindType(CustomField field);
}
