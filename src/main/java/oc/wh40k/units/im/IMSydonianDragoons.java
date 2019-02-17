package oc.wh40k.units.im;

import oc.*;

public class IMSydonianDragoons extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1;
	private final OptionsZaehlerGruppe o1x;
	private final OptionsEinzelZaehler oe1;

    public IMSydonianDragoons() {
        name = "Sydonian Dragoons";
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Sydonian Dragoons", 1, 6, getPts("Sydonian Dragoons")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Taser lance", getPts("Taser lance")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag("Radium jezzail", getPts("Radium jezzail")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Phosphor serpenta", 1, getPts("Phosphor serpenta")));

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());
        o1x.setMaxAnzahl(squad.getModelle());
        oe1.setMaxAnzahl(squad.getModelle());
        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());

        power = squad.getModelle() * 3;
    }
}
