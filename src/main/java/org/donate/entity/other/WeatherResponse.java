package org.donate.entity.other;

import java.util.ArrayList;

public class WeatherResponse {
    public String status;
    public Data data;

}

 class Location{
    public String type;
    public ArrayList<Double> coordinates;
}

 class Weather{
    public String ts;
    public int tp;
    public int pr;
    public int hu;
    public double ws;
    public int wd;
    public String ic;
}

 class Pollution{
    public String ts;
    public int aqius;
    public String mainus;
    public int aqicn;
    public String maincn;
}

 class Current{
    public Weather weather;
    public Pollution pollution;
}

 class Data{
    public String city;
    public String state;
    public String country;
    public Location location;
    public Current current;
}

