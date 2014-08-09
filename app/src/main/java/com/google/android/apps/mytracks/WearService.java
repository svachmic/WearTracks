package com.google.android.apps.mytracks;

import android.util.Log;

import com.google.android.apps.mytracks.services.TrackRecordingServiceConnection;
import com.google.android.apps.mytracks.util.TrackRecordingServiceConnectionUtils;
import com.mariux.teleport.lib.TeleportService;

public class WearService extends TeleportService {
   private TrackRecordingServiceConnection trackRecordingServiceConnection;

   public WearService() {
    }

   @Override
   public void onCreate() {
      super.onCreate();
      setOnGetMessageTask(new StartWorkout());

      trackRecordingServiceConnection = new TrackRecordingServiceConnection(
              this, new Runnable() {
         @Override
         public void run() {

         }
      });

   }

   public class StartWorkout extends OnGetMessageTask {

      @Override
      protected void onPostExecute(String path) {
         Log.d("Teleport", "getMessage " + path);
         if (path.equals("/track")) {
            TrackRecordingServiceConnectionUtils.resumeTrack(trackRecordingServiceConnection);
         }
      }
   }
}
