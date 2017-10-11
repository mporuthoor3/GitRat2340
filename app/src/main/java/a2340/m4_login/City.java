package a2340.m4_login;

public enum City {

    BAYSIDE("Bayside"),
    BRONX("Bronx"),
    BROOKLYN("Brooklyn"),
    FLUSHING("Flushing"),
    JACKSON("Jackson Heights"),
    JAMAICA("Jamaica"),
    LILNECK("Little Neck"),
    MASPETH("Maspeth"),
    NEWYORK("New York"),
    RIDGEWOOD("Ridgewood"),
    SOUTHHILL("South Richmond Hill"),
    STATENISLAND("Staten Island"),
    UNSPECIFIED("Unspecified"),
    WOODHAVEN("Woodhaven"),
    WOODSIDE("Woodside");

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
