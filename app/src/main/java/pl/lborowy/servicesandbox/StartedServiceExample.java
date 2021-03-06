package pl.lborowy.servicesandbox;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by RENT on 2017-08-10.
 */

public class StartedServiceExample extends Service {

    public static final String TAG = StartedServiceExample.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "StartedService started");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "Message");
        Intent intentServiceIntent = new Intent(this, IntentServiceExample.class);
        startService(intentServiceIntent);
        stopSelf();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "StartedService dead");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
