package com.mnguyen1130.messingaround;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] favoriteTVShows = {"Madoka Magica", "G Gundam", "Gundam Seed", "Gundam Wing", "Orange is the New Black", "Bob's Burgers", "The Voice", "Family Guy", "The Cleaveland Show",
                "American Dad", "Bojack Horseman", "Bleach", "Naruto", "Lucky Star"};

        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, favoriteTVShows);
        //ListAdapter listAdapter = new MyAdapter(this, favoriteTVShows);

        ListView listView = (ListView) findViewById(R.id.theListView);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String tvShowPicked = "You selected " + String.valueOf(adapterView.getItemAtPosition(position));

                Toast.makeText(MainActivity.this, tvShowPicked, Toast.LENGTH_SHORT).show();
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

            DialogFragment myFragment = new MyDialogFragment();

            myFragment.show(getFragmentManager(), "theDialog");

            return true;
        } else if (id == R.id.options_exit) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onGetNameClick(View view) {

       // Intent getNameScreenIntent = new Intent(this, SecondScreen.class);

        final int result = 1;

        Human bob = new Human(6.25, 185, "Bob");

        Intent sendBob = new Intent(this, SecondScreen.class);

        //getNameScreenIntent.putExtra("callingActivity", "MainActivity");

        sendBob.putExtra("humanBob", bob);

        startActivityForResult(sendBob, result);

        //startActivityForResult(getNameScreenIntent, result);

    }

    public void toConversionButtonClick(View view){
        Intent toConversionScreen = new Intent(this, Conversion.class);

        startActivity(toConversionScreen);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView usersNameMessage = (TextView) findViewById(R.id.users_name_message);

        String nameSentBack = data.getStringExtra("UsersName");

        usersNameMessage.append(" " + nameSentBack);
    }


}
