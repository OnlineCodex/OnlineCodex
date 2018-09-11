//APO2

package oc.wh40k.units.apo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class APOFellblade extends Eintrag {

        OptionsUpgradeGruppe o4;
        OptionsUpgradeGruppe o5;
        OptionsUpgradeGruppe o6;

	public APOFellblade() {
		name = "Fellblade";
		grundkosten = 540;


		add(ico = new oc.Picture("oc/wh40k/images/Baneblade.gif"));
		
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armoured ceramite", 25));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Lascannons","Quad lascannon sponsons", 0));
		ogE.addElement(new OptionsGruppeEintrag("Laser destroyer","Laser destroyer sponsons", 0));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("TL Heavy bolters", 0));
		ogE.addElement(new OptionsGruppeEintrag("TL Heavy flamers", 0));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 20));
		add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		complete();

	}

	public void refreshen() {
            if(!o4.isSelected()){
            	o4.setSelected(0, true);
            }
            if(!o5.isSelected()){
            	o5.setSelected(0, true);
            }
	}
}
