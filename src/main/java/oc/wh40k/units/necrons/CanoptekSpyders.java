package oc.wh40k.units.necrons;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.wh40k.units.AOPSlot.HeavySupport;
import oc.wh40k.units.Fly;
import oc.wh40k.units.UnitType.Monster;
import oc.wh40k.units.necrons.Necrons.Canoptek;

public class CanoptekSpyders extends Eintrag<Canoptek, HeavySupport, Monster> implements Fly {

    private final AnzahlPanel squad;
    private final OptionsZaehlerGruppe o1;
    private final OptionsZaehlerGruppe o2;
    private final OptionsZaehlerGruppe o3;

    public CanoptekSpyders() {
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
