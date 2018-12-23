package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class CHBloodletters extends Eintrag {

    private final AnzahlPanel bloodletters;

    public CHBloodletters() {
        name = "Bloodletters";
        grundkosten = 0;
        power = 5;

        add(bloodletters = new AnzahlPanel(ID, randAbstand, cnt, "Bloodletters", 10, 30, getPts("Bloodletters")));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument of Chaos", getPts("Instrument of Chaos")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Icon", getPts("Daemonic Icon")));

        seperator();

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new CHEmptykammer(), "Bloodreaper");
        rkBoss.setGrundkosten(getPts("Bloodreaper"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(false);
        add(rkBoss);

        complete();

    }

    @Override
    public void refreshen() {
        power = 5 +
                ((bloodletters.getModelle() == 20) ? 5 : 0) +
                ((bloodletters.getModelle() == 30) ? 10 : 0);
    }
}
