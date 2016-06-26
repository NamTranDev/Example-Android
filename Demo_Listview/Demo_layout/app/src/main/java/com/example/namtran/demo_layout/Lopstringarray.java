package com.example.namtran.demo_layout;

/**
 * Created by Nam Tran on 5/19/2015.
 */
public class Lopstringarray
{
    String viet;
    String anh;
    int image;

    public String getViet() {
        return viet;
    }

    public void setViet(String viet) {
        this.viet = viet;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Lopstringarray(String viet, String anh, int image) {

        this.viet = viet;
        this.anh = anh;
        this.image = image;
    }
}
