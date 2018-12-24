package oc.wh40k.units.ae;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.RUNES_OF_BATTLE;

public class AEWarlockSkyrunner extends Eintrag {

    private final OptionsZaehlerGruppe o1;

    public AEWarlockSkyrunner() {
        name = "Warlock Skyrunner";
        grundkosten = getPts("Warlock Skyrunner") + getPts("Shuriken pistol") + getPts("Twin shuriken catapult");

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Witchblade", getPts("Witchblade")));
        ogE.addElement(new OptionsGruppeEintrag("Singing spear", getPts("Singing spear")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        o1.setAktiv(0, true);

        seperator();

        addPsychicPowers(1, RUNES_OF_BATTLE);

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

