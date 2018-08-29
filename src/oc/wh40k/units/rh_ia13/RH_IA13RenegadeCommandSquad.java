package oc.wh40k.units.rh_ia13;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerStarter;

public class RH_IA13RenegadeCommandSquad extends Eintrag {

	OptionsUpgradeGruppe champ;
	OptionsUpgradeGruppe devotion;
	OptionsUpgradeGruppe champW;
	OptionsEinzelUpgrade mb;
	OptionsEinzelUpgrade ca;
	OptionsEinzelUpgrade rf;

	AnzahlPanel squad;
	OptionsUpgradeGruppe banner;
	OptionsEinzelZaehler vox;
	OptionsZaehlerGruppe specWeapon;
	OptionsZaehlerGruppe weaponTeam;
	OptionsZaehlerGruppe weapon;
	OptionsEinzelUpgrade krak;
	OptionsEinzelUpgrade carapace;
	OptionsEinzelUpgrade wl;
	OptionsEinzelUpgrade fnp;

	boolean wlBool=false;
	int devotionInt=-1;

	RuestkammerStarter rkTransport;

	public RH_IA13RenegadeCommandSquad() {
		name = "Renegade Command Squad\n";
		grundkosten = 0;
		add(ico = new oc.Picture("oc/wh40k/images/RHCompanyCommandSquad.jpg"));
		überschriftSetzen=true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Disciples", 5, 15, 10);
		squad.setGrundkosten(-5);
		add(squad);

		ogE.addElement(new OptionsGruppeEintrag("Arch-demagogue","Arch-demagogue (No Chaos Covenant)", 0));
		ogE.addElement(new OptionsGruppeEintrag("Arch-demagogue (Khorne)","Arch-demagogue (Covenant of Khorne)", 10));
		ogE.addElement(new OptionsGruppeEintrag("Arch-demagogue (Nurgle)","Arch-demagogue (Covenant of Nurgle)", 10));
		ogE.addElement(new OptionsGruppeEintrag("Arch-demagogue (Slaanesh)","Arch-demagogue (Covenant of Slaanesh)", 10));
		ogE.addElement(new OptionsGruppeEintrag("Arch-demagogue (Tzeentch)","Arch-demagogue (Covenant of Tzeentch)", 10));
		add(champ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		champ.setSelected(0, true);

		seperator();

		add(wl = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Warlord",0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bloody-handed Reaver", 20));
		ogE.addElement(new OptionsGruppeEintrag("Primaris-rogue Witch (ML 1)", 35));
		ogE.addElement(new OptionsGruppeEintrag("Primaris-rogue Witch (ML 2)", 60));
		ogE.addElement(new OptionsGruppeEintrag("Mutant Overlord", 15));
		ogE.addElement(new OptionsGruppeEintrag("Master of the Horde", 20));
		ogE.addElement(new OptionsGruppeEintrag("Arch-heretic Revolutionary", 25));
		ogE.addElement(new OptionsGruppeEintrag("Heretek Magus", 30));
		add(devotion = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Autopistol", 0));
		ogE.addElement(new OptionsGruppeEintrag("Close Combat Weapon", 0));
		ogE.addElement(new OptionsGruppeEintrag("Laspistol", 0));
		ogE.addElement(new OptionsGruppeEintrag("Autogun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Lasgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Shotgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power Weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power axe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power maul", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power lance", 10));
		ogE.addElement(new OptionsGruppeEintrag("Powerfist", 15));
		add(champW = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();

		add(ca = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Carapace Armour", 5));
		add(mb = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta bombs", 5));
		add(rf = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Refractor field", 15));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Banner of the Apostate", 10));
		ogE.addElement(new OptionsGruppeEintrag("Banner of Hate", 25));
		add(banner = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(vox = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Command net vox", 1, 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flamer", "Disciple with flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Disciple with grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", "Disciple with melta gun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", "Disciple with plasma gun", 15));
		add(specWeapon = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy stubber team", 5));
		ogE.addElement(new OptionsGruppeEintrag("Mortar team", 5));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter team", 10));
		ogE.addElement(new OptionsGruppeEintrag("Autocannon team", 10));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher team", 15));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher team (flakk)", 25));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon team", 20));
		add(weaponTeam = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Lasgun", "Disciple with lasgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Autogun", "Disciple with autogun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Shotgun", "Disciple with shotgun", 0));
		add(weapon = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();

		add(krak = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Krak grenades", 5));
		add(carapace = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Carapace armour", 20));
		add(fnp = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Feel no Pain SR", 10));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeChimera", "Renegade Chimera");
		rkTransport.initKammer(true);
		add(rkTransport);

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

		banner.setAktiv(vox.getAnzahl()+specWeapon.getAnzahl()+weaponTeam.getAnzahl()*2<(squad.getModelle()-1));
		vox.setAktiv(banner.getAnzahl()+specWeapon.getAnzahl()+weaponTeam.getAnzahl()*2<(squad.getModelle()-1));
		specWeapon.setAktiv(banner.getAnzahl()+vox.getAnzahl()+weaponTeam.getAnzahl()*2<(squad.getModelle()-1));
		weaponTeam.setAktiv(banner.getAnzahl()+vox.getAnzahl()+specWeapon.getAnzahl()<(squad.getModelle()-2));
		weapon.setMaxAnzahl((squad.getModelle()-1)-specWeapon.getAnzahl()-weaponTeam.getAnzahl()*2);
		weapon.setLegal(weapon.getAnzahl() == weapon.getMaxAnzahl());

		if(getCountFromInformationVector("Main")<1 || (getCountFromInformationVector("RHWarlord")>0 && wlBool==false)){
			wl.setSelected(false);
			wl.setAktiv(false);
		} else{
			wl.setAktiv(true);
		}

		if(wlBool!=wl.isSelected()){
			wlBool=wl.isSelected();
			addToInformationVector("RHWarlord", (wlBool)?1:-1);
		}



		devotion.setAktiv(wlBool);
		devotion.setAktiv(1, wlBool && !champ.isSelected(1));
		devotion.setAktiv(2, wlBool && !champ.isSelected(1));
		champ.setAktiv(1, !devotion.isSelected(1) && !devotion.isSelected(2));

		//No Covenant
		if(getCountFromInformationVector("RHWarlord")<1){
			buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Renegade Marauder Squad");
		}else{
			if(!champ.isSelected(0) && wlBool){
				buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Renegade Marauder Squad");
			}else if(champ.isSelected(0) && wlBool){
				buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Renegade Marauder Squad");
			}
		}

		//Khorne Covenant
		if(getCountFromInformationVector("RHWarlord")<1){
			buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Renegade Blood Slaughterers");
		}else{
			if(!champ.isSelected(1) && wlBool){
				buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Renegade Blood Slaughterers");
			}else if(champ.isSelected(1) && wlBool){
				buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Renegade Blood Slaughterers");
			}
		}

		//Nurgle Covenant
		if(getCountFromInformationVector("RHWarlord")<1){
			buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Renegade Blight Drones");
			buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Plague Zombie Horde");
		}else{
			if(!champ.isSelected(2) && wlBool){
				buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Renegade Blight Drones");
				buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Plague Zombie Horde");
			}else if(champ.isSelected(2) && wlBool){
				buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Renegade Blight Drones");
				buildaVater.getChooserGruppeForChange(3).addSpezialAuswahl("Plague Zombie Horde");
			}
		}

		//Slaanesh Covenant
		if(getCountFromInformationVector("RHWarlord")<1){
			buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Noise Marines");
			buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Sonic Dreadnought");
		}else{
			if(!champ.isSelected(3) && wlBool){
				buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Noise Marines");
				buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Sonic Dreadnought");
			}else if(champ.isSelected(3) && wlBool){
				buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Noise Marines");
				buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Sonic Dreadnought");
			}
		}

		//Tzeentch Covenant
		if(getCountFromInformationVector("RHWarlord")<1){
			buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Renegade Chaos Spawn");
			setInformationVectorValue("RHTzeentchCovenant", 0);
		}else{
			if(!champ.isSelected(4) && wlBool && !devotion.isSelected(3)){
				buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Renegade Chaos Spawn");
				setInformationVectorValue("RHTzeentchCovenant", 0);
			}else if(champ.isSelected(4) && wlBool){
				setInformationVectorValue("RHTzeentchCovenant", 1);
				buildaVater.getChooserGruppeForChange(3).addSpezialAuswahl("Renegade Chaos Spawn");
			}
		}


		//Bloody-handed Reaver
		if(!devotion.isSelected(0) && wlBool || devotion.isSelected(0) && !wlBool){
			setInformationVectorValue("RHBloodyHandedReaver", 0);
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Khorne Lord of Skulls");
			if(!devotion.isSelected(6)){
				buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Greater Brass Scorpion");
			}
		}else if(devotion.isSelected(0) && wlBool){
			setInformationVectorValue("RHBloodyHandedReaver", 1);
			buildaVater.getChooserGruppeForChange(7).addSpezialAuswahl("Khorne Lord of Skulls");
			buildaVater.getChooserGruppeForChange(7).addSpezialAuswahl("Greater Brass Scorpion");
		}

		//Primaris-rogue Witch
		if(!devotion.isSelected(1) && !devotion.isSelected(2) && wlBool || (devotion.isSelected(1) || devotion.isSelected(2))  && !wlBool){
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Daemon Lord Scabeiathrax the Bloated");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Daemon Lord An'ggrath the Unbound");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Daemon Lord Aetaos'rau'keres");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Daemon Lord Zarakynel");
			buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Rogue Psykers Coven");
		}else if((devotion.isSelected(1) || devotion.isSelected(2)) && wlBool){
			buildaVater.getChooserGruppeForChange(7).addSpezialAuswahl("Daemon Lord Scabeiathrax the Bloated");
			buildaVater.getChooserGruppeForChange(7).addSpezialAuswahl("Daemon Lord An'ggrath the Unbound");
			buildaVater.getChooserGruppeForChange(7).addSpezialAuswahl("Daemon Lord Aetaos'rau'keres");
			buildaVater.getChooserGruppeForChange(7).addSpezialAuswahl("Daemon Lord Zarakynel");
			buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Rogue Psykers Coven");
		}

		//Mutant Overlord
		if(!devotion.isSelected(3) && wlBool || devotion.isSelected(3) && !wlBool){
			setInformationVectorValue("RHMutantOverlord", 0);
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Giant Chaos Spawn");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Spined Chaos Beast");
			if(!champ.isSelected(4) || !wlBool){
				buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Renegade Chaos Spawn");
			}
		}else if(devotion.isSelected(3) && wlBool){
			setInformationVectorValue("RHMutantOverlord", 1);
			buildaVater.getChooserGruppeForChange(7).addSpezialAuswahl("Giant Chaos Spawn");
			buildaVater.getChooserGruppeForChange(7).addSpezialAuswahl("Spined Chaos Beast");
			buildaVater.getChooserGruppeForChange(3).addSpezialAuswahl("Renegade Chaos Spawn");
		}

		//Master of the Horde
		if(!devotion.isSelected(4) && wlBool || devotion.isSelected(4) && !wlBool){
			setInformationVectorValue("RHMasterOfTheHorde", 0);
		}else if(devotion.isSelected(4) && wlBool){
			setInformationVectorValue("RHMasterOfTheHorde", 1);
		}

		//Arch-heretic Revolutionary
		if(!devotion.isSelected(5) && wlBool || devotion.isSelected(5) && !wlBool){
			setInformationVectorValue("RHArchHereticRev", 0);
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Macharius Heavy Tank");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Macharius Vanquisher");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Macharius Vulcan");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Macharius Omega");
			champ.setMaxAnzahl(1);
			champ.setLegal(champ.getAnzahl()==1);
			//champ.deselectAll();
			for(int i=1;i<champ.getNumberOfOptions()-1;i++){
				champ.setPreis(i, 10);
			}
		}else if(devotion.isSelected(5) && wlBool){
			setInformationVectorValue("RHArchHereticRev", 1);
			buildaVater.getChooserGruppeForChange(7).addSpezialAuswahl("Macharius Heavy Tank");
			buildaVater.getChooserGruppeForChange(7).addSpezialAuswahl("Macharius Vanquisher");
			buildaVater.getChooserGruppeForChange(7).addSpezialAuswahl("Macharius Vulcan");
			buildaVater.getChooserGruppeForChange(7).addSpezialAuswahl("Macharius Omega");
			champ.setMaxAnzahl(2);
			if(!champ.isSelected(0) && champ.getAnzahl()==2){
				champ.setPreis(champ.getSelectedIndex(), 0);
			}else{
				for(int i=1;i<champ.getNumberOfOptions()-1;i++){
					champ.setPreis(i, 10);
				}
			}
		}

		//Heretek Magus
		if(!devotion.isSelected(6) && wlBool || devotion.isSelected(6) && !wlBool){
			setInformationVectorValue("RHHeretekMagus", 0);
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Valdor Tank Hunter");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Chaos Warhound Titan");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Chaos Reaver Titan");
			buildaVater.getChooserGruppeForChange(5).removeSpezialAuswahl("Chaos Defiler");
			buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Chaos Decimator");
			if(!devotion.isSelected(0)){
				buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Greater Brass Scorpion");
			}
			fnp.setAktiv(false);
		}else if(devotion.isSelected(6) && wlBool){
			setInformationVectorValue("RHHeretekMagus", 1);
			buildaVater.getChooserGruppeForChange(7).addSpezialAuswahl("Valdor Tank Hunter");
			buildaVater.getChooserGruppeForChange(7).addSpezialAuswahl("Chaos Warhound Titan");
			buildaVater.getChooserGruppeForChange(7).addSpezialAuswahl("Chaos Reaver Titan");
			buildaVater.getChooserGruppeForChange(7).addSpezialAuswahl("Greater Brass Scorpion");
			buildaVater.getChooserGruppeForChange(5).addSpezialAuswahl("Chaos Defiler");
			buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Chaos Decimator");
			fnp.setAktiv(true);
		}

		if(!wlBool){
			devotion.deselectAll();
		}

		if(devotion.getSelectedIndex()!=devotionInt){
			devotionInt=devotion.getSelectedIndex();
			RefreshListener.fireRefresh();
		}

	}

	@Override
	public void deleteYourself() { 


		if(champ.isSelected(0) && wlBool){
			buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Renegade Marauder Squad");
		}

		if(champ.isSelected(1) && wlBool){
			buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Renegade Blood Slaughterers");
		}

		if(champ.isSelected(2) && wlBool){
			buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Renegade Blight Drones");
			buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Plague Zombie Horde");
		}

		if(champ.isSelected(3) && wlBool){
			buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Noise Marines");
			buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Sonic Dreadnought");
		}

		if(champ.isSelected(4) && wlBool){
			buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Renegade Chaos Spawn");
			setInformationVectorValue("RHTzeentchCovenant", 0);
		}

		if(devotion.isSelected(0) && wlBool){
			setInformationVectorValue("RHBloodyHandedReaver", 0);
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Khorne Lord of Skulls");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Greater Brass Scorpion");
		}

		if((devotion.isSelected(1) || devotion.isSelected(2))  && wlBool){
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Daemon Lord Scabeiathrax the Bloated");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Daemon Lord An'ggrath the Unbound");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Daemon Lord Aetaos'rau'keres");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Daemon Lord Zarakynel");
			buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Rogue Psykers Coven");
		}

		if(devotion.isSelected(3) && wlBool){
			setInformationVectorValue("RHMutantOverlord", 0);
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Giant Chaos Spawn");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Spined Chaos Beast");
			buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Renegade Chaos Spawn");
		}

		if(devotion.isSelected(4) && wlBool){
			setInformationVectorValue("RHMasterOfTheHorde", 0);
		}

		if(devotion.isSelected(5) && wlBool){
			setInformationVectorValue("RHArchHereticRev", 0);
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Macharius Heavy Tank");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Macharius Vanquisher");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Macharius Vulcan");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Macharius Omega");
		}

		if(devotion.isSelected(6) && wlBool){
			setInformationVectorValue("RHHeretekMagus", 0);
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Valdor Tank Hunter");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Chaos Warhound Titan");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Chaos Reaver Titan");
			buildaVater.getChooserGruppeForChange(5).removeSpezialAuswahl("Chaos Defiler");
			buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Chaos Decimator");
			buildaVater.getChooserGruppeForChange(7).removeSpezialAuswahl("Greater Brass Scorpion");
		}

		if(wlBool==true){
			wlBool=false;
			addToInformationVector("RHWarlord",-1);
		}

		super.deleteYourself();
	}
}
