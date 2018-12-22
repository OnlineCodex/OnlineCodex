package oc.wh40k.units.ch;

import oc.*;
import oc.wh40k.units.PsychicPowers;

public class CHDaemonPrinceofNurglewithWings extends Eintrag {

    OptionsUpgradeGruppe waffe1;
    OptionsEinzelUpgrade waffe2;
    RuestkammerStarter psychicPowers;

    public CHDaemonPrinceofNurglewithWings() {

        name = "Daemon Prince of Nurgle with Wings";
        grundkosten = getPts("Daemon Prince of Nurgle with Wings");
        power = 10;

        ogE.addElement(new OptionsGruppeEintrag("Hellforged sword", getPts("Hellforged sword CSM")));
        ogE.addElement(new OptionsGruppeEintrag("Daemonic axe", getPts("Daemonic axe (CSM)")));
        ogE.addElement(new OptionsGruppeEintrag("Malefic talons", getPts("Malefic talons")));
        add(waffe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        waffe1.setSelected(0, true);

        seperator();

        add(waffe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Plague spewer", getPts("Plague spewer")));

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enableContagion();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();
        
        addWarlordTraits("", true);

        complete();

    }
}
