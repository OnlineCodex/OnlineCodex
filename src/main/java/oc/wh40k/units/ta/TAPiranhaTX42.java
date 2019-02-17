package oc.wh40k.units.ta;

import oc.*;

//[IA3 2nd Ed]

public class TAPiranhaTX42 extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1;
	private final OptionsZaehlerGruppe o1x;
	private final OptionsEinzelZaehler oez1;
	private final OptionsEinzelZaehler oez2;
	private final OptionsEinzelZaehler oez3;
	private final OptionsEinzelZaehler oez4;
    private final OptionsEinzelZaehler oez5;
    private final OptionsEinzelZaehler oez6;
    private final OptionsEinzelZaehler oez7;
    private final OptionsEinzelZaehler oez8;
    private final OptionsEinzelZaehler oez9;

    public TAPiranhaTX42() {
        name = "Piranha TX-42 Team";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Piranha TX-42", 1, 5, 70);
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/TAPiranhaTX42.jpg"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sync. FuBla", "Synchronisierter Fusionsblaster", 0));
        o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0);
        add(o1x);

        ogE.addElement(new OptionsGruppeEintrag("Sync. RakMag", "Synchronisiertes Raketenmagazin", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Plasma", "Synchronisierter Plasmabeschleuniger", 10));
        ogE.addElement(new OptionsGruppeEintrag("Sync. MB-Gewehr", "Synchronisiertes Massebeschleuniger-Gewehr", 20));
        o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0);
        add(o1);

        seperator();

        add(oez1 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Reparatursystem", "Automatisches Reparatursystem", 1, 5));
        add(oez2 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Fahrzeugsensorik", 1, 5));
        add(oez3 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Filteroptik", 1, 1));
        add(oez4 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Flechettewerfer", 1, 10));
        add(oez5 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Zielsystem", "Hochentwickeltes Zielsystem", 1, 10));
        add(oez6 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Ködersystem", 1, 3));
        add(oez7 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Punktverteidigung", "Punktverteidigungs-Zielrelais", 1, 10));
        add(oez8 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Störsystem", 1, 15));
        add(oez9 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Lenkraketen", 2, 10));

        complete();
    }

    @Override
    public void refreshen() {
        int count = squad.getModelle();
        o1.setMaxAnzahl(count);
        o1x.setMaxAnzahl(count);
        o1x.setAnzahl(0, count - o1.getAnzahl());

        oez1.setMaxAnzahl(count);
        oez2.setMaxAnzahl(count);
        oez3.setMaxAnzahl(count);
        oez4.setMaxAnzahl(count);
        oez5.setMaxAnzahl(count);
        oez6.setMaxAnzahl(count);
        oez7.setMaxAnzahl(count);
        oez8.setMaxAnzahl(count);
        oez9.setMaxAnzahl(count * 2);
    }

}
