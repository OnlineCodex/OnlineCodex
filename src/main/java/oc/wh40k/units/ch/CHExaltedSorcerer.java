package oc.wh40k.units.ch;

import oc.*;
import oc.wh40k.units.PsychicPowers;

public class CHExaltedSorcerer extends Eintrag {

    RuestkammerStarter waffen;
    OptionsUpgradeGruppe stave;
    OptionsUpgradeGruppe inferno;
    RuestkammerStarter psychicPowers;

    public CHExaltedSorcerer() {

        name = "Exalted Sorcerer";
        grundkosten = getPts("Exalted Sorcerer");
        power = 7;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
        ogE.addElement(new OptionsGruppeEintrag("2 Power swords", getPts("Power sword") * 2));
        add(stave = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Inferno bolt pistol", getPts("Inferno bolt pistol")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
        ogE.addElement(new OptionsGruppeEintrag("Warpflame pistol", getPts("Warpflame pistol")));
        add(inferno = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power sword", getPts("Power sword")));

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableDarkHereticus();
        ((PsychicPowers) psychicPowers.getKammer()).enableChange();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        complete();
    }

    @Override
    public void refreshen() {
        inferno.alwaysSelected();
        stave.alwaysSelected();
    }
}
