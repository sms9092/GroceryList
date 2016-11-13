package com.example.sameer.myapplication;


import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Sameer on 11/3/2016.
 */

@Table(database = MyDatabase.class)
public class Items extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    int ID;
    @Column
    String ITEM;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    Listname mylist;


    public void setList(Listname mylist) {
        this.mylist = mylist;
    }

    public void setName(String item) {
        this.ITEM = item;
    }
}

