package com.liyue.btpassservice;

/**
 * Created by liyue on 10/22/15.
 */

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import android.os.Handler;
import android.os.Process;


public class BT extends Service{
    private static final int REQUEST_ENABLE_BT = 3;
    private static final String TAG = "mytag";
    /*private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;

    private final class ServiceHandler extends Handler{
        public ServiceHandler(Looper looper){
            super(looper);
        }
        @Override
        public void handleMessage(Message msg){
            for (int i =0;i<100;i++) {
                try {
                    Log.e(TAG,Integer.toString(i));
                    Thread.sleep(1000);                 //1000 milliseconds is one second.
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
            Log.e(TAG,"handler message In!");
            stopSelf();
        }
    }*/

    public void onCreate(){
        HandlerThread thread = new HandlerThread("ServiceStartArguments", Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();

        //mServiceLooper = thread.getLooper();
        //mServiceHandler = new ServiceHandler(mServiceLooper);
    }




    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "Starting BluePass", Toast.LENGTH_SHORT).show();
        /*Message msg = mServiceHandler.obtainMessage();
        msg.arg1 = startId;
        mServiceHandler.sendMessage(msg);*/

        return START_STICKY;
    }

    @Override
    public IBinder onBind (Intent intent){
        return null;
    }

    @Override
    public void onDestroy(){
        Toast.makeText(this, "BluePass Service Done", Toast.LENGTH_SHORT).show();
    }

}
