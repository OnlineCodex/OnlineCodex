package oc.wh40k.units.ae;

import oc.*;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.RUNES_OF_BATTLE;

public class AEWarlockConclave extends Eintrag {

    private final AnzahlPanel squad;
    private final OptionsZaehlerGruppe o1;

    public AEWarlockConclave() {
        name = "Warlock Conclave";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Warlock Conclave", 2, 10, getPts("Warlock Conclave") + getPts("Shuriken pistol"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Witchblade", getPts("Witchblade")));
        ogE.addElement(new OptionsGruppeEintrag("Singing spear", getPts("Singing spear")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        o1.setAktiv(0, true);

        seperator();

        addPsychicPowers(2, RUNES_OF_BATTLE);

        complete();
    }

    @Override
    public void refreshen() {
        power = squad.getModelle() * 3;
        o1.setMaxAnzahl(squad.getModelle());
    }
}