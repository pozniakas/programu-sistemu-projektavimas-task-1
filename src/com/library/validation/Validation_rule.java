package com.library.validation;

public class Validation_rule {
    private String prefix;
    private int length;
    public Validation_rule(String prefix, int length){
        this.prefix=prefix;
        this.length=length;
    }
    public String getPrefix(){
        return this.prefix;
    }
    public int getLength(){
        return this.length;
    }
}
