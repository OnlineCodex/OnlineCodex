package oc.wh40k.armies;

import java.util.Vector;

import oc.BuildaHQ;
import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKDarkHarvestIA12 extends BuildaVater {

    public VOLKDarkHarvestIA12() {
        reflectionKennung = "DH";

        BuildaHQ.Items = new Vector<String>();

        HQeinträge = new String[] {"", "Maynarkh Overlord", "Destruktor-Lord","Royal Court of Maynarkh", "", "Kutlakh the World Killer", "Toholk the Blinded"};
        Eliteeinträge = new String[] {"", "Canoptek Tomb Stalker", "Charnel Lychguard", "Eliminatoren", "Prätorianer des Triarchats", "Jagdläufer des Triarchats"};
        Standardeinträge = new String[] {"", "Maynarkh Warrior Phalanx", "Maynarkh Flayed One Pack", "Maynarkh Immortals"};
        Sturmeinträge = new String[] {"","Canoptek Acanthrites", "Kanoptech-Phantome", "Exovenatoren", "Destruktoren", "Maynarkh Canoptek Scarab Swarms", "Canoptek Tomb Sentinel"};
        Unterstützungeinträge = new String[] {"", "Tesseract Ark", "Sentry Pylon", "Nightshroud Bomber", "Dominator-Barke", "Annihilator-Gleiter", "Monolith", "Kanoptech-Spinnen", "[DftS] Todessichel"};
        Befestigungen= uniteUnitList(Befestigungen, new String[]{"", "Necron Tomb Citadel", "Necron Tomb Fortress","Necron City of the Dead"});
        LordofWar = new String[] {"", "[LoW]Gauss Pylon"};
//        Formationen = new String[] {"", "[IA APO 2013] Gauss Pylon Network"};

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
        if (oc.OnlineCodex.getInstance().isApo()) {
        	cnt += CHOOSERGRUPPEN_X_ABSTAND;
            adden(new ChooserGruppe(this,reflectionKennung, cnt, 0, 7, LordofWar));
//            cnt += CHOOSERGRUPPEN_X_ABSTAND;
//            adden(new ChooserGruppe(this,"FORM", cnt, 0, 8, Formationen));
        }
        cnt += CHOOSERGRUPPEN_X_ABSTAND;

        cnt += CHOOSERGRUPPEN_TEXTAREA_ZUSATZABSTAND;

        nameDerArtDerArmee = "Dark Harvest Army";
        nameDerArtDerArmeeDekliniert = "Dark Harvest Army";
        textAreaUeberschrift = "Dark Harvest Army";

        noAllies.clear();
        
        noAllies.add("NE");
    	noAllies.add("DH");
		noAllies.add("EC");
    	
    	battleBrothers.add("NE");
    	battleBrothers.add("DH");

    	alliesOfConvenience.add("CM");
    	alliesOfConvenience.add("CS");
		alliesOfConvenience.add("BL");
		alliesOfConvenience.add("RH");

		desperateAllies.add("OR");
		desperateAllies.add("DM");
		
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
		comeTheApocalypse.add("CD");
		comeTheApocalypse.add("DE");
		comeTheApocalypse.add("EL");
		comeTheApocalypse.add("FE");
		comeTheApocalypse.add("TA");
		comeTheApocalypse.add("TY");
		comeTheApocalypse.add("HQ");
		comeTheApocalypse.add("SY");
		comeTheApocalypse.add("DW");
        
        complete();
    }

    @Override
    protected void finalize() {
        System.out.println("Object gelöscht in " + nameDerArtDerArmee + "Builda !!");
    }
}