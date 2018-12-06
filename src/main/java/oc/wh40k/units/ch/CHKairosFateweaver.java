package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHKairosFateweaver extends Eintrag {

    OptionsUpgradeGruppe waffe1;
    OptionsEinzelUpgrade waffe2;
    RuestkammerStarter psychicPowers;

    public CHKairosFateweaver() {

        name = "Kairos Fateweaver";
        grundkosten = getPts("Kairos Fateweaver");
        power = 20;

        add(waffe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Staff of Tomorrow", getPts("Staff of Tomorrow")));
        waffe2.setSelected(true);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(6);
        ((PsychicPowers) psychicPowers.getKammer()).enableTzeentch();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();
        
        addWarlordTraits("Tzeentch: Tyrant of the Warp", true);

        complete();

    }

    @Override
    public void refreshen() {
        if (!waffe2.isSelected()) waffe2.setSelected(true);
        
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
