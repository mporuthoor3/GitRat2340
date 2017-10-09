package a2340.m4_login;

public enum LocationType {

    FAMILYDWELLING("1-2 family dwelling"),
    MIXBUILDING("1-2 family mixed use building"),
    FAMILYAPT("3+ family apt. building"),
    MIXBUILDING3("3+ family mixed use building"),
    SEWER("catch basin/sewer"),
    COMMBUILDING("commercial building"),
    CONSTRUCTION("construction site"),
    DAYCARE("day care/nursery"),
    GOVTBUILDING("government building"),
    HOSPITAL("hospital"),
    OFFICEBUILDING("office building"),
    PARKINGLOT("parking lot/garage"),
    GARDEN("public garden"),
    STAIRS("public stairs"),
    SCHOOL("school/pre-school"),
    SRO("single room occupancy (sro)"),
    SUMMERCAMP("summer camp"),
    UNSPECIFIED("unspecified"),
    VACANTBUILDING("vacant building"),
    VACANTLOT("vacant lot");

    private String detail;

    LocationType(String det) {
        detail = det;
    }

    public String getDetail() {
        return detail;
    }

    public static String getNam(String str) {
        if (str.equals("1-2 family dwelling")) {
            return "FAMILYDWELLING";
        } else if (str.equals("1-2 family mixed use building")) {
            return "MIXBUILDING";
        } else if (str.equals("3+ family apt. building")) {
            return "FAMILYAPT";
        } else if (str.equals("3+ family mixed use building")) {
            return "MIXBUILDING3";
        } else if (str.equals("catch basin/sewer")) {
            return "SEWER";
        } else if (str.equals("commercial building")) {
            return "COMMBUILDING";
        } else if (str.equals("construction site")) {
            return "CONSTRUCTION";
        } else if (str.equals("day care/nursery")) {
            return "DAYCARE";
        } else if (str.equals("government building")) {
            return "GOVTBUILDING";
        } else if (str.equals("hospital")) {
            return "HOSPITAL";
        } else if (str.equals("office building")) {
            return "OFFICEBUILDING";
        } else if (str.equals("parking lot/garage")) {
            return "PARKINGLOT";
        } else if (str.equals("public garden")) {
            return "GARDEN";
        } else if (str.equals("public stairs")) {
            return "STAIRS";
        } else if (str.equals("school/pre-school")) {
            return "SCHOOL";
        } else if (str.equals("single room occupancy (sro)")) {
            return "SRO";
        } else if (str.equals("summer camp")) {
            return "SUMMERCAMP";
        } else if (str.equals("vacant building")) {
            return "VACANTBUILDING";
        } else if (str.equals("vacant lot")) {
            return "VACANTLOT";
        } else {
            return "UNSPECIFIED";
        }
    }

}
