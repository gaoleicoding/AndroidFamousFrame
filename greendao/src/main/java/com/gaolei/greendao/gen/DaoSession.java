package com.gaolei.greendao.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.gaolei.greendao.db.SearchRecord;

import com.gaolei.greendao.gen.SearchRecordDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig searchRecordDaoConfig;

    private final SearchRecordDao searchRecordDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        searchRecordDaoConfig = daoConfigMap.get(SearchRecordDao.class).clone();
        searchRecordDaoConfig.initIdentityScope(type);

        searchRecordDao = new SearchRecordDao(searchRecordDaoConfig, this);

        registerDao(SearchRecord.class, searchRecordDao);
    }
    
    public void clear() {
        searchRecordDaoConfig.clearIdentityScope();
    }

    public SearchRecordDao getSearchRecordDao() {
        return searchRecordDao;
    }

}