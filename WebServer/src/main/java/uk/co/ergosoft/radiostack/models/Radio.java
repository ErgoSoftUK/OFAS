package uk.co.ergosoft.radiostack.models;

public class Radio {
    private String skin;
    private Com_1 com1 = new Com_1();
    private Com_2 com2 = new Com_2();
    private Nav_1 nav1 = new Nav_1();
    private Nav_2 nav2 = new Nav_2();
    private Adf adf = new Adf();

    public Com_1 getCom1() {
        return com1;
    }

    public Radio setCom1(Com_1 com1) {
        this.com1 = com1;
        return this;
    }

    public Com_2 getCom2() {
        return com2;
    }

    public Radio setCom2(Com_2 com2) {
        this.com2 = com2;
        return this;
    }

    public Nav_1 getNav1() {
        return nav1;
    }

    public Radio setNav1(Nav_1 nav1) {
        this.nav1 = nav1;
        return this;
    }

    public Nav_2 getNav2() {
        return nav2;
    }

    public Radio setNav2(Nav_2 nav2) {
        this.nav2 = nav2;
        return this;
    }

    public Adf getAdf() {
        return adf;
    }

    public Radio setAdf(Adf adf) {
        this.adf = adf;
        return this;
    }

    public String getSkin() {
        return skin;
    }

    public Radio setSkin(String skin) {
        this.skin = skin;
        return this;
    }
}
