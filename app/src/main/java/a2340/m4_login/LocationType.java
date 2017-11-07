package a2340.m4_login;

/**
 * public enu class for the location
 */
public enum LocationType {

    FAMILYDWELLING("1-2 Family Dwelling"),
    MIXBUILDING("1-2 Family Mixed Use Building"),
    FAMILYAPT("3+ Family Apt. Building"),
    MIXBUILDING3("3+ Family Mixed Use Building"),
    SEWER("Catch Basin/Sewer"),
    COMMBUILDING("Commercial Building"),
    CONSTRUCTION("Construction Site"),
    DAYCARE("Day Care/Nursery"),
    GOVTBUILDING("Government Building"),
    HOSPITAL("Hospital"),
    OFFICEBUILDING("Office Building"),
    PARKINGLOT("Parking Lot/Garage"),
    GARDEN("Public Garden"),
    STAIRS("Public Stairs"),
    SCHOOL("School/Pre-School"),
    SRO("Single Room Occupancy (SRO)"),
    SUMMERCAMP("Summer Camp"),
    UNSPECIFIED("Unspecified"),
    VACANTBUILDING("Vacant Building"),
    VACANTLOT("Vacant Lot");

    private String detail;

    LocationType(String det) {
        detail = det;
    }

    /**
     *
     * @return this location's detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     *
     * @param str is this enum's new location value
     * @return this location as a string
     */
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
