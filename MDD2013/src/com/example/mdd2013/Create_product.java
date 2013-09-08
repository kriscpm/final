package com.example.mdd2013;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Create_product extends Activity {
	@SuppressLint("NewApi")
	//public SQLiteDatabase pricedb;
	//Button button1=null;

	 SQLiteDatabase pricedb;
		Button button1=null;
		Context myContext=null;
		String data=null;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_product);
		// Show the Up button in the action bar.
		setupActionBar();
		
		pricedb = this.openOrCreateDatabase("myprice_database.db", MODE_PRIVATE, null);
		myContext=this.getApplicationContext();
		
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
		getMenuInflater().inflate(R.menu.create_product, menu);
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
	public void saveProduct(View view)
	{
		EditText categorytext = (EditText) findViewById(R.id.category);
		String cattext= categorytext.getText().toString();
		
		EditText producttext = (EditText) findViewById(R.id.product);
		String protext= producttext.getText().toString();
		
		EditText tescotext = (EditText) findViewById(R.id.tesco_price);
		String testext= tescotext.getText().toString();
		
		EditText juscotext = (EditText) findViewById(R.id.jusco_price);
		String justext= juscotext.getText().toString();
		
		EditText gianttext = (EditText) findViewById(R.id.giant_price);
		String giatext= gianttext.getText().toString();
		
		
		
		
		/*
		 * pricedb.execSQL("INSERT INTO "+ "myprice_database"+ " (Category)" + cattext);
		pricedb.execSQL("INSERT INTO "+ "myprice_database"+ " (Product)" +  protext);
		pricedb.execSQL("INSERT INTO "+ "myprice_database"+ " (Tesco)" +  testext);
		pricedb.execSQL("INSERT INTO "+ "myprice_database"+ " (Jusco)" +  justext);
		pricedb.execSQL("INSERT INTO "+ "myprice_database"+ " (Giant)" +  giatext);
		*/
		try{
			pricedb = this.openOrCreateDatabase("myprice_database.db", MODE_PRIVATE, null);
			myContext=this.getApplicationContext();
		pricedb.execSQL("INSERT INTO myprice_database ( Category, Product, Tesco, Jusco, Giant) VALUES ('" + cattext + "','" + protext + "','" + testext + "','" + justext + "', '" + giatext + "')");
		Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
		} catch(Exception e) {
			Log.d("DEBUGGER", e.toString());
		}
	}
	
}
