package oc.wh40k.units.ae;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class AEAutarchwithSwoopingHawkWingsIndex extends Eintrag {

	OptionsEinzelUpgrade oe1;
	OptionsUpgradeGruppe o1, o2;
	OptionsZaehlerGruppe o3, o4;
	
	public AEAutarchwithSwoopingHawkWingsIndex() {
		name = "Autarch with Swooping Hawk Wings";
		grundkosten = getPts("Autarch with Swooping Hawk Wings") + getPts("Sunburst grenade") + getPts("Forceshield");
		power = 4;
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Banshee mask", getPts("Banshee mask")));
		ogE.addElement(new OptionsGruppeEintrag("Mandiblasters", getPts("Mandiblaster")));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Shuriken pistol", getPts("Shuriken pistol")));
		ogE.addElement(new OptionsGruppeEintrag("Fusion pistol", getPts("Fusion pistol")));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		o2.setAktiv(0, true);
		
		seperator();
		
		ogE.addAll(AEAutarchWeaponsDouble.createRK("", "", buildaVater));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
		seperator();
		
		ogE.addAll(AEAutarchWeaponsSingle.createRK("", "", buildaVater));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		complete();
	}

	@Override
	public void refreshen() {	
		o1.alwaysSelected();
		o2.alwaysSelected();
		
		if(o4.isSelected())
		{
			o3.setMaxAnzahl(1);
		}
		else
		{
			o3.setMaxAnzahl(2);
		}
	}
}
