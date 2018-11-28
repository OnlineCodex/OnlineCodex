package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHMalignantPlaguecaster extends Eintrag {

    OptionsUpgradeGruppe pistol, staff;
    RuestkammerStarter psychicPowers;

    public CHMalignantPlaguecaster() {

        name = "Malignant Plaguecaster";
        grundkosten = getPts("Malignant Plaguecaster");

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
        add(pistol = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        ogE.addElement(new OptionsGruppeEintrag("Corrupted staff", getPts("Corrupted staff")));
        add(staff = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableContagion();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        complete();

    }

    @Override
    public void refreshen() {
        pistol.setSelected(0, true);
        staff.setSelected(0, true);

        power = 6;
    }
}
