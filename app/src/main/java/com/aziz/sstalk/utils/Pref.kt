package com.aziz.sstalk.utils

import android.content.Context
import android.util.Log

object Pref {

    const val KEY_SOUND = "sound"
    const val KEY_VIBRATION = "vibration"
    const val FILE = "settings"
    const val FILE_PROFILE = "profile"
    const val KEY_CURRENT_TARGET = "current"
    const val KEY_MEDIA_VISIBILITY = "media_visibility"

    fun storeToken(context: Context, token:String){
        context.getSharedPreferences(FILE, Context.MODE_PRIVATE)
            .edit().putString("token", token)
            .apply()
    }

    fun getStoredToken(context: Context):String? = context.getSharedPreferences(FILE, Context.MODE_PRIVATE)
            .getString("token","")


    object Notification{
        fun setSoundEnabled(context: Context, isEnabled:Boolean){
            context.getSharedPreferences(FILE, Context.MODE_PRIVATE)
                .edit()
                .putBoolean(KEY_SOUND, isEnabled)
                .apply()
        }

        fun setVibrationEnabled(context: Context, isEnabled:Boolean){
            context.getSharedPreferences(FILE, Context.MODE_PRIVATE)
                .edit()
                .putBoolean(KEY_VIBRATION, isEnabled)
                .apply()
        }


        fun hasSoundEnabled(context: Context):Boolean =
            context.getSharedPreferences(FILE, Context.MODE_PRIVATE)
                .getBoolean(KEY_SOUND, true)

        fun hasVibrationEnabled(context: Context):Boolean =
            context.getSharedPreferences(FILE, Context.MODE_PRIVATE)
                .getBoolean(KEY_VIBRATION, true)

    }

    object Profile{
        fun setProfileUrl(context: Context, uid:String, url:String){
            Log.d("Profile", "setProfileUrl: profile url updated")
            context.getSharedPreferences(FILE_PROFILE, Context.MODE_PRIVATE)
                .edit()
                .putString(uid, url)
                .apply()
        }

        fun isProfileUrlSame(context: Context, uid: String, providedURL:String): Boolean{
           return  context.getSharedPreferences(FILE_PROFILE, Context.MODE_PRIVATE)
                .getString(uid,"") == providedURL

        }
    }

   fun setCurrentTargetUID(context: Context, targetUID:String){
       context.getSharedPreferences(KEY_CURRENT_TARGET, Context.MODE_PRIVATE)
           .edit()
           .putString(KEY_CURRENT_TARGET, targetUID)
           .apply()
   }


    fun getCurrentTargetUID(context: Context):String? {
        return context.getSharedPreferences(KEY_CURRENT_TARGET, Context.MODE_PRIVATE)
            .getString(KEY_CURRENT_TARGET,"")
    }


    fun setMediaVisibility(context:Context, isVisible:Boolean){
        context.getSharedPreferences(FILE, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(KEY_MEDIA_VISIBILITY, isVisible)
            .apply()
    }


    fun isMediaVisible(context:Context):Boolean{
        return context.getSharedPreferences(FILE, Context.MODE_PRIVATE)
            .getBoolean(KEY_MEDIA_VISIBILITY, true)
    }
}