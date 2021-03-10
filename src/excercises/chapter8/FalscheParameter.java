package excercises.chapter8;

public class FalscheParameter extends Throwable {
    public FalscheParameter(boolean ledersitz, AutoSitz.SeatColor farbe) {
        super("Die Parameterkombination Ledersitz und Farbe "+farbe+" ist ungültig!");
    }
}
