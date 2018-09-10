//IA1 2nd Ed

package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class APOMalcadorAnnihilator extends Eintrag {

	OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
        OptionsUpgradeGruppe o2;

	public APOMalcadorAnnihilator() {
		name = "Malcador Annihilator";
		grundkosten = 275;


		add(ico = new oc.Picture("oc/wh40k/images/MalcadorDefender.gif"));
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "heavy stubber", "pintle-mounted heavy stubber", 10));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "storm bolter", "pintle-mounted storm bolter", 10));
                
                seperator();

		ogE.addElement(new OptionsGruppeEintrag("heavy stubbers", "sponsons with heavy stubbers", 0));
		ogE.addElement(new OptionsGruppeEintrag("autocannons", "sponsons with autocannons", 20));
		ogE.addElement(new OptionsGruppeEintrag("lascannons", "sponsons with lascannons", 30));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
                
		complete();

	}

	public void refreshen() {
            if (!o2.isSelected()) o2.setSelected(0,true);
            oe1.setAktiv(!oe2.isSelected());
            oe2.setAktiv(!oe1.isSelected());
	}
}
