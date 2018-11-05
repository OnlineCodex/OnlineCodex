package oc.wh40k.armies;


import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKGreyKnights extends BuildaVater {

    public VOLKGreyKnights() {

        reflectionKennung = "GK";

        HQeinträge = new String[]{"", "Brother-Captain", "Brother-Captain Stern", "Brotherhood Champion", "Castellan Crowe", "Librarian", "Techmarine", "Grand Master Voldus", "",
                "Belisarius Cawl", "Celestine", "Inquisitor Greyfax",
                "", "[IA4 2nd Ed] Ordo Xenos Inquisitor Solomon Lok"};
        Eliteeinträge = new String[]{"", "", "Purifier Squad", "Paladin Squad", "Dreadnought",
                "", "[IA2 2nd Ed] Doomglaive Dreadnought"};
        Standardeinträge = new String[]{"", "Strike Squad", "Terminator Squad"};
        Sturmeinträge = new String[]{"", "Rhino", "Razorback", "Interceptor Squad", "[DftS] Stormraven Gunship",
                "", "[IA Experimental] Xiphon Pattern Interceptor"};
        Unterstützungeinträge = new String[]{"", "Purgation Squad", "Nemesis Dreadknight", "Land Raider", "Land Raider Crusader", "Land Raider Redeemer",
                "", "[IA2 2nd Ed] Vortimer Pattern Land Raider Redeemer"};
        LordofWar = new String[]{"", "Kaldor Draigo", "[APO2 Armageddon] Reaver Battle Titan", "[APO2 Armageddon] Warhound-Scouttitan",
                "", "[IA2 2nd Ed] Greyknight Thunderhawk Gunship"};

        /*LoW
         * Grey Knights Thunderhawk Gunship IA: Apoc, IA2 2nd ed
         */
		
/*
	BROTHERS OF THE FLAME
	Castellan Crowe Tide of Cleansing Flame.
	5 Purifier Squads
	FORMATION RESTRICTIONS
	Each Purifier Squad must contain 10 models. They cannot split into Combat Squads, and may not have Dedicated Transports.
		
	DREADKNIGHT BRETHREN
	3-5 Nemesis Dreadknights
	
	EXTERMINATION FORCE
	1 Nemesis Dreadknight
	3-5 Stormraven Gunships
	
	FORMATION RESTRICTIONS
	The Nemesis Dreadknight must have a heavy psycannon. The Stormraven Gunships must have psybolt ammunition .

*/

        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 1, HQeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 2, Eliteeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 3, Standardeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 4, Sturmeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 5, Unterstützungeinträge));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, "FO", cnt, 0, 6, Befestigungen));
        cnt += CHOOSERGRUPPEN_X_ABSTAND;
        adden(new ChooserGruppe(this, reflectionKennung, cnt, 0, 7, LordofWar));
        cnt += 480;

        nameDerArtDerArmee = "Grey Knights";
        nameDerArtDerArmeeDekliniert = "Grey Knights";
        textAreaUeberschrift = "Grey Knights";

        noAllies.clear();
        noAllies.add("GK");

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
        battleBrothers.add("SK");
        battleBrothers.add("CU");
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

        //Verschiedene Spezialkontingente der GK
        kontingente.add("");
        kontingente.add("Nemesis Strike Force");

        //Formationen
        formationen.add("Formation");
        formationen.add("Grey Knight Brotherhood");
        formationen.add("");

        //Min/max-Auswahlen je Spezialkontingent
        int[] arr1 = {1, 0, 1, 0, 0, 0, 0, 0};
        minAuswahlen.put("Nemesis Strike Force", arr1);
        int[] arr2 = {2, 4, 4, 2, 2, 1, 1, 0};
        maxAuswahlen.put("Nemesis Strike Force", arr2);

        int[] arr3 = {3, 1, 6, 2, 3, 0, 0, 0};
        minAuswahlen.put("Grey Knight Brotherhood", arr3);
        maxAuswahlen.put("Grey Knight Brotherhood", arr3);

        complete();
    }

    @Override
    public void volkRefresh() {


        if (getKontingentTyp().equals("Grey Knight Brotherhood")) {
            setInformationVectorValue("Grey Knight Brotherhood", 1);
            myChooserGruppen.get(0).changeComboBoxAuswahlen(new String[]{"", "Brother-Captain", "Brotherhood Champion"});
            myChooserGruppen.get(1).changeComboBoxAuswahlen(new String[]{"", "Dreadnought"});
            myChooserGruppen.get(2).changeComboBoxAuswahlen(new String[]{"", "Strike Squad", "Terminator Squad"});
            myChooserGruppen.get(3).changeComboBoxAuswahlen(new String[]{"", "Interceptor Squad"});
            myChooserGruppen.get(4).changeComboBoxAuswahlen(new String[]{"", "Purgation Squad", "Nemesis Dreadknight"});
            myChooserGruppen.get(5).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(6).changeComboBoxAuswahlen(new String[]{""});
            if (!isLoading) {
                addUnit(0, "Brother-Captain");//TODO: Einer muss Grand Master sein
                addUnit(0, "Brother-Captain");
                addUnit(0, "Brotherhood Champion");
                addUnit(0, "");
                addUnit(1, "Dreadnought");
                addUnit(1, "");
                addUnit(2, "Strike Squad");
                addUnit(2, "Strike Squad");
                addUnit(2, "Strike Squad");
                addUnit(2, "Terminator Squad");
                addUnit(2, "Terminator Squad");
                addUnit(2, "Terminator Squad");
                addUnit(2, "");
                addUnit(3, "Interceptor Squad");
                addUnit(3, "Interceptor Squad");
                addUnit(3, "");
                addUnit(4, "Purgation Squad");
                addUnit(4, "Purgation Squad");
                addUnit(4, "Nemesis Dreadknight");
                addUnit(4, "");
            }
            kontingentBox.setEnabled(false);
            formationBox.setEnabled(false);
        } else {
            setInformationVectorValue("Great Company", 0);
        }

        fillChooserSpace();
    }
}