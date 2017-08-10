package pl.lborowy.servicesandbox;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by RENT on 2017-08-10.
 */

public class BoundServiceExample extends Service {

    public static final String TAG = BoundServiceExample.class.getSimpleName();
    // nowa instancja Binder'a
    private final IBinder binder = new LocalBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onBoundedService create");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // komunikacja komponentu z którego wywołamy Service z Service
        return binder;
    }

    public String getValue() {
        return "Message3";
    }

    public class LocalBinder extends Binder {
        // Binder - zwracanie instancji naszego Service
        BoundServiceExample getService() {
            return BoundServiceExample.this;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onBouneddService dead");
    }
}
