package com.hakodzhak.final;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
public class DashboardActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Button btnKill = findViewById(R.id.btn_kill);
        Button btnFormat = findViewById(R.id.btn_format);
        btnKill.setOnClickListener(v -> Toast.makeText(this, "💀 جاري حذف الفيروس...", Toast.LENGTH_SHORT).show());
        btnFormat.setOnClickListener(v -> Toast.makeText(this, "💥 جاري فرمتة الهاتف...", Toast.LENGTH_SHORT).show());
    }
}
