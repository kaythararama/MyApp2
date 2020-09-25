package com.kmd.myapp2.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.kmd.myapp2.model.entity.Person;
import java.util.List;

@Dao
public interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(Person person);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Person... people);

    @Delete
    void delete( Person person);

    @Update
    void update(Person person);


    @Query("SELECT * FROM Person WHERE id = :id LIMIT 1")
    Person findById(int id);

    @Query("select * from Person")
    List<Person> findAll();

    @Query("SELECT * FROM Person LIMIT :limit OFFSET :offset")
    List<Person> findAll( int offset, int limit );
}
