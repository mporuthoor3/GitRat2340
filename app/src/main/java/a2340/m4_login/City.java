package a2340.m4_login;

public enum City {

    BAYSIDE("bayside"),
    BRONX("bronx"),
    BROOKLYN("brooklyn"),
    FLUSHING("flushing"),
    JACKSON("jackson heights"),
    JAMAICA("jamaica"),
    LILNECK("little neck"),
    MASPETH("maspeth"),
    NEWYORK("new york"),
    RIDGEWOOD("ridgewood"),
    SOUTHHILL("south richmond hill"),
    STATENISLAND("staten island"),
    UNSPECIFIED("unspecified"),
    WOODHAVEN("woodhaven"),
    WOODSIDE("woodside");

    private String detail;

    City(String det) {
        detail = det;
    }

    public String getDetail() {
        return detail;
    }

    public static String getNam(String str) {
        if (str.equals("bayside")) {
            return "BAYSIDE";
        } else if (str.equals("bronx")) {
            return "BRONX";
        } else if (str.equals("brooklyn")) {
            return "BROOKLYN";
        } else if (str.equals("flushing")) {
            return "FLUSHING";
        } else if (str.equals("jackson heights")) {
            return "JACKSON";
        } else if (str.equals("jamaica")) {
            return "JAMAICA";
        } else if (str.equals("little neck")) {
            return "LILNECK";
        } else if (str.equals("maspeth")) {
            return "MASPETH";
        } else if (str.equals("new york")) {
            return "NEWYORK";
        } else if (str.equals("ridgewood")) {
            return "RIDGEWOOD";
        } else if (str.equals("south richmond hill")) {
            return "SOUTHHILL";
        } else if (str.equals("staten island")) {
            return "STATENISLAND";
        } else if (str.equals("woodhaven")) {
            return "WOODHAVEN";
        } else if (str.equals("woodside")) {
            return "WOODSIDE";
        } else {
            return "UNSPECIFIED";
        }
    }

}
