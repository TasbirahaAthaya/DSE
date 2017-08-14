package com.example.user.dse;

/**
 * Created by User on 8/14/2017.
 */
public class WatchlistTemplate {

    // variables

    int w_id;
    String w_sym;
    String w_ltp;
    String w_vol;
    String w_chng;

    //empty constructor
    public WatchlistTemplate()
    {}


    // constructor 
    public WatchlistTemplate(int id, String sym,String ltp,String vol,String chng){

        this.w_id = id;
        this.w_sym = sym;
        this.w_ltp = ltp;
        this.w_vol = vol;
        this.w_chng = chng;

    }

    // constructor
    public WatchlistTemplate( String sym,String ltp,String vol,String chng){

        this.w_sym = sym;
        this.w_ltp = ltp;
        this.w_vol = vol;
        this.w_chng = chng;

    }

    // getter setter


    public int getW_id() {
        return w_id;
    }

    public String getW_sym() {
        return w_sym;
    }

    public String getW_ltp() {
        return w_ltp;
    }

    public String getW_vol() {
        return w_vol;
    }

    public String getW_chng() {
        return w_chng;
    }

    public void setW_chng(String w_chng) {
        this.w_chng = w_chng;
    }

    public void setW_id(int w_id) {
        this.w_id = w_id;
    }

    public void setW_ltp(String w_ltp) {
        this.w_ltp = w_ltp;
    }

    public void setW_sym(String w_sym) {
        this.w_sym = w_sym;
    }

    public void setW_vol(String w_vol) {
        this.w_vol = w_vol;
    }
}
