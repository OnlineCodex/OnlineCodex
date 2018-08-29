package oc.wh40k.units.kd;


import oc.Eintrag;
import oc.OptionsZaehlerGruppe;

public class KDBloodthirsterOfUnfetteredFury extends Eintrag {

	OptionsZaehlerGruppe o1,o2,o3;
	
	public KDBloodthirsterOfUnfetteredFury() {

		name = "Bloodthirster Of Unfettered Fury";

		grundkosten = 250;

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
