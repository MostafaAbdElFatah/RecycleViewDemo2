package com.mostafaabdel_fatah.recycleviewdemo2;

/**
 * Created by Mostafa AbdEl_Fatah on 9/7/2017.
 */

public class ListProvider {
    private int imageId ;
    private String country,capital;

    public ListProvider(int imageId, String country, String capital) {
        this.setImageId( imageId);
        this.setCountry( country);
        this.setCapital( capital);
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
