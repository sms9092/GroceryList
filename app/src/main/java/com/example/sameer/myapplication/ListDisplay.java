package com.example.sameer.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import static android.R.attr.defaultValue;

/**
 * Created by Sameer on 11/22/2016.
 */

public class ListDisplay extends AppCompatActivity {
  public  LinearLayout Container;
    public   TextView TitleText;
    public static int numberData;
    int TotalTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        //object declaration and link
        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        Container = (LinearLayout) findViewById(R.id.LinearTextView);
        TitleText = (TextView) findViewById(R.id.Title_input);

        //Toolbar
        setSupportActionBar(my_toolbar);

        getSupportActionBar().setTitle(R.string.List_Activity);
        getSupportActionBar().setSubtitle(R.string.toolbar_subtitle);

        CreateTextView();
    }


    List<Listname> logs = SQLite.select()
            .from(Listname.class)
            .queryList();

    List<Items> itemsList =SQLite.select()
            .from(Items.class)
            .where(Items_Table.mylist_ID.eq(numberData))
            .queryList();


    public void CreateTextView() {
        Intent myintent = getIntent();
        numberData = myintent.getIntExtra("TextViewID", defaultValue);

            String Title;
           Title = logs.get(numberData).Listname;
            TitleText.setText(Title);



        if (TotalTextView < itemsList.size())
            while (TotalTextView < itemsList.size()) {
                TextView textView = new TextView(this);
                Container.addView(textView);
                // editText.setGravity(Gravity.CENTER);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
                layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT;
                layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;

                textView.setLayoutParams(layoutParams);
                String S;
                S = itemsList.get(TotalTextView).ITEM;
                textView.setTextSize(20);
                textView.setText(S);
                TotalTextView++;

            }
        else
            return;








    }


}





















