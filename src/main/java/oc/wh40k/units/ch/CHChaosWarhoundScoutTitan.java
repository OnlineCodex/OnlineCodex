package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class CHChaosWarhoundScoutTitan extends Eintrag {

	private final OptionsZaehlerGruppe o4;

    public CHChaosWarhoundScoutTitan() {
        name = "Chaos Warhound Scout Titan";
        grundkosten = getPts("Chaos Warhound Scout Titan");

        add(ico = new oc.Picture("oc/wh40k/images/ChaosPredator.gif"));

        ogE.addElement(new OptionsGruppeEintrag("Dual turbo-laser destructor", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Titan plasma blastgun", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Titan inferno gun", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Titan vulcan mega-bolter", getPts("")));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        complete();
    }

    @Override
    public void refreshen() {
        o4.setLegal(o4.getAnzahl() == 2);

        power = 75;
    }

}
