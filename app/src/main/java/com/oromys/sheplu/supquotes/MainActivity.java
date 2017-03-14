package com.oromys.sheplu.supquotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.oromys.sheplu.supquotes.models.Quote;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Quote> arrayListQuote = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] quotes = getResources().getStringArray(R.array.quotes);
        for (String item: quotes) {
            Log.i("Datas", "onCreate: "+ item);
            addQuote(item);
        }

        showQuotes(arrayListQuote);

    }

    protected void addQuote(String quote) {
        Quote newQuote = new Quote(quote);
        arrayListQuote.add(newQuote);
    }

    protected void showQuotes(ArrayList<Quote> quotes) {

        ListView lv = (ListView) findViewById(R.id.lv);
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getAllQuotes(quotes));
        lv.setAdapter(listAdapter);
        for (Quote quote : quotes) {
            Log.i("Datas", "showQuotes: "+quote.getStrQuote());
            Toast toast = Toast.makeText(getApplicationContext(),
                    quote.getStrQuote(), Toast.LENGTH_LONG);
            toast.show();
        }
    }

    protected ArrayList<String> getAllQuotes(ArrayList<Quote> quotes) {
        ArrayList<String> listQuotes = new ArrayList<>();
        for (Quote quote: quotes) {
            listQuotes.add(quote.getStrQuote());
        }
        return listQuotes;
    }
}
