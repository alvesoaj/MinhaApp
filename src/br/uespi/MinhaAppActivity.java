package br.uespi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MinhaAppActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView myTextView = (TextView) findViewById(R.id.myTextView);
		
		myTextView.setText("AJ Alves");
	}
}