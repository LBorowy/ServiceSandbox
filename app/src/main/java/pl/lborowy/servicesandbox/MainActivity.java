package pl.lborowy.servicesandbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // odpalenie serwisu (poprzez INTENT)
        Intent intent = new Intent(this, StartedServiceExample.class);
        startService(intent);
    }
}
