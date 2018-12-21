package oc.wh40k.units.necrons;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.wh40k.units.AOPSlot.Fortification;
import oc.wh40k.units.Building;
import oc.wh40k.units.Source.ImperialArmourIndexXenos;
import oc.wh40k.units.UnitType.Vehicle;

public class TombCitadel extends Eintrag<Necrons, Fortification, Vehicle, ImperialArmourIndexXenos> implements Building {

    public TombCitadel() {
        name = "Tomb Citadel";
        grundkosten = getPts("TombCitadel");
        power = 40;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Tesla destructor", getPts("Tesla destructor")));
        ogE.addElement(new OptionsGruppeEintrag("Gauss exterminator", getPts("Gauss exterminator")));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        complete();
    }
}