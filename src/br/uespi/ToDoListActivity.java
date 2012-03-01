package br.uespi;

import java.util.ArrayList;

import br.uespi.daos.ListDAO;
import br.uespi.models.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ToDoListActivity extends Activity {
	private ListDAO listDataSource;

	private TextView todoHello;

	private ListView myListView;

	private EditText todoEditText;

	private ArrayList<String> todoItems;
	private ArrayAdapter<String> aa;

	private ArrayList<List> allLists = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		listDataSource = new ListDAO(this);
		listDataSource.open();

		setContentView(R.layout.to_do_list);

		String name = "";

		if (getIntent().hasExtra("name")) {
			name = getIntent().getStringExtra("name");
		} else {
			name = "Nada";
		}

		todoHello = (TextView) findViewById(R.id.to_do_hello);

		todoHello.setText(name);

		myListView = (ListView) findViewById(R.id.list_view);

		todoEditText = (EditText) findViewById(R.id.to_do_edit_text);

		todoItems = new ArrayList<String>();

		allLists = listDataSource.getAllLists();

		for (List list : allLists) {
			todoItems.add(list.toString());
		}

		aa = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, todoItems);

		myListView.setAdapter(aa);

		todoEditText.setOnKeyListener(new OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN)
					if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
						todoItems.add(0, todoEditText.getText().toString());
						aa.notifyDataSetChanged();
						listDataSource.createList(todoEditText.getText()
								.toString());
						todoEditText.setText("");
						return true;
					}
				return false;
			}
		});

		myListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Log.w("mycalc", aa.getItem(position));
			}
		});
	}

	@Override
	protected void onResume() {
		listDataSource.open();
		super.onResume();
	}

	@Override
	protected void onPause() {
		listDataSource.close();
		super.onPause();
	}
}
