package com.example.sprawdzian;

public class Przepisy {
    public String nazwaPrzepisu;
    public String skladniki;
    public boolean CzyGotowac;
    public int liczbaOsob;

    public Przepisy(String nazwaPrzepisu, String skladniki, boolean czyGotowac, int liczbaOsob) {
        this.nazwaPrzepisu = nazwaPrzepisu;
        this.skladniki = skladniki;
        CzyGotowac = czyGotowac;
        this.liczbaOsob = liczbaOsob;
    }

    @Override
    public String toString() {
        return "{" +
                "" + nazwaPrzepisu +
                ", " + skladniki +
                ", " + CzyGotowac +
                ", " + liczbaOsob +
                '}';
    }
//    @Override
//    public String toString() {
//        return "Przepisy{" +
//                "nazwaPrzepisu='" + nazwaPrzepisu + '\'' +
//                ", skladniki='" + skladniki + '\'' +
//                ", CzyGotowac=" + CzyGotowac +
//                ", liczbaOsob=" + liczbaOsob +
//                '}';
//    }
}
