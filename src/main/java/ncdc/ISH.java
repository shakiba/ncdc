package ncdc;

import java.io.Serializable;

/**
 * @see https://data.noaa.gov/dataset/integrated-surface-global-hourly-data
 * @see http://www1.ncdc.noaa.gov/pub/data/ish/ish-format-document.pdf
 * @see ftp://ftp.ncdc.noaa.gov/pub/data/noaa/ish-abbreviated.txt
 * @see ftp://ftp.ncdc.noaa.gov/pub/data/noaa/ishJava.java
 * 
 * @author Ali Shakiba
 */
public class ISH {

    // Used for empty, invalid or missing values
    private static final String nil = "";

    /**
     * ISHLazy extracts stores raw data and extracts fields when a method is
     * called.
     */
    public static ISHLazy parseLazy(String line) {
        return new ISHLazy(line);
    }

    /**
     * ISHBasic extracts and stores Control and Mandatory fields.
     */
    public static ISHBasic parseBasic(String line) {
        return parseBasic(line, new ISHBasic());
    }

    /**
     * @see ISH#parseBasic(String)
     */
    public static ISHBasic parseBasic(String line, ISHBasic ish) {
        return ish.read(line);
    }

    /**
     * ISHFull extracts and stores several other fields in addition to Control
     * and Mandatory fields.
     */
    public static ISHFull parseFull(String line) {
        return parseFull(line, new ISHFull());
    }

    /**
     * @see ISH#parseFull(String)
     */
    public static ISHFull parseFull(String line, ISHFull ish) {
        return ish.read(line);
    }

    public static String usaf(String record) {
        String field = record.substring(4, 10);
        return field;
    }

    public static String wban(String record) {
        String field = record.substring(10, 15);
        return field;
    }

    public static String wban(String record, String nil) {
        String field = record.substring(10, 15);
        if (field.equals("99999")) {
            field = nil;
        }
        return field;
    }

    public static String year(String record) {
        String field = record.substring(15, 19);
        return field;
    }

    public static String month(String record) {
        String field = record.substring(19, 21);
        return field;
    }

    public static String day(String record) {
        String field = record.substring(21, 23);
        return field;
    }

    public static String hour(String record) {
        String field = record.substring(23, 25);
        return field;
    }

    public static String minute(String record) {
        String field = record.substring(25, 27);
        return field;
    }

    public static String latitude(String record) {
        String field = record.substring(28, 34);
        return field;
    }

    public static String longitude(String record) {
        String field = record.substring(34, 41);
        return field;
    }

    public static String elevation(String record) {
        String field = record.substring(46, 51);
        return field;
    }

    public static String windDirection(String record) {
        String field = record.substring(60, 63);
        return field;
    }

    public static String windDirection(String record, String nil) {
        String field = record.substring(60, 63);
        if (field.equals("999")) {
            field = nil;
        }
        return field;
    }

    public static String windSpeed(String record) {
        String field = record.substring(65, 69);
        return field;
    }

    public static String windSpeed(String record, String nil) {
        String field = record.substring(65, 69);
        if (field.equals("9999")) {
            field = nil;
        }
        return field;
    }

    public static String cloudCeiling(String record) {
        String field = record.substring(70, 75);
        return field;
    }

    public static String cloudCeiling(String record, String nil) {
        String field = record.substring(70, 75);
        if (field.equals("99999")) {
            field = nil;
        }
        return field;
    }

    public static String visibility(String record) {
        String field = record.substring(78, 84);
        return field;
    }

    public static String visibility(String record, String nil) {
        String field = record.substring(78, 84);
        if (field.equals("999999")) {
            field = nil;
        }
        return field;
    }

    public static String temp(String record) {
        String field = record.substring(87, 92);
        return field;
    }

    public static String temp(String record, String nil) {
        String field = record.substring(87, 92);
        if (field.equals("+9999")) {
            field = nil;
        }
        return field;
    }

    public static String dewp(String record) {
        String field = record.substring(93, 98);
        return field;
    }

    public static String dewp(String record, String nil) {
        String field = record.substring(93, 98);
        if (field.equals("+9999")) {
            field = nil;
        }
        return field;
    }

    public static String pressure(String record) {
        String field = record.substring(99, 104);
        return field;
    }

    public static String pressure(String record, String nil) {
        String field = record.substring(99, 104);
        if (field.equals("99999")) {
            field = nil;
        }
        return field;
    }

    public static class ISHLazy implements Serializable {

        private String data;

        private ISHLazy(String data) {
            this.data = data;
        }

        public String usaf() {
            return ISH.usaf(data);
        }

        public String wban() {
            return ISH.wban(data);
        }

        public String wban(String nil) {
            return ISH.wban(data, nil);
        }

        public String year() {
            return ISH.year(data);
        }

        public String month() {
            return ISH.month(data);
        }

        public String day() {
            return ISH.day(data);
        }

        public String hour() {
            return ISH.hour(data);
        }

        public String minute() {
            return ISH.minute(data);
        }

        public String latitude() {
            return ISH.latitude(data);
        }

        public String longitude() {
            return ISH.longitude(data);
        }

