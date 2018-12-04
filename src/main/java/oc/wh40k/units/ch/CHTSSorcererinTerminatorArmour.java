package oc.wh40k.units.ch;

import oc.*;
import oc.wh40k.units.PsychicPowers;

public class CHTSSorcererinTerminatorArmour extends Eintrag {

    RuestkammerStarter waffen;
    OptionsUpgradeGruppe inferno, stave;
    RuestkammerStarter psychicPowers;

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

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableDarkHereticus();
        ((PsychicPowers) psychicPowers.getKammer()).enableChange();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
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
