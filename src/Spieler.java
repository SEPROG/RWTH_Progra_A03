public class Spieler {

    private Karte[] kartenhand;
    private String name;
    private double siegesquote;

    public Spieler(String name) {
        this.name = name;
    }

    public Spieler(String name, double siegesquote) {
        this(name);
        this.siegesquote = siegesquote;
    }

    public Spieler(String name, double siegesquote, Karte[] kartenhand) {
        this(name, siegesquote);
        this.kartenhand = kartenhand;
    }

    /** Gibt in stdout aus ob dieser Spieler eine bestimmte Karte bedienen kann oder nicht.
     *
     * @param k, die karte die bedient werden soll.
     */
    public void kannBedienen(Karte k) {
        System.out.println(this.name + (k.bedienbar(this.kartenhand) ? "kann bedienen!" : "kann nicht bedienen!"));
    }

    @Override
    public String toString() {
        return this.name;
    }

    /** Gibt den besten Spieler für einen gegebenen Club (Spieler-Array) zurück. Vergleich anhand von siegesquote.
     *
     * @param club, das Spieler-Array in dem der beste Spieler festgestellt werden soll.
     * @return den besten Spieler in club.
     */
    public static Spieler besterSpieler(Spieler... club) {
        Spieler besterSpieler = club[0];

        for (Spieler s : club) {
            besterSpieler = s.siegesquote > besterSpieler.siegesquote ? s : besterSpieler;
        }

        return besterSpieler;
    }

    /** Startet das Prgramm. Führt einige Testfunktionen aus.
     *
     * @param args, werden nicht beachtet.
     */
    public static void main(String[] args) {
        // Initialize example players
        Spieler s0 = new Spieler("Elisabeth", 0.375);
        Spieler s1 = new Spieler("Klaus", 0.125);
        Spieler s2 = new Spieler("Helmut", 0.3875);
        Spieler s3 = new Spieler("Erwin", 0.1125);
        // Set best player
        Spieler bs = Spieler.besterSpieler(s0, s1, s2, s3);

        // Initialize sample cards
        Karte[] karten = {Karte.neueKarte(Farbe.HERZ, Wert.SIEBEN), Karte.neueKarte(Farbe.HERZ, Wert.NEUN), Karte.neueKarte(Farbe.KARO, Wert.KOENIG)};

        // Give sample cards to best player
        bs.kartenhand = karten;

        // Check whether the best player can serve the jack of diamonds
        bs.kannBedienen(Karte.neueKarte(Farbe.KARO, Wert.BUBE));
    }
}
