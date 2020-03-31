package co.chatsdk.ui.binders;

import android.content.Context;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import co.chatsdk.core.types.MessageSendStatusFormatter;
import co.chatsdk.core.utils.CurrentLocale;
import co.chatsdk.ui.chat.model.MessageHolder;
import co.chatsdk.ui.module.DefaultUIModule;

public class MessageBinder {

    public static DateFormat messageTimeComparisonDateFormat(Context context) {
        return new SimpleDateFormat("dd-M-yyyy hh:mm", CurrentLocale.get(context));
    }

    public static void onBindSendStatus(TextView textView, MessageHolder holder) {

        if (DefaultUIModule.config().dateFormat != null) {
            DateFormat format = new SimpleDateFormat(DefaultUIModule.config().dateFormat, CurrentLocale.get());
            textView.setText(format.format(holder.getCreatedAt()));
        }

        String status = MessageSendStatusFormatter.format(textView.getContext(), holder.getStatus(), holder.getUploadPercentage());
        String timeString = status + " " + textView.getText();
        textView.setText(timeString);
    }
}
