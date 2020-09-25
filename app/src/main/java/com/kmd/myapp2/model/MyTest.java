package com.kmd.myapp2.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class MyTest  implements java.io.Serializable{
    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ColumnInfo(name = "name")
    @NonNull
    private String name;

    @Ignore
    public MyTest(Long id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    public MyTest(@NonNull String name) {
        this.name = name;
    }

    public MyTest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}
