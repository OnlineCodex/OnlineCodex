package oc.wh40k.units.im;

import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;

import oc.RuestkammerStarter;

import oc.wh40k.units.PsychicPowers;

public class IMAstropath extends Eintrag {
    OptionsUpgradeGruppe o1;
    RuestkammerStarter psychicPowers;

    public IMAstropath() {
        name = "Astropath";
        grundkosten = getPts("Astropath");
        power = 1;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Telepathica stave", getPts("Telepathica stave")));
        ogE.addElement(new OptionsGruppeEintrag("Laspistol", getPts("Laspistol")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enablePsykana();
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
        o1.alwaysSelected();
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }

}

