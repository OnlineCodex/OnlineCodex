package oc.wh40k.units.ae;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class AEArchon extends Eintrag {

	OptionsEinzelUpgrade oe1;
	OptionsUpgradeGruppe o1, o2;

	public AEArchon() {
		name = "Archon";
		grundkosten = getPts("Archon");
		power = 4;
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Splinter pistol", getPts("Splinter pistol")));
		ogE.addElement(new OptionsGruppeEintrag("Blast pistol", getPts("Blast Pistol")));
		ogE.addElement(new OptionsGruppeEintrag("Blaster (Index)", getPts("Blaster")));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Huskblade", getPts("Huskblade")));
		ogE.addElement(new OptionsGruppeEintrag("Agoniser", getPts("Agoniser")));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (Drukhari)")));
		ogE.addElement(new OptionsGruppeEintrag("Venom blade", getPts("Venom blade")));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Phantasm grenade launcher", getPts("Phantasm grenade launcher")));
		
		complete();
	}

	@Override
	public void refreshen() {	
		o1.alwaysSelected();
		o2.alwaysSelected();
	}
}
