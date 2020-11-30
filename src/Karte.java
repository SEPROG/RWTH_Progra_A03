public class Karte {

    private Farbe farbe;
    private Wert wert;

    @Override
    public String toString() {
        return (farbe.toString() + wert.toString());
    }
}
