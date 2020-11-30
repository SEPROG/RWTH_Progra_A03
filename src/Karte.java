public class Karte {

    private final Farbe FARBE;
    private final Wert WERT;

    private Karte(Farbe farbe, Wert wert) {
        this.FARBE = farbe;
        this.WERT = wert;
    }

    @Override
    public String toString() {
        return ( this.FARBE.toString() + this.WERT.toString() );
    }

    /** Gibt eine neue Karten Instanz zurueck.
     *
     * @param farbe, die Farbe der neuen Karte.
     * @param wert, der Wert der neuen Karte.
     * @return eine neue Instanz vom Typ Karte.
     */
    public static Karte neueKarte(Farbe farbe, Wert wert) {
        return new Karte(farbe, wert);
    }

    /** Gibt eine neue Karten Instanz zurueck. Die Paramater dürfern als valide Strings angegeben werden.
     *
     * @param farbe, die Farbe der neuen Karte. String Repräsentant des Enums Farbe.
     * @param wert, der Wert der neuen Karte. String Repräsentant des Enums Wert.
     * @return eine neue Instanz vom Typ Karte.
     */
    public static Karte neueKarte(String farbe, String wert) {
        return neueKarte(Farbe.valueOf(farbe), Wert.valueOf(wert));
    }
}
