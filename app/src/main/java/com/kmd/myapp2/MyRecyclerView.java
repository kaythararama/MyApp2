package com.kmd.myapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.kmd.myapp2.adapter.MyListAdapter;
import com.kmd.myapp2.model.User;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerView extends AppCompatActivity {
private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recycler_view);

        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);

        List<User> userList = new ArrayList<>();
        userList.add(new User("Email", android.R.drawable.ic_dialog_email, "mg mg"));
        userList.add(new User("Info", android.R.drawable.ic_dialog_info, "ko ko"));
        userList.add(new User("Delete", android.R.drawable.ic_delete, "mya mya"));
        userList.add(new User("Dialer", android.R.drawable.ic_dialog_dialer, "myo myo"));
        userList.add(new User("Alert", android.R.drawable.ic_dialog_alert, "mg mg"));
        userList.add(new User("Map", android.R.drawable.ic_dialog_map, "min mg"));
        userList.add(new User("Email", android.R.drawable.ic_dialog_email, "mg mg"));
        userList.add(new User("Info", android.R.drawable.ic_dialog_info, "ko ko"));
        userList.add(new User("Delete", android.R.drawable.ic_delete, "mya mya"));
        userList.add(new User("Dialer", android.R.drawable.ic_dialog_dialer, "myo myo"));
        userList.add(new User("Alert", android.R.drawable.ic_dialog_alert, "mg mg"));
        userList.add(new User("Map", android.R.drawable.ic_dialog_map, "min mg"));
        userList.add(new User("Email", android.R.drawable.ic_dialog_email, "mg mg"));
        userList.add(new User("Info", android.R.drawable.ic_dialog_info, "ko ko"));
        userList.add(new User("Delete", android.R.drawable.ic_delete, "mya mya"));
        userList.add(new User("Dialer", android.R.drawable.ic_dialog_dialer, "myo myo"));
        userList.add(new User("Alert", android.R.drawable.ic_dialog_alert, "mg mg"));
        userList.add(new User("Map", android.R.drawable.ic_dialog_map, "min mg"));
        userList.add(new User("Email", android.R.drawable.ic_dialog_email, "mg mg"));
        userList.add(new User("Info", android.R.drawable.ic_dialog_info, "ko ko"));
        userList.add(new User("Delete", android.R.drawable.ic_delete, "mya mya"));
        userList.add(new User("Dialer", android.R.drawable.ic_dialog_dialer, "myo myo"));
        userList.add(new User("Alert", android.R.drawable.ic_dialog_alert, "mg mg"));
        userList.add(new User("Map", android.R.drawable.ic_dialog_map, "min mg"));
        userList.add(new User("Email", android.R.drawable.ic_dialog_email, "mg mg"));
        userList.add(new User("Info", android.R.drawable.ic_dialog_info, "ko ko"));
        userList.add(new User("Delete", android.R.drawable.ic_delete, "mya mya"));
        userList.add(new User("Dialer", android.R.drawable.ic_dialog_dialer, "myo myo"));
        userList.add(new User("Alert", android.R.drawable.ic_dialog_alert, "mg mg"));
        userList.add(new User("Map", android.R.drawable.ic_dialog_map, "min mg"));
        userList.add(new User("Email", android.R.drawable.ic_dialog_email, "mg mg"));
        userList.add(new User("Info", android.R.drawable.ic_dialog_info, "ko ko"));
        userList.add(new User("Delete", android.R.drawable.ic_delete, "mya mya"));
        userList.add(new User("Dialer", android.R.drawable.ic_dialog_dialer, "myo myo"));
        userList.add(new User("Alert", android.R.drawable.ic_dialog_alert, "mg mg"));
        userList.add(new User("Map", android.R.drawable.ic_dialog_map, "min mg"));


        MyListAdapter myListAdapter = new MyListAdapter(userList);
        recyclerview.setAdapter(myListAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
}