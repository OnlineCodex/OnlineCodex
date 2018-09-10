package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMImmolator extends Eintrag {

	OptionsUpgradeGruppe o1;

	public IMImmolator() {
		name = "Immolator";
		grundkosten = getPts("Immolator");
		power = 5;

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Immolation flamer", getPts("Immolation flamer")));
		ogE.addElement(new OptionsGruppeEintrag("Twin heavy bolter", getPts("Twin heavy bolter (AMI)")));
		ogE.addElement(new OptionsGruppeEintrag("Twin multi-melta", getPts("Twin multi-melta (AMI)")));
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
