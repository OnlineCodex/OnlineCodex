package oc.wh40k.units.sm;

import oc.*;

public class SMTerminatorwaffen extends RuestkammerVater {

    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsUpgradeGruppe o3;
    OptionsUpgradeGruppe o4;
    OptionsUpgradeGruppe o5;
    OptionsUpgradeGruppe o6;
    OptionsEinzelUpgrade handwaffe, kombibolter;
    OptionsEinzelUpgrade glaiveOfVengeance;
    OptionsEinzelUpgrade huntersEye;
    OptionsEinzelUpgrade mantleOfTheStormseer;
    OptionsEinzelUpgrade scimitarOfTheGreatKhan;
    OptionsEinzelUpgrade wraithOfTheHeavens;
    OptionsEinzelUpgrade armourOfShadows;
    OptionsEinzelUpgrade exTenebris;
    OptionsEinzelUpgrade ravenSkullofKorvaad;

    boolean isKompaniemeister = false; //E-Schwert
    boolean isOrdenspriester = false;//Crozius Arcanum
    boolean isScriptor = false; //Psi-Waffe

    boolean wrathBool = false;
    boolean teethBool = false;
    boolean shieldBool = false;
    boolean bladeBool = false;
    boolean armourBool = false;
    boolean uniqueError = false;
    boolean glaiveOfVengeanceBool = false;
    boolean huntersEyeBool = false;
    boolean mantleOfTheStormseerBool = false;
    boolean scimitarOfTheGreatKhanBool = false;
    boolean wraithOfTheHeavensBool = false;
    boolean SonsOfTheGreatKhan = false;
    boolean armourOfShadowsBool = false;
    boolean exTenebrisBool = false;
    boolean ravenSkullofKorvaadBool = false;
    boolean SonsOfCorax = false;
    boolean ClanRaukaan = false;
    boolean mindforgeBool = false;
    boolean axeBool = false;
    boolean stoneBool = false;
    boolean baneBool = false;
    boolean chainBool = false;
    boolean helmBool = false;
    boolean AngelOfSacrifice = false;
    boolean EyeofHypnoth = false;
    boolean BonesofOsrak = false; //Librarian
    boolean Spartean = false;
    boolean SentinelsOfTerra = false;
    boolean SkullofPetronella = false;
    boolean BladeoftheWorthy = false;
    boolean Castigator = false;
    boolean TheFontofFury = false;
    boolean ShroudoftheAntiMartyr = false;
    boolean DesvallessHolyCircle = false;

    public SMTerminatorwaffen() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        try {
            isKompaniemeister = defaults[0];
            isOrdenspriester = defaults[1];
            isScriptor = defaults[2];
        } catch (Exception e) {
        }

