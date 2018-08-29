package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMFuriosoDreadnought extends Eintrag {
	OptionsUpgradeGruppe o1x, o1, o2, o3, o4;

	public IMFuriosoDreadnought() {
		name = "Furioso Dreadnought";
		grundkosten = getPts("Furioso Dreadnought");
		power = 10;
		
//		A Furioso Dreadnought is a single model equipped with two Furioso fists, a storm bolter and a meltagun.
//		WARGEAR OPTIONS 
//		This model may replace one Furioso fist and either its storm bolter or its meltagun with a frag cannon.
//		This model may replace its two Furioso fists with blood talons.
//		This model may replace its storm bolter with a heavy flamer.
//		This model may replace its meltagun with a heavy flamer.
//		This model may replace its smoke launchers with a magna-grapple.
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("2 Furioso fists", getPts("Furioso fist (single)")));
		add(o1x = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("2 Furioso fists", getPts("Furioso fist (pair)")));
		ogE.addElement(new OptionsGruppeEintrag("Blood talons", getPts("blood talons")));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		 
		ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Frag cannon", getPts("Frag cannon")));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Frag cannon", getPts("Frag cannon")));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Smoke launchers", getPts("smoke launchers")));
		ogE.addElement(new OptionsGruppeEintrag("Magna-grapple", getPts("magna-grapple")));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
		
		if (o2.isSelected("Frag cannon")){
			o1.setAktiv(false);
			o1x.setAktiv(true);
			o1x.alwaysSelected();
			o3.setAktiv("Frag cannon", false);
		}else if (o3.isSelected("Frag cannon")){
			o1.setAktiv(false);
			o1x.setAktiv(true);
			o1x.alwaysSelected();
			o2.setAktiv("Frag cannon", false);
		}else {
			o1x.setAktiv(false);
			o1.setAktiv(true);
			o1.alwaysSelected();
			o2.setAktiv("Frag cannon", true);
			o3.setAktiv("Frag cannon", true);
		}

		o2.alwaysSelected();
		o3.alwaysSelected();
		o4.alwaysSelected();
	}
}
