package edu.utd.movierental.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie {
    
    private String title;
    public Movie(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return this.title;
    }
}