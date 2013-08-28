package lu.mir.droid.pomodoro;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.dropbox.sync.android.DbxAccountManager;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	final String welcomeScreenShownPref = "welcomeScreenShown";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		DbxAccountManager mDbxAcctMgr = DbxAccountManager.getInstance(
				getApplicationContext(), "3rglfd35h2aabho", "wcy337zm6m7paxs");

		if (!mDbxAcctMgr.hasLinkedAccount()) {
			showWelcomeScreen();
		}

		setContentView(R.layout.activity_main);

		showKeyboardWhenStartingActivity();
	}

	private void showKeyboardWhenStartingActivity() {
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
	}

	public void unlinkFromDropbox(View view) {
		DbxAccountManager mDbxAcctMgr = DbxAccountManager.getInstance(
				getApplicationContext(), "3rglfd35h2aabho", "wcy337zm6m7paxs");
		mDbxAcctMgr.unlink();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/** Called when the user clicks the Send button */
	public void startCounter(View view) {
		Intent intent = new Intent(this, CountdownActivity.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}

	public void showWelcomeScreen() {
		Intent intent = new Intent(this, WelcomeActivity.class);
		startActivity(intent);
	}

}
