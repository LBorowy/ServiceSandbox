package pl.lborowy.servicesandbox;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BoundServiceExample service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.main_activity_button);

        // odpalenie serwisu (poprzez INTENT)
        Intent intent = new Intent(this, StartedServiceExample.class);
        startService(intent);

//        stopService(intent);

        Intent boundedServiceIntent = new Intent(this, BoundServiceExample.class);
        bindService(boundedServiceIntent, connection, Context.BIND_AUTO_CREATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), service.getValue(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            BoundServiceExample.LocalBinder binder = (BoundServiceExample.LocalBinder) iBinder;
            service = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
