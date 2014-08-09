package com.google.android.apps.mytracks.wear;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;

import com.mariux.teleport.lib.TeleportClient;

public class Tracks extends Activity {

    private Button mButton;
    TeleportClient mTeleport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracks);

        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mButton = (Button) stub.findViewById(R.id.button);
                mButton.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                     mTeleport.syncString("track", "start");
                  }
               });


            }
        });
       mTeleport = new TeleportClient(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        mTeleport.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mTeleport.disconnect();
    }
}
