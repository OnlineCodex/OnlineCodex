package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;

public class CHLegion extends Eintrag {

    OptionsUpgradeGruppe ordenHaupt;

	public CHLegion() {
		grundkosten = 0;
		name="Legion:";
		//überschriftSetzen=true;
		this.setEintragsCNT(0);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Black Legion", 0));
		ogE.addElement(new OptionsGruppeEintrag("Iron Warriors", 0));
		ogE.addElement(new OptionsGruppeEintrag("Renegade Cahpters", 0));
		ogE.addElement(new OptionsGruppeEintrag("World Eaters", 0));
		ogE.addElement(new OptionsGruppeEintrag("Night Lords", 0));
		ogE.addElement(new OptionsGruppeEintrag("Emperor's Children", 0));//Each Character may upgrade one Weapon to an mastercrafted one (0)
		ogE.addElement(new OptionsGruppeEintrag("Alpha Legion", 0));
		ogE.addElement(new OptionsGruppeEintrag("Word Bearers", 0));
		add(ordenHaupt = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		complete();
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
		
	}

}
