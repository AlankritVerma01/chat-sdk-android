package sdk.chat.examples;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import sdk.chat.core.dao.User;
import sdk.chat.core.events.EventType;
import sdk.chat.core.events.NetworkEvent;
import sdk.chat.core.session.ChatSDK;
import io.reactivex.functions.Predicate;

public class UserExamples extends BaseExample {

    public UserExamples() {

        // Get the current user
        User currentUser = ChatSDK.core().currentUser();

        // Add some custom data
        currentUser.setMetaValue("Key", "Value");

        // Update the user's details on Firebase
        dm.add(ChatSDK.core().pushUser().subscribe(() -> {

        }, this));

        // Go online or offline
        ChatSDK.core().goOffline();
        ChatSDK.core().goOnline();

        // Set the user's presence
        dm.add(ChatSDK.core().setUserOnline().subscribe(() -> {
            // Completion
        }, this));

        dm.add(ChatSDK.core().setUserOnline().subscribe(() -> {
            // Completion
        }, this));

        // If you need a user for a given ID
        dm.add(ChatSDK.core().getUserForEntityID("user-entity-id").subscribe(user -> {

            String name = user.getName();
            String avatarURL = user.getAvatarURL();
            String customString = user.metaStringForKey("Key");

            // etc...
        }, this));

        // User Events
        Predicate<NetworkEvent> filter = NetworkEvent.filterType(EventType.UserMetaUpdated, EventType.UserPresenceUpdated);
        dm.add(ChatSDK.events().sourceOnMain().filter(filter).subscribe(networkEvent -> {
            // Handle event
        }));

    }

    public User fetchUserWithEntityID(String entityID) {
        User user = ChatSDK.db().fetchOrCreateEntityWithEntityID(User.class, entityID);
        ChatSDK.core().userOn(user).subscribe(ChatSDK.events());
        return user;
    }

}
