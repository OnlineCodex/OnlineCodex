
package oc.wh40k.units.sm;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class SMFahrzeugruestkammer extends RuestkammerVater {

	OptionsUpgradeGruppe fahrzeugausruestung;
	boolean isLR=false;

	public SMFahrzeugruestkammer() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		try { 
			isLR = defaults[0]; 
			
		} catch(Exception e) {}

		if(!isLR){
			ogE.addElement(new OptionsGruppeEintrag("Bulldozerschaufel", 5));
		}
        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Suchkopfrakete", 10));
        ogE.addElement(new OptionsGruppeEintrag("Zusätzlich Panzerung", 10));
        add(fahrzeugausruestung=new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE,9));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

}
