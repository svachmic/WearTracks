package com.google.android.apps.mytracks.wear;

import android.content.Intent;

import com.mariux.teleport.lib.TeleportService;

/**
 * Created by eliska on 9.8.14.
 */
public class TracksService extends TeleportService {

//    private static boolean isRunning = false;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        setOnGetMessageTask(new StartActivityTask());
//    }
//    //Task that shows the path of a received message
//    public class StartActivityTask extends TeleportService.OnGetMessageTask {
//        @Override
//        protected void onPostExecute(String path) {
//            if (path.equals("/start")){
//                isRunning = true;
//                Intent startIntent = new Intent(getBaseContext(), Tracks.class);
//                startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(startIntent);
//            } else if (path.equals("/stop")){
//                isRunning = false;
//                Intent startIntent = new Intent(getBaseContext(), Tracks.class);
//                startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(startIntent);
//            }
////let's reset the task (otherwise it will be executed only once)
//            setOnGetMessageTask(new StartActivityTask());
//        }
//    }
}
