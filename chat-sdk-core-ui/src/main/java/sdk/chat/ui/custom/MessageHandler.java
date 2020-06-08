package sdk.chat.ui.custom;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.view.View;

import com.stfalcon.chatkit.messages.MessageHolders;

import sdk.chat.core.dao.Keys;
import sdk.chat.core.dao.Message;
import sdk.chat.core.rigs.MessageSendRig;
import sdk.chat.core.session.ChatSDK;
import sdk.chat.core.types.MessageSendStatus;
import sdk.chat.core.types.MessageType;
import sdk.chat.ui.R;
import sdk.chat.ui.chat.ImageMessageOnClickHandler;
import sdk.chat.ui.chat.LocationMessageOnClickHandler;
import sdk.chat.ui.chat.model.ImageMessageHolder;
import sdk.chat.ui.chat.model.MessageHolder;
import sdk.chat.ui.chat.model.SystemMessageHolder;
import sdk.chat.ui.utils.DialogUtils;
import sdk.chat.ui.view_holders.IncomingImageMessageViewHolder;
import sdk.chat.ui.view_holders.IncomingTextMessageViewHolder;
import sdk.chat.ui.view_holders.OutcomingImageMessageViewHolder;
import sdk.chat.ui.view_holders.OutcomingTextMessageViewHolder;
import sdk.chat.ui.view_holders.SystemMessageViewHolder;
import sdk.chat.ui.view_holders.base.BaseIncomingTextMessageViewHolder;

public class MessageHandler implements IMessageHandler {

    @Override
    public void onBindMessageHolders(Context context, MessageHolders holders) {

        BaseIncomingTextMessageViewHolder.Payload holderPayload = new BaseIncomingTextMessageViewHolder.Payload();
        holderPayload.avatarClickListener = user -> {
            ChatSDK.ui().startProfileActivity(context, user.getEntityID());
        };

        holders.registerContentType(
                (byte) MessageType.Image,
                IncomingImageMessageViewHolder.class,
                holderPayload,
                R.layout.view_holder_incoming_image_message,
                OutcomingImageMessageViewHolder.class,
                holderPayload,
                R.layout.view_holder_outcoming_image_message,
                Customiser.shared());

        holders.registerContentType(
                (byte) MessageType.System,
                SystemMessageViewHolder.class,
                R.layout.view_holder_system_message,
                R.layout.view_holder_system_message,
                Customiser.shared());

        holders.setIncomingTextConfig(IncomingTextMessageViewHolder.class, R.layout.view_holder_incoming_text_message, holderPayload)
        .setOutcomingTextConfig(OutcomingTextMessageViewHolder.class, R.layout.view_holder_outcoming_text_message, holderPayload);

    }

    @Override
    public MessageHolder onNewMessageHolder(Message message) {
        if (message.getMessageType().is(MessageType.Image, MessageType.Location)) {
            return new ImageMessageHolder(message);
        }
        if (message.getMessageType().is(MessageType.System)) {
            return new SystemMessageHolder(message);
        }
        return new MessageHolder(message);
    }

    @Override
    public void onClick(Activity activity, View rootView, Message message) {
        if (message.getSender().isMe() && message.getMessageStatus() == MessageSendStatus.Failed) {
            DialogUtils.showToastDialog(activity, R.string.message_send_failed, R.string.try_to_resend_the_message, R.string.send, R.string.cancel, () -> {
                MessageSendRig.create(message).run().subscribe(ChatSDK.events());
            }, null);
        }
        if (message.getMessageType().is(MessageType.Image)) {
            ImageMessageOnClickHandler.onClick(activity, rootView, message.stringForKey(Keys.ImageUrl));
        }
        if (message.getMessageType().is(MessageType.Location)) {
            double longitude = message.doubleForKey(Keys.MessageLongitude);
            double latitude = message.doubleForKey(Keys.MessageLatitude);

            Location location = new Location(ChatSDK.getString(R.string.app_name));
            location.setLatitude(latitude);
            location.setLongitude(longitude);

            LocationMessageOnClickHandler.onClick(activity, location);
        }
    }

    @Override
    public void onLongClick(Activity activity, View rootView, Message message) {

    }

    @Override
    public boolean hasContentFor(MessageHolder message, byte type) {
        return type == MessageType.Text ||
               type == MessageType.Image && message instanceof ImageMessageHolder ||
               type == MessageType.System && message instanceof SystemMessageHolder;
    }
}
