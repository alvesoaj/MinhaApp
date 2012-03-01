package br.uespi.daos;

import java.util.ArrayList;
import br.uespi.models.List;
import br.uespi.utils.MySQLiteHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ListDAO {
	public static final String TABLE = "lists";
	public static final String TABLE_ID = "_id";
	public static final String TABLE_DESC = "description";
	public static final String[] ALL_COLUMNS = { TABLE_ID, TABLE_DESC };

	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;

	public ListDAO(Context context) {
		dbHelper = new MySQLiteHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public long createList(String description) {
		ContentValues values = new ContentValues();

		values.put(TABLE_DESC, description);

		return database.insert(TABLE, null, values);
	}

	public void deleteList(List list) {
		long id = list.getId();
		database.delete(TABLE, TABLE_ID + " = " + id, null);
	}

	public List getListById(long id) {
		Cursor cursor = database.query(TABLE, ALL_COLUMNS, TABLE_ID + " = "
				+ String.valueOf(id), null, null, null, null);
		cursor.moveToFirst();
		List list = cursorToList(cursor);
		cursor.close();
		return list;
	}

	public ArrayList<List> getAllLists() {
		ArrayList<List> lists = new ArrayList<List>();
		Cursor cursor = database.query(TABLE, ALL_COLUMNS, null, null, null,
				null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			List list = cursorToList(cursor);
			lists.add(list);
			cursor.moveToNext();
		}
		cursor.close();
		return lists;
	}

	private List cursorToList(Cursor cursor) {
		List list = new List();
		list.setId(cursor.getLong(0));
		list.setDescription(cursor.getString(1));
		return list;
	}
}
