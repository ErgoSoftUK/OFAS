package uk.co.ergosoft.radiostack.models;

public class BaseJsonWrapper {
    protected String asString(String property) {
        if (property == null || property.isEmpty() || property.hashCode() == 0)
            return "";

        int nullTerminator = property.indexOf("\u0000");
        if (nullTerminator > -1)
            property = property.substring(0, nullTerminator);
        return property;
    }
}
