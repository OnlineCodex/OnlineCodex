//APO2

package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class APOHellhammer extends Eintrag {

        OptionsEinzelUpgrade o1;
        OptionsEinzelUpgrade o2;
        OptionsEinzelUpgrade o3;
        OptionsUpgradeGruppe o4;
        OptionsZaehlerGruppe o5;

	public APOHellhammer() {
		name = "Hellhammer";
		grundkosten = 540;

		add(ico = new oc.Picture("oc/wh40k/images/Hellhammer.gif"));
		


                add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzlicher Sturmbolter", 5));
		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzliches Maschinengewehr", 5));

                seperator();

		ogE.addElement(new OptionsGruppeEintrag("zwei Seitenkuppeln", 50));
		ogE.addElement(new OptionsGruppeEintrag("vier Seitenkuppeln", 100));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		seperator();

        ogE.addElement(new OptionsGruppeEintrag("LK + sync. schw. Bolter", "Laserkanone + synchronisierter schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("LK + sync. schw. Flamer", "Laserkanone + synchronisierter schwerer Flammenwerfer", 0));
		add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		complete();

	}

	public void refreshen() {
            o1.setAktiv(!o3.isSelected());
            o3.setAktiv(!o1.isSelected());

            o5.setAktiv(o4.isSelected("zwei Seitenkuppeln") || o4.isSelected("vier Seitenkuppeln"));
            o5.setMaxAnzahl(o4.isSelected("zwei Seitenkuppeln") ? 2 : 4);
            o5.setLegal(o5.getAnzahl() == o5.getMaxAnzahl());
	}
}