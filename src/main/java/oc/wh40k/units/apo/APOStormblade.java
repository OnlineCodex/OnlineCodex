//IA1 2nd Ed
package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class APOStormblade extends Eintrag {

        OptionsEinzelUpgrade o1;
        OptionsEinzelUpgrade o2;
        OptionsEinzelUpgrade o3;
        OptionsUpgradeGruppe o4;

	public APOStormblade() {
		name = "Stormblade";
		grundkosten = 450;


		add(ico = new oc.Picture("oc/wh40k/images/Stormblade.gif"));
		


        add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzliches Maschinengewehr", 10));
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzliches Sturmbolter", 10));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("zwei Seitenkuppeln", 0));
		ogE.addElement(new OptionsGruppeEintrag("zusätzliche Panzerplatten", 0));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Command tank",25));
                
		complete();

	}

	public void refreshen() {
            if (!o4.isSelected()) o4.setSelected(0,true);
            o3.setAktiv(!o2.isSelected());
            o2.setAktiv(!o3.isSelected());
	}
}
