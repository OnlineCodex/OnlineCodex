package oc.wh40k.units.da;

import oc.*;

public class DAWaffenUndReliquien extends RuestkammerVater {

    OptionsUpgradeGruppe o1, o4;
    OptionsZaehlerGruppe o2, o3;
    OptionsEinzelUpgrade handwaffe = null;
    OptionsEinzelUpgrade boltpistole = null;
    OptionsEinzelUpgrade bolter = null;
    OptionsEinzelUpgrade spezialWaffe = null;
    OptionsUpgradeGruppe psiWaffe = null;

    boolean schnitterBool = false;
    boolean stimmeBool = false;
    boolean streitkolbenBool = false;
    boolean bestientöterBool = false;
    boolean leichentuchBool = false;
    boolean augeBool = false;
    boolean SkullofPetronella = false;
    boolean BladeoftheWorthy = false;
    boolean Castigator = false;
    boolean TheFontofFury = false;
    boolean ShroudoftheAntiMartyr = false;
    boolean DesvallessHolyCircle = false;
    boolean uniqueError = false;

    boolean isKompaniemeister = false; //Kompaniemeister/Absolutionspriester/Skriptor
    boolean isAbsolutionspriester = false;        //Psiwaffe, Boltpistole
    boolean isOrdenspriester = false;  //Energieaxt, Boltpistole
    boolean isSkriptor = false;      //Energiestreitkolben, Boltpistole
    boolean isTechmarine = false; //Seuchenmesser, Boltpistole, Bolter

    public DAWaffenUndReliquien() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        try {
            isKompaniemeister = defaults[0];
            isAbsolutionspriester = defaults[1];
            isOrdenspriester = defaults[2];
            isSkriptor = defaults[3];
            isTechmarine = defaults[4];
        } catch (Exception e) {
        }

