package com.desafiolatam.prueba4;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.desafiolatam.prueba4.models.Quotes;
import com.desafiolatam.prueba4.network.GetQuotes;

public class QuoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DailyAppointment().execute("author", "category", "quote");

            }
        });
    }
    private class DailyAppointment extends GetQuotes {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(QuoteActivity.this);
            //progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Quotes quotes) {
            if (quotes != null) {

                TextView authorTv = (TextView) findViewById(R.id.authorTv);
                authorTv.setText(quotes.getAuthor());
                TextView categoryTv = (TextView) findViewById(R.id.categoryTv);
                categoryTv.setText(quotes.getCategory());
                TextView quoteTv = (TextView) findViewById(R.id.quoteTv);
                quoteTv.setText(quotes.getQuote());

            }
        }

    }
}
