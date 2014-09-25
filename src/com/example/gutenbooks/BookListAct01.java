package com.example.gutenbooks;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class BookListAct01 extends Activity {
	
	String[] authorBooks = null;	
	String[] bookUrls = null;
	ListView bookListView = null;
	Activity mThisAct = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Initializing 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.book_list_layout);
		mThisAct = this;
		
		//Get the author's id passed from MainActivity
		Intent i = getIntent();
		Bundle extras = i.getExtras();
		int authorId = (int) extras.get("authorId");
		setInfo(authorId);
				

		bookListView = (ListView) findViewById(R.id.BookListView);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, authorBooks);
		if(bookListView != null)
			bookListView.setAdapter(adapter);
		
		//Create and run an implicit intent calling the clicked on work's url
		bookListView.setOnItemClickListener( new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				String bookUrl = bookUrls[(int) id];
	    	    Intent intent = new Intent(Intent.ACTION_VIEW,
	    				Uri.parse(bookUrl));
				startActivity(intent);
				
			}
			
		});
		
	}

	//Sets the titles and url arrays to correspond to the correct author
	private void setInfo(int authorId){
		switch(authorId){
		case 0:
			authorBooks = getResources().getStringArray(R.array.andersens_titles);
			bookUrls = getResources().getStringArray(R.array.andersens_urls);
			break;
		case 1:
			authorBooks = getResources().getStringArray(R.array.twains_titles);
			bookUrls = getResources().getStringArray(R.array.twains_urls);
			break;
		case 2:
			authorBooks = getResources().getStringArray(R.array.sabatinis_titles);
			bookUrls = getResources().getStringArray(R.array.sabatinis_urls);
			break;
		case 3:
			authorBooks = getResources().getStringArray(R.array.dickens_titles);
			bookUrls = getResources().getStringArray(R.array.dickens_urls);
			break;
		case 4:
			authorBooks = getResources().getStringArray(R.array.maupassants_titles);
			bookUrls = getResources().getStringArray(R.array.maupassants_urls);
			break;
		case 5:
			authorBooks = getResources().getStringArray(R.array.hugos_titles);
			bookUrls = getResources().getStringArray(R.array.hugos_urls);
			break;
		case 6:
			authorBooks = getResources().getStringArray(R.array.tolstoys_titles);
			bookUrls = getResources().getStringArray(R.array.tolstoys_urls);
			break;
		case 7:
			authorBooks = getResources().getStringArray(R.array.kiplings_titles);
			bookUrls = getResources().getStringArray(R.array.kiplings_urls);
			break;
		case 8:
			authorBooks = getResources().getStringArray(R.array.tagores_titles);
			bookUrls = getResources().getStringArray(R.array.tagores_urls);
			break;
		case 9:
			authorBooks = getResources().getStringArray(R.array.shakespeares_titles);
			bookUrls = getResources().getStringArray(R.array.shakespeares_urls);
			break;
		}
	}
}
