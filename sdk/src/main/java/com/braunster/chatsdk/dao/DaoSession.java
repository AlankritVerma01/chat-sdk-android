package com.braunster.chatsdk.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.braunster.chatsdk.dao.BUser;
import com.braunster.chatsdk.dao.BMessage;
import com.braunster.chatsdk.dao.BMessageReceipt;
import com.braunster.chatsdk.dao.BThread;
import com.braunster.chatsdk.dao.BLinkedAccount;
import com.braunster.chatsdk.dao.ContactLink;
import com.braunster.chatsdk.dao.UserThreadLink;
import com.braunster.chatsdk.dao.FollowerLink;

import com.braunster.chatsdk.dao.BUserDao;
import com.braunster.chatsdk.dao.BMessageDao;
import com.braunster.chatsdk.dao.BMessageReceiptDao;
import com.braunster.chatsdk.dao.BThreadDao;
import com.braunster.chatsdk.dao.BLinkedAccountDao;
import com.braunster.chatsdk.dao.ContactLinkDao;
import com.braunster.chatsdk.dao.UserThreadLinkDao;
import com.braunster.chatsdk.dao.FollowerLinkDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig bUserDaoConfig;
    private final DaoConfig bMessageDaoConfig;
    private final DaoConfig bMessageReceiptDaoConfig;
    private final DaoConfig bThreadDaoConfig;
    private final DaoConfig bLinkedAccountDaoConfig;
    private final DaoConfig contactLinkDaoConfig;
    private final DaoConfig userThreadLinkDaoConfig;
    private final DaoConfig followerLinkDaoConfig;

    private final BUserDao bUserDao;
    private final BMessageDao bMessageDao;
    private final BMessageReceiptDao bMessageReceiptDao;
    private final BThreadDao bThreadDao;
    private final BLinkedAccountDao bLinkedAccountDao;
    private final ContactLinkDao contactLinkDao;
    private final UserThreadLinkDao userThreadLinkDao;
    private final FollowerLinkDao followerLinkDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        bUserDaoConfig = daoConfigMap.get(BUserDao.class).clone();
        bUserDaoConfig.initIdentityScope(type);

        bMessageDaoConfig = daoConfigMap.get(BMessageDao.class).clone();
        bMessageDaoConfig.initIdentityScope(type);

        bMessageReceiptDaoConfig = daoConfigMap.get(BMessageReceiptDao.class).clone();
        bMessageReceiptDaoConfig.initIdentityScope(type);

        bThreadDaoConfig = daoConfigMap.get(BThreadDao.class).clone();
        bThreadDaoConfig.initIdentityScope(type);

        bLinkedAccountDaoConfig = daoConfigMap.get(BLinkedAccountDao.class).clone();
        bLinkedAccountDaoConfig.initIdentityScope(type);

        contactLinkDaoConfig = daoConfigMap.get(ContactLinkDao.class).clone();
        contactLinkDaoConfig.initIdentityScope(type);

        userThreadLinkDaoConfig = daoConfigMap.get(UserThreadLinkDao.class).clone();
        userThreadLinkDaoConfig.initIdentityScope(type);

        followerLinkDaoConfig = daoConfigMap.get(FollowerLinkDao.class).clone();
        followerLinkDaoConfig.initIdentityScope(type);

        bUserDao = new BUserDao(bUserDaoConfig, this);
        bMessageDao = new BMessageDao(bMessageDaoConfig, this);
        bMessageReceiptDao = new BMessageReceiptDao(bMessageReceiptDaoConfig, this);
        bThreadDao = new BThreadDao(bThreadDaoConfig, this);
        bLinkedAccountDao = new BLinkedAccountDao(bLinkedAccountDaoConfig, this);
        contactLinkDao = new ContactLinkDao(contactLinkDaoConfig, this);
        userThreadLinkDao = new UserThreadLinkDao(userThreadLinkDaoConfig, this);
        followerLinkDao = new FollowerLinkDao(followerLinkDaoConfig, this);

        registerDao(BUser.class, bUserDao);
        registerDao(BMessage.class, bMessageDao);
        registerDao(BMessageReceipt.class, bMessageReceiptDao);
        registerDao(BThread.class, bThreadDao);
        registerDao(BLinkedAccount.class, bLinkedAccountDao);
        registerDao(ContactLink.class, contactLinkDao);
        registerDao(UserThreadLink.class, userThreadLinkDao);
        registerDao(FollowerLink.class, followerLinkDao);
    }
    
    public void clear() {
        bUserDaoConfig.getIdentityScope().clear();
        bMessageDaoConfig.getIdentityScope().clear();
        bMessageReceiptDaoConfig.getIdentityScope().clear();
        bThreadDaoConfig.getIdentityScope().clear();
        bLinkedAccountDaoConfig.getIdentityScope().clear();
        contactLinkDaoConfig.getIdentityScope().clear();
        userThreadLinkDaoConfig.getIdentityScope().clear();
        followerLinkDaoConfig.getIdentityScope().clear();
    }

    public BUserDao getBUserDao() {
        return bUserDao;
    }

    public BMessageDao getBMessageDao() {
        return bMessageDao;
    }

    public BMessageReceiptDao getBMessageReceiptDao() {
        return bMessageReceiptDao;
    }

    public BThreadDao getBThreadDao() {
        return bThreadDao;
    }

    public BLinkedAccountDao getBLinkedAccountDao() {
        return bLinkedAccountDao;
    }

    public ContactLinkDao getContactLinkDao() {
        return contactLinkDao;
    }

    public UserThreadLinkDao getUserThreadLinkDao() {
        return userThreadLinkDao;
    }

    public FollowerLinkDao getFollowerLinkDao() {
        return followerLinkDao;
    }

}