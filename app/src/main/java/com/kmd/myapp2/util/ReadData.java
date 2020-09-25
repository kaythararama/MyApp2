package com.kmd.myapp2.util;

import android.content.Context;
import android.os.AsyncTask;

import com.kmd.myapp2.model.database.MyDatabaseRepository;
import com.kmd.myapp2.model.entity.Person;

import java.util.List;

public class ReadData extends AsyncTask<Void, Void, List<Person>> {

    public interface ReadDataListener{
        public void onResult(List<Person> result);
    }


    private Context context;
    private ReadDataListener listener;

    public void setListener(ReadDataListener listener){
        this.listener = listener;
    }

    public ReadData(Context context){
        this.context = context;
    }
    @Override
    protected List<Person> doInBackground(Void... voids) {
        List<Person> personList = MyDatabaseRepository.getInstance(context)
                .getMyDatabase()
                .personDao().findAll();

        return personList;
    }

    @Override
    protected void onPostExecute(List<Person> result) {
        listener.onResult(result);
    }
}