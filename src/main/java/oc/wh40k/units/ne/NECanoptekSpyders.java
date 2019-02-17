package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class NECanoptekSpyders extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1, o2, o3;

    public NECanoptekSpyders() {
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Canoptek Spyder", "Canoptek Spyders", 1, 3, getPts("Canoptek Spyders") + getPts("Automaton claws"));
        add(squad);

        seperator();


        ogE.addElement(new OptionsGruppeEintrag("Fabricator claw array", getPts("Fabricator claw array")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag("Gloom prism", getPts("Gloom prism")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag("2 Particle beamers", getPts("Particle beamer") * 2));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }

    @Override
    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle());
        o2.setMaxAnzahl(squad.getModelle());
        o3.setMaxAnzahl(squad.getModelle());

        power = 4 * squad.getModelle();
    }

}
