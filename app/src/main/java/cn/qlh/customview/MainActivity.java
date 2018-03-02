package cn.qlh.customview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.qlh.sdk.myview.loading.SpinKitViewManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){

        SpinKitViewManager loading = new SpinKitViewManager(this);
        loading.setProgressBarStyle(SpinKitViewManager.CUBE_GRID)
                .setDlgBg(Color.parseColor("#18AD5C"))
                .setTipsTxt("欢迎...")
                .show();

    }
}
