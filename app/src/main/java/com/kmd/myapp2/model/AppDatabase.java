package com.kmd.myapp2.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {MyTest.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MyTestDao myTestDao();
}