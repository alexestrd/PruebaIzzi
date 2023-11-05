package com.example.izzi.Izzi.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class dataipModel {
    @JsonProperty("ip") @Getter @Setter
    private String ip;

    @JsonProperty("type") @Getter @Setter
    private String type;

    @JsonProperty("location") @Getter @Setter
    private Location location;

    @JsonProperty("postcode") @Getter @Setter
    private String postcode;

    @JsonProperty("area") @Getter @Setter
    private Area area;

    @JsonProperty("asn") @Getter @Setter
    private ASN asn;

    @JsonProperty("city") @Getter @Setter
    private City city;

    @JsonProperty("continent") @Getter @Setter
    private Continent continent;

    @JsonProperty("country") @Getter @Setter
    private Country country;

    @JsonProperty("currency") @Getter @Setter
    private Currency currency;

    @JsonProperty("security") @Getter @Setter
    private Security security;

    @JsonProperty("time") @Getter @Setter
    private Time time;

    @JsonProperty("status") @Getter @Setter
    private String status;

    public static class Location {
        @JsonProperty("latitude") @Getter @Setter
        private double latitude;

        @JsonProperty("longitude") @Getter @Setter
        private double longitude;
    }

    public static class Area {
        @JsonProperty("code") @Getter @Setter
        private String code;

        @JsonProperty("geonameid") @Getter @Setter
        private int geonameid;

        @JsonProperty("name") @Getter @Setter
        private String name;
    }

    public static class ASN {
        @JsonProperty("number") @Getter @Setter
        private int number;

        @JsonProperty("organisation") @Getter @Setter
        private String organisation;
    }

    public static class City {
        @JsonProperty("geonameid") @Getter @Setter
        private int geonameid;

        @JsonProperty("name") @Getter @Setter
        private String name;

        @JsonProperty("population") @Getter @Setter
        private int population;
    }

    public static class Continent {
        @JsonProperty("geonameid") @Getter @Setter
        private int geonameid;

        @JsonProperty("name") @Getter @Setter
        private String name;

        @JsonProperty("code") @Getter @Setter
        private String code;
    }

    public static class Country {
        @JsonProperty("geonameid") @Getter @Setter
        private int geonameid;

        @JsonProperty("name") @Getter @Setter
        private String name;

        @JsonProperty("code")@Getter @Setter
        private String code;

        @JsonProperty("capital") @Getter @Setter
        private String capital;

        @JsonProperty("area_size") @Getter @Setter
        private String areaSize;

        @JsonProperty("population") @Getter @Setter
        private int population;

        @JsonProperty("phone_code") @Getter @Setter
        private String phoneCode;

        @JsonProperty("is_in_eu") @Getter @Setter
        private boolean isInEu;

        @JsonProperty("languages") @Getter @Setter
        private Languages languages;

        @JsonProperty("flag") @Getter @Setter
        private Flag flag;

        @JsonProperty("tld") @Getter @Setter
        private String tld;
    }

    public static class Languages {
        @JsonProperty("es") @Getter @Setter
        private String es;
    }

    public static class Flag {
        @JsonProperty("file") @Getter @Setter
        private String file;

        @JsonProperty("emoji") @Getter @Setter
        private String emoji;

        @JsonProperty("unicode") @Getter @Setter
        private String unicode;
    }

    public static class Currency {
        @JsonProperty("code") @Getter @Setter
        private String code;

        @JsonProperty("name") @Getter @Setter
        private String name;
    }

    public static class Security {
        @JsonProperty("is_tor") @Getter @Setter
        private boolean isTor;

        @JsonProperty("is_proxy") @Getter @Setter
        private boolean isProxy;

        @JsonProperty("is_crawler") @Getter @Setter
        private boolean isCrawler;

        @JsonProperty("is_threat") @Getter @Setter
        private boolean isThreat;

        @JsonProperty("is_thread")@Getter @Setter
        private boolean isThread;
    }

    public static class Time {
        @JsonProperty("timezone") @Getter @Setter
        private String timezone;

        @JsonProperty("gtm_offset") @Getter @Setter
        private int gtmOffset;

        @JsonProperty("gmt_offset") @Getter @Setter
        private int gmtOffset;

        @JsonProperty("is_daylight_saving") @Getter @Setter
        private boolean isDaylightSaving;

        @JsonProperty("code") @Getter @Setter
        private String code;
    }
}
