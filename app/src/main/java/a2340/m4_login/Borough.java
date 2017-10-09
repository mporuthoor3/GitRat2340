package a2340.m4_login;

public enum Borough {

    BRONX("bronx"),
    BROOKLYN("brooklyn"),
    MANHATTAN("manhattan"),
    QUEENS("queens"),
    STATENISLAND("staten island"),
    UNSPECIFIED("unspecified");

    private String detail;

    Borough(String det) {
        detail = det;
    }

    public String getDetail() {
        return detail;
    }

    public static String getNam(String str) {
        if (str.equals("bronx")) {
            return "BRONX";
        } else if (str.equals("brooklyn")) {
            return "BROOKLYN";
        } else if (str.equals("manhattan")) {
            return "MANHATTAN";
        } else if (str.equals("queens")) {
            return "QUEENS";
        } else if (str.equals("staten island")) {
            return "STATENISLAND";
        } else {
            return "UNSPECIFIED";
        }
    }

}
