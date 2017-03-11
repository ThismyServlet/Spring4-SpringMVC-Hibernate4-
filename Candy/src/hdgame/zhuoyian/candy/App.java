package hdgame.zhuoyian.candy;

import com.zhuoyian.pay.ZYAPay;

import android.app.Application;

public class App extends Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		ZYAPay.initApp(getApplicationContext());
	}

}
