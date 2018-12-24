package oc.wh40k.units.ae;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.RUNES_OF_FATE;


public class AEFarseerSkyrunner extends Eintrag {

    public AEFarseerSkyrunner() {
        name = "Farseer Skyrunner";
        grundkosten = getPts("Farseer Skyrunner") + getPts("Shuriken pistol") + getPts("Twin shuriken catapult");
        power = 9;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Witchblade", getPts("Witchblade")));
        ogE.addElement(new OptionsGruppeEintrag("Singing spear", getPts("Singing spear")));
        OptionsZaehlerGruppe o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);
        o1.setAktiv(0, true);
        add(o1);

        seperator();

        addPsychicPowers(2, RUNES_OF_FATE);

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

