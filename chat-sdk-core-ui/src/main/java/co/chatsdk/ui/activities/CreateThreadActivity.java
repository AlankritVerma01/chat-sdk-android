package co.chatsdk.ui.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import co.chatsdk.core.base.AbstractEntity;
import co.chatsdk.core.dao.Thread;
import co.chatsdk.core.dao.User;
import co.chatsdk.core.interfaces.CoreEntity;
import co.chatsdk.core.interfaces.UserListItem;
import co.chatsdk.core.session.ChatSDK;
import co.chatsdk.ui.R;
import co.chatsdk.ui.module.DefaultUIModule;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class CreateThreadActivity extends SelectContactActivity {

    protected Thread thread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionBarTitle(R.string.new_chat);
        setMultiSelectEnabled(DefaultUIModule.config().groupsEnabled);
    }

    @Override
    protected void initViews() {
        super.initViews();
    }

    @Override
    protected void doneButtonPressed(List<UserListItem> users) {
        if (adapter.getSelectedCount() == 0) {
            showSnackbar(getString(R.string.select_at_least_one_user));
            return;
        }

        // If there are more than 2 users then show a dialog to enter the name
        if(users.size() > 1) {
            ArrayList<String> userEntityIDs = new ArrayList<>();
            for (UserListItem u : users) {
                userEntityIDs.add(u.getEntityID());
            }
//            finish();
            ChatSDK.ui().startEditThreadActivity(this, null, userEntityIDs);
        }
        else {
            createAndOpenThread("", users);
        }
    }

    protected void createAndOpenThread (String name, List<UserListItem> users) {
        showProgressDialog(getString(R.string.creating_thread));
        dm.add(ChatSDK.thread()
                .createThread(name, User.convertIfPossible(users))
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEvent((thread, throwable) -> dismissProgressDialog())
                .subscribe(thread -> {
                    ChatSDK.ui().startChatActivityForID(this, thread.getEntityID());
                    finish();
                }, this));
    }



}
