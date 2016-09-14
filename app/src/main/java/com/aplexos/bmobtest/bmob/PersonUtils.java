package com.aplexos.bmobtest.bmob;

import android.util.Log;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.*;

/**
 * Created by aplex on 16-9-14.
 */
public class PersonUtils {

    static public void pushPerson(String name, String address) {
        Person p2 = new Person();
        p2.setName(name);
        p2.setAddress(address);
        p2.save(new SaveListener<String>() {

            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                    Log.e("pushPerson", "添加数据成功，返回objectId为："+objectId);
                }else{
                    Log.e("pushPerson", "创建数据失败：" + e.getMessage());
                }
            }
        });
    }

    static public void pullPersonById(String id) {
        BmobQuery<Person> bmobQuery = new BmobQuery<Person>();
        bmobQuery.getObject(id, new QueryListener<Person>() {

            @Override
            public void done(Person object, BmobException e) {
                if(e==null){
                    Log.e("pullPerson", "查询成功: " + object.getName());
                }else{
                    Log.e("pullPerson", "查询失败");
                }
            }
        });
    }

    static public void deletePersonById(String id) {
        Person p2 = new Person();
        p2.setObjectId(id);
        p2.delete(new UpdateListener() {

            @Override
            public void done(BmobException e) {
                if(e==null){
                    Log.e("deletePersonById", "删除成功");
                }else{
                    Log.e("deletePersonById", "删除失败: " + e.getMessage());
                }
            }

        });
    }

    static public void updatePersonById(String id, String address) {
        Person p2 = new Person();
        p2.setAddress(address);
        p2.update(id, new UpdateListener() {

            @Override
            public void done(BmobException e) {
                if(e==null){
                    Log.e("updatePersonById", "更新成功");
                }else{
                    Log.e("updatePersonById", "更新失败");
                }
            }

        });
    }
}

