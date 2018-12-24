package oc.wh40k.units.ch;

import oc.*;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.CHANGE;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DARK_HERETICUS;

public class CHTSSorcererinTerminatorArmour extends Eintrag {

    private final OptionsUpgradeGruppe inferno;
    private final OptionsUpgradeGruppe stave;

    public CHTSSorcererinTerminatorArmour() {

        name = "Sorcerer in Terminator Armour";
        grundkosten = getPts("Sorcerer in Terminator Armour");
        power = 8;

        ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
        add(stave = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Inferno combi-bolter", getPts("Inferno combi-bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
        add(inferno = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Familiar", getPts("Familiar")));

        seperator();

        addPsychicPowers(2, DARK_HERETICUS, CHANGE);

        seperator();

        addWarlordTraits("", true);

        complete();

    }

    @Override
    public void refreshen() {
        inferno.alwaysSelected();
        stave.alwaysSelected();
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
