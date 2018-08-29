//APO2

package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class APOBaneblade extends Eintrag {

        OptionsEinzelUpgrade o1;
        OptionsEinzelUpgrade o2;
        OptionsEinzelUpgrade o3;
        OptionsUpgradeGruppe o4;
        OptionsUpgradeGruppe o5;

	public APOBaneblade() {
		name = "Baneblade";
		grundkosten = 525;


		add(ico = new oc.Picture("oc/wh40k/images/Baneblade.gif"));
		
        add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzlicher Sturmbolter", 5));
		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzliches Maschinengewehr", 5));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("zwei Seitenkuppeln", 50));
		ogE.addElement(new OptionsGruppeEintrag("vier Seitenkuppeln", 100));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("[APO2] Kommissar","[APO2] Kommissariats-Besatzung", 45));
		ogE.addElement(new OptionsGruppeEintrag("[APO2] Befehlspanzer",200));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		complete();

	}

	public void refreshen() {
            o3.setAktiv(!o2.isSelected());
            o2.setAktiv(!o3.isSelected());
	}
}
