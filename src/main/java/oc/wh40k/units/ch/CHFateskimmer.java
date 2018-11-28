package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHFateskimmer extends Eintrag {

    OptionsEinzelUpgrade waffe1;
    OptionsEinzelUpgrade waffe2;
    RuestkammerStarter psychicPowers;

    public CHFateskimmer() {

        name = "Fateskimmer";
        grundkosten = getPts("Fateskimmer");
        power = 7;

        add(waffe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ritual dagger", getPts("Ritual dagger")));
        waffe1.setSelected(true);

        add(waffe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Staff of change", getPts("Staff of change")));

        seperator();

        add(waffe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chanting Horrors", getPts("Chanting Horrors")));

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableTzeentch();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        complete();

    }

    @Override
    public void refreshen() {
        if (!waffe1.isSelected()) waffe1.setSelected(true);
    }
}
