package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class CHDaemonettes extends Eintrag {

	private final AnzahlPanel daemonettes;
	private final RuestkammerStarter rkBoss;

    public CHDaemonettes() {

        name = "Daemonettes";
        grundkosten = 0;
        power = 5;

        add(daemonettes = new AnzahlPanel(ID, randAbstand, cnt, "Daemonettes", 10, 30, getPts("Daemonettes")));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument of Chaos", getPts("Instrument of Chaos")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Icon", getPts("Daemonic Icon")));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, CHEmptykammer.class, "Alluress");
        ((CHEmptykammer) rkBoss.getKammer()).type = "Alluress";
        rkBoss.initKammer();
        rkBoss.setGrundkosten(getPts("Alluress"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();

    }

    public void deleteYourself() {
    }


    @Override
    public void refreshen() {
        power = 4 +
                ((daemonettes.getModelle() > 10) ? 4 : 0) +
                ((daemonettes.getModelle() > 20) ? 4 : 0);

    }
}
