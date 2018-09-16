package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMInterrogatorChaplaininTerminatorArmour extends Eintrag {

	OptionsZaehlerGruppe o1;

	public IMInterrogatorChaplaininTerminatorArmour() {
		name = "Interrogator-Chaplain in Terminator Armour";
		grundkosten = getPts("Interrogator-Chaplain in Terminator Armour") + getPts("Crozius arcanum");
		power = 6;
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw (single)")));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
		ogE.addAll(IMSpaceMarinesTerminatorCombiWeapons.createRK("", "", buildaVater));
		ogE.addAll(IMSpaceMarinesTerminatorMeleeWeapons.createRK("", "", buildaVater));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		complete();
	}

	@Override
	public void refreshen() {
	}
}