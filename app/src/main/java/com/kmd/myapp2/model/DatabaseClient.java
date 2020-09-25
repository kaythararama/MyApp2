package com.kmd.myapp2.model;

import android.content.Context;
import androidx.room.Room;


public class DatabaseClient {
    public static final String DATABASE_NAME = "myTestDatabase";

    private Context context;
    private static DatabaseClient databaseClient;
    private AppDatabase appDatabase;

    private DatabaseClient(Context context) {
        this.context = context;
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, DatabaseClient.DATABASE_NAME).build();
    }

    public static synchronized DatabaseClient getInstance(Context context) {
        if (databaseClient == null) {
            databaseClient = new DatabaseClient(context);
        }
        return databaseClient;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
