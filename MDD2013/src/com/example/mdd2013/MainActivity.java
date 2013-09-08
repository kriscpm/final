package com.example.mdd2013;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;



public class MainActivity extends Activity {
	
	
	EditText category =null;
	EditText product =null;
	EditText tesco_price =null;
	EditText jusco_price =null;
	EditText giant_price =null;
	 SQLiteDatabase pricedb;
	Button button1=null;
	Context myContext=null;
	String data=null;
	
	ListView listView ;
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		pricedb = this.openOrCreateDatabase("myprice_database.db", MODE_PRIVATE, null);
		myContext=this.getApplicationContext();
		pricedb.execSQL("CREATE TABLE IF NOT EXISTS "+ "myprice_database"+ " (Category TEXT,Product TEXT, Tesco double(4),Jusco double(4),Giant double(4));");
		 //listView = (ListView) findViewById(R.id.listView1);
		 //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
			//setListAdapter(new ArrayAdapter<String>(listview,cursor, product));
		//	  listView.setAdapter(adapter); 
		/**
		listView.setOnItemClickListener(new OnItemClickListener() {
	    	 
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id)
            {
              
             // ListView Clicked item index
             int itemPosition     = position;
             
             // ListView Clicked item value
             String  itemValue    = (String) listView.getItemAtPosition(position);
                
              // Show Alert 
              Toast.makeText(getApplicationContext(),"Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG).show();
           
            }

       }); 
	*/
		   
	}
	
		
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
		public void searchProduct(View x)
		{
			try{
			Intent searchproduct= new Intent(this,Search_Result.class);
			EditText searchtext = (EditText) findViewById(R.id.editText1);
			String search= searchtext.getText().toString();
			//Cursor cursor=pricedb.query("myprice_database",null,"Product" ,new String[]{search},null,null,null);
			Cursor cursor = pricedb.rawQuery("SELECT * FROM myprice_database WHERE Product like '%" + search + "%'", null);
				if(cursor.getCount() > 0 ) {
					cursor.moveToFirst();
					//searchproduct.putExtra("category", cursor.getString(1));
					searchproduct.putExtra("cursor", cursor.getString(1));
					//final ListView listview = (ListView) findViewById(R.id.listView1);
					
					startActivity(searchproduct);
				}
			} catch(Exception e) {
				Log.d("DEBUGGER", e.toString());
			}
			
		
		}
		public void CreateProduct(View view)
		{
			Intent createproduct = new Intent(this, Create_product.class);
			startActivity(createproduct);
		}
		
	/**	public boolean checkForTable()
		{
			Cursor c=pricedb.query("productdb",null," Product=?",new String[]{"eggs"},null,null,null);
			if(c.getCount()>0)
				return true;
			else
				return false;
		}

*/
	

	
	
}


