package com.example.pokemon;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint("ParcelCreator")
public class Pokemon implements Parcelable{

    String pnm,pim,ptyp,pab,ph,pw,pdesc;

    public Pokemon(String pnm, String pim, String ptyp, String pab, String ph, String pw, String pdesc) {
        this.pnm = pnm;
        this.pim = pim;
        this.ptyp = ptyp;
        this.pab = pab;
        this.ph = ph;
        this.pw = pw;
        this.pdesc = pdesc;
    }
    public Pokemon(String pimgurl, String pproname) {
        this.pnm = pnm;
        this.pim = pim;
    }

    protected Pokemon(Parcel in) {
        pnm = in.readString();
        pim = in.readString();
        ptyp = in.readString();
        pab = in.readString();
        ph = in.readString();
        pw = in.readString();
        pdesc = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getPnm() {
        return pnm;
    }

    public void setPnm(String pnm) {
        this.pnm = pnm;
    }

    public String getPim() {
        return pim;
    }

    public void setPim(String pim) {
        this.pim = pim;
    }

    public String getPtyp() {
        return ptyp;
    }

    public void setPtyp(String ptyp) {
        this.ptyp = ptyp;
    }

    public String getPab() {
        return pab;
    }

    public void setPab(String pab) {
        this.pab = pab;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(pnm);
        dest.writeString(pim);
        dest.writeString(ptyp);
        dest.writeString(pab);
        dest.writeString(ph);
        dest.writeString(pw);
        dest.writeString(pdesc);

    }
}
