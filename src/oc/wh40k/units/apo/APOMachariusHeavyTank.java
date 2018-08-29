//IA1 2nd Ed

package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class APOMachariusHeavyTank extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;

	public APOMachariusHeavyTank() {
		name = "Macharius Heavy Tank";
		grundkosten = 325;


		add(ico = new oc.Picture("oc/wh40k/images/Macharius.gif"));
		
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "hunter-killer missile", 10));
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "heavy stubber", "pintle-mounted heavy stubber", 10));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "storm bolter", "pintle-mounted storm bolter", 10));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("heavy stubbers", "sponsons with heavy stubbers", 0));
		ogE.addElement(new OptionsGruppeEintrag("heavy bolters", "sponsons with heavy bolters", 10));
		ogE.addElement(new OptionsGruppeEintrag("heavy flamers", "sponsons with heavy flamers", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
                
		complete();

	}

	public void refreshen() {
            if (!o1.isSelected()) o1.setSelected(0,true);
            oe1.setAktiv(!oe2.isSelected());
            oe2.setAktiv(!oe1.isSelected());
	}
}