        public String elevation() {
            return ISH.elevation(data);
        }

        public String windDirection() {
            return ISH.temp(data);
        }

        public String windDirection(String nil) {
            return ISH.windDirection(data, nil);
        }

        public String windSpeed() {
            return ISH.temp(data);
        }

        public String windSpeed(String nil) {
            return ISH.windSpeed(data, nil);
        }

        public String temp() {
            return ISH.temp(data);
        }

        public String temp(String nil) {
            return ISH.temp(data, nil);
        }

        public String dewp() {
            return ISH.dewp(data);
        }

        public String dewp(String nil) {
            return ISH.dewp(data, nil);
        }

        public String pressure() {
            return ISH.pressure(data);
        }

        public String pressure(String nil) {
            return ISH.pressure(data, nil);
        }

        private static final long serialVersionUID = 1L;
    }

    public static class ISHBasic implements Serializable {

        // Control Data Section
        public String usaf;
        public String wban;
        public String year;
        public String month;
        public String day;
        public String hour;
        public String minute;
        public String latitude;
        public String longitude;
        public String elevation;

        // Mandatory Data Section
        public String windDirection;
        public String windSpeed;
        public String cloudCeiling;
        public String visibility;
        public String temp;
        public String dewp;
        /** Sea Level Pressure */
        public String pressure;

        private ISHBasic read(String record) {

            // Control Data Section
            this.usaf = ISH.usaf(record);
            this.wban = ISH.wban(record, nil);
            this.year = ISH.year(record);
            this.month = ISH.month(record);
            this.day = ISH.day(record);
            this.hour = ISH.hour(record);
            this.minute = ISH.minute(record);
            this.latitude = ISH.latitude(record);
            this.longitude = ISH.longitude(record);
            this.elevation = ISH.elevation(record);

            // Mandatory Data Section
            this.windDirection = ISH.windDirection(record, nil);
            this.windSpeed = ISH.windSpeed(record, nil);
            this.cloudCeiling = ISH.cloudCeiling(record, nil);
            this.visibility = ISH.visibility(record, nil);
            this.temp = ISH.temp(record, nil);
            this.dewp = ISH.dewp(record, nil);
            this.pressure = ISH.pressure(record, nil);

            return this;
        }

        private static final long serialVersionUID = 1L;
    }

    public static class ISHFull extends ISHBasic implements Serializable {

        // OC1
        public String windGust;

        // AJ1
        public String snowDepth;

        // AY1
        /** Past Weather */
        public String PW;

        // MW1-4
        /** Present Manual Weather */
        public String MW1, MW2, MW3, MW4;

        // AW1-4
        /** Present Automated Weather */
        public String AW1, AW2, AW3, AW4;

        // GF1
        public String skyCoverage;
        public String lowCloud;
        public String midCloud;
        public String highCloud;

        // MA1
        /** Station Pressure and Altitude */
        public String stAlt, stPrs;

        // KA1-2
        public String maxTemp, minTemp;

        // AA1-4
        public String precip01h;
        public String precip01ht;
        public String precip06h;
        public String precip06ht;
        public String precip24h;
        public String precip24ht;
        public String precipxh;
        public String precipxht;

