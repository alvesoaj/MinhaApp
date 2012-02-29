package br.uespi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MinhaAppActivity extends Activity {
	private Button sum;
	private Button sub;
	private Button mult;
	private Button div;

	private EditText num1;
	private EditText num2;

	private TextView result;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		sum = (Button) findViewById(R.id.sum);
		sub = (Button) findViewById(R.id.sub);
		mult = (Button) findViewById(R.id.mult);
		div = (Button) findViewById(R.id.div);

		num1 = (EditText) findViewById(R.id.num1);
		num2 = (EditText) findViewById(R.id.num2);

		result = (TextView) findViewById(R.id.result);

		sum.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				float value1 = Float.valueOf(num1.getText().toString());
				float value2 = Float.valueOf(num2.getText().toString());

				float res = value1 + value2;

				result.setText(String.valueOf(res));
			}
		});

		sub.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				float value1 = Float.valueOf(num1.getText().toString());
				float value2 = Float.valueOf(num2.getText().toString());

				float res = value1 - value2;

				result.setText(String.valueOf(res));
			}
		});

		mult.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				float value1 = Float.valueOf(num1.getText().toString());
				float value2 = Float.valueOf(num2.getText().toString());

				float res = value1 * value2;

				result.setText(String.valueOf(res));
			}
		});

		div.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				float value1 = Float.valueOf(num1.getText().toString());
				float value2 = Float.valueOf(num2.getText().toString());

				float res = value1 / value2;

				result.setText(String.valueOf(res));
			}
		});
	}
}