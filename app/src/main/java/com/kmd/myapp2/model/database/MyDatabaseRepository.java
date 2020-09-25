package com.kmd.myapp2.model.database;


import android.content.Context;

import androidx.room.Room;

public class MyDatabaseRepository {

    public static final String DATABASE_NAME = "myTest123";
    private static MyDatabaseRepository myDatabaseRepository;
    private MyDatabase myDatabase;
    private Context context;

    public MyDatabaseRepository(Context context){
        this.context = context;
        //appDatabase = Room.databaseBuilder(context, AppDatabase.class, DatabaseClient.DATABASE_NAME).build();
        myDatabase = Room.databaseBuilder(context, MyDatabase.class, DATABASE_NAME).build();
    }


    public static synchronized MyDatabaseRepository getInstance(Context context) {
        if (myDatabaseRepository == null) {
            myDatabaseRepository = new MyDatabaseRepository(context);
        }
        return myDatabaseRepository;
    }

    public MyDatabase getMyDatabase() {
        return myDatabase;
    }
}
