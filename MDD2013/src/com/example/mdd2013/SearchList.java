package com.example.mdd2013;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class SearchList extends Activity {
	ListView listView ;

	@SuppressLint("NewApi")
	
	SQLiteDatabase pricedb;
	Button button1=null;
	Context myContext=null;
	String data=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_list);
		// Show the Up button in the action bar.
		setupActionBar();
	
		pricedb = this.openOrCreateDatabase("myprice_database.db", MODE_PRIVATE, null);
		myContext=this.getApplicationContext();
		 listView = (ListView) findViewById(R.id.listView1);
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
			//setListAdapter(new ArrayAdapter<String>(listview,cursor, product));
			  listView.setAdapter(adapter); 
			  
		//final ListView listview = (ListView) findViewById(R.id.listView1);
		//setListAdapter(new ArrayAdapter<String>(listview,cursor, R.id.product));
				  
		//((ArrayAdapter)listView.getAdapter()).notifyDataSetChanged();
		/** Bundle extras = getIntent().getExtras();
		 String listview = (String) extras.get("cursor");
		 ListView text1 = (ListView) findViewById(R.id.listView1);
		 text1.setLeft(listview);
		 */
	     
		 
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
