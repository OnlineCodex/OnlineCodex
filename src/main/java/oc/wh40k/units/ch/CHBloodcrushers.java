package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class CHBloodcrushers extends Eintrag {

    AnzahlPanel bloodcrushers;
    RuestkammerStarter rkBoss;

    public CHBloodcrushers() {

        name = "Bloodcrushers";
        grundkosten = 0;
        power = 5;

        add(bloodcrushers = new AnzahlPanel(ID, randAbstand, cnt, "Bloodcrushers", 3, 12, getPts("Bloodcrushers")));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument of Chaos", getPts("Instrument of Chaos")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Icon", getPts("Daemonic Icon")));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, CHEmptykammer.class, "Bloodhunter");
        ((CHEmptykammer) rkBoss.getKammer()).type = "Bloodhunter";
        rkBoss.initKammer();
        rkBoss.setGrundkosten(getPts("Bloodhunter"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();

    }

    @Override
    public void refreshen() {
        power = 8 +
                ((bloodcrushers.getModelle() > 3) ? 7 : 0) +
                ((bloodcrushers.getModelle() > 6) ? 7 : 0) +
                ((bloodcrushers.getModelle() > 9) ? 7 : 0);
    }
}
