package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMRazorback extends Eintrag {

	OptionsUpgradeGruppe o1;

	public IMRazorback() {
		name = "Razorback";
		grundkosten = getPts("Razorback");
		power = 5;

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));
		ogE.addElement(new OptionsGruppeEintrag("Twin assault cannon", getPts("Twin assault cannon")));
		ogE.addElement(new OptionsGruppeEintrag("Twin heavy flamer", getPts("Twin heavy flamer (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Las + twin plasma gun", getPts("lascannon (SM)") + getPts("Twin plasma gun")));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", getPts("Hunter-killer missile (SM)")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", getPts("Storm bolter (SM)")));

		complete();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
	}
}
