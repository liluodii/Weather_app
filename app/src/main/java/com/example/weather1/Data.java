package com.example.weather1;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {
    public Integer id,humidity,predictability,visibility;
    public String weatherStateName,weatherstateAbbr,windDirectionCompass,created,applicableDate;
    public Double mintemp,maxtemp,theTemp,windDirection,windspeed;

    public Data() {
        this.id = id;
        this.humidity = humidity;
        this.predictability = predictability;
        this.visibility = visibility;
        this.weatherStateName = weatherStateName;
        this.weatherstateAbbr = weatherstateAbbr;
        this.windDirectionCompass = windDirectionCompass;
        this.created = created;
        this.applicableDate = applicableDate;
        this.mintemp = mintemp;
        this.maxtemp = maxtemp;
        this.theTemp = theTemp;
        this.windDirection = windDirection;
        this.windspeed = windspeed;
    }

    public Data(Parcel in) {
       weatherStateName=in.readString();
       weatherstateAbbr=in.readString();
       applicableDate=in.readString();
       maxtemp=in.readDouble();
       mintemp=in.readDouble();
       theTemp=in.readDouble();
       humidity=in.readInt();
       predictability=in.readInt();
    }

    public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getPredictability() {
        return predictability;
    }

    public void setPredictability(Integer predictability) {
        this.predictability = predictability;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public String getWeatherStateName() {
        return weatherStateName;
    }

    public void setWeatherStateName(String weatherStateName) {
        this.weatherStateName = weatherStateName;
    }

    public String getWeatherstateAbbr() {
        return weatherstateAbbr;
    }

    public void setWeatherstateAbbr(String weatherstateAbbr) {
        this.weatherstateAbbr = weatherstateAbbr;
    }

    public String getWindDirectionCompass() {
        return windDirectionCompass;
    }

    public void setWindDirectionCompass(String windDirectionCompass) {
        this.windDirectionCompass = windDirectionCompass;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        created = created;
    }

    public String getApplicableDate() {
        return applicableDate;
    }

    public void setApplicableDate(String applicableDate) {
        this.applicableDate = applicableDate;
    }

    public Double getMintemp() {
        return mintemp;
    }

    public void setMintemp(Double mintemp) {
        this.mintemp = mintemp;
    }

    public Double getMaxtemp() {
        return maxtemp;
    }

    public void setMaxtemp(Double maxtemp) {
        this.maxtemp = maxtemp;
    }

    public Double getTheTemp() {
        return theTemp;
    }

    public void setTheTemp(Double theTemp) {
        this.theTemp = theTemp;
    }

    public Double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Double windDirection) {
        this.windDirection = windDirection;
    }

    public Double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(Double windspeed) {
        this.windspeed = windspeed;
    }

    public static Creator<Data> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(weatherStateName);
        dest.writeString(weatherstateAbbr);
        dest.writeString(applicableDate);
        dest.writeString(maxtemp.toString());
        dest.writeString(mintemp.toString());
        dest.writeString(theTemp.toString());
        dest.writeString(humidity.toString());
        dest.writeString(predictability.toString());
    }
}
