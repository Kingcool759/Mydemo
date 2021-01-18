package com.example.mydemo;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.mydemo", appContext.getPackageName());
    }

    @Test
    public void main() {
        System.out.println(isUnique("leetcode"));
    }

    public boolean isUnique(String astr) {
        for(int i=0;i<astr.length();i++){
            if(astr.indexOf(astr.charAt(i)) != astr.lastIndexOf(astr.charAt(i))){
                return false;
            }
        }
        return true;
    }
}