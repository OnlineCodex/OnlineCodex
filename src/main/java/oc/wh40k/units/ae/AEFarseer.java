package oc.wh40k.units.ae;

import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;

import oc.RuestkammerStarter;

import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.RUNES_OF_FATE;

public class AEFarseer extends Eintrag {
    OptionsZaehlerGruppe o1;
    RuestkammerStarter psychicPowers;

    public AEFarseer() {
        name = "Farseer";
        grundkosten = getPts("Farseer") + getPts("Shuriken pistol");
        power = 6;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Witchblade", getPts("Witchblade")));
        ogE.addElement(new OptionsGruppeEintrag("Singing spear", getPts("Singing spear")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        o1.setAktiv(0, true);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(2, RUNES_OF_FATE), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

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

