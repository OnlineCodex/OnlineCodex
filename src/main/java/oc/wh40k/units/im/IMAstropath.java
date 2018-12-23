package oc.wh40k.units.im;

import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;

import oc.RuestkammerStarter;

import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.PSYKANA;

public class IMAstropath extends Eintrag {

    private final OptionsUpgradeGruppe o1;
    private final RuestkammerStarter psychicPowers;

    public IMAstropath() {
        name = "Astropath";
        grundkosten = getPts("Astropath");
        power = 1;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Telepathica stave", getPts("Telepathica stave")));
        ogE.addElement(new OptionsGruppeEintrag("Laspistol", getPts("Laspistol")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(1, PSYKANA), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

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