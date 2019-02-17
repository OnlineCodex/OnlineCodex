package oc.wh40k.units.or;

import oc.*;

public class ORNobz extends Eintrag {

	private final AnzahlPanel bosse;
	private final OptionsZaehlerGruppe bosseCC;
	private final OptionsZaehlerGruppe bosseCC2;
	private final OptionsZaehlerGruppe bosseFK;
	private final OptionsEinzelZaehler munigrotz;
	private final OptionsEinzelZaehler cyborg;

    public ORNobz() {
        kategorie = 2;
        grundkosten = 0;

        bosse = new AnzahlPanel(ID, randAbstand, cnt, "Nobz", 5, 10, getPts("Nobz") + getPts("Stikkbombs"));
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
        
        seperator(5);

        ogE.addElement(new OptionsGruppeEintrag("Kombi-rokkit", "Kombi-weapon with rokkit-launcha", getPts("Kombi-weapon with rokkit-launcha")));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-skorcha", "Kombi-weapon with skorcha", getPts("Kombi-weapon with skorcha")));
        ogE.addElement(new OptionsGruppeEintrag("Shoota [Index]", getPts("Shoota")));
        ogE.addElement(new OptionsGruppeEintrag("Kustom shoota [Index]", getPts("Kustom shoota")));
        add(bosseFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator(5);

        add(munigrotz = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Ammo Runt", bosse.getModelle(), getPts("Ammo Runt")));

        seperator(5);

        add(cyborg = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Cybork body", bosse.getModelle() / 5, getPts("Cybork body")));

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        bosseCC.setMaxAnzahl(bosse.getModelle() * 2 - bosseCC2.getAnzahl() * 2 - bosseFK.getAnzahl());
        bosseCC2.setMaxAnzahl(bosse.getModelle()- (bosseCC.getAnzahl() + bosseFK.getAnzahl()) / 2 - (bosseCC.getAnzahl() + bosseFK.getAnzahl()) % 2);
        bosseFK.setMaxAnzahl(Math.min(bosse.getModelle() * 2 - bosseCC2.getAnzahl() * 2 - bosseCC.getAnzahl(), bosse.getModelle()));
        
        munigrotz.setMaxAnzahl(bosse.getModelle() / 5);

        cyborg.setMaxAnzahl(bosse.getModelle() / 5);

        if (bosse.getModelle() > 5) {
            power = 14;
        } else {
            power = 7;
        }
    }

}
