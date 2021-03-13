package sdk.chat.app.xmpp;

import android.app.Application;

import org.pmw.tinylog.Logger;

import app.xmpp.adapter.module.XMPPModule;
import app.xmpp.receipts.XMPPReadReceiptsModule;
import io.reactivex.disposables.Disposable;
import sdk.chat.core.session.ChatSDK;
import sdk.chat.firebase.push.FirebasePushModule;
import sdk.chat.firebase.upload.FirebaseUploadModule;
import sdk.chat.message.audio.AudioMessageModule;
import sdk.chat.message.file.FileMessageModule;
import sdk.chat.message.location.LocationMessageModule;
import sdk.chat.message.sticker.module.StickerMessageModule;
import sdk.chat.message.video.VideoMessageModule;
import sdk.chat.ui.extras.ExtrasModule;
import sdk.chat.ui.module.UIModule;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        xmpp();
    }

    public void xmpp() {
        try {


            ChatSDK.builder()

                    // Configure the library
                    .setGoogleMaps("AIzaSyCwwtZrlY9Rl8paM0R6iDNBEit_iexQ1aE")
                    .setAnonymousLoginEnabled(false)
                    .setDebugModeEnabled(false)
                    .setThreadDestructionEnabled(false)
                    .build()

                    // Add modules to handle file uploads, push notifications
                    .addModule(FirebaseUploadModule.shared())
                    .addModule(FirebasePushModule.shared())

                    .addModule(XMPPModule.builder()
                            .setXMPP("develop.aku-pintar.co.id", "develop.aku-pintar.co.id")
//                            .setXMPP("xmpp.app", "xmpp.app")
//                            .setXMPP("sysnet-ecs.multidemos.com", "sysnet-ecs.multidemos.com")
                            .setAllowServerConfiguration(false)
                            .setSecurityMode("ifpossible")
//                            .setSecurityMode("ifpossible")
                            .setPingInterval(5)
                            .build())

                    .addModule(AudioMessageModule.shared())
                    .addModule(LocationMessageModule.shared())
                    .addModule(VideoMessageModule.shared())
                    .addModule(FileMessageModule.shared())
                    .addModule(StickerMessageModule.builder()
                            .build())
                    .addModule(StickerMessageModule.builder()
                            .build())
                    .addModule(UIModule.builder()
                            .setMessageSelectionEnabled(true)
                            .setUsernameHint("JID")
                            .setResetPasswordEnabled(false)
                            .setPublicRoomCreationEnabled(true)
                            .setPublicRoomsEnabled(false)
                            .build())

                    .addModule(XMPPReadReceiptsModule.shared())
                    .addModule(ExtrasModule.builder()
                            .setQrCodesEnabled(true)
                            .setDrawerEnabled(false)
                            .build())

//                    .addModule(XMPPEncryptionModule.shared())

                    .build().activateWithEmail(this, "ben@sdk.chat");

//            ChatSDK.config().setDebugUsername(Device.honor() ? "a3": "a4");
//            ChatSDK.config().setDebugPassword("123");

//            ChatSDK.ui().setThreadDetailsActivity(ThreadDetailsActivity.class);

//            chatsdkAuth(Device.honor() ? "xxx1" : "xxx2", "123", "test@conference.xmpp.app");

        }
        catch (Exception e) {
            e.printStackTrace();
            Logger.error(e.getLocalizedMessage());
            assert(false);
        }

        Disposable d = ChatSDK.events().sourceOnMain().subscribe(networkEvent -> {
            networkEvent.debug();
        });

        d = ChatSDK.events().errorSourceOnMain().subscribe(throwable -> {
            // Catch errors
            throwable.printStackTrace();
        });

    }

//    private void chatsdkAuth(String username, String password, String threadId) {
//        if (ChatSDK.auth().isAuthenticatedThisSession()) {
//            chatsdkGroup(threadId);
//        } else {
//            ChatSDK.auth().authenticate(AccountDetails.username(username, password)).subscribe(() -> {
//                chatsdkGroup(threadId);
//            }, throwable -> {
//                ChatSDK.auth().authenticate(AccountDetails.signUp(username, password)).subscribe(() -> {
//                    chatsdkGroup(threadId);
//                }, throwable1 -> {
////                    view.displayFailure("Gagal register group");
//                });
//            });
//        }
//    }
//
//    private void chatsdkGroup(String threadId){
//        Thread thread = getThread(threadId);
//        if(thread != null) {
////            if(ChatSDK.thread().hasVoice(thread, ChatSDK.currentUser())){
//                ChatSDK.thread().joinThread(thread).observeOn(RX.main()).subscribe(() -> {
//                    startChatActivity(thread);
//                }, throwable -> {
////                    view.displayFailure("Gagal join group");
//                });
//        }
//    }
//
//    private Thread getThread(String threadId){
//        Thread thread =  ChatSDK.db().fetchOrCreateThreadWithEntityID(threadId);
//        thread.setType(ThreadType.PrivateGroup);
//        return thread;
//    }
//
//    private void startChatActivity(Thread thread){
//        ChatSDK.ui().startChatActivityForID(this, thread.getEntityID(), Intent.FLAG_ACTIVITY_NEW_TASK);
//    }
}