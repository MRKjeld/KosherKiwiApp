package com.kkiwi.kosherkiwi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.io.IOException;
/**
 * Created by Alleras on 11/30/2016.
 */


/**
 * Utilize a load animation?
 * testing splash screen creation
 */


public class LoadScreen extends Activity {

    private final int SPLASH_DELAY = 5000;

    @Override
    public void onCreate(Bundle state){
        super.onCreate(state);
        setContentView(R.layout.splash_screen);
        try{
            DataReader pr = new DataReader(getApplicationContext());
        }
        catch(IOException ioe){
            System.out.println("Error loading list\r\n" + ioe.toString());
        }
        catch(Exception e){
            System.out.println("OUT OF BOUNDS " + e.toString());
        }

        new Handler().postDelayed(new Runnable(){
            public void run(){
                startActivity(new Intent(LoadScreen.this, MainActivity.class));
                finish();
            }
        }, SPLASH_DELAY);
    }

}
