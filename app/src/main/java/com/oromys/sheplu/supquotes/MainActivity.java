package com.oromys.sheplu.supquotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.oromys.sheplu.supquotes.models.Quote;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Quote> arrayListQuote = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textview = (TextView) findViewById(R.id.hello);
        Log.i("Datas", "onCreate: ID" + textview.getText().toString());

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
        for (Quote quote : quotes) {
            Log.i("Datas", "showQuotes: "+quote.getStrQuote());
            Toast toast = Toast.makeText(getApplicationContext(),
                    quote.getStrQuote(), Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