        seperator();
        if (isScriptor) {
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sturmbolter"), 5));
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombi-Flammenwerfer"), 10));
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombi-Melter"), 10));
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombi-Plasmawerfer"), 10));
            ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 10));
        } else {
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Sturmbolter"), 0));
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombi-Flammenwerfer"), 5));
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombi-Melter"), 5));
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kombi-Plasmawerfer"), 5));
            if (!isOrdenspriester) {
                ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 10));
                ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 25));
            }
        }
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        if (!isScriptor) {
            o1.setAnzahl(0, 1);
        }

        seperator();

        if (isKompaniemeister) {
            ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 0));
            ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 5));
            ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 5));
            ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 10));
            ogE.addElement(new OptionsGruppeEintrag("Kettenfaust", 15));
            ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 15));
        } else if (isOrdenspriester) {
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Crozius Arcanum"), 0));
            ogE.addElement(new OptionsGruppeEintrag("[SoT] The Angel of Sacrifice", 10)); //Chaplain instead of Crozius
        } else if (isScriptor) {
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psiwaffe"), 0));
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psischwert"), 0));
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psiaxt"), 0));
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Psistab"), 0));
        }
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        o2.setAnzahl(0, 1);
        sizeSetzen();

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Der Zorn des Primarchen", 20));
        ogE.addElement(new OptionsGruppeEintrag("Die Zähne Terras", 35));
        ogE.addElement(new OptionsGruppeEintrag("Der Schild der Ewigkeit", 50));
        ogE.addElement(new OptionsGruppeEintrag("Die Brennende Klinge", 55));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));

        cnt = randAbstand;

        if (isScriptor) {
            ogE.addElement(new OptionsGruppeEintrag("[CR] The Mindforge Stave", 15));
        }
        ogE.addElement(new OptionsGruppeEintrag("[CR] The Axe of Medusa", 25));
        ogE.addElement(new OptionsGruppeEintrag("[CR] The Ironstone", 30));
        ogE.addElement(new OptionsGruppeEintrag("[CR] Betrayer´s Bane", 25));
        ogE.addElement(new OptionsGruppeEintrag("[CR] The Gorgon´s Chain", 45));
        ogE.addElement(new OptionsGruppeEintrag("[CR] The Tempered Helm", 35));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand + 280, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("[SoT] The Eye of Hypnoth", 15));
        if (isScriptor) {
            ogE.addElement(new OptionsGruppeEintrag("[SoT] The Bones of Osrak", 25)); //Librarian
        }
        ogE.addElement(new OptionsGruppeEintrag("[SoT] The Spartean", 5));
        add(o5 = new OptionsUpgradeGruppe(ID, randAbstand + 280, cnt, "", ogE, 1));

        seperator();

        add(glaiveOfVengeance = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "[WZK] The Glaive of Vengeance", "The Glaive of Vengeance (WZ Kauyon - Sons of the Great Khan)", 30));
        add(huntersEye = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "[WZK] The Hunter's Eye", "The Hunter's Eye (WZ Kauyon - Sons of the Great Khan)", 20));
        add(mantleOfTheStormseer = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "[WZK] Mantle of the Stormseer", "Mantle of the Stormseer (WZ Kauyon - Sons of the Great Khan)", 20));
        add(scimitarOfTheGreatKhan = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "[WZK] Scimitar of the Great Khan", "Scimitar of the Great Khan (WZ Kauyon - Sons of the Great Khan)", 25));

        seperator();

        add(armourOfShadows = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "[WZK] The Armour of Shadows", "The Armour of Shadows (WZ Kauyon - Sons of Corax)", 35));
        add(exTenebris = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "[WZK] Ex Tenebris", "Ex Tenebris (WZ Kauyon - Sons of Corax)", 10));
        add(ravenSkullofKorvaad = new OptionsEinzelUpgrade(ID, randAbstand + 280, cnt, "", "[WZK] The Raven Skull of Korvaad", "The Raven Skull of Korvaad (WZ Kauyon - Sons of Corax)", 15));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Skull of Petronella the Pious (GS)"), 30));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blade of the Worthy (GS)"), 30)); // TODO NKW ersetzen
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Castigator (GS)"), 15));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("The Font of Fury (GS)"), 10));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Shroud of the Anti-Martyr (GS)"), 35));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Desvalles's Holy Circle (GS)"), 35));
        add(o6 = new OptionsUpgradeGruppe(ID, randAbstand + 280, cnt, "", ogE, 1));

        sizeSetzen();

        setUeberschrift("Termiwaffen und Artefakte");
        sizeSetzen();
    }

    @Override
    public void refreshen() {
        int nahkampfwaffen = 0;
        int fernkampfwaffen = 0;
        int artefakte = 0;


        boolean EcclesiarchyRelics = getCountFromInformationVector("EcclesiarchyRelics") > 0;

        o6.setAktiv("Skull of Petronella the Pious (GS)", EcclesiarchyRelics);
        o6.setAktiv("Blade of the Worthy (GS)", EcclesiarchyRelics);
        o6.setAktiv("Castigator (GS)", EcclesiarchyRelics);
        o6.setAktiv("The Font of Fury (GS)", EcclesiarchyRelics);
        o6.setAktiv("Shroud of the Anti-Martyr (GS)", EcclesiarchyRelics);
        o6.setAktiv("Desvalles's Holy Circle (GS)", EcclesiarchyRelics);

        if (o3 != null && o4 != null && o5 != null) {
            if (ClanRaukaan) {
                o3.setAktiv(false);
                o4.setAktiv(true);
                o5.setAktiv(false);
                if (isOrdenspriester) {
                    o2.setAktiv("[SoT] The Angel of Sacrifice", false);
                }
            } else if (SentinelsOfTerra) {
                o3.setAktiv(false);
                o4.setAktiv(false);
                o5.setAktiv(true);
                if (isOrdenspriester) {
                    o2.setAktiv("[SoT] The Angel of Sacrifice", true);
                }
            } else {
                o3.setAktiv(true);
                o4.setAktiv(false);
                o5.setAktiv(false);
                if (isOrdenspriester) {
                    o2.setAktiv("[SoT] The Angel of Sacrifice", false);
                }
            }
        }

        if (isScriptor) {

            o1.setMaxAnzahl((o2.isSelected() && o3.isSelected()) ? 0 : 1);
            o2.setMaxAnzahl((o1.isSelected() && o3.isSelected()) ? 0 : 1);
            o3.setMaxAnzahl((o2.isSelected() && o1.isSelected()) ? 0 : 1);

            if (o2.isSelected()) {
                o3.setPreis("Der Zorn des Primarchen", 25);
                o3.setPreis("Die Zähne Terras", 40);
                o3.setPreis("Der Schild der Ewigkeit", 55);
                o3.setPreis("Die Brennende Klinge", 60);
            } else {
                o3.setPreis("Der Zorn des Primarchen", 20);
                o3.setPreis("Die Zähne Terras", 35);
                o3.setPreis("Der Schild der Ewigkeit", 50);
                o3.setPreis("Die Brennende Klinge", 55);
            }

            o2.setLegal(o2.isSelected() || o3.isSelected());
            o3.setLegal(o2.isSelected() || o3.isSelected());

        } else {
            nahkampfwaffen = 2 - o2.getAnzahl() - o3.getAnzahl();
            fernkampfwaffen = 2 - o3.getAnzahl() - o1.getAnzahl();
            artefakte = 2 - o2.getAnzahl() - o1.getAnzahl();

            if (nahkampfwaffen < 0) nahkampfwaffen = 0;
            if (fernkampfwaffen < 0) fernkampfwaffen = 0;
            if (artefakte < 0) artefakte = 0;

            if (fernkampfwaffen > 1) fernkampfwaffen = 1;
            if (artefakte > 1) artefakte = 1;

            o3.setMaxAnzahl(nahkampfwaffen);
            o2.setMaxAnzahl(fernkampfwaffen);

            o1.setAktiv(artefakte > 0);
            o1.setMaxAnzahl(artefakte);

            legal = o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl() == 2;
            o1.setLegal(legal);
            o2.setLegal(legal);
            o3.setLegal(legal);
        }

        glaiveOfVengeance.setAktiv(SonsOfTheGreatKhan);
        huntersEye.setAktiv(SonsOfTheGreatKhan);
        mantleOfTheStormseer.setAktiv(SonsOfTheGreatKhan && isScriptor);
        scimitarOfTheGreatKhan.setAktiv(SonsOfTheGreatKhan);

        //Einzigartige Gegenstände
        if (o1.isSelected("Der Zorn des Primarchen")) {
            if (wrathBool == false) {
                wrathBool = true;
                BuildaHQ.addToInformationVectorGlobal("SMWrath", 1);
            }
        } else if (!o1.isSelected("Der Zorn des Primarchen")) {
            if (wrathBool == true) {
                wrathBool = false;
                BuildaHQ.addToInformationVectorGlobal("SMWrath", -1);
            }
        }

        if (o1.isSelected("Die Zähne Terras")) {
            if (teethBool == false) {
                teethBool = true;
                BuildaHQ.addToInformationVectorGlobal("SMTeeth", 1);
            }
        } else if (!o1.isSelected("Die Zähne Terras")) {
            if (teethBool == true) {
                teethBool = false;
                BuildaHQ.addToInformationVectorGlobal("SMTeeth", -1);
            }
        }

        if (o1.isSelected("Der Schild der Ewigkeit")) {
            if (shieldBool == false) {
                shieldBool = true;
                BuildaHQ.addToInformationVectorGlobal("SMShield", 1);
            }
        } else if (!o1.isSelected("Der Schild der Ewigkeit")) {
            if (shieldBool == true) {
                shieldBool = false;
                BuildaHQ.addToInformationVectorGlobal("SMShield", -1);
            }
        }

        if (o1.isSelected("Die Brennende Klinge")) {
            if (bladeBool == false) {
                bladeBool = true;
                BuildaHQ.addToInformationVectorGlobal("SMBlade", 1);
            }
        } else if (!o1.isSelected("Die Brennende Klinge")) {
            if (bladeBool == true) {
                bladeBool = false;
                BuildaHQ.addToInformationVectorGlobal("SMBlade", -1);
            }
        }

        if (glaiveOfVengeance.isSelected()) {
            if (glaiveOfVengeanceBool == false) {
                glaiveOfVengeanceBool = true;
                BuildaHQ.addToInformationVectorGlobal("SMglaiveOfVengeance", 1);
            }
        } else if (!glaiveOfVengeance.isSelected()) {
            if (glaiveOfVengeanceBool == true) {
                glaiveOfVengeanceBool = false;
                BuildaHQ.addToInformationVectorGlobal("SMglaiveOfVengeance", -1);
            }
        }

        if (huntersEye.isSelected()) {
            if (huntersEyeBool == false) {
                huntersEyeBool = true;
                BuildaHQ.addToInformationVectorGlobal("SMhuntersEye", 1);
            }
        } else if (!huntersEye.isSelected()) {
            if (huntersEyeBool == true) {
                huntersEyeBool = false;
                BuildaHQ.addToInformationVectorGlobal("SMhuntersEye", -1);
            }
        }

        if (mantleOfTheStormseer.isSelected()) {
            if (mantleOfTheStormseerBool == false) {
                mantleOfTheStormseerBool = true;
                BuildaHQ.addToInformationVectorGlobal("SMmantleOfTheStormseer", 1);
            }
        } else if (!mantleOfTheStormseer.isSelected()) {
            if (mantleOfTheStormseerBool == true) {
                mantleOfTheStormseerBool = false;
                BuildaHQ.addToInformationVectorGlobal("SMmantleOfTheStormseer", -1);
            }
        }

        if (scimitarOfTheGreatKhan.isSelected()) {
            if (scimitarOfTheGreatKhanBool == false) {
                scimitarOfTheGreatKhanBool = true;
                BuildaHQ.addToInformationVectorGlobal("SMscimitarOfTheGreatKhan", 1);
            }
        } else if (!scimitarOfTheGreatKhan.isSelected()) {
            if (scimitarOfTheGreatKhanBool == true) {
                scimitarOfTheGreatKhanBool = false;
                BuildaHQ.addToInformationVectorGlobal("SMscimitarOfTheGreatKhan", -1);
            }
        }

        if (armourOfShadows.isSelected()) {
            if (armourOfShadowsBool == false) {
                armourOfShadowsBool = true;
                BuildaHQ.addToInformationVectorGlobal("SMarmourOfShadows", 1);
            }
        } else if (!armourOfShadows.isSelected()) {
            if (armourOfShadowsBool == true) {
                armourOfShadowsBool = false;
                BuildaHQ.addToInformationVectorGlobal("SMarmourOfShadows", -1);
            }
        }

        if (exTenebris.isSelected()) {
            if (exTenebrisBool == false) {
                exTenebrisBool = true;
                BuildaHQ.addToInformationVectorGlobal("SMexTenebris", 1);
            }
        } else if (!exTenebris.isSelected()) {
            if (exTenebrisBool == true) {
                exTenebrisBool = false;
                BuildaHQ.addToInformationVectorGlobal("SMexTenebris", -1);
            }
        }

        if (ravenSkullofKorvaad.isSelected()) {
            if (ravenSkullofKorvaadBool == false) {
                ravenSkullofKorvaadBool = true;
                BuildaHQ.addToInformationVectorGlobal("SMravenSkullofKorvaad", 1);
            }
        } else if (!ravenSkullofKorvaad.isSelected()) {
            if (ravenSkullofKorvaadBool == true) {
                ravenSkullofKorvaadBool = false;
                BuildaHQ.addToInformationVectorGlobal("SMravenSkullofKorvaad", -1);
            }
        }

        if (o4.isSelected("The Mindforge Stave")) {
            if (mindforgeBool == false) {
                mindforgeBool = true;
                BuildaHQ.addToInformationVectorGlobal("SMMind", 1);
            }
        } else if (!o4.isSelected("The Mindforge Stave")) {
            if (mindforgeBool == true) {
                mindforgeBool = false;
                BuildaHQ.addToInformationVectorGlobal("SMMind", -1);
            }
        }

        if (o4.isSelected("The Axe of Medusa")) {
            if (axeBool == false) {
                axeBool = true;
                BuildaHQ.addToInformationVectorGlobal("SMAxe", 1);
            }
        } else if (!o4.isSelected("The Axe of Medusa")) {
            if (axeBool == true) {
                axeBool = false;
                BuildaHQ.addToInformationVectorGlobal("SMAxe", -1);
            }
        }

        if (o4.isSelected("The Ironstone")) {
            if (stoneBool == false) {
                stoneBool = true;
                BuildaHQ.addToInformationVectorGlobal("SMStone", 1);
            }
        } else if (!o4.isSelected("The Ironstone")) {
            if (stoneBool == true) {
                stoneBool = false;
                BuildaHQ.addToInformationVectorGlobal("SMStone", -1);
            }
        }

        if (o4.isSelected("Betrayer´s Bane")) {
            if (baneBool == false) {
                baneBool = true;
                BuildaHQ.addToInformationVectorGlobal("SMBane", 1);
            }
        } else if (!o4.isSelected("Betrayer´s Bane")) {
            if (baneBool == true) {
                baneBool = false;
                BuildaHQ.addToInformationVectorGlobal("SMBane", -1);
            }
        }

        if (o4.isSelected("The Gorgon´s Chain")) {
            if (chainBool == false) {
                chainBool = true;
                BuildaHQ.addToInformationVectorGlobal("SMChain", 1);
            }
        } else if (!o4.isSelected("The Gorgon´s Chain")) {
            if (chainBool == true) {
                chainBool = false;
                BuildaHQ.addToInformationVectorGlobal("SMChain", -1);
            }
        }

        if (o4.isSelected("The Tempered Helm")) {
            if (helmBool == false) {
                helmBool = true;
                BuildaHQ.addToInformationVectorGlobal("SMHelm", 1);
            }
        } else if (!o4.isSelected("The Tempered Helm")) {
            if (helmBool == true) {
                helmBool = false;
                BuildaHQ.addToInformationVectorGlobal("SMHelm", -1);
            }
        }

        if (o2.isSelected("[SoT] The Angel of Sacrifice")) {
            if (AngelOfSacrifice == false) {
                AngelOfSacrifice = true;
                BuildaHQ.addToInformationVectorGlobal("SMAngelOfSacrifice", 1);
            }
        } else if (!o2.isSelected("[SoT] The Angel of Sacrifice")) {
            if (AngelOfSacrifice == true) {
                AngelOfSacrifice = false;
                BuildaHQ.addToInformationVectorGlobal("SMAngelOfSacrifice", -1);
            }
        }

        if (o5.isSelected("[SoT] The Eye of Hypnoth")) {
            if (EyeofHypnoth == false) {
                EyeofHypnoth = true;
                BuildaHQ.addToInformationVectorGlobal("SMEyeofHypnoth", 1);
            }
        } else if (!o5.isSelected("[SoT] The Eye of Hypnoth")) {
            if (EyeofHypnoth == true) {
                EyeofHypnoth = false;
                BuildaHQ.addToInformationVectorGlobal("SMEyeofHypnoth", -1);
            }
        }

        if (o5.isSelected("[SoT] The Bones of Osrak")) {
            if (BonesofOsrak == false) {
                BonesofOsrak = true;
                BuildaHQ.addToInformationVectorGlobal("SMBonesofOsrak", 1);
            }
        } else if (!o5.isSelected("[SoT] The Bones of Osrak")) {
            if (BonesofOsrak == true) {
                BonesofOsrak = false;
                BuildaHQ.addToInformationVectorGlobal("SMBonesofOsrak", -1);
            }
        }

        if (o5.isSelected("[SoT] The Spartean")) {
            if (Spartean == false) {
                Spartean = true;
                BuildaHQ.addToInformationVectorGlobal("SMSpartean", 1);
            }
        } else if (!o5.isSelected("[SoT] The Spartean")) {
            if (Spartean == true) {
                Spartean = false;
                BuildaHQ.addToInformationVectorGlobal("SMSpartean", -1);
            }
        }

        if (o6.isSelected("Skull of Petronella the Pious (GS)")) {
            if (SkullofPetronella == false) {
                SkullofPetronella = true;
                BuildaHQ.addToInformationVectorGlobal("SkullofPetronella", 1);
            }
        } else if (!o6.isSelected("Skull of Petronella the Pious (GS)")) {
            if (SkullofPetronella == true) {
                SkullofPetronella = false;
                BuildaHQ.addToInformationVectorGlobal("SkullofPetronella", -1);
            }
        }

        if (o6.isSelected("Blade of the Worthy (GS)")) {
            if (BladeoftheWorthy == false) {
                BladeoftheWorthy = true;
                BuildaHQ.addToInformationVectorGlobal("BladeoftheWorthy", 1);
            }
        } else if (!o6.isSelected("Blade of the Worthy (GS)")) {
            if (BladeoftheWorthy == true) {
                BladeoftheWorthy = false;
                BuildaHQ.addToInformationVectorGlobal("BladeoftheWorthy", -1);
            }
        }

        if (o6.isSelected("Castigator (GS)")) {
            if (Castigator == false) {
                Castigator = true;
                BuildaHQ.addToInformationVectorGlobal("Castigator", 1);
            }
        } else if (!o6.isSelected("Castigator (GS)")) {
            if (Castigator == true) {
                Castigator = false;
                BuildaHQ.addToInformationVectorGlobal("Castigator", -1);
            }
        }

        if (o6.isSelected("The Font of Fury (GS)")) {
            if (TheFontofFury == false) {
                TheFontofFury = true;
                BuildaHQ.addToInformationVectorGlobal("TheFontofFury", 1);
            }
        } else if (!o6.isSelected("The Font of Fury (GS)")) {
            if (TheFontofFury == true) {
                TheFontofFury = false;
                BuildaHQ.addToInformationVectorGlobal("TheFontofFury", -1);
            }
        }

        if (o6.isSelected("Shroud of the Anti-Martyr (GS)")) {
            if (ShroudoftheAntiMartyr == false) {
                ShroudoftheAntiMartyr = true;
                BuildaHQ.addToInformationVectorGlobal("ShroudoftheAntiMartyr", 1);
            }
        } else if (!o6.isSelected("Shroud of the Anti-Martyr (GS)")) {
            if (ShroudoftheAntiMartyr == true) {
                ShroudoftheAntiMartyr = false;
                BuildaHQ.addToInformationVectorGlobal("ShroudoftheAntiMartyr", -1);
            }
        }
        //Desvalles's Holy Circle - 35
        if (o6.isSelected("Desvalles's Holy Circle (GS)")) {
            if (DesvallessHolyCircle == false) {
                DesvallessHolyCircle = true;
                BuildaHQ.addToInformationVectorGlobal("DesvallessHolyCircle", 1);
            }
        } else if (!o6.isSelected("Desvalles's Holy Circle (GS)")) {
            if (DesvallessHolyCircle == true) {
                DesvallessHolyCircle = false;
                BuildaHQ.addToInformationVectorGlobal("DesvallessHolyCircle", -1);
            }
        }

        if (BuildaHQ.getCountFromInformationVectorGlobal("SMWrath") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMTeeth") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMShield") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMBlade") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMArmour") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMglaiveOfVengeance") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMhuntersEye") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMmantleOfTheStormseer") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMscimitarOfTheGreatKhan") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMarmourOfShadows") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMexTenebris") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMravenSkullofKorvaad") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMMind") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMAxe") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMStone") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMBane") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMChain") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMHelm") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMAngelOfSacrifice") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMEyeofHypnoth") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMBonesofOsrak") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SMSpartean") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("SkullofPetronella") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("BladeoftheWorthy") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("Castigator") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("TheFontofFury") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("ShroudoftheAntiMartyr") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("DesvallessHolyCircle") > 1) {
            uniqueError = true;
        } else {
            uniqueError = false;
        }
    }

    @Override
    public Object getSpecialValue() {
        return 0;
    }

    @Override
    public void switchEntry(String name, boolean aktiv) {
        boolean entrySwitched = false;

        if (entrySwitched) {
            //Aktualisisert alle Einträge, auch die, welche diese Rüstkammer enthält.
            //Sonst werden dort zwar beim abwählen von Malen die Punkte korrekt berechnet,
            //der Text aber nicht aktualisiert.
            RefreshListener.fireRefresh();
        }
    }

    @Override
    public void deleteYourself() {

        if (AngelOfSacrifice == true) {
            AngelOfSacrifice = false;
            BuildaHQ.addToInformationVectorGlobal("SMAngelOfSacrifice", -1);
        }

        if (EyeofHypnoth == true) {
            EyeofHypnoth = false;
            BuildaHQ.addToInformationVectorGlobal("SMEyeofHypnoth", -1);
        }

        if (BonesofOsrak == true) {
            BonesofOsrak = false;
            BuildaHQ.addToInformationVectorGlobal("SMBonesofOsrak", -1);
        }

        if (Spartean == true) {
            Spartean = false;
            BuildaHQ.addToInformationVectorGlobal("SMSpartean", -1);
        }

        if (wrathBool == true) {
            wrathBool = false;
            BuildaHQ.addToInformationVectorGlobal("SMWrath", -1);
        }

        if (teethBool == true) {
            teethBool = false;
            BuildaHQ.addToInformationVectorGlobal("SMTeeth", -1);
        }

        if (shieldBool == true) {
            shieldBool = false;
            BuildaHQ.addToInformationVectorGlobal("SMShield", -1);
        }

        if (bladeBool == true) {
            bladeBool = false;
            BuildaHQ.addToInformationVectorGlobal("SMBlade", -1);
        }

        if (armourBool == true) {
            armourBool = false;
            BuildaHQ.addToInformationVectorGlobal("SMArmour", -1);
        }

        if (glaiveOfVengeanceBool == true) {
            glaiveOfVengeanceBool = false;
            BuildaHQ.addToInformationVectorGlobal("SMglaiveOfVengeance", -1);
        }

        if (huntersEyeBool == true) {
            huntersEyeBool = false;
            BuildaHQ.addToInformationVectorGlobal("SMhuntersEye", -1);
        }

        if (mantleOfTheStormseerBool == true) {
            mantleOfTheStormseerBool = false;
            BuildaHQ.addToInformationVectorGlobal("SMmantleOfTheStormseer", -1);
        }

        if (scimitarOfTheGreatKhanBool == true) {
            scimitarOfTheGreatKhanBool = false;
            BuildaHQ.addToInformationVectorGlobal("SMscimitarOfTheGreatKhan", -1);
        }

        if (armourOfShadowsBool == true) {
            armourOfShadowsBool = false;
            BuildaHQ.addToInformationVectorGlobal("SMarmourOfShadows", -1);
        }

        if (exTenebrisBool == true) {
            exTenebrisBool = false;
            BuildaHQ.addToInformationVectorGlobal("SMexTenebris", -1);
        }

        if (ravenSkullofKorvaadBool == true) {
            ravenSkullofKorvaadBool = false;
            BuildaHQ.addToInformationVectorGlobal("SMravenSkullofKorvaad", -1);
        }

        if (SkullofPetronella == true) {
            SkullofPetronella = false;
            BuildaHQ.addToInformationVectorGlobal("SkullofPetronella", -1);
        }

        if (BladeoftheWorthy == true) {
            BladeoftheWorthy = false;
            BuildaHQ.addToInformationVectorGlobal("BladeoftheWorthy", -1);
        }

        if (Castigator == true) {
            Castigator = false;
            BuildaHQ.addToInformationVectorGlobal("Castigator", -1);
        }

        if (TheFontofFury == true) {
            TheFontofFury = false;
            BuildaHQ.addToInformationVectorGlobal("TheFontofFury", -1);
        }

        if (ShroudoftheAntiMartyr == true) {
            ShroudoftheAntiMartyr = false;
            BuildaHQ.addToInformationVectorGlobal("ShroudoftheAntiMartyr", -1);
        }

        if (DesvallessHolyCircle == true) {
            DesvallessHolyCircle = false;
            BuildaHQ.addToInformationVectorGlobal("DesvallessHolyCircle", -1);
        }

        super.deleteYourself();
    }

}
