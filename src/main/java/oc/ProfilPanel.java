package oc;

public class ProfilPanel /*extends OptionsVater*/{
    private final String[] NAMEN_LANG = {
        "[B] Bewegung", "[KG] Kampfgeschick", "[BF] Ballistische Fähigkeit", "[S] Stärke", "[W] Widerstand", "[LP] Lebenspunkte", "[I] Initiative", "[A] Attacken", "[MW] Moralwert"
    };
    private final String[] NAMEN = {
        "Bewegung", "Kampfgeschick", "Ballistische Fähigkeit", "Stärke", "Widerstand", "Lebenspunkte", "Initiative", "Attacken", "Moralwert"
    };
    private final String[] NAMEN_KURZ = {
        "B", "KG", "BF", "S", "W", "LP", "I", "A", "MW"
    };

    private final int[][] START = {
        {4, 4, 4, 3, 3, 1, 4, 1, 8}, {4, 3, 3, 3, 3, 1, 3, 1, 7}, {4, 3, 3, 3, 3, 1, 3, 1, 7}, {4, 2, 2, 3, 3, 1, 3, 1, 6}, {4, 4, 4, 3, 3, 1, 3, 1, 7},
    };
    private final int[] MAX = {
        4, 6, 6, 4, 4, 3, 6, 3, 9
    };

    private final int[] xpStart = {
        60, 60, 20, 0, 0
    };

    AnzahlPanel[] ap = new AnzahlPanel[NAMEN.length];

    public ProfilPanel(Eintrag eintrag, int kat) {
        eintrag.add(new NamePanel(eintrag.ID, Eintrag.randAbstand, eintrag.cnt, ""));
        eintrag.seperator();
        eintrag.add(new NamePanel(eintrag.ID, Eintrag.randAbstand, eintrag.cnt, xpStart[kat] + "", "Erfahrung"));
        eintrag.seperator(15);
        for(int i=0;i<NAMEN.length;i++) {
            eintrag.add(ap[i] = new AnzahlPanel(eintrag.ID, Eintrag.randAbstand, eintrag.cnt, NAMEN_LANG[i], 0, MAX[i], NAMEN_KURZ[i], NAMEN[i], START[kat][i]));
            ap[i].setNichtDieErsteOption(true);

        }
        eintrag.seperator();
        eintrag.seperator();


    }
}