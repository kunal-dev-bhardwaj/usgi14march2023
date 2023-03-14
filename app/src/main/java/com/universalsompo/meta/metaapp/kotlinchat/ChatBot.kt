package com.universalsompo.meta.metaapp.kotlinchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.universalsompo.meta.R
import com.universalsompo.meta.metaapp.motor.activities.MainActivity
import com.yellowmessenger.ymchat.YMChat
import com.yellowmessenger.ymchat.YMConfig
import com.yellowmessenger.ymchat.models.YMBotEventResponse
import java.util.HashMap

class ChatBot : AppCompatActivity() {
    private var TAG: String = "YMLog"
    private var botId = "x1636459132969"
    private var deviceToken: String? = null
    lateinit var start:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_bot)
        showExtraNotificationData()
        start= findViewById<Button>(R.id.backButton)
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result
            deviceToken = token.toString()
        })
        startChatBot()
    }
    private fun getDataFromIntent(): MutableMap<String, Any?> {
        val data = mutableMapOf<String, Any?>()
        if (intent.extras != null) {
            for (key in intent.extras!!.keySet()) {
                val value = intent.extras!![key]
                data[key] = value
            }
            this.intent.putExtras(Bundle.EMPTY)
        }
        return data
    }

    private fun showExtraNotificationData() {
        if (intent.extras != null && intent.extras?.getString("botId") != null) {
            val data = getDataFromIntent()
            showNotificationAlert(intent.extras?.getString("botId").toString())
        }
    }

    private fun showNotificationAlert(botId: String) {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
        alertDialog.setTitle("Notification")
        alertDialog.setMessage("Notification received for the Bot id : $botId")
        alertDialog.setPositiveButton("Ok") { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        alertDialog.show()

    }

    private fun startChatBot() {

        //Get YMChat instance
        val ymChat: YMChat = YMChat.getInstance()
        ymChat.config = YMConfig(botId)

        //Payload attributes
        val payloadData = HashMap<String, Any>()
        //Setting Payload Data
        payloadData["some-key"] = "some-value"
        ymChat.config.payload = payloadData

        // To Change the color of status bar, by default it will pick app theme
        ymChat.config.statusBarColor = R.color.black

        // To Change the color of close button, default color is white
        ymChat.config.closeButtonColor = R.color.white

        // Start
        // For fetching the history-
        // For bot on app.yellow.ai, make sure Configuration -> Channels -> Chat Widget -> General -> Reset Context for every load is "Not checked"
        // For Bot on cloud.yellow.ai, make sure Channels -> Web -> Setting -> Other Settings -< Show History, option is enabled
        // Finally make sure following code is added in main function of Bot
        /*
         if (app.data.event && app.data.event.code === 'authenticate') {
             return app.sendEvent({
                 code: "verifiedUser",
                 data: app.data.event.payload
             });
         }
         */

        //Please pass unique and secure ymAuthenticationToken, this is used to identify user
        ymChat.config.ymAuthenticationToken = "11341adse3werwerw"

        // End

        /**
         *  To enable Speach to text feature please uncomment below line
         */
        // ymChat.config.enableSpeech = true

        /**
         *  To use v2 widget for bot please uncomment below line
         */
        // ymChat.config.version = 2

        /**
         * If your bot is deployed on On-premise or in specific region please set the url in `customBaseUrl`
         */
        //ymChat.config.customBaseUrl = "Https:/on.pre,.url"

        /**
         * To use custom image as chat bot loader please set following parameter
         * Note- Image/Gif should be deployed on public url and should be light weight for better performance
         * */
        //ymChat.config.customLoaderUrl = "https://example.com/test.svg"

        /**
         * Setting Event Listener
         * You will receive all the events here
         * botEvent.code can be used to identify the event
         * botEvent.data will contain the data in String format
         *
         */
        ymChat.onEventFromBot { botEvent: YMBotEventResponse ->
            when (botEvent.code) {
                "event-name" -> {
                }
            }
        }

        //Bot close event
        ymChat.onBotClose { Log.d("Example App", "Bot Was closed") }

        if (!TextUtils.isEmpty(deviceToken)) {
            ymChat.config.deviceToken = deviceToken
        }

        //Starting the bot activity
        try {
            ymChat.startChatbot(this)
        } catch (e: Exception) {
            //Catch and handle the exception
            e.printStackTrace()
        }

    }

    override fun onBackPressed() {
            if (start.visibility == View.VISIBLE) {
                super.onBackPressed()
            } else {
                Toast.makeText(this@ChatBot, "Its a toast!", Toast.LENGTH_SHORT).show()

            }

//        val selectGameIntent = Intent(this@ChatBot, MainActivity::class.java)
//        startActivity(selectGameIntent)
//        finish()
    }
}