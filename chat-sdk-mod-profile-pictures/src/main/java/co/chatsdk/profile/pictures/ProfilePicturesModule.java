package co.chatsdk.profile.pictures;

import android.content.Context;

import androidx.annotation.Nullable;

import sdk.chat.core.handlers.Module;
import sdk.chat.core.session.ChatSDK;

/**
 * Created by Pepe on 01/12/19.
 */

public class ProfilePicturesModule implements Module {

    public static final ProfilePicturesModule instance = new ProfilePicturesModule();

    public static ProfilePicturesModule shared() {
        return instance;
    }

    public void activate (@Nullable Context context) {
        ChatSDK.a().profilePictures = new BaseProfilePicturesHandler();
    }

    @Override
    public String getName() {
        return "ProfilePicturesModule";
    }

}
