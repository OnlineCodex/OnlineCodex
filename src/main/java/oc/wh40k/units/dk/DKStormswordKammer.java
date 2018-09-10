package oc.wh40k.units.dk;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DKStormswordKammer extends RuestkammerVater {

        OptionsEinzelUpgrade o1;
        OptionsEinzelUpgrade o2;
        OptionsEinzelUpgrade o3;
        OptionsUpgradeGruppe o4;
        OptionsZaehlerGruppe o5;
        OptionsZaehlerGruppe o6;

	public DKStormswordKammer() {}
	
	public void initButtons(boolean... defaults) {
		name = "Stormsword";
		grundkosten = 450;

		add(ico = new oc.Picture("oc/wh40k/images/Stormsword.gif"));
		

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Befehlspanzer", 25));

        seperator(5);

        add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzlicher Sturmbolter", 10));
		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzliches Maschinengewehr", 10));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("zwei Seitenkuppeln", 0));
		ogE.addElement(new OptionsGruppeEintrag("vier Seitenkuppeln", 100));
		ogE.addElement(new OptionsGruppeEintrag("zusätzliche Panzerplatten", 0));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flamer + Bolter", "schwerer Flammenwerfer + schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Flamer + Flamer", "zwei schwere Flammenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("LK + schwerer Bolter", "Laserkanone + schwerer Bolter", 20));
		ogE.addElement(new OptionsGruppeEintrag("LK + schwerer Flamer", "Laserkanone + schwerer Flammenwerfer", 20));
		add(o6 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("schwerer Bolter", "Laserkanone + schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("schwerer Flamer", "Laserkanone + schwerer Flammenwerfer", 0));
		add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		sizeSetzen();

	}

	public void refreshen() {
            o3.setAktiv(!o2.isSelected());
            o2.setAktiv(!o3.isSelected());
            if (!o4.isSelected()) o4.setSelected(0,true);
            o5.setAktiv(o4.isSelected("vier Seitenkuppeln"));
            o5.setLegal(o5.getAnzahl() == o5.getMaxAnzahl());
            o6.setLegal(o6.getAnzahl() == o6.getMaxAnzahl());
	}
}
