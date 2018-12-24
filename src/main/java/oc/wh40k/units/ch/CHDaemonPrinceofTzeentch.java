package oc.wh40k.units.ch;

import oc.*;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.CHANGE;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DARK_HERETICUS;

public class CHDaemonPrinceofTzeentch extends Eintrag {

    public CHDaemonPrinceofTzeentch() {
        name = "Daemon Prince of Tzeentch";
        grundkosten = getPts("Daemon Prince of Nurgle") + getPts("Malefic talons");
        power = 10;

        ogE.addElement(new OptionsGruppeEintrag("Hellforged sword", getPts("Hellforged sword CSM")));
        ogE.addElement(new OptionsGruppeEintrag("Daemonic axe", getPts("Daemonic axe")));
        ogE.addElement(new OptionsGruppeEintrag("Malefic talons", getPts("Malefic talons")));
        OptionsUpgradeGruppe waffe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1);
        waffe1.setSelected(0, true);
        add(waffe1);

        seperator();

        addPsychicPowers(2, DARK_HERETICUS, CHANGE);

        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}