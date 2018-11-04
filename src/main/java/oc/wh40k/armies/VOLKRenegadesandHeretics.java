package oc.wh40k.armies;




import oc.BuildaVater;
import oc.ChooserGruppe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VOLKRenegadesandHeretics extends BuildaVater {

	private static final Logger LOGGER = LoggerFactory.getLogger(VOLKRenegadesandHeretics.class);

	public VOLKRenegadesandHeretics() {
		reflectionKennung = "RH";

		HQeinträge = new String[] {"", "Company Command Platoon", "Enforcer", "Rogue Psyker", "Apostate Preacher"};
		Eliteeinträge = new String[] {"", "Disciples of Xaphan", "Renegade Ogryn Berserkers", "Alpha Legion Squad"};
		Standardeinträge = new String[] {"", "Renegade Militia Platoon", "Workers Rabble", "Renegade Armoured Fist Squad"};
		Sturmeinträge = new String[] {"", "Hellhound", "Scout Sentinel Squadron", "Armoured Sentinel Squadron", "Salamander Scout Squadron"};
		Unterstützungeinträge = new String[] {"", "Renegade Militia Heavy Weapon Platoon", "Sentry Gun Battery", "Turret Emplacement", "Renegade Tank", "Close Support Artillery", "Weapon Platform", "Mine Field", "Artillery Strike"};
		LordofWar = new String[] {""};
		
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
        adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 7, LordofWar));
		cnt += CHOOSERGRUPPEN_X_ABSTAND;

		cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

		nameDerArtDerArmee = "Renegades and Heretics";
		nameDerArtDerArmeeDekliniert = "Renegades and Heretics";
		textAreaUeberschrift = "Renegades and Heretics";

		noAllies.clear();
		noAllies.add("RH");
		noAllies.add("CS");
		noAllies.add("CM");
		noAllies.add("BL");
		
		battleBrothers.add("RH");
		battleBrothers.add("CS");
		battleBrothers.add("CM");
		battleBrothers.add("BL");
		battleBrothers.add("CD");
		
		alliesOfConvenience.add("NE");
		alliesOfConvenience.add("OR");
		alliesOfConvenience.add("DM");
		alliesOfConvenience.add("DH");
		
		desperateAllies.add("DE");
		desperateAllies.add("TA");
		desperateAllies.add("FE");
		desperateAllies.add("EC");
		
		comeTheApocalypse.add("AB");
		comeTheApocalypse.add("AM");
		comeTheApocalypse.add("AS");
		comeTheApocalypse.add("BA");
		comeTheApocalypse.add("CR");
		comeTheApocalypse.add("DA");
		comeTheApocalypse.add("DK");
		comeTheApocalypse.add("DKAB");
		comeTheApocalypse.add("ED");
		comeTheApocalypse.add("GK");
		comeTheApocalypse.add("IN");
		comeTheApocalypse.add("IR");
		comeTheApocalypse.add("MT");
		comeTheApocalypse.add("SF");
		comeTheApocalypse.add("SM");
		comeTheApocalypse.add("TL");
		comeTheApocalypse.add("EL");
		comeTheApocalypse.add("TY");
		comeTheApocalypse.add("HQ");
		comeTheApocalypse.add("SY");
		comeTheApocalypse.add("DW");
		
		complete();
	}

	@Override
	protected void finalize() {
		LOGGER.info("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
	}
}