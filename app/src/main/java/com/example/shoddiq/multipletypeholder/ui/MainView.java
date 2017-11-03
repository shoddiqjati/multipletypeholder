package com.example.shoddiq.multipletypeholder.ui;

import com.example.shoddiq.multipletypeholder.model.CustomField;

import java.util.List;

/**
 * Created by shoddiq on 03/11/17.
 */

public interface MainView {
    void showProgress(boolean isLoading);
    void showData(List<CustomField> fieldList);
}
