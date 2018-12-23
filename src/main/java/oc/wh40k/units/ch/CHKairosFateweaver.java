package oc.wh40k.units.ch;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DISCIPLINE_OF_TZEENTCH;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHKairosFateweaver extends Eintrag {

    private final OptionsEinzelUpgrade waffe2;

    public CHKairosFateweaver() {
        super(CHAOS, TZEENTCH, DAEMON, CHARACTER, MONSTER, FLY, PSYKER, LORD_OF_CHANGE, KAIROS_FATEWEAVER);

        name = "Kairos Fateweaver";
        grundkosten = getPts("Kairos Fateweaver");
        power = 20;

        add(waffe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Staff of Tomorrow", getPts("Staff of Tomorrow")));
        waffe2.setSelected(true);

        seperator();

        RuestkammerStarter psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(6, DISCIPLINE_OF_TZEENTCH), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();
        
        addWarlordTraits("Tzeentch: Tyrant of the Warp", TZEENTCH);

        complete();

    }

    @Override
    public void refreshen() {
        if (!waffe2.isSelected()) waffe2.setSelected(true);
    }
}
