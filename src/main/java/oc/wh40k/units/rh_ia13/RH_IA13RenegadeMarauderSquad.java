package oc.wh40k.units.rh_ia13;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class RH_IA13RenegadeMarauderSquad extends Eintrag {

	OptionsUpgradeGruppe champ;
	OptionsUpgradeGruppe champW;
	OptionsEinzelUpgrade mb;
	OptionsEinzelUpgrade ca;
	OptionsEinzelUpgrade rf;
	
	AnzahlPanel squad;
	AnzahlPanel squad2;
	OptionsZaehlerGruppe weapon;
	OptionsZaehlerGruppe specWeapon;
	OptionsUpgradeGruppe spec;
	
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkTransport2;

	public RH_IA13RenegadeMarauderSquad() {
		name = "Renegade Marauder Squad\n";
		grundkosten = 0;
		überschriftSetzen=true;
		add(ico = new oc.Picture("oc/wh40k/images/RHCompanyCommandSquad.jpg"));
		
		seperator();
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Marauder", 5, 10, 10);
		squad.setGrundkosten(5);
		add(squad);
		
		squad2 = new AnzahlPanel(ID, randAbstand, cnt, "Brute", 0, 2, 30);
		squad2.setGrundkosten(5);
		add(squad2);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Marauder Chief", 0));
		add(champ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		champ.setSelected(0, true);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Autopistol", 0));
		ogE.addElement(new OptionsGruppeEintrag("Close Combat Weapon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Autogun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Lasgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Shotgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Bolt gun", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power Weapon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power axe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power maul", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power lance", 15));
		ogE.addElement(new OptionsGruppeEintrag("Powerfist", 25));
		add(champW = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();

		add(ca = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Breacher charge", 15));
		add(mb = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta bombs", 5));
		add(rf = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Refractor field", 15));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flamer", "Marauder with flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Marauder with grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Sniper rifle", "Marauder with sniper rifle", 2));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", "Marauder with melta gun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", "Marauder with heavy stubber", 5));
		ogE.addElement(new OptionsGruppeEintrag("Power Weapon", "Marauder with power weapon", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", "Marauder with power sword", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power axe", "Marauder with power axe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power maul", "Marauder with power maul", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power lance", "Marauder with power lance", 15));
		add(specWeapon = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Lasgun", "Marauder with lasgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Autogun", "Marauder with autogun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Shotgun", "Marauder with shotgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Shotgun", "Marauder with laspistol", 0));
		add(weapon = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Stalkers", 0));
		ogE.addElement(new OptionsGruppeEintrag("Murder Cultists", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heretekx", 0));
		add(spec = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));

		seperator();
		
		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13ArvusLighterKammer", "Arvus Lighter");
		rkTransport.initKammer(true);
		add(rkTransport);
		
		seperator();
		
		rkTransport2 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeChimera", "Renegade Chimera");
		rkTransport2.initKammer(true);
		add(rkTransport2);

		complete();
	}

  @Override
	public void refreshen() {
		if(!champ.isSelected()){ 
			champ.setSelected(0,true);
		}
		if(!champW.isSelected()){
			champW.setSelected(0,true);
			champW.setSelected(1,true);
		}
		if(!spec.isSelected()){ 
			spec.setSelected(0,true);
		}
		
		rkTransport.setAktiv(!rkTransport2.isSelected());
		rkTransport2.setAktiv(!rkTransport.isSelected());
		
		weapon.setMaxAnzahl((squad.getModelle()-1)-specWeapon.getAnzahl());
		weapon.setLegal(weapon.getAnzahl() == weapon.getMaxAnzahl());
		
		}
}
