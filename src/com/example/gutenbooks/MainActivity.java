package com.example.gutenbooks;

/*
 * GutenBooks displays a partial list of authors found on the popular eBooks site, Project GutenBerg.
 * When an author's name is clicked on, a list of his/her books is displayed in a separate activity.
 * When a book's name is clicked on, it implicitly loads the URL in a web browser
 */

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
	int a;
	ListView authorListView = null;
	String[] authorNames = null;
	protected Activity mThisAct = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		//Initializing
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		authorListView = (ListView) findViewById(R.id.AuthorListView);
		authorNames = getResources().getStringArray(R.array.gutenberg_authors);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, authorNames);
		if(authorListView != null)
			authorListView.setAdapter(adapter);
		mThisAct = this;
		
		//When an author's name is clicked on, loads a new activity displaying that author's works
		authorListView.setOnItemClickListener( new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//Create and run an explicit intent
				Intent i = new Intent(mThisAct, BookListAct01.class);
				i.putExtra("authorId", (int) id);
				startActivity(i);
				
			}
			
		});
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
