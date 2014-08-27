package com.eflake.baseproject.base;

import android.app.Application;
import android.util.Log;

/**
 * <p>
 * Entrance of the application,do some initiation works here
 * </p>
 * 
 * @author Eflake
 * @date 2014-8-12
 */
public class BaseApplication extends Application {
	public BaseApplication() {
		super();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		setUpAppConfig();
		setUpLibConfig();
		Log.i("eflake", "begin");
	}

	/**
	 * <p>
	 * Initiation of application configuration
	 * </p>
	 */
	private void setUpAppConfig() {
	}

	/**
	 * <p>
	 * Initiation of library configuration
	 * </p>
	 */
	private void setUpLibConfig() {
	}

}
