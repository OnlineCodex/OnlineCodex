package oc.wh40k.units.rh_ia13;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class RH_IA13RenegadeInfantryVeterans extends Eintrag {


	AnzahlPanel squad;
	RuestkammerStarter champ1;
	OptionsZaehlerGruppe weapon;
	OptionsZaehlerGruppe weaponStd;
	OptionsZaehlerGruppe weapon2;
	OptionsZaehlerGruppe weaponStd2;
	OptionsZaehlerGruppe specWeapon;
	OptionsUpgradeGruppe spec;
	OptionsUpgradeGruppe spec2;
	OptionsUpgradeGruppe spec3;

	RuestkammerStarter rkTransport2;

	public RH_IA13RenegadeInfantryVeterans() {
		name = "Renegade Infantry Veterans\n";
		grundkosten = 0;
		überschriftSetzen=true;
		add(ico = new oc.Picture("oc/wh40k/images/RHCompanyCommandSquad.jpg"));

		seperator();

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Renegade Veterans", 5, 10, 10);
		squad.setGrundkosten(-15);
		add(squad);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Vox caster", 5));
		ogE.addElement(new OptionsGruppeEintrag("Chaos sigil", 5));
		ogE.addElement(new OptionsGruppeEintrag("Hot-shot volley gun", 10));
		add(specWeapon = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Autopistol", 0));
		add(weaponStd = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 10));
		ogE.addElement(new OptionsGruppeEintrag("Laspistol", 0));
		ogE.addElement(new OptionsGruppeEintrag("Stubgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Lasgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Shotgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Autogun", 0));
		add(weapon = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
		
		ogE.addElement(new OptionsGruppeEintrag("Hot-shot lasgun", 0));
		add(weaponStd2= new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 10));
		ogE.addElement(new OptionsGruppeEintrag("Hot-shot laspistol", 0));
		add(weapon2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Carapace armour", 20));
		ogE.addElement(new OptionsGruppeEintrag("Scout SR", 15));
		ogE.addElement(new OptionsGruppeEintrag("Furious Charge SR", 25));
		ogE.addElement(new OptionsGruppeEintrag("Deep Strike SR", 15));
		ogE.addElement(new OptionsGruppeEintrag("Tank Hunters SR", 25));
		add(spec = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Grenadiers", 15));
		add(spec2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Fanatic SR", 20));
		ogE.addElement(new OptionsGruppeEintrag("Feel no Pain SR", 10));
		add(spec3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));
		
		seperator();

		champ1 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13InfantryChampionKammer", "",1);
		champ1.initKammer(false,true);
		champ1.setButtonText("Veteran Champion");
		add(champ1);

		seperator();

		rkTransport2 = new RuestkammerStarter(ID, randAbstand, cnt, "RH_IA13RenegadeChimera", "Renegade Chimera");
		rkTransport2.initKammer(true);
		add(rkTransport2);

		complete();
	}

	@Override
	public void refreshen() {

		specWeapon.setMaxAnzahl(squad.getModelle()/5);
		weaponStd.setMaxAnzahl(squad.getModelle()-weapon.getAnzahl()-(champ1.isSelected()?1:0));
		weaponStd.setAnzahl(0,squad.getModelle()-weapon.getAnzahl()-(champ1.isSelected()?1:0));
		weapon.setMaxAnzahl(squad.getModelle()-(champ1.isSelected()?1:0));
		weaponStd2.setMaxAnzahl(squad.getModelle()-weapon.getAnzahl()-(champ1.isSelected()?1:0)-specWeapon.getAnzahl(6));
		weaponStd2.setAnzahl(0,squad.getModelle()-weapon.getAnzahl()-(champ1.isSelected()?1:0)-specWeapon.getAnzahl(6));
		weapon2.setMaxAnzahl(squad.getModelle()-(champ1.isSelected()?1:0)-specWeapon.getAnzahl(6));

		spec2.setAktiv(getCountFromInformationVector("RHBloodyHandedReaver")==1);
		spec3.setAktiv(0,getCountFromInformationVector("RHArchHereticRev")==1);
		spec3.setAktiv(1,getCountFromInformationVector("RHHeretekMagus")==1);
		
		weaponStd.setAktiv(!spec2.isSelected());
		weapon.setAktiv(!spec2.isSelected());
		weaponStd2.setAktiv(spec2.isSelected());
		weapon2.setAktiv(spec2.isSelected());
		specWeapon.setAktiv(6, spec2.isSelected());
		
		if(getCountFromInformationVector("RHMutantOverlord")==1 && getCountFromInformationVector("MutantRabble")<2){
			setFehlermeldung("2+ Mutant Rabble");
		}else if(getCountFromInformationVector("RHMasterOfTheHorde")==1 && getCountFromInformationVector("InfPlatoon")<2){
			setFehlermeldung("2+ Inf. Platoons");
		}else{
			setFehlermeldung("");
		}

	}
}
