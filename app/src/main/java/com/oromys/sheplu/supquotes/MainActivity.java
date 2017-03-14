package com.oromys.sheplu.supquotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.oromys.sheplu.supquotes.models.Quote;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button addButton;
    private String[] quotes;
    private Quote newQuote;
    private  ArrayAdapter<String> listAdapter;
    private ArrayList<String> listQuotes;
    ArrayList<Quote> arrayListQuote = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(this);

        loadQuotes();
        showQuotes(arrayListQuote);

    }

    protected void loadQuotes() {
        quotes = getResources().getStringArray(R.array.quotes);
        for (String item: quotes) {
            addQuote(item);
        }
    }
    protected void addQuote(String quote) {
        newQuote = new Quote(quote);
        arrayListQuote.add(newQuote);
    }

    protected void showQuotes(ArrayList<Quote> quotes) {
        ListView lv = (ListView) findViewById(R.id.lv);
        listAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getAllQuotes(quotes));
        lv.setAdapter(listAdapter);
    }

    protected ArrayList<String> getAllQuotes(ArrayList<Quote> quotes) {
        listQuotes = new ArrayList<>();
        for (Quote quote: quotes) {
            listQuotes.add(quote.getStrQuote());
        }
        return listQuotes;
    }

    public void onClick(View view) {
        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        EditText edittext =  (EditText) findViewById(R.id.addQuote);
        String newQuoteString = edittext.getText().toString();
        addQuote(newQuoteString);
        showQuotes(arrayListQuote);
        edittext.setText("");
    }
}
