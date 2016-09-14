package com.aplexos.bmobtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.aplexos.bmobtest.bmob.Person;
import com.aplexos.bmobtest.bmob.PersonUtils;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bmob.initialize(this, "b46fb5ef4e5809f4a5d558abbd18fd51");

        // PersonUtils.pushPerson("zengjf", "shenzhen");
        String id = "7de7f532f4";
        // PersonUtils.pullPersonById(id);
        // PersonUtils.updatePersonById(id, "fuzhou");
        PersonUtils.deletePersonById(id);

    }
}
