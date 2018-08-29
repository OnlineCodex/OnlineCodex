package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.Eintrag;

public class CHGreaterBrassScorpionOfKhorne extends Eintrag {
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o4;
    AnzahlPanel squad;

	public CHGreaterBrassScorpionOfKhorne() {
		name = "Greater Brass Scorpion of Khorne";
		grundkosten = getPts("Greater Brass Scorpion of Khorne");

		ogE.addElement(new OptionsGruppeEintrag("Hellcrusher claws", getPts("Hellcrusher claws")));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Scorpion cannon", getPts("Scorpion cannon")));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Soulshatter bombard", getPts("Soulshatter bombard")));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
	
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Twin hellmaw blasters", getPts("Twin hellmaw blasters")));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		complete();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
		o2.alwaysSelected();
		o3.alwaysSelected();
		o4.alwaysSelected();
	}
}
