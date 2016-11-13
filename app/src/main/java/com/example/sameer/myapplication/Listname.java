package com.example.sameer.myapplication;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Sameer on 11/5/2016.
 */
@Table(database = MyDatabase.class)
public class Listname extends BaseModel {

    @Column
    @PrimaryKey
    int ID;
    @Column
    String Listname;

    public void setName(String name) {
        this.Listname = name;
    }

}
