public class Spieler {

    private Karte[] kartenhand;
    private String name;
    private double siegesquote;

    /** Gibt in stdout aus ob dieser Spieler eine bestimmte Karte bedienen kann oder nicht.
     *
     * @param k, die karte die bedient werden soll.
     */
    public void kannBedienen(Karte k) {
        System.out.println(name + (k.bedienbar(kartenhand) ? "kann bedienen!" : "kann nicht bedienen!"));
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
}
