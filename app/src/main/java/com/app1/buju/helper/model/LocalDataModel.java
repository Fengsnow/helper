package com.app1.buju.helper.model;

import com.app1.buju.helper.Bean.UserModelBean;
import com.app1.buju.helper.modelinterface.LocalDataInterface;

import org.xutils.ex.DbException;

/**
 * Created by Administrator on 2017/3/14.
 */
public class LocalDataModel implements LocalDataInterface{

    private static LocalDataModel mLocalDataModel;
    private static byte[] lock = new byte[0];
    private UserModelDao mUserModelDao;

    private LocalDataModel() {
        mUserModelDao = new UserModelDao();

    }

    public static LocalDataModel getInstance(){
        synchronized (lock){
            if(mLocalDataModel == null){
                mLocalDataModel = new LocalDataModel();
            }
            return mLocalDataModel;
        }
    }

    @Override
    public void saveuser(UserModelBean userModelBean) {
        try {
            mUserModelDao.saveUser(userModelBean);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserModelBean selectUser(String username) {
        UserModelBean userModelBean = null;
        try {
            userModelBean = mUserModelDao.selectUser(username);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return userModelBean;
    }
}
