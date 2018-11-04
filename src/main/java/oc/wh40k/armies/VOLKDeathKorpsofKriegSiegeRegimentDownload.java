/* Regeln aus Imperial Armour Volume Five
 * aktualisierte Version zu finden unter:
 * http://www.forgeworld.co.uk/Downloads/Product/PDF/d/dkksiegelist.pdf
 */

package oc.wh40k.armies;




import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKDeathKorpsofKriegSiegeRegimentDownload extends BuildaVater {

	public VOLKDeathKorpsofKriegSiegeRegimentDownload() {
		reflectionKennung = "DK";

		HQeinträge = new String[] {"", "Company Command Squad", "Commissar-General", "Quartermaster Cadre"};
		Eliteeinträge = new String[] {"", "Grenadier Squad", "Engineer Squad", "Hydra Flakk Platform", "Rapier Laser Destroyer Battery", "Field Artillery Battery"};
		Standardeinträge = new String[] {"", "Infantry Platoon", "Engineer Squad"};
		Sturmeinträge = new String[] {"","Cyclops Demolition Squadron", "Hellhound Squadron","Death Rider Platoon"};
		Unterstützungeinträge = new String[] {"","Heavy Weapons Platoon", "Thunderer Siege Tank Squadron", "Leman Russ Squadron", "Bombard Battery", "Heavy Artillery Battery","Thunderbolt","Lightning","Avenger"};
		LordofWar = new String[] {"","[APO2 Armageddon] Reaver Battle Titan", "[APO2 Armageddon] Warhound-Scouttitan"};

		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 1, HQeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 2, Eliteeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 3, Standardeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 4, Sturmeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 5, Unterstützungeinträge));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;
		adden(new ChooserGruppe(this,"FO", cnt, 0, 6, Befestigungen));
    	cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this,"APO", cnt, 0, 7, LordofWar));
		cnt += 480;

		cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

		nameDerArtDerArmee = "Death Korps of Krieg Siege Regiment";
		nameDerArtDerArmeeDekliniert = "Death Korps of Krieg Siege Regiment";
		textAreaUeberschrift = "Death Korps of Krieg Siege Regiment";

		noAllies.clear();
		noAllies.add("MT");
		noAllies.add("AM");
		noAllies.add("ED");
		noAllies.add("AB");
		noAllies.add("DK");
		noAllies.add("DKAB");

		battleBrothers.add("AB");
		battleBrothers.add("AM");
		battleBrothers.add("AS");
		battleBrothers.add("BA");
		battleBrothers.add("CR");
		battleBrothers.add("DA");
		battleBrothers.add("DK");
		battleBrothers.add("DKAB");
		battleBrothers.add("ED");
		battleBrothers.add("GK");
		battleBrothers.add("IN");
		battleBrothers.add("IR");
		battleBrothers.add("MT");
		battleBrothers.add("SF");
		battleBrothers.add("SM");
		battleBrothers.add("TL");
		battleBrothers.add("DW");
		
		alliesOfConvenience.add("EL");
		alliesOfConvenience.add("HQ");
		
		desperateAllies.add("DE");
		desperateAllies.add("TA");
		desperateAllies.add("FE");
		desperateAllies.add("EC");
		
		comeTheApocalypse.add("BL");
		comeTheApocalypse.add("CD");
		comeTheApocalypse.add("CM");
		comeTheApocalypse.add("CS");
		comeTheApocalypse.add("DH");
		comeTheApocalypse.add("DM");
		comeTheApocalypse.add("NE");
		comeTheApocalypse.add("OR");
		comeTheApocalypse.add("RH");
		comeTheApocalypse.add("TY");
		comeTheApocalypse.add("SY");
		
		complete();
	}
}
