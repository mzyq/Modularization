package com.muzi.modularization.login.model;

import android.app.Application;

import com.muzi.annotation.annotation.RegisterApplication;
import com.muzi.annotationapi.AbsApplication;
import com.muzi.modularization.login.greendao.DaoMaster;
import com.muzi.modularization.login.greendao.DaoSession;


/**
 * Author: lipeng
 * Date: 2019/7/18
 * Email: lipeng@moyi365.com
 * Content:
 */
@RegisterApplication
public class LoginDao extends AbsApplication {

    private static LoginDao instance;

    private DaoSession daoSession;

    private LoginDao() {
    }

    public static LoginDao getInstance() {
        return instance;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    @Override
    public void onCreate(Application application) {
        super.onCreate(application);
        instance = this;
        DaoMaster daoMaster = new DaoMaster(SqlDao.getInstance().getSqLiteDatabase());
        daoSession = daoMaster.newSession();
    }

}