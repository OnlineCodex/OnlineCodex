package oc.wh40k.units.rh_ia13;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class RH_IA13RenegadeDiscipleSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe specWeapon;
	OptionsZaehlerGruppe weapon;
	OptionsZaehlerGruppe weaponTeam;
	OptionsUpgradeGruppe vox;
	
	RuestkammerStarter champion;
	RuestkammerStarter rkTransport;
	
	boolean lastState = false;

	public RH_IA13RenegadeDiscipleSquad() {
		name = "Renegade Disciple Squad\n";
		grundkosten = 0;
		überschriftSetzen=true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Disciples", 5, 10, 10);
		squad.setGrundkosten(-15);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGRatlingSquad.jpg"));
		
		ogE.addElement(new OptionsGruppeEintrag("Flamer", "Disciple with flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Disciple with grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", "Disciple with melta gun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", "Disciple with plasma gun", 15));
		add(specWeapon = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
		
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

		ogE.addElement(new OptionsGruppeEintrag("Lasgun", "Renegade with lasgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Autogun", "Renegade with autogun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Shotgun", "Renegade with shotgun", 0));
		add(weapon = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Vox-caster", 5));
		ogE.addElement(new OptionsGruppeEintrag("Chaos sigil", 10));
		add(vox = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Krak grenades", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Carapace armour", 20));

		seperator();
		
		champion = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13ChampionKammer", "",0);
		champion.initKammer();
		champion.setButtonText("Champion");
		add(champion);
		champion.setAbwaehlbar(false);
		
		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeChimera", "Renegade Chimera");
		rkTransport.initKammer(true);
		add(rkTransport);
		
		complete();
	}

	@Override
	public void refreshen() {
		
		if(!champion.isSelected()) champion.setSelected(true);
	
		vox.setAktiv(specWeapon.getAnzahl()+weaponTeam.getAnzahl()*2<(squad.getModelle()-1));
		specWeapon.setAktiv(vox.getAnzahl()+weaponTeam.getAnzahl()*2<(squad.getModelle()-1));
		weaponTeam.setAktiv(vox.getAnzahl()+specWeapon.getAnzahl()<(squad.getModelle()-2));
		weapon.setMaxAnzahl((squad.getModelle()-1)-specWeapon.getAnzahl()-weaponTeam.getAnzahl()*2);
		weapon.setLegal(weapon.getAnzahl() == weapon.getMaxAnzahl());
		
	}

}
