package com.desafiolatam.prueba4.models;

/**
 * Created by amuno on 12-11-2017.
 *
 */

public class Quotes {
    private String author;
    private String category;
    private String quote;

    public String getQuote() {
        return quote;
    }
    public Quotes() {
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public void setQuote(String quote) {
        this.quote = quote;
    }

}
