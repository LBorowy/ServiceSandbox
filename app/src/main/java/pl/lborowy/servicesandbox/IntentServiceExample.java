package pl.lborowy.servicesandbox;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by RENT on 2017-08-10.
 */

public class IntentServiceExample extends IntentService {

    public static final String TAG = IntentServiceExample.class.getSimpleName();

    public IntentServiceExample() {
        super("IntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"IntentService started");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "Message2");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "IntentService dead");
    }
}
