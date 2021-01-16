package sdk.chat.core.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import sdk.chat.core.dao.ContactLink;
import sdk.chat.core.dao.Message;
import sdk.chat.core.dao.MessageMetaValue;
import sdk.chat.core.dao.PublicKey;
import sdk.chat.core.dao.ReadReceiptUserLink;
import sdk.chat.core.dao.Thread;
import sdk.chat.core.dao.ThreadMetaValue;
import sdk.chat.core.dao.User;
import sdk.chat.core.dao.UserMetaValue;
import sdk.chat.core.dao.UserThreadLink;
import sdk.chat.core.dao.UserThreadLinkMetaValue;

import sdk.chat.core.dao.ContactLinkDao;
import sdk.chat.core.dao.MessageDao;
import sdk.chat.core.dao.MessageMetaValueDao;
import sdk.chat.core.dao.PublicKeyDao;
import sdk.chat.core.dao.ReadReceiptUserLinkDao;
import sdk.chat.core.dao.ThreadDao;
import sdk.chat.core.dao.ThreadMetaValueDao;
import sdk.chat.core.dao.UserDao;
import sdk.chat.core.dao.UserMetaValueDao;
import sdk.chat.core.dao.UserThreadLinkDao;
import sdk.chat.core.dao.UserThreadLinkMetaValueDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig contactLinkDaoConfig;
    private final DaoConfig messageDaoConfig;
    private final DaoConfig messageMetaValueDaoConfig;
    private final DaoConfig publicKeyDaoConfig;
    private final DaoConfig readReceiptUserLinkDaoConfig;
    private final DaoConfig threadDaoConfig;
    private final DaoConfig threadMetaValueDaoConfig;
    private final DaoConfig userDaoConfig;
    private final DaoConfig userMetaValueDaoConfig;
    private final DaoConfig userThreadLinkDaoConfig;
    private final DaoConfig userThreadLinkMetaValueDaoConfig;

    private final ContactLinkDao contactLinkDao;
    private final MessageDao messageDao;
    private final MessageMetaValueDao messageMetaValueDao;
    private final PublicKeyDao publicKeyDao;
    private final ReadReceiptUserLinkDao readReceiptUserLinkDao;
    private final ThreadDao threadDao;
    private final ThreadMetaValueDao threadMetaValueDao;
    private final UserDao userDao;
    private final UserMetaValueDao userMetaValueDao;
    private final UserThreadLinkDao userThreadLinkDao;
    private final UserThreadLinkMetaValueDao userThreadLinkMetaValueDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        contactLinkDaoConfig = daoConfigMap.get(ContactLinkDao.class).clone();
        contactLinkDaoConfig.initIdentityScope(type);

        messageDaoConfig = daoConfigMap.get(MessageDao.class).clone();
        messageDaoConfig.initIdentityScope(type);

        messageMetaValueDaoConfig = daoConfigMap.get(MessageMetaValueDao.class).clone();
        messageMetaValueDaoConfig.initIdentityScope(type);

        publicKeyDaoConfig = daoConfigMap.get(PublicKeyDao.class).clone();
        publicKeyDaoConfig.initIdentityScope(type);

        readReceiptUserLinkDaoConfig = daoConfigMap.get(ReadReceiptUserLinkDao.class).clone();
        readReceiptUserLinkDaoConfig.initIdentityScope(type);

        threadDaoConfig = daoConfigMap.get(ThreadDao.class).clone();
        threadDaoConfig.initIdentityScope(type);

        threadMetaValueDaoConfig = daoConfigMap.get(ThreadMetaValueDao.class).clone();
        threadMetaValueDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        userMetaValueDaoConfig = daoConfigMap.get(UserMetaValueDao.class).clone();
        userMetaValueDaoConfig.initIdentityScope(type);

        userThreadLinkDaoConfig = daoConfigMap.get(UserThreadLinkDao.class).clone();
        userThreadLinkDaoConfig.initIdentityScope(type);

        userThreadLinkMetaValueDaoConfig = daoConfigMap.get(UserThreadLinkMetaValueDao.class).clone();
        userThreadLinkMetaValueDaoConfig.initIdentityScope(type);

        contactLinkDao = new ContactLinkDao(contactLinkDaoConfig, this);
        messageDao = new MessageDao(messageDaoConfig, this);
        messageMetaValueDao = new MessageMetaValueDao(messageMetaValueDaoConfig, this);
        publicKeyDao = new PublicKeyDao(publicKeyDaoConfig, this);
        readReceiptUserLinkDao = new ReadReceiptUserLinkDao(readReceiptUserLinkDaoConfig, this);
        threadDao = new ThreadDao(threadDaoConfig, this);
        threadMetaValueDao = new ThreadMetaValueDao(threadMetaValueDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);
        userMetaValueDao = new UserMetaValueDao(userMetaValueDaoConfig, this);
        userThreadLinkDao = new UserThreadLinkDao(userThreadLinkDaoConfig, this);
        userThreadLinkMetaValueDao = new UserThreadLinkMetaValueDao(userThreadLinkMetaValueDaoConfig, this);

        registerDao(ContactLink.class, contactLinkDao);
        registerDao(Message.class, messageDao);
        registerDao(MessageMetaValue.class, messageMetaValueDao);
        registerDao(PublicKey.class, publicKeyDao);
        registerDao(ReadReceiptUserLink.class, readReceiptUserLinkDao);
        registerDao(Thread.class, threadDao);
        registerDao(ThreadMetaValue.class, threadMetaValueDao);
        registerDao(User.class, userDao);
        registerDao(UserMetaValue.class, userMetaValueDao);
        registerDao(UserThreadLink.class, userThreadLinkDao);
        registerDao(UserThreadLinkMetaValue.class, userThreadLinkMetaValueDao);
    }
    
    public void clear() {
        contactLinkDaoConfig.clearIdentityScope();
        messageDaoConfig.clearIdentityScope();
        messageMetaValueDaoConfig.clearIdentityScope();
        publicKeyDaoConfig.clearIdentityScope();
        readReceiptUserLinkDaoConfig.clearIdentityScope();
        threadDaoConfig.clearIdentityScope();
        threadMetaValueDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
        userMetaValueDaoConfig.clearIdentityScope();
        userThreadLinkDaoConfig.clearIdentityScope();
        userThreadLinkMetaValueDaoConfig.clearIdentityScope();
    }

    public ContactLinkDao getContactLinkDao() {
        return contactLinkDao;
    }

    public MessageDao getMessageDao() {
        return messageDao;
    }

    public MessageMetaValueDao getMessageMetaValueDao() {
        return messageMetaValueDao;
    }

    public PublicKeyDao getPublicKeyDao() {
        return publicKeyDao;
    }

    public ReadReceiptUserLinkDao getReadReceiptUserLinkDao() {
        return readReceiptUserLinkDao;
    }

    public ThreadDao getThreadDao() {
        return threadDao;
    }

    public ThreadMetaValueDao getThreadMetaValueDao() {
        return threadMetaValueDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public UserMetaValueDao getUserMetaValueDao() {
        return userMetaValueDao;
    }

    public UserThreadLinkDao getUserThreadLinkDao() {
        return userThreadLinkDao;
    }

    public UserThreadLinkMetaValueDao getUserThreadLinkMetaValueDao() {
        return userThreadLinkMetaValueDao;
    }

}
