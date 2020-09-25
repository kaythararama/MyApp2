package com.kmd.myapp2.model;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface MyTestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<MyTest> myTests);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MyTest myTest);

    @Query("DELETE FROM MyTest")
    void deleteAll();
    @Delete
    void delete(MyTest myTest);

    @Update
    void updateAll(MyTest... myTests);
    @Update
    void update(MyTest myTest);

    @Query("SELECT * FROM MyTest")
    List<MyTest> getAll( );

    @Query("SELECT * FROM MyTest LIMIT :limit OFFSET :offset")
    List<MyTest> getAll( int offset, int limit );

    @Query("SELECT * FROM MyTest WHERE id = :id LIMIT 1")
    MyTest findById(long id);

    @Query("SELECT * FROM MyTest WHERE name = :name LIMIT 1")
    MyTest findByName(String name);
}