        if (isKompaniemeister) {
            add(handwaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kettenschwert", 0));
            handwaffe.setSelected(true);
        } else if (isSkriptor) {
            ogE.addElement(new OptionsGruppeEintrag("Psiwaffe", 0));
            ogE.addElement(new OptionsGruppeEintrag("Psistab", 0));
            ogE.addElement(new OptionsGruppeEintrag("Psischwert", 0));
            ogE.addElement(new OptionsGruppeEintrag("Psiaxt", 0));
            add(psiWaffe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            psiWaffe.setSelected(0, true);
        } else if (isAbsolutionspriester || isOrdenspriester) {
            add(spezialWaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Crozius Arcanum", 0));
            spezialWaffe.setSelected(true);
        } else if (isTechmarine) {
            add(bolter = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bolter", 0));
            bolter.setSelected(true);
        }

        add(boltpistole = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boltpistole", 0));
        boltpistole.setSelected(true);

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
        if (isKompaniemeister) ogE.addElement(new OptionsGruppeEintrag("Ehrenklinge", 25));
        ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
        ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kombi-Gravstrahler", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Gravstrahler", 15));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Feindschnitter"), 15));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Stimme des Löwen"), 20));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Streitkolben der Erlösung"), 30));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bestientöter von Caliban"), 40));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blade of the Worthy (GS)"), 30)); // TODO NKW ersetzen
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));
        setUeberschrift("Waffen und Artefakte");

        seperator();

        if (!isOrdenspriester) {
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Leichentuch der Helden"), 10));
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Auge des Ungesehenen"), 40));
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Skull of Petronella the Pious (GS)"), 30));
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Castigator (GS)"), 15));
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("The Font of Fury (GS)"), 10));
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Shroud of the Anti-Martyr (GS)"), 35));
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Desvalles's Holy Circle (GS)"), 35));
            add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));
        }
        sizeSetzen();
    }

    @Override
    public void refreshen() {

        int nahkampfwaffen = 0;
        int fernkampfwaffen = 0;
        int artefakte = 0;
        int substractor = 0;

        boolean EcclesiarchyRelics = getCountFromInformationVector("EcclesiarchyRelics") > 0;

        if (!isOrdenspriester) {
            o1.setAktiv(!o4.isSelected());
            o4.setAktiv(!o1.isSelected());

            o4.setAktiv("Skull of Petronella the Pious (GS)", EcclesiarchyRelics && !o1.isSelected());
            o1.setAktiv("Blade of the Worthy (GS)", EcclesiarchyRelics && !o4.isSelected());
            o4.setAktiv("Castigator (GS)", EcclesiarchyRelics && !o1.isSelected());
            o4.setAktiv("The Font of Fury (GS)", EcclesiarchyRelics && !o1.isSelected());
            o4.setAktiv("Shroud of the Anti-Martyr (GS)", EcclesiarchyRelics && !o1.isSelected());
            o4.setAktiv("Desvalles's Holy Circle (GS)", EcclesiarchyRelics && !o1.isSelected());
        }

        if (isKompaniemeister) {
            if (handwaffe.isSelected() && boltpistole.isSelected()) {
                substractor = 2;
            } else if (handwaffe.isSelected() || boltpistole.isSelected()) {
                substractor = 1;
            } else if (!handwaffe.isSelected() && !boltpistole.isSelected()) {
                substractor = 0;
            }

            nahkampfwaffen = 2 - substractor - o2.getAnzahl() - o1.getAnzahl();
            fernkampfwaffen = 2 - substractor - o3.getAnzahl() - o1.getAnzahl();
            artefakte = 2 - substractor - o2.getAnzahl() - o3.getAnzahl();

            if (nahkampfwaffen < 0) nahkampfwaffen = 0;
            if (fernkampfwaffen < 0) fernkampfwaffen = 0;
            if (artefakte < 0) artefakte = 0;

            if (nahkampfwaffen > 2) nahkampfwaffen = 2;
            if (artefakte > 1) artefakte = 1;

            o3.setMaxAnzahl(nahkampfwaffen);
            o2.setMaxAnzahl(fernkampfwaffen);

            if (artefakte == 0) {
                o1.setAktiv(false);
            }
//			o1.setAktiv(artefakte>0);
            o1.setMaxAnzahl(artefakte);

            legal = ((boltpistole.isSelected() ? 1 : 0) + (handwaffe.isSelected() ? 1 : 0) + o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl()) == 2;
            boltpistole.setLegal(legal);
            handwaffe.setLegal(legal);
            o1.setLegal(legal);
            o2.setLegal(legal);
            o3.setLegal(legal);
        }

        if (isSkriptor) {
            if (!psiWaffe.isSelected()) nahkampfwaffen = 1;

            if (psiWaffe.isSelected() && boltpistole.isSelected()) {
                substractor = 2;
            } else if (psiWaffe.isSelected() || boltpistole.isSelected()) {
                substractor = 1;
            } else if (!psiWaffe.isSelected() && !boltpistole.isSelected()) {
                substractor = 0;
            }

            nahkampfwaffen = 2 - substractor - o2.getAnzahl() - o1.getAnzahl();
            fernkampfwaffen = 2 - substractor - o3.getAnzahl() - o1.getAnzahl();
            artefakte = 2 - substractor - o2.getAnzahl() - o3.getAnzahl();

            if (nahkampfwaffen < 0) nahkampfwaffen = 0;
            if (fernkampfwaffen < 0) fernkampfwaffen = 0;
            if (artefakte < 0) artefakte = 0;

            if (nahkampfwaffen > 2) nahkampfwaffen = 2;
            if (fernkampfwaffen > 2) fernkampfwaffen = 2;
            if (artefakte > 1) artefakte = 1;

            if (!boltpistole.isSelected()) {
                o2.setMaxAnzahl(fernkampfwaffen);
            } else {
                o2.setMaxAnzahl(0);
            }
            o3.setMaxAnzahl(nahkampfwaffen);
            o1.setMaxAnzahl(artefakte);

            legal = ((boltpistole.isSelected() ? 1 : 0) + (psiWaffe.isSelected() ? 1 : 0) + o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl()) == 2;
            boltpistole.setLegal(legal);
            psiWaffe.setLegal(legal);
            o1.setLegal(legal);
            o2.setLegal(legal);
            o3.setLegal(legal);
        }

        if (isAbsolutionspriester || isOrdenspriester) {

            if (spezialWaffe.isSelected() && boltpistole.isSelected()) {
                substractor = 2;
            } else if (spezialWaffe.isSelected() || boltpistole.isSelected()) {
                substractor = 1;
            } else if (!spezialWaffe.isSelected() && !boltpistole.isSelected()) {
                substractor = 0;
            }

            nahkampfwaffen = 2 - substractor - o2.getAnzahl() - o1.getAnzahl();
            fernkampfwaffen = 2 - substractor - o1.getAnzahl() - o3.getAnzahl();
            artefakte = 2 - substractor - o2.getAnzahl();

            if (nahkampfwaffen < 0) nahkampfwaffen = 0;
            if (fernkampfwaffen < 0) fernkampfwaffen = 0;
            if (artefakte < 0) artefakte = 0;

            if (nahkampfwaffen > 2) nahkampfwaffen = 2;
            if (fernkampfwaffen > 2) fernkampfwaffen = 2;
            if (artefakte > 1) artefakte = 1;

            o3.setMaxAnzahl(nahkampfwaffen);
            o2.setMaxAnzahl(fernkampfwaffen);

            if (isAbsolutionspriester) {
                if (artefakte == 0) {
                    o1.setAktiv(false);
                }
//				o1.setAktiv(artefakte>0);
                o1.setMaxAnzahl(artefakte);
            }

            if (isOrdenspriester) {
                o1.setAktiv(false);
                o1.setMaxAnzahl(0);
            }

            legal = ((boltpistole.isSelected() ? 1 : 0) + (spezialWaffe.isSelected() ? 1 : 0) + o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl()) == 2;
            boltpistole.setLegal(legal);
            spezialWaffe.setLegal(legal);
            o1.setLegal(legal);
            o2.setLegal(legal);
            o3.setLegal(legal);
        }

        if (isTechmarine) {

            if (bolter.isSelected() && boltpistole.isSelected()) {
                substractor = 2;
            } else if (bolter.isSelected() || boltpistole.isSelected()) {
                substractor = 1;
            } else if (!bolter.isSelected() && !boltpistole.isSelected()) {
                substractor = 0;
            }

            nahkampfwaffen = 2 - substractor - o2.getAnzahl() - o1.getAnzahl();
            fernkampfwaffen = 2 - substractor - o1.getAnzahl() - o3.getAnzahl();

            if (nahkampfwaffen < 0) nahkampfwaffen = 0;
            if (fernkampfwaffen < 0) fernkampfwaffen = 0;
            if (artefakte < 0) artefakte = 0;

            o3.setMaxAnzahl(nahkampfwaffen);
            o2.setMaxAnzahl(fernkampfwaffen);

            legal = ((boltpistole.isSelected() ? 1 : 0) + o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl()) == 2;
            boltpistole.setLegal(legal);
            o1.setLegal(legal);
            o2.setLegal(legal);
            o3.setLegal(legal);
        }

        //Einzigartige Gegenstände
        if (o1.isSelected("Feindschnitter")) {
            if (schnitterBool == false) {
                schnitterBool = true;
                BuildaHQ.addToInformationVectorGlobal("DASchnitter", 1);
            }
        } else if (!o1.isSelected("Feindschnitter")) {
            if (schnitterBool == true) {
                schnitterBool = false;
                BuildaHQ.addToInformationVectorGlobal("DASchnitter", -1);
            }
        }

        if (o1.isSelected("Stimme des Löwen")) {
            if (stimmeBool == false) {
                stimmeBool = true;
                BuildaHQ.addToInformationVectorGlobal("DAStimme", 1);
            }
        } else if (!o1.isSelected("Stimme des Löwen")) {
            if (stimmeBool == true) {
                stimmeBool = false;
                BuildaHQ.addToInformationVectorGlobal("DAStimme", -1);
            }
        }

        if (o1.isSelected("Streitkolben der Erlösung")) {
            if (streitkolbenBool == false) {
                streitkolbenBool = true;
                BuildaHQ.addToInformationVectorGlobal("DAStreitkolben", 1);
            }
        } else if (!o1.isSelected("Streitkolben der Erlösung")) {
            if (streitkolbenBool == true) {
                streitkolbenBool = false;
                BuildaHQ.addToInformationVectorGlobal("DAStreitkolben", -1);
            }
        }

        if (o1.isSelected("Bestientöter von Caliban")) {
            if (bestientöterBool == false) {
                bestientöterBool = true;
                BuildaHQ.addToInformationVectorGlobal("DABestientöter", 1);
            }
        } else if (!o1.isSelected("Bestientöter von Caliban")) {
            if (bestientöterBool == true) {
                bestientöterBool = false;
                BuildaHQ.addToInformationVectorGlobal("DABestientöter", -1);
            }
        }


        if (!isOrdenspriester) {
            if (o4.isSelected("Leichentuch der Helden")) {
                if (leichentuchBool == false) {
                    leichentuchBool = true;
                    BuildaHQ.addToInformationVectorGlobal("DALeichtentuch", 1);
                }
            } else if (!o4.isSelected("Leichentuch der Helden")) {
                if (leichentuchBool == true) {
                    leichentuchBool = false;
                    BuildaHQ.addToInformationVectorGlobal("DALeichtentuch", -1);
                }
            }

            if (o4.isSelected("Auge des Ungesehenen")) {
                if (augeBool == false) {
                    augeBool = true;
                    BuildaHQ.addToInformationVectorGlobal("DAAuge", 1);
                }
            } else if (!o4.isSelected("Auge des Ungesehenen")) {
                if (augeBool == true) {
                    augeBool = false;
                    BuildaHQ.addToInformationVectorGlobal("DAAuge", -1);
                }
            }

            if (o4.isSelected("Skull of Petronella the Pious (GS)")) {
                if (SkullofPetronella == false) {
                    SkullofPetronella = true;
                    BuildaHQ.addToInformationVectorGlobal("SkullofPetronella", 1);
                }
            } else if (!o4.isSelected("Skull of Petronella the Pious (GS)")) {
                if (SkullofPetronella == true) {
                    SkullofPetronella = false;
                    BuildaHQ.addToInformationVectorGlobal("SkullofPetronella", -1);
                }
            }

            if (o4.isSelected("Blade of the Worthy (GS)")) {
                if (BladeoftheWorthy == false) {
                    BladeoftheWorthy = true;
                    BuildaHQ.addToInformationVectorGlobal("BladeoftheWorthy", 1);
                }
            } else if (!o4.isSelected("Blade of the Worthy (GS)")) {
                if (BladeoftheWorthy == true) {
                    BladeoftheWorthy = false;
                    BuildaHQ.addToInformationVectorGlobal("BladeoftheWorthy", -1);
                }
            }

            if (o4.isSelected("Castigator (GS)")) {
                if (Castigator == false) {
                    Castigator = true;
                    BuildaHQ.addToInformationVectorGlobal("Castigator", 1);
                }
            } else if (!o4.isSelected("Castigator (GS)")) {
                if (Castigator == true) {
                    Castigator = false;
                    BuildaHQ.addToInformationVectorGlobal("Castigator", -1);
                }
            }

            if (o4.isSelected("The Font of Fury (GS)")) {
                if (TheFontofFury == false) {
                    TheFontofFury = true;
                    BuildaHQ.addToInformationVectorGlobal("TheFontofFury", 1);
                }
            } else if (!o4.isSelected("The Font of Fury (GS)")) {
                if (TheFontofFury == true) {
                    TheFontofFury = false;
                    BuildaHQ.addToInformationVectorGlobal("TheFontofFury", -1);
                }
            }

            if (o4.isSelected("Shroud of the Anti-Martyr (GS)")) {
                if (ShroudoftheAntiMartyr == false) {
                    ShroudoftheAntiMartyr = true;
                    BuildaHQ.addToInformationVectorGlobal("ShroudoftheAntiMartyr", 1);
                }
            } else if (!o4.isSelected("Shroud of the Anti-Martyr (GS)")) {
                if (ShroudoftheAntiMartyr == true) {
                    ShroudoftheAntiMartyr = false;
                    BuildaHQ.addToInformationVectorGlobal("ShroudoftheAntiMartyr", -1);
                }
            }
            //Desvalles's Holy Circle - 35
            if (o4.isSelected("Desvalles's Holy Circle (GS)")) {
                if (DesvallessHolyCircle == false) {
                    DesvallessHolyCircle = true;
                    BuildaHQ.addToInformationVectorGlobal("DesvallessHolyCircle", 1);
                }
            } else if (!o4.isSelected("Desvalles's Holy Circle (GS)")) {
                if (DesvallessHolyCircle == true) {
                    DesvallessHolyCircle = false;
                    BuildaHQ.addToInformationVectorGlobal("DesvallessHolyCircle", -1);
                }
            }
        }

        if (BuildaHQ.getCountFromInformationVectorGlobal("DASchnitter") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("DAStimme") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("DAStreitkolben") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("DABestientöter") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("DALeichtentuch") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("DAAuge") > 1 ||
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

        if (schnitterBool == true) {
            schnitterBool = false;
            BuildaHQ.addToInformationVectorGlobal("DASchnitter", -1);
        }

        if (stimmeBool == true) {
            stimmeBool = false;
            BuildaHQ.addToInformationVectorGlobal("DAStimme", -1);
        }

        if (streitkolbenBool == true) {
            streitkolbenBool = false;
            BuildaHQ.addToInformationVectorGlobal("DAStreitkolben", -1);
        }

        if (bestientöterBool == true) {
            bestientöterBool = false;
            BuildaHQ.addToInformationVectorGlobal("DABestientöter", -1);
        }

        if (leichentuchBool == true) {
            leichentuchBool = false;
            BuildaHQ.addToInformationVectorGlobal("DALeichtentuch", -1);
        }

        if (augeBool == true) {
            augeBool = false;
            BuildaHQ.addToInformationVectorGlobal("DAAuge", -1);
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
