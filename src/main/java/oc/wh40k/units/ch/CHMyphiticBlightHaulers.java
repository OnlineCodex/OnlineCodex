package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;

public class CHMyphiticBlightHaulers extends Eintrag {

	private final AnzahlPanel Nurglings;

    public CHMyphiticBlightHaulers() {

        name = "Myphitic Blight-haulers";
        grundkosten = 0;
        power = 2;

        final int pts = getPts("Myphitic Blight-haulers") + getPts("Bile spurt") + getPts("Missile launcher") + getPts("Multi-melta") + getPts("Gnashing maw");

        add(Nurglings = new AnzahlPanel(ID, randAbstand, cnt, "Myphitic Blight-haulers", 1, 3, pts));

        complete();

    }

    @Override
    public void refreshen() {
        power = Nurglings.getModelle() * 2;
    }
}
