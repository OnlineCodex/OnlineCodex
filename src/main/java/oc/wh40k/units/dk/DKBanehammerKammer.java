package oc.wh40k.units.dk;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DKBanehammerKammer extends RuestkammerVater {

        OptionsEinzelUpgrade o1;
        OptionsEinzelUpgrade o3;
        OptionsUpgradeGruppe o4;
        OptionsZaehlerGruppe o5;

	public DKBanehammerKammer() {}
	
	public void initButtons(boolean... defaults) {
		name = "Banehammer";
		grundkosten = 450;


		add(ico = new oc.Picture("oc/wh40k/images/Banehammer.gif"));
		


        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzliches Maschinengewehr", 10));
        add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzlicher Sturmbolter", 10));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("zwei Seitenkuppeln", 0));
		ogE.addElement(new OptionsGruppeEintrag("vier Seitenkuppeln", 100));
		ogE.addElement(new OptionsGruppeEintrag("zusätzliche Panzerplatten", 0));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("schwerer Bolter", "Laserkanone + schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("schwerer Flamer", "Laserkanone + schwerer Flammenwerfer", 0));
		add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		sizeSetzen();

	}

	public void refreshen() {
            if (!o4.isSelected()) o4.setSelected(0,true);
            o1.setAktiv(!o3.isSelected());
            o3.setAktiv(!o1.isSelected());

            o5.setAktiv(o4.isSelected("zwei Seitenkuppeln") || o4.isSelected("vier Seitenkuppeln"));
            o5.setMaxAnzahl(o4.isSelected("zwei Seitenkuppeln") ? 2 : 4);
            o5.setLegal(o5.getAnzahl() == o5.getMaxAnzahl());
	}
}
