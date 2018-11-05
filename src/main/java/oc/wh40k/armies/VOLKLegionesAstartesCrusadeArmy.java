package oc.wh40k.armies;

import oc.BuildaVater;
import oc.ChooserGruppe;

public class VOLKLegionesAstartesCrusadeArmy extends BuildaVater {

    public VOLKLegionesAstartesCrusadeArmy() {
        reflectionKennung = "HHCA";

        HQeinträge = new String[]{"", "Legion Praetor", "Legion Centurion", "Chaplain", "Forge Lord", "Legion Champion", "Librarian",
                "Master of Signal", "Moritat", "Primus medicae", "Siege Breaker", "Vigilator",
                "", "Legion Command Squad",}; //(Deathguard) "Deathshroud Terminator Squad" , "Section Leader Crysos Morturg", "Marshall Durak Rask", ""
        Eliteeinträge = new String[]{"", "Legion Veteran Tactical Squad", "Legion Destroyer Squad", "Legion Terminator Squad",
                "Techmarine Covenant", "Apothecarion Detachment", "Legion Dreadnought Talon",
                "Contemptor Dreadnought Talon", "Legion Rapier Weapons Battery", "Legion Mortis Dreadnought",
                "Contemptor-Mortis Dreadnought"};
        Standardeinträge = new String[]{"", "Legion Tactical Squad", "Legion Assault Squad", "Legion Breacher Siege Squad",
                "Legion Tactical Support Squad", "Legion Reconnaissance Squad"};
        Sturmeinträge = new String[]{"", "Legion Seeker Squad", "Legion Outrider Squad", "Legion Attack Bike Squadron",
                "Legion Jetbike Sky Hunter Squadron", "Primaris-Lightning Strike Fighter",
                "Tarantula Sentry Gun Battery", "[NEW] Anvillus Pattern Dreadclav Drop Pod",
                "Legion Land Speeder Squadron", "Legion Storm Eagle Assault Gunship",
                "Legion Javelin Attack Speeder Squadron"};
        Unterstützungeinträge = new String[]{"", "Deathstorm Drop Pod", "Legion Heavy Support Squad", "Legion Predator Strike Armour Squadron",
                "Legion Land Raider Battle Squadron", "[NEW] Legion Fire Raptor Gunship",
                "[NEW] Achilles-Alpha Pattern Land Raider", "Legion Artillery Tank Squadron",
                "Legion Vindicator", "Legion Spartan Assault Tank", "Legion Caestus Assault Ram",
                "[NEW] Sicaran Venator Tank Destoyer", "Legion Sicaran Battle Tank",
                "[NEW] Legion Kharybdis Assault Claw", "Legion Whirlwind Scorpius"};
        LordofWar = new String[]{//Deathguard: "", "Mortarion the Reaper",
                "", "[NEW] Legion Stormblade Super-heavy Tank", "Legion Cerberus Heavy Tank Destroyer",
                "Legion Typhon Heavy Siege Tank", "[NEW] Legion Falchion Super-heavy Tank Destroyer",
                "Legion Malcador Assault Tank", "Legion Fellblade Super-heavy Tank",
                "Legion Glaive Super-heavy Special Weapons Tank", "Legion Thunderhawk Transporter",
                "Legion Thunderhawk Gunship"}; //? "Imperial Avenger Strike Fighter"

        Befestigungen = uniteUnitList(new String[]{"", "Imperial Castellum Stronghold", ""}, Befestigungen);

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

        //TODO Optional Heavy Support - Thallax Cohort
        //TODO Optional Heavy Support - Castellax Class Battle-automata Maniple

//		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Angel's wrath");
//		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Armoured spearhead");
//		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Orbital assault");
//		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War Pride of the Legion");
//		BuildaHQ.getChooserGruppe(1).addSpezialAuswahl("Rite of War The Reaping");
//		BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Legion Terminator Squad");
//		BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Legion Veteran Tactical Squad");
//		BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("Deathstorm Drop Pod");

        nameDerArtDerArmee = "Legiones Astartes Crusade Army";
        nameDerArtDerArmeeDekliniert = "Legiones Astartes Crusade Army";
        textAreaUeberschrift = "Legiones Astartes Crusade Army";

        //Verschiedene Spezialkontingente
        kontingente.add("");
        kontingente.add("Battles in the Age of Darkness FOC");
        kontingente.add("Optional Onslaught FOC"); //Keine Befestigungen
        kontingente.add("Optional Castellan FOC");
        kontingente.add("Optional Leviathan FOC"); //Nur LoW
        kontingente.add("Alliiertes Kontingent");

        //Min/max-Auswahlen je Spezialkontingent/Formation
        minAuswahlen.put("Battles in the Age of Darkness FOC", new int[]{1, 0, 2, 0, 0, 0, 0, 0});
        maxAuswahlen.put("Battles in the Age of Darkness FOC", new int[]{3, 4, 6, 3, 3, 1, 1, 0});

        minAuswahlen.put("Optional Onslaught FOC", new int[]{1, 0, 1, 0, 1, 0, 0, 0});
        maxAuswahlen.put("Optional Onslaught FOC", new int[]{2, 4, 4, 2, 4, 0, 2, 0});

        minAuswahlen.put("Optional Castellan FOC", new int[]{1, 0, 3, 0, 0, 1, 0, 0});
        maxAuswahlen.put("Optional Castellan FOC", new int[]{2, 2, 6, 1, 3, 4, 1, 0});

        minAuswahlen.put("Optional Leviathan FOC", new int[]{0, 0, 0, 0, 0, 1, 0, 0});
        maxAuswahlen.put("Optional Leviathan FOC", new int[]{0, 0, 0, 0, 0, 3, 1, 0});

        complete();

    }

    @Override
    public void volkRefresh() {

        if (getKontingentTyp().equals("Battles in the Age of Darkness FOC") ||
                getKontingentTyp().equals("Optional Castellan FOC") ||
                getKontingentTyp().equals("Alliiertes Kontingent")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge);
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungeinträge);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(Befestigungen);
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LordofWar);
        } else if (getKontingentTyp().equals("Optional Onslaught FOC")) {
            myChooserGruppen.get(HQ).changeComboBoxAuswahlen(HQeinträge);
            myChooserGruppen.get(EL).changeComboBoxAuswahlen(Eliteeinträge);
            myChooserGruppen.get(TR).changeComboBoxAuswahlen(Standardeinträge);
            myChooserGruppen.get(FA).changeComboBoxAuswahlen(Sturmeinträge);
            myChooserGruppen.get(HS).changeComboBoxAuswahlen(Unterstützungeinträge);
            myChooserGruppen.get(FORT).changeComboBoxAuswahlen(new String[]{""});
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LordofWar);
        } else if (getKontingentTyp().equals("Optional Leviathan FOC")) {
            clearCombo();
            myChooserGruppen.get(LOW).changeComboBoxAuswahlen(LordofWar);
        }

        if (formation != null) {
            formation.refreshControlPanel();
        }

        fillChooserSpace();
    }
}