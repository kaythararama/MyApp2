package com.kmd.myapp2.model.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.kmd.myapp2.model.dao.PersonDao;
import com.kmd.myapp2.model.entity.Person;


@Database(entities = {Person.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract PersonDao personDao();
}