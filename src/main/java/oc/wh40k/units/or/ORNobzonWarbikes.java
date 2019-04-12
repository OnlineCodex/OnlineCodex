package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORNobzonWarbikes extends Eintrag {

	private final AnzahlPanel bosse;
	private final OptionsZaehlerGruppe bosseCC;
	private final OptionsZaehlerGruppe bosseCC2;

    public ORNobzonWarbikes() {
        category = 2;
        grundkosten = 0;

        bosse = new AnzahlPanel(ID, randAbstand, cnt, "Nobz", 3, 9, getPts("Nobz on Warbikes") + getPts("Stikkbombs"));
        add(bosse);

        add(ico = new oc.Picture("oc/wh40k/images/Bosse.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Choppa", getPts("Choppa")));
        ogE.addElement(new OptionsGruppeEintrag("Killsaw", getPts("Killsaw")));
        ogE.addElement(new OptionsGruppeEintrag("Power stabba", getPts("Power stabba")));
        ogE.addElement(new OptionsGruppeEintrag("Power klaw", getPts("Power klaw")));
        ogE.addElement(new OptionsGruppeEintrag("Big choppa", getPts("Big choppa")));
        ogE.addElement(new OptionsGruppeEintrag("Slugga", getPts("Slugga")));
        add(bosseCC = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        bosseCC.setAnzahl(0, bosse.getModelle());
        bosseCC.setAnzahl(5, bosse.getModelle());

        seperator(5);

        ogE.addElement(new OptionsGruppeEintrag("2 Killsaws", getPts("Two killsaws")));
        add(bosseCC2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));


        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
    	bosseCC.setMaxAnzahl(bosse.getModelle() * 2 - bosseCC2.getAnzahl() * 2);
        bosseCC2.setMaxAnzahl(bosse.getModelle()- bosseCC.getAnzahl() / 2 - bosseCC.getAnzahl() % 2);

        if (bosse.getModelle() > 6) {
            power = 19;
        } else if (bosse.getModelle() > 3) {
            power = 14;
        } else {
            power = 7;
        }

    }

}
