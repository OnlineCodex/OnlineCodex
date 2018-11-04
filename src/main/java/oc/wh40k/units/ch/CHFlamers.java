package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class CHFlamers extends Eintrag {

    AnzahlPanel flamers;
    OptionsEinzelUpgrade pyro;
    RuestkammerStarter rkBoss;

    public CHFlamers() {

        name = "Flamers";
        grundkosten = 0;
        power = 5;

        add(flamers = new AnzahlPanel(ID, randAbstand, cnt, "Flamers", 3, 8, getPts("Flamers")));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "CHEmptykammer", "Pyrocaster");
        ((CHEmptykammer) rkBoss.getKammer()).type = "Pyrocaster";
        rkBoss.initKammer();
        rkBoss.setGrundkosten(getPts("Pyrocaster"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();

    }

    public void deleteYourself() {
    }


    @Override
    public void refreshen() {
        power = flamers.getModelle();

        power = 5 +
                ((flamers.getModelle() == 6) ? 4 : 0) +
                ((flamers.getModelle() == 9) ? 8 : 0);
    }
}
