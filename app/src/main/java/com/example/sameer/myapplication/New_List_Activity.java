package com.example.sameer.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

public class New_List_Activity extends AppCompatActivity {

    EditText userinput;
    LinearLayout Containerlayout;
    int TotalEdittexts = 0;
   // static int ListID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_list_activity);

        // Objects Linked
        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        userinput = (EditText) findViewById(R.id.Title_input);
        Containerlayout = (LinearLayout) findViewById(R.id.LinearEditTexts);

        setSupportActionBar(my_toolbar);
        //Toolbar Shiz
        getSupportActionBar().setTitle(R.string.NewListActivity);
        getSupportActionBar().setSubtitle(R.string.toolbar_subtitle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Created functions


    }


    List<Listname> logs = SQLite.select()
            .from(Listname.class)
            .queryList();

    List<Items> itemsList =SQLite.select()
            .from(Items.class)
            .queryList();


    List<EditText> alledittexts = new ArrayList<EditText>();

    public void AddNewTextFields(View view) {
        TotalEdittexts++;
        if (TotalEdittexts > 100)
            return;
        EditText editText = new EditText(this);
        Containerlayout.addView(editText);
        editText.setGravity(Gravity.TOP);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) editText.getLayoutParams();
        layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT;
        layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;

        editText.setLayoutParams(layoutParams);
        //if you want to identify the created editTexts, set a tag, like below
        editText.setTag("AddedEditText" + TotalEdittexts);
        editText.requestFocus();
        editText.setHint("item #" + TotalEdittexts);
        editText.setHintTextColor(getResources().getColor(R.color.EditTExt_hint_Color));
        alledittexts.add(editText);

    }


 /*   public void IDcounter() {
        if (logs.size() == 0 || logs.isEmpty())
            return;
        else
            ListID = logs.size() + 1;

    }
 */


    //adds items to table
    public void AddItemToList() {
        Listname list = new Listname();
        list.ID = logs.size()+1;
        list.setName(userinput.getText().toString());
        list.save();


        for (int i = 0; i <= alledittexts.size(); i++) {
           int counter = itemsList.size() +i;
            Items item = new Items();
            item.ID = counter;
            item.ITEM = alledittexts.get(i).getText().toString();
            item.setList(list);
            item.save();



        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_list, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings: {
                Intent settingsActivity = new Intent(New_List_Activity.this, Settings.class);
                startActivity(settingsActivity);
                return true;
            }
            case R.id.about: {
                Intent AboutActivity = new Intent(New_List_Activity.this, About.class);
                startActivity(AboutActivity);
                return true;
            }
            case R.id.Save: {
                AddItemToList();
                finish();

                return true;
            }
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


}