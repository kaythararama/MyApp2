package com.kmd.myapp2.util;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import com.kmd.myapp2.model.DatabaseClient;
import com.kmd.myapp2.model.MyTest;
import com.kmd.myapp2.model.MyTestDao;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<String,Void, String> {
    // The TextView where we will show results
    private WeakReference<TextView> mTextView;
    private Context context;

    // Constructor that provides a reference to the TextView from the MainActivity
    public SimpleAsyncTask(TextView tv, Context context) {
        mTextView = new WeakReference<>(tv);
        this.context = context;
    }


    @Override
    protected String doInBackground(String... strings) {

        // Generate a random number between 0 and 10.
        Random r = new Random();
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running.
        int s = n * 200;

        // Sleep for the random amount of time.
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //Internal storage
        File file = new File(context.getFilesDir(), strings[0]);
        try {

            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // External storage
        File path = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS);
        File externalFile = new File(path, strings[0]);
        try {

            externalFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            MyTestDao myTestDao = DatabaseClient.getInstance(context).getAppDatabase().myTestDao();
//            MyTest myTest = new MyTest("Mg Mg");
//            myTestDao.insert(myTest);
//            List<MyTest> myTests = myTestDao.getAll();
//            for( MyTest myTest1 : myTests){
//                Log.i("Tag", "My Name is: "+myTest1.getName());
//            }
//
//        }catch (Exception e){e.printStackTrace();}

        // Return a String result.
        return "Awake at last after sleeping for " + s + " milliseconds!\n" +
                "My param=" +strings[0]+"\n" +
                "File path="  + file.getAbsolutePath()+"\n" +
                " External file path=" + externalFile.getAbsolutePath();
    }

    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

}
