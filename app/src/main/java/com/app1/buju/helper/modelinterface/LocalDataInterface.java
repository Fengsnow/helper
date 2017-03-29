package com.app1.buju.helper.modelinterface;

import com.app1.buju.helper.Bean.UserModelBean;

/**
 * Created by Administrator on 2017/3/14.
 */
public interface LocalDataInterface {
    void saveuser(UserModelBean userModelBean);

    UserModelBean selectUser(String username);
}
