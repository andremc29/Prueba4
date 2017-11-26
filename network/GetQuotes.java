package com.desafiolatam.prueba4.network;

import android.os.AsyncTask;

import com.desafiolatam.prueba4.models.Quotes;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by amuno on 12-11-2017.
 */

public abstract class GetQuotes extends AsyncTask<Object,Object,Quotes> {

    @Override
    protected Quotes doInBackground(Object... objects) {
        QuoteInterface quoteInterface = new Interceptor().InterceptorChange();
        Call<Quotes> quotePpp = quoteInterface.quotePpp();
        try {
            Response<Quotes> response = quotePpp.execute();
            if(response.code() == 200 && response.isSuccessful()){
                return response.body();
            }else{
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }



}
