package com.example.sameer.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;



public class MainActivity extends AppCompatActivity {
    int TotalTextView = 0;
    LinearLayout Containerlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //object declaration and link
        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        Containerlayout = (LinearLayout) findViewById(R.id.LinearTextViews);

        //Toolbar
        setSupportActionBar(my_toolbar);

        getSupportActionBar().setTitle(R.string.MainActivity_title);
        getSupportActionBar().setSubtitle(R.string.toolbar_subtitle);

        //Created Functions
        AddNewTextView();
    }


    List<Listname> logs = SQLite.select()
            .from(Listname.class)
            .queryList();

    //List<TextView> alltextviews = new ArrayList<TextView>();
    public void AddNewTextView() {

        if (TotalTextView < logs.size())
            while (TotalTextView < logs.size()) {
                TextView textView = new TextView(this);
                Containerlayout.addView(textView);
                // editText.setGravity(Gravity.CENTER);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
                layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT;
                layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;

                textView.setLayoutParams(layoutParams);
                //if you want to identify the created TextViews, set a tag, like below
                textView.setTag("AddedTextView" + TotalTextView);
                textView.setId(TotalTextView);
                textView.setClickable(true);
                textView.setOnClickListener(listener);

                String S;
                S = logs.get(TotalTextView).Listname;
                textView.setTextSize(20);
                textView.setText(S);
                TotalTextView++;
                //alltextviews.add(textView);}
            }
        else
            return;


    }


    public void New_List_Activity(View view) {
        Intent newact = new Intent(MainActivity.this, New_List_Activity.class);
        startActivity(newact);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings: {
                Intent settingsActivity = new Intent(MainActivity.this, Settings.class);
                startActivity(settingsActivity);
                return true;
            }
            case R.id.about: {
                Intent AboutActivity = new Intent(MainActivity.this, About.class);
                startActivity(AboutActivity);
                return true;
            }
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }



    View.OnClickListener listener = new View.OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent myintent = new Intent(MainActivity.this, List_Final.class);

            myintent.putExtra("TextViewID", v.getId());
            startActivity(myintent);

        }
    };

}

