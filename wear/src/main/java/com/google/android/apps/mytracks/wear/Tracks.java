package com.google.android.apps.mytracks.wear;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.Wearable;
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
                     mTeleport.sendMessage("/track", null);
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
        Wearable.NodeApi.getConnectedNodes(mTeleport.getGoogleApiClient()).setResultCallback(new ResultCallback<NodeApi
                .GetConnectedNodesResult>() {


            @Override
            public void onResult(NodeApi.GetConnectedNodesResult getConnectedNodesResult) {
                if (getConnectedNodesResult.getNodes().size() > 0) {
                    startConnected();
                } else {
                    startDisconnected();
                }
            }
        });
    }

    /**
     * Override in child to handle disconnected state.
     */
    protected void startDisconnected() {
        Log.d("Tag", "start disconnect");
    }

    /**
     * Override in child to handle connected state.
     */
    protected void startConnected() {
        Log.d("Tag", "start connect");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mTeleport.disconnect();
        Log.d("Tag", "onStop");
    }
}
