package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class CHDaemonettes extends Eintrag {

    private final AnzahlPanel daemonettes;

    public CHDaemonettes() {
        name = "Daemonettes";
        grundkosten = 0;
        power = 5;

        add(daemonettes = new AnzahlPanel(ID, randAbstand, cnt, "Daemonettes", 10, 30, getPts("Daemonettes")));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument of Chaos", getPts("Instrument of Chaos")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Icon", getPts("Daemonic Icon")));

        seperator();

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new CHEmptykammer(), "Alluress");
        rkBoss.setGrundkosten(getPts("Alluress"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(false);
        add(rkBoss);

        complete();

    }

    @Override
    public void refreshen() {
        power = 5 +
                ((daemonettes.getModelle() == 20) ? 5 : 0) +
                ((daemonettes.getModelle() == 30) ? 10 : 0);

    }
}