package com.eflake.baseproject.base;

import com.eflake.base.main.R;
import com.eflake.baseproject.constant.StaticInfo;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * <p>
 * Base activity,using FragmentActivity activity of support-v4, which allow
 * us to use ActionBar in old version.
 * </p>
 * 
 * @author Eflake
 * @date 2014-8-12
 */
public class BaseActivity extends FragmentActivity {
	protected ActionBar actionBar;// contains a member actionBar
	public static int current_fragment_index = 0; // index of current fragment

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actionBar = getActionBar();
	}

	/**
	 * Switch Activity
	 * 
	 * @param target_activity
	 */
	protected void switchActivityByClass(Class<?> target_activity) {
		Intent intent = new Intent(this, target_activity);
		startActivity(intent);
	}

	/**
	 * Switch to Back Activity or Top Activity
	 * 
	 * @param target_activity
	 */
	protected void switchActivityByClass(Class<?> target_activity,
			boolean isUpBack) {
		Intent intent = new Intent(this, target_activity);
		if (isUpBack) {
			// this flag is using to avoid create new activity in the activity
			// stack when switch to Back Activity or Top Activity
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		}
		startActivity(intent);
	}

	/**
	 * Switch fragment by index
	 * 
	 * @param content_id
	 *            ID of target frameLayout
	 * @param index
	 *            Index of fragment
	 * @param AnimTpye
	 *            Index of animation effect Type
	 */
	protected void switchFragment(int content_id, Fragment fragment,
			int AnimTpye) {
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		switch (AnimTpye) {
		case StaticInfo.ANIM_TYPE_SLIDE_LEFT:
			transaction.setCustomAnimations(R.anim.slide_from_right,
					R.anim.slide_from_right);
			break;
		case StaticInfo.ANIM_TYPE_SLIDE_RIGHT:
			transaction.setCustomAnimations(R.anim.slide_from_left,
					R.anim.slide_from_left);
			break;
		case StaticInfo.ANIM_TYPE_FADE_IN:
			transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
			break;
		default:
			break;
		}
		transaction.replace(content_id, fragment);
		transaction.commit();
	}

	/**
	 * Switch fragment by index ,which contains an bundle augment
	 * 
	 * @param content_id
	 *            ID of target frameLayout
	 * @param index
	 *            Index of fragment
	 * @param AnimTpye
	 *            Index of animation effect Type
	 * @param augument
	 *            Bundle augment
	 */
	protected void switchFragment(int content_id, Fragment fragment,
			int AnimTpye, Bundle augument) {
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		fragment.setArguments(augument);
		switch (AnimTpye) {
		case StaticInfo.ANIM_TYPE_SLIDE_LEFT:
			transaction.setCustomAnimations(R.anim.slide_from_right,
					R.anim.slide_from_right);
			break;
		case StaticInfo.ANIM_TYPE_SLIDE_RIGHT:
			transaction.setCustomAnimations(R.anim.slide_from_left,
					R.anim.slide_from_left);
			break;
		case StaticInfo.ANIM_TYPE_FADE_IN:
			transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
			break;
		default:
			break;
		}
		transaction.replace(content_id, fragment);
		transaction.commit();
	}

	/**
	 * Toggle actionbar showing state
	 */
	protected void ToogleActionBarState() {
		if (actionBar.isShowing()) {
			actionBar.hide();
		} else {
			actionBar.show();
		}
	}

}
