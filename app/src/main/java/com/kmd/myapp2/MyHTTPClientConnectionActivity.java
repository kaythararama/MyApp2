package com.kmd.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class MyHTTPClientConnectionActivity extends AppCompatActivity {

    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_h_t_t_p_client_connection);

        txtResult = (TextView) findViewById(R.id.txtResult);
        new SimpleAsyncTask().execute("https://jsonplaceholder.typicode.com/todos/1");
    }


    public class SimpleAsyncTask extends AsyncTask<String,Void, String> {

        public SimpleAsyncTask() {
        }


        @Override
        protected String doInBackground(String... strings) {
            String resultString = null;
            HttpURLConnection conn = null;

            try {
                URL requestURL = new URL(strings[0]);
                conn = (HttpURLConnection) requestURL.openConnection();

                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);

                conn.connect();
                int response = conn.getResponseCode();//HTTP_OK=200, HTTP_OK=201

                if( response == HttpURLConnection.HTTP_OK){
                    InputStream is = conn.getInputStream();

                    StringBuilder builder = new StringBuilder();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        builder.append(line + "\n");
                    }
                    if (builder.length() == 0) {
                        return null;
                    }
                    resultString = builder.toString();

                }else{
                    Log.e("tag","HTTP Code="+response);
                }

            }catch (Exception e){e.printStackTrace();}
            finally {
                if( conn != null)
                    conn.disconnect();
            }
            return resultString;
        }

        protected void onPostExecute(String result) {
//            "userId": 1,
//                    "id": 1,
//                    "title": "delectus aut autem",
//                    "completed": false

            try {
                JSONObject jsonObject = new JSONObject(result);
                int userId = jsonObject.getInt("userId");
                int id = jsonObject.getInt("id");
                String title = jsonObject.getString("title");
                boolean completed = jsonObject.getBoolean("completed");

                txtResult.setText(
                        "userId=" + userId+"\n" +
                                "id=" + id +"\n" +
                                "title=" + title+"\n" +
                                "completed=" + completed
                );


                //
                jsonObject.put("name","Mg Mg");
                Log.i("Tag", jsonObject.toString() );
                txtResult.setText(txtResult.getText().toString()+"\n\n" + jsonObject.toString());

            } catch (JSONException e) {
                e.printStackTrace();
            }



        }


    }
}