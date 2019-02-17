package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class NECanoptekWraiths extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1;

    public NECanoptekWraiths() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Canoptek Wraith", "Canoptek Wraiths", 3, 6, getPts("Canoptek Wraiths") + getPts("Vicious claws"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/NEKanoptechPhantome.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Particle caster", getPts("Particle caster")));
        ogE.addElement(new OptionsGruppeEintrag("Transdimensional beamer", getPts("Transdimensional beamer")));
        ogE.addElement(new OptionsGruppeEintrag("Whip coils", getPts("Whip coils")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());

        power = 9 + ((squad.getModelle() > 3) ? 9 : 0);
    }

}
