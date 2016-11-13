package com.example.sameer.myapplication;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Sameer on 11/3/2016.
 */
@Database(name = MyDatabase.NAME, version = MyDatabase.VERSION)
public class MyDatabase {

    public static final String NAME = "MyDatabase";
    public static final int VERSION = 1;

}
