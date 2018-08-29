package oc.wh40k.units.dw;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DWVenerableDreadnoughtNihilus extends Eintrag {
             
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	
	public DWVenerableDreadnoughtNihilus() {
		name = "Venerable Dreadnought Nihilus";
		grundkosten = 135;
        
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 0));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE)); 
		
		complete();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
		o2.alwaysSelected();
		o3.alwaysSelected();
		setUnikat(true);
	}
	
	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}
}