package uk.co.ergosoft.radiostack.models;

import com.flightsim.fsuipc.FSNavRadio;

public abstract class Nav extends BaseJsonWrapper {
    protected FSNavRadio nav;

    public Short getFreq() {
        return nav.Freq();
    }

    public String getFreqAsString() {
        return asString(nav.FreqAsString());
    }

    public String getIdentity() {
        return asString(nav.Identity());
    }

    public String getName() {
        return asString(nav.Name());
    }

    public Short getStandByFreq() {
        return nav.StandByFreq();
    }

    public String getStandByFreqAsString() {
        return asString(nav.StandByFreqAsString());
    }

    public Byte getLocaliserNeedle() {
        return nav.LocaliserNeedle();
    }

    public Byte getGlideSlope() {
        return nav.GlideSlope();
    }

}
