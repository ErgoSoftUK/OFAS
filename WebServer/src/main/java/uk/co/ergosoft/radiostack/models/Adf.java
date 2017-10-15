package uk.co.ergosoft.radiostack.models;

import com.flightsim.fsuipc.FSADF;

public class Adf extends BaseJsonWrapper {
    private FSADF fsadf = new FSADF();

    public String getIdentity() {
        return asString(fsadf.Identity());
    }

    public Short getFreq() {
        return fsadf.Freq();
    }

    public String getFreqAsString() {
        return asString(fsadf.FreqAsString());
    }

    public String getName() {
        return asString(fsadf.Name());
    }

}
