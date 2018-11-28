package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class CHPlaguebearers extends Eintrag {

    AnzahlPanel plaguebearers;
    RuestkammerStarter rkBoss;

    public CHPlaguebearers() {

        name = "Plaguebearers";
        grundkosten = 0;
        power = 5;

        add(plaguebearers = new AnzahlPanel(ID, randAbstand, cnt, "Plaguebearers", 10, 30, getPts("Plaguebearers")));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument of Chaos", getPts("Instrument of Chaos")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Icon", getPts("Daemonic Icon")));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, CHEmptykammer.class, "Plagueridden");
        ((CHEmptykammer) rkBoss.getKammer()).type = "Plagueridden";
        rkBoss.initKammer();
        rkBoss.setGrundkosten(getPts("Plagueridden"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();

    }

    public void deleteYourself() {
    }


    @Override
    public void refreshen() {

        power = 5 +
                ((plaguebearers.getModelle() == 20) ? 5 : 0) +
                ((plaguebearers.getModelle() == 30) ? 10 : 0);
    }
}
