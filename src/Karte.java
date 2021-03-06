public class Karte {

    private final Farbe FARBE;
    private final Wert WERT;

    private Karte(Farbe farbe, Wert wert) {
        this.FARBE = farbe;
        this.WERT = wert;
    }

    /** Überprüft ob diese Karte eine andere bedient.
     *
     * @param other, die Karte bei der überprüft werden soll.
     * @return True, wenn diese Karte die andere Karte bedient. False wenn nicht.
     */
    public boolean bedient(Karte other) {
        return (this.FARBE == other.FARBE || this.WERT == other.WERT || this.WERT == Wert.BUBE);
    }

    /** Überprüft ob mindestens eine der übergebenen Karte diese Karte bedient.
     *
     * @param karten, zu überpüfende Karten.
     * @return True, wenn eine der Karten diese Karte bedient.
     */
    public boolean bedienbar(Karte... karten) {
        for (Karte karte : karten) {
            if(karte.bedient(this)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return (this.FARBE.toString() + this.WERT.toString());
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

    /** Gibt die Anzahl möglicher einzigartiger Farb-Wert Kombinationen zurück.
     *
     * @return Anzahl einzigartiger Farb-Wert Kombinationen.
     */
    public static int kombinationen() {
        return (Farbe.values().length * Wert.values().length);
    }

    /** Generiert ein Skatblatt als Karten-Array durch Iteration über Farbe und Wert und gibt dieses zurück.
     *
     * @return Skatblatt als Karten-Array
     */
    public static Karte[] skatblatt() {
        Karte[] skatblatt = new Karte[Karte.kombinationen()];

        int i = 0;
        for (Farbe f : Farbe.values()) {
            for (Wert w : Wert.values()) {
                skatblatt[i] = Karte.neueKarte(f, w);
                i++;
            }
        }

        return skatblatt;
    }
}
