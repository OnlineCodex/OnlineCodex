/* Regeln aus IA12
 * aktualisierte Version zu finden unter:
 * http://www.forgeworld.co.uk/Downloads/Product/PDF/d/dkksiegelist.pdf
 */

package oc.wh40k.armies;




import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKDeathKorpsofKriegAssaultBrigadeIA12 extends BuildaVater {

	public VOLKDeathKorpsofKriegAssaultBrigadeIA12() {
		reflectionKennung = "DKAB";

		HQeinträge = new String[] {"", "Company Command Squad", "Quartermaster Cadre"};//,"Marshal Karis Venner" nun im CCS
		Eliteeinträge = new String[] {"", "Combat Engineer Squad", "Griffon Strike Battery", "Leman Russ Forward Command Tank", "Hydra Flak Tank Battery", "Rapier Laser Destroyer Battery"};
		Standardeinträge = new String[] {"", "Infantry Platoon", "Grenadier Storm Squad"};
		Sturmeinträge = new String[] {"", "Hellhound Flame Tank Squadron","Death Rider Platoon", "Salamander Reconnaissance Squadron"};
		Unterstützungeinträge = new String[] {"","Heavy Weapons Platoon", "Thunderer Siege Squadron", "Leman Russ Tank Squadron","Ordnance Battery","Field Artillery Battery","Thunderbolt","Lightning","Avenger"};
		LordofWar = new String[] {
				"", "[FW Download] Arkurian Pattern Stormblade",
				"", "[WZ Mont'ka] Baneblade", "[WZ Mont'ka] Banehammer", "[WZ Mont'ka] Banesword", "[WZ Mont'ka] Doomhammer", "[WZ Mont'ka] Hellhammer", 
				"[WZ Mont'ka] Shadowsword",	"[WZ Mont'ka] Stormlord", "[WZ Mont'ka] Stormsword",
				"", "[APO2 Armageddon] Reaver Battle Titan", "[APO2 Armageddon] Warhound-Scouttitan", "[APO2 Armageddon] Festung der Arroganz",
				"", "[IA1 2nd Ed] Stormblade", "[IA1 2nd Ed] Macharius Heavy Tank", "[IA1 2nd Ed] Macharius Vanquisher", 
				"[IA1 2nd Ed] Macharius Vulcan", "[IA1 2nd Ed] Macharius Omega", "[IA1 2nd Ed] Crassus Armoured Assault Transport",
				"[IA1 2nd Ed] Praetor Armoured Assault Launcher", "[IA1 2nd Ed] Dominus Armoured Siege Bombard", 
				"[IA1 2nd Ed] Gorgon Heavy Transporter", "[IA1 2nd Ed] Malcador Heavy Tank", "[IA1 2nd Ed] Malcador Annihilator",
				"[IA1 2nd Ed] Malcador Defender", "[IA1 2nd Ed] Malcador Infernus", "[IA1 2nd Ed] Valdor Tank Hunter", 
				"[IA1 2nd Ed] Minotaur Artillery Tank",
				"", "[IA Aeronautica] Marauder Bomber","[IA Aeronautica] Marauder Destroyer", 
				"[IA Aeronautica] Praetor Armoured Assault Launcher (Air Defence)",
				"", "[Alt] Imperator-Kampftitan", "[Alt] Warlord-Kampftitan"
		};

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

		nameDerArtDerArmee = "Death Korps of Krieg Assault Brigade";
		nameDerArtDerArmeeDekliniert = "Death Korps of Krieg Assault Brigade";
		textAreaUeberschrift = "Death Korps of Krieg Assault Brigade";

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
