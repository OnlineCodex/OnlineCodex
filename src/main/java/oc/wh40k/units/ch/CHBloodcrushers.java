package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class CHBloodcrushers extends Eintrag {

    private final AnzahlPanel bloodcrushers;

    public CHBloodcrushers() {
        name = "Bloodcrushers";
        grundkosten = 0;
        power = 5;

        add(bloodcrushers = new AnzahlPanel(ID, randAbstand, cnt, "Bloodcrushers", 3, 12, getPts("Bloodcrushers")));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument of Chaos", getPts("Instrument of Chaos")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Icon", getPts("Daemonic Icon")));

        seperator();

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new CHEmptykammer(), "Bloodhunter");
        rkBoss.setGrundkosten(getPts("Bloodhunter"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(false);
        add(rkBoss);

        complete();

    }

    @Override
    public void refreshen() {
        power = 8 +
                ((bloodcrushers.getModelle() == 6) ? 7 : 0) +
                ((bloodcrushers.getModelle() == 9) ? 14 : 0) +
                ((bloodcrushers.getModelle() == 12) ? 21 : 0);
    }
}
