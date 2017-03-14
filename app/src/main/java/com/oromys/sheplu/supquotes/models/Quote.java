package com.oromys.sheplu.supquotes.models;

import java.util.Date;

/**
 * Created by sheplu on 13/03/17.
 */

public class Quote {
    private String strQuote;
    private Integer rating;
    private Date creationDate;

    public Quote(String quote) {
        this.strQuote = quote;
        this.rating = 0;
        this.creationDate = new Date();
    }

    public String getStrQuote() {
        return strQuote;
    }

    public void setStrQuote(String strQuote) {
        this.strQuote = strQuote;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
