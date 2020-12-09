package edu.northeastern.ashish;

import java.sql.Ref;

public class RefClass<T> {
    public T value;

    public RefClass(){}

    public RefClass(T value){
        this.value = value;
    }

}
