package com.mhasandev.CoronavirusTrackerApp.entity;

public class CountryInfo {
    int _id;
    String iso2;
    String iso3;
    int lat;
    int longitude;
    String flag;

    public CountryInfo() {
    }

    public CountryInfo(int _id, String iso2, String iso3, int lat, int longitude, String flag) {
        this._id = _id;
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.lat = lat;
        this.longitude = longitude;
        this.flag = flag;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
