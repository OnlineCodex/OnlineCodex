package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class CHBloodletters extends Eintrag {

	private final AnzahlPanel bloodletters;
	private final RuestkammerStarter rkBoss;

    public CHBloodletters() {

        name = "Bloodletters";
        grundkosten = 0;
        power = 5;

        add(bloodletters = new AnzahlPanel(ID, randAbstand, cnt, "Bloodletters", 10, 30, getPts("Bloodletters")));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument of Chaos", getPts("Instrument of Chaos")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Icon", getPts("Daemonic Icon")));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, CHEmptykammer.class, "Bloodreaper");
        ((CHEmptykammer) rkBoss.getKammer()).type = "Bloodreaper";
        rkBoss.initKammer();
        rkBoss.setGrundkosten(getPts("Bloodreaper"));
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
                ((bloodletters.getModelle() > 10) ? 4 : 0) +
                ((bloodletters.getModelle() > 20) ? 4 : 0);
    }
}
