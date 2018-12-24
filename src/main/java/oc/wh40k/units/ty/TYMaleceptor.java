package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.HIVE_MIND;

public class TYMaleceptor extends Eintrag {

    public TYMaleceptor() {
        name = "Maleceptor";
        grundkosten = getPts("Maleceptor") + getPts("Massive Scything Talons (Maleceptor)");
        power = 9;

        add(ico = new oc.Picture("oc/wh40k/images/TYMorgon.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (Monsters)")));

        seperator();

        addPsychicPowers(1, HIVE_MIND);

        complete();
    }
}