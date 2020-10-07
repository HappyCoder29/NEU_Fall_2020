package edu.northeastern.ashish;

public class Interval {
    public int start;
    public int end;

    private Interval(){}

    public Interval(int start, int end){
        if(start > end){
            this.start = end;
            this.end = start;
        }else {
            this.start = start;
            this.end = end;
        }

    }

}
