package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.CONTAGION;

public class CHMalignantPlaguecaster extends Eintrag {

    OptionsUpgradeGruppe pistol, staff;
    RuestkammerStarter psychicPowers;

    public CHMalignantPlaguecaster() {
        name = "Malignant Plaguecaster";
        grundkosten = getPts("Malignant Plaguecaster");
        power = 6;

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
        add(pistol = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        ogE.addElement(new OptionsGruppeEintrag("Corrupted staff", getPts("Corrupted staff")));
        add(staff = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        addPsychicPowers(2, CONTAGION);

        seperator();
        
        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        pistol.setSelected(0, true);
        staff.setSelected(0, true);
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
