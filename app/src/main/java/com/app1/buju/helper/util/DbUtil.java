package com.app1.buju.helper.util;

import org.xutils.DbManager;
import org.xutils.x;

/**
 * Created by Administrator on 2016/12/14.
 */
public class DbUtil {

        public synchronized static DbManager getDbManger(){
            DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
                    .setDbName("star_user")
                    .setDbVersion(1);
            DbManager db = x.getDb(daoConfig);

            return db;
        }
}
