package com.braunster.chatsdk.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.identityscope.IdentityScopeType;

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
 * Master of DAO (schema version 54): knows all DAOs.
*/
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 54;

    /** Creates underlying database table using DAOs. */
    public static void createAllTables(SQLiteDatabase db, boolean ifNotExists) {
        BUserDao.createTable(db, ifNotExists);
        BMessageDao.createTable(db, ifNotExists);
        BMessageReceiptDao.createTable(db, ifNotExists);
        BThreadDao.createTable(db, ifNotExists);
        BLinkedAccountDao.createTable(db, ifNotExists);
        ContactLinkDao.createTable(db, ifNotExists);
        UserThreadLinkDao.createTable(db, ifNotExists);
        FollowerLinkDao.createTable(db, ifNotExists);
    }
    
    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(SQLiteDatabase db, boolean ifExists) {
        BUserDao.dropTable(db, ifExists);
        BMessageDao.dropTable(db, ifExists);
        BMessageReceiptDao.dropTable(db, ifExists);
        BThreadDao.dropTable(db, ifExists);
        BLinkedAccountDao.dropTable(db, ifExists);
        ContactLinkDao.dropTable(db, ifExists);
        UserThreadLinkDao.dropTable(db, ifExists);
        FollowerLinkDao.dropTable(db, ifExists);
    }
    
    public static abstract class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(db, false);
        }
    }
    
    /** WARNING: Drops all table on Upgrade! Use only during development. */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }
    }

    public DaoMaster(SQLiteDatabase db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(BUserDao.class);
        registerDaoClass(BMessageDao.class);
        registerDaoClass(BMessageReceiptDao.class);
        registerDaoClass(BThreadDao.class);
        registerDaoClass(BLinkedAccountDao.class);
        registerDaoClass(ContactLinkDao.class);
        registerDaoClass(UserThreadLinkDao.class);
        registerDaoClass(FollowerLinkDao.class);
    }
    
    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }
    
    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }
    
}