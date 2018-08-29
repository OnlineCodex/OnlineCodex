package oc.wh40k.units.dk;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DKMachariusKammer extends RuestkammerVater {

        OptionsUpgradeGruppe o1;
        OptionsUpgradeGruppe m1;

	public DKMachariusKammer() {}
	
	public void initButtons(boolean... b) {
		grundkosten = 0;
		
		add(ico = new oc.Picture("oc/wh40k/images/Macharius.gif"));
		
		ogE.addElement(new OptionsGruppeEintrag("Macharius", 325));
		ogE.addElement(new OptionsGruppeEintrag("Macharius \"Vanquisher\"", 375));
		ogE.addElement(new OptionsGruppeEintrag("Macharius \"Vulcan\"", 405));
		add(m1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();

                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "hunter-killer missile", 10));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "improved comms", 0));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "minesweeper", 0));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "heavy stubber", "pintle-mounted heavy stubber", 10));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "searchlight", 0));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "smoke launchers", 0));

                seperator();

		ogE.addElement(new OptionsGruppeEintrag("heavy stubbers", "sponsons with heavy stubbers", 0));
		ogE.addElement(new OptionsGruppeEintrag("heavy bolters", "sponsons with heavy bolters", 10));
		ogE.addElement(new OptionsGruppeEintrag("heavy flamers", "sponsons with heavy flamers", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
                
		sizeSetzen();

	}

	public void refreshen() {
			if (!m1.isSelected()) m1.setSelected(0,true);
            if (!o1.isSelected()) o1.setSelected(0,true);
	}

	
}
