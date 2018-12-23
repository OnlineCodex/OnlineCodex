package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class CHFlamers extends Eintrag {

    private final AnzahlPanel flamers;

    public CHFlamers() {

        name = "Flamers";
        grundkosten = 0;
        power = 5;

        add(flamers = new AnzahlPanel(ID, randAbstand, cnt, "Flamers", 3, 8, getPts("Flamers")));

        seperator();

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new CHEmptykammer(), "Pyrocaster");
        rkBoss.setGrundkosten(getPts("Pyrocaster"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(false);
        add(rkBoss);

        complete();
    }

    @Override
    public void refreshen() {
        power = 5 +
                ((flamers.getModelle() == 6) ? 4 : 0) +
                ((flamers.getModelle() == 9) ? 8 : 0);
    }
}