        private ISHFull read(String line) {
            super.read(line);

            // start of REM section
            int iREM = line.indexOf("REM");
            if (iREM == -1) {
                iREM = 9999;
            }

            this.PW = findStr(line, 0, iREM, "AY1", 3, 4, nil);

            this.MW1 = findStr(line, 0, iREM, "MW1", 3, 5, nil);
            this.MW2 = findStr(line, 0, iREM, "MW2", 3, 5, nil);
            this.MW3 = findStr(line, 0, iREM, "MW3", 3, 5, nil);
            this.MW4 = findStr(line, 0, iREM, "MW4", 3, 5, nil);

            this.AW1 = findStr(line, 0, iREM, "AW1", 3, 5, nil);
            this.AW2 = findStr(line, 0, iREM, "AW2", 3, 5, nil);
            this.AW3 = findStr(line, 0, iREM, "AW3", 3, 5, nil);
            this.AW4 = findStr(line, 0, iREM, "AW4", 3, 5, nil);

            this.windGust = findStr(line, 0, iREM, "OC1", 3, 7, nil);
            if (this.windGust.equals("9999")) {
                this.windGust = nil;
            }

            this.snowDepth = findStr(line, 0, iREM, "AJ1", 3, 7, nil);
            if (this.snowDepth.equals("9999")) {
                this.snowDepth = nil;
            }

            this.skyCoverage = this.lowCloud = this.midCloud = this.highCloud = nil;
            int iGF1 = indexOf(line, 0, iREM, "GF1");
            if (iGF1 >= 0) {
                this.skyCoverage = line.substring(iGF1 + 3, iGF1 + 5);
                if (this.skyCoverage.equals("99")) {
                    this.skyCoverage = nil;
                }

                this.lowCloud = line.substring(iGF1 + 11, iGF1 + 13);
                if (this.lowCloud.equals("99")) {
                    this.lowCloud = nil;
                } else {
                    this.lowCloud = this.lowCloud.substring(1, 2);
                }

                this.midCloud = line.substring(iGF1 + 20, iGF1 + 22);
                if (this.midCloud.equals("99")) {
                    this.midCloud = nil;
                } else {
                    this.midCloud = this.midCloud.substring(1, 2);
                }

                this.highCloud = line.substring(iGF1 + 23, iGF1 + 25);
                if (this.highCloud.equals("99")) {
                    this.highCloud = nil;
                } else {
                    this.highCloud = this.highCloud.substring(1, 2);
                }
            }

            this.stAlt = this.stPrs = nil;
            int iMA1 = indexOf(line, 0, iREM, "MA1");
            if (iMA1 >= 0) {
                this.stAlt = line.substring(iMA1 + 3, iMA1 + 8);
                if (this.stAlt.equals("99999")) {
                    this.stAlt = nil;
                }
                this.stPrs = line.substring(iMA1 + 9, iMA1 + 14);
                if (this.stPrs.equals("99999")) {
                    this.stPrs = nil;
                }
            }

            this.maxTemp = this.minTemp = nil;
            int iKA1 = indexOf(line, 0, iREM, "KA1");
            if (iKA1 >= 0) {
                String temp = line.substring(iKA1 + 7, iKA1 + 12);
                if (temp.equals("+9999")) {
                    temp = nil;
                } else {
                    String code = line.substring(iKA1 + 6, iKA1 + 7);
                    this.setTemp(temp, code);
                }
            }
            int iKA2 = indexOf(line, 0, iREM, "KA2");
            if (iKA2 >= 0) {
                String temp = line.substring(iKA2 + 7, iKA2 + 12);
                if (temp.equals("+9999")) {
                    temp = nil;
                } else {
                    String code = line.substring(iKA2 + 6, iKA2 + 7);
                    this.setTemp(temp, code);
                }
            }

            this.precip01h = this.precip06h = this.precip24h = this.precipxh = nil;
            this.precip01ht = this.precip06ht = this.precip24ht = this.precipxht = nil;
            int iAA1 = indexOf(line, 0, iREM, "AA1");
            if (iAA1 >= 0) {
                String precip = line.substring(iAA1 + 5, iAA1 + 9);
                if (precip.equals("9999")) {
                    precip = nil;
                } else {
                    String hours = line.substring(iAA1 + 3, iAA1 + 5);
                    String trace = line.substring(iAA1 + 9, iAA1 + 10);
                    this.setPrecip(precip, hours, trace);
                }
            }
            int iAA2 = indexOf(line, 0, iREM, "AA2");
            if (iAA2 >= 0) {
                String precip = line.substring(iAA2 + 5, iAA2 + 9);
                if (precip.equals("9999")) {
                    precip = nil;
                } else {
                    String hours = line.substring(iAA2 + 3, iAA2 + 5);
                    String trace = line.substring(iAA2 + 9, iAA2 + 10);
                    this.setPrecip(precip, hours, trace);
                }
            }
            int iAA3 = indexOf(line, 0, iREM, "AA3");
            if (iAA3 >= 0) {
                String precip = line.substring(iAA3 + 5, iAA3 + 9);
                if (precip.equals("9999")) {
                    precip = nil;
                } else {
                    String hours = line.substring(iAA3 + 3, iAA3 + 5);
                    String trace = line.substring(iAA3 + 9, iAA3 + 10);
                    this.setPrecip(precip, hours, trace);
                }
            }
            int iAA4 = indexOf(line, 0, iREM, "AA4");
            if (iAA4 >= 0) {
                String precip = line.substring(iAA4 + 5, iAA4 + 9);
                if (precip.equals("9999")) {
                    precip = nil;
                } else {
                    String hours = line.substring(iAA4 + 3, iAA4 + 5);
                    String trace = line.substring(iAA4 + 9, iAA4 + 10);
                    this.setPrecip(precip, hours, trace);
                }
            }

            return this;
        }

        private void setTemp(String temp, String code) {
            if (code.equals("N")) {
                minTemp = temp;
            } else if (code.equals("M")) {
                maxTemp = temp;
            }
        }

        private void setPrecip(String precip, String hours, String trace) {
            // precip = String.format("%5s", precip);
            // trace = trace.equals("2") ? "T" : nil;
            switch (hours) {
            case "01":
                precip01h = precip;
                precip01ht = trace;
                break;
            case "06":
                precip06h = precip;
                precip06ht = trace;
                break;
            case "24":
                precip24h = precip;
                precip24ht = trace;
                break;
            default:
                precipxh = precip;
                precipxht = trace;
                break;
            }
        }

        private static final long serialVersionUID = 1L;
    }

    private static int indexOf(String line, int from, int to, String tag) {
        int i = line.indexOf(tag, from);
        return i < to ? i : -1;
    }

    private static String findStr(String line, int searchFrom, int searchTo,
            String tag, int from, int to, String fallback) {
        int i = indexOf(line, searchFrom, searchTo, tag);
        if (i >= 0) {
            return line.substring(i + from, i + to);
        }
        return fallback;
    }

    private ISH() {
    }
}
