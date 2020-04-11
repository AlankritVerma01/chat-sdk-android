package co.chatsdk.typing_indicator;


import android.content.Context;

import sdk.chat.core.handlers.Module;
import sdk.chat.core.session.ChatSDK;
import sdk.chat.core.session.Configure;
import sdk.guru.common.BaseConfig;

/**
 * Created by ben on 10/5/17.
 */

public class FirebaseTypingIndicatorModule implements Module {

    public static final FirebaseTypingIndicatorModule instance = new FirebaseTypingIndicatorModule();

    public static FirebaseTypingIndicatorModule shared() {
        return instance;
    }

    public static Config<FirebaseTypingIndicatorModule> configure() {
        return instance.config;
    }

    public static FirebaseTypingIndicatorModule configure(Configure<Config> config) {
        config.with(instance.config);
        return instance;
    }

    public static class Config<T> extends BaseConfig<T> {

        public long typingTimeout  = 3000;

        public Config(T onBuild) {
            super(onBuild);
        }

        public Config<T> setTypingTimeout(long typingTimeout) {
            this.typingTimeout = typingTimeout;
            return this;
        }

    }

    protected Config<FirebaseTypingIndicatorModule> config = new Config<>(this);

    @Override
    public void activate(Context context) {
        ChatSDK.a().typingIndicator = new FirebaseTypingIndicatorHandler();
    }

    @Override
    public String getName() {
        return "FirebaseTypingIndicatorModule";
    }

    public static Config config() {
        return instance.config;
    }
}
