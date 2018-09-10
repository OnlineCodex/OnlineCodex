package oc.wh40k.units.kd;


import oc.Eintrag;
import oc.OptionsZaehlerGruppe;

public class KDBloodthirsterOfInsensateRage extends Eintrag {

	OptionsZaehlerGruppe o1,o2,o3;
	
	public KDBloodthirsterOfInsensateRage() {

		name = "Bloodthirster Of Insensate Rage";

		grundkosten = 275;

		complete();

	}

	@Override
	public void refreshen() {
	}
	
	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}
}
