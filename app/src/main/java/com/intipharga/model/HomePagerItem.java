package com.intipharga.model;

import android.widget.ImageView;

/**
 * Created by macair on 2/6/16.
 */
public class HomePagerItem {

    public String imgUrl;
    public String destUrl;
    public String txtPrimary;
    public String txtSecondary;
    public String txtButton;

    public HomePagerItem(String imgUrl, String destUrl, String txtPrimary, String txtSecondary, String txtButton){
        this.imgUrl = imgUrl;
        this.destUrl = destUrl;
        this.txtPrimary = txtPrimary;
        this.txtSecondary = txtSecondary;
        this.txtButton = txtButton;
    }

    public HomePagerItem setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
        return this;
    }

    public HomePagerItem setDestUrl(String destUrl){
        this.destUrl = destUrl;
        return this;
    }

    public HomePagerItem setTxtPrimary(String txtPrimary){
        this.txtPrimary = txtPrimary;
        return this;
    }

    public HomePagerItem setTxtSecondary(String txtSecondary){
        this.txtSecondary = txtSecondary;
        return this;
    }

    public HomePagerItem setTxtButton(String txtButton){
        this.txtButton = txtButton;
        return this;
    }
}
