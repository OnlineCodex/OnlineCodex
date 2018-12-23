package oc.wh40k.units.ch;

import oc.*;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.CONTAGION;

public class CHDaemonPrinceofNurglewithWings extends Eintrag {

    public CHDaemonPrinceofNurglewithWings() {
        name = "Daemon Prince of Nurgle with Wings";
        grundkosten = getPts("Daemon Prince of Nurgle with Wings");
        power = 10;

        ogE.addElement(new OptionsGruppeEintrag("Hellforged sword", getPts("Hellforged sword CSM")));
        ogE.addElement(new OptionsGruppeEintrag("Daemonic axe", getPts("Daemonic axe (CSM)")));
        ogE.addElement(new OptionsGruppeEintrag("Malefic talons", getPts("Malefic talons")));
        OptionsUpgradeGruppe waffe1;
        add(waffe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        waffe1.setSelected(0, true);

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Plague spewer", getPts("Plague spewer")));

        seperator();

        RuestkammerStarter psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(1, CONTAGION), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();
        
        addWarlordTraits("", true);

        complete();
    }
}
