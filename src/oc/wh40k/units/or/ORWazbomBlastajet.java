package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORWazbomBlastajet extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	
	public ORWazbomBlastajet() {
		name = "Wazbom Blastajet";
		grundkosten = getPts("Wazbom Blastajet") + getPts("Smasha gun");
		power = 8;

		add(ico = new oc.Picture("oc/wh40k/images/Dakkajet.gif"));
		
		ogE.addElement(new OptionsGruppeEintrag("2 Wazbom mega-kannons", getPts("Wazbom mega-kannon") * 2));
		ogE.addElement(new OptionsGruppeEintrag("2 Tellyport mega-blastas", getPts("Tellyport mega-blasta") * 2));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt,"", "2 Supa shootas", getPts("supa shoota") * 2));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Stikkbomb flinga", getPts("Stikkbomb flinga")));
		ogE.addElement(new OptionsGruppeEintrag("Kustom force field", getPts("Kustom force field")));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		complete();
	}

	public void refreshen() {
		o1.alwaysSelected();
		o2.alwaysSelected();
	}
}
