package com.kmd.myapp2.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Person {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    @ColumnInfo(name = "first_name")
    @NonNull
    private String firstName;
    @ColumnInfo(name = "last_name")
    private String lastName;

    @Ignore
    public Person() {
    }

    public Person(@NonNull String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}