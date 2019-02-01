package com.example.ouser.asynctaskprogressupdate;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AsyncProgress extends AsyncTask<Integer, Integer, String> {

    Context context;
    ProgressBar progress;

    public AsyncProgress (Context context, ProgressBar progress){
        this.context = context;
        this.progress = progress;
    }

      protected String doInBackground(Integer... params) {
            for(int i=0; i<= params[0]; i++){
                try{
                    Thread.sleep(2000);
                    publishProgress(i);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return "Done";
        }

        protected  void onPostExecute(String result){
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Toast.makeText(context, "Completed!", Toast.LENGTH_SHORT).show();
            progress.setProgress(0);
        }

        protected  void onProgressUpdate(Integer... prog){
            progress.setProgress(prog[0]);
        }


    }

