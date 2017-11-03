package com.example.shoddiq.multipletypeholder.model;

import com.example.shoddiq.multipletypeholder.utils.Constants;

import java.util.List;

public class CustomField implements FieldType {
    private List<String> data;
    private String name;
    private int id;
    private String type;

    public void setData(List<String> data) {
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return
                "CustomField{" +
                        "data = '" + data + '\'' +
                        ",name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        ",type = '" + type + '\'' +
                        "}";
    }

    @Override
    public int getListItemType() {
        if (type.equals(Constants.SINGLE)) {
            return FieldType.TYPE_SINGLE;
        } else {
            return FieldType.TYPE_DROP;
        }
    }
}