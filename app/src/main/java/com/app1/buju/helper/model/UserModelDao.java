package com.app1.buju.helper.model;

import com.app1.buju.helper.Bean.UserModelBean;
import com.app1.buju.helper.util.DbUtil;

import org.xutils.ex.DbException;

/**
 * Created by Administrator on 2016/12/21.
 */
public class UserModelDao {
    public void saveUser(UserModelBean userModelBean) throws DbException {
        DbUtil.getDbManger().save(userModelBean);

    }

    public UserModelBean selectUser(String username) throws DbException {
        UserModelBean userModelBean = DbUtil.getDbManger().findById(UserModelBean.class,username);

        if(userModelBean !=null) return userModelBean;
        else{
            return null;
        }
    }
}
