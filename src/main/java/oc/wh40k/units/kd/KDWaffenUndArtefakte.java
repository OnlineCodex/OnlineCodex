package oc.wh40k.units.kd;

import oc.*;

public class KDWaffenUndArtefakte extends RuestkammerVater {

    OptionsUpgradeGruppe o1, o4;
    OptionsZaehlerGruppe o2, o3;
    OptionsEinzelUpgrade handwaffe = null;
    OptionsEinzelUpgrade boltpistole = null;
    OptionsEinzelUpgrade bolter = null;
    OptionsEinzelUpgrade spezialWaffe = null;
    boolean runeBool = false;
    boolean rüstungBool = false;
    boolean helmBool = false;
    boolean goreBool = false;
    boolean schwertBool = false;
    boolean axtBool = false;
    boolean uniqueError = false;

    boolean isLord = false; //Handwaffe, Boltpistole
    boolean isTermi = false;        //Psiwaffe, Boltpistole
    boolean isDaemonPrince = false;  //Energieaxt, Boltpistole
    boolean isHerald = false;      //Energiestreitkolben, Boltpistole
    boolean isBloodthrone = false; //Seuchenmesser, Boltpistole, Bolter


    public KDWaffenUndArtefakte() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        try {
            // lord, termi, dp, herald, bloodthrone
            isLord = defaults[0];
            isTermi = defaults[1];
            isDaemonPrince = defaults[2];
            isHerald = defaults[3];
            isBloodthrone = defaults[4];
        } catch (Exception e) {
        }

        if (isLord || isDaemonPrince) {
            add(handwaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Handwaffe", 0));
            handwaffe.setSelected(true);
        }
        if (isHerald || isBloodthrone) {
            add(handwaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hellblade", 0));
            handwaffe.setSelected(true);
        }

        if (isLord) {
            add(boltpistole = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boltpistole", 0));
            boltpistole.setSelected(true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Kettenaxt", 8));
            ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
            ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
            ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 15));
            ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 15));
            ogE.addElement(new OptionsGruppeEintrag("Energielanze", 15));
            ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 15));
            ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
            ogE.addElement(new OptionsGruppeEintrag("Axt des Khorne", 30));
            add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Kombibolter", 3));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
            add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        }

        seperator();

        if (isLord || isDaemonPrince)
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Goredrinker"), 30));

        ogE.addElement(new OptionsGruppeEintrag("Schwert des Blutvergiesens", "Schwert des ewigen Blutvergiesens", 35));

        if (isLord || isDaemonPrince)
            ogE.addElement(new OptionsGruppeEintrag("Kor'lath", "Kor'lath, die Axt der Zerstörung", 60));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bronze Rune"), 15));

        if (isLord)
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schädelhelm des Khorne"), 15));

        if ((isLord || isDaemonPrince) && !isTermi)
            ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blutgeschmiedete Rüstung"), 50));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        setUeberschrift("Waffen und Artefakte");
        sizeSetzen();
    }

    @Override
    public void refreshen() {

        int nahkampfwaffen = 0;
        int fernkampfwaffen = 0;
        int artefakte = 0;
        int substractor = 0;

        if (isLord) {
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

            if (fernkampfwaffen > 1) fernkampfwaffen = 1;
            if (artefakte > 1) artefakte = 1;

            o3.setMaxAnzahl(nahkampfwaffen);
            o2.setMaxAnzahl(fernkampfwaffen);

            legal = ((boltpistole.isSelected() ? 1 : 0) + (handwaffe.isSelected() ? 1 : 0) + o1.getAnzahl() + o2.getAnzahl() + o3.getAnzahl()) == 2;
            boltpistole.setLegal(legal);
            handwaffe.setLegal(legal);
            o1.setLegal(legal);
            o2.setLegal(legal);
            o3.setLegal(legal);
        }

        if (isDaemonPrince || isHerald || isBloodthrone) {
            if (!handwaffe.isSelected()) {
                artefakte = 1;
            } else {
                artefakte = 0;
                if (o1.isSelected()) {
                    int index = o1.getSelectedIndex();
                    o1.setSelected(index, false);
                }
            }

            legal = ((handwaffe.isSelected() ? 1 : 0) + o1.getAnzahl()) == 1;
            handwaffe.setLegal(legal);
            o1.setLegal(legal);
        }

        //Einzigartige Gegenstände
        if (o1.isSelected("Bronze Rune")) {
            if (runeBool == false) {
                runeBool = true;
                BuildaHQ.addToInformationVectorGlobal("KDRune", 1);
            }
        } else if (!o1.isSelected("Bronze Rune")) {
            if (runeBool == true) {
                runeBool = false;
                BuildaHQ.addToInformationVectorGlobal("KDRune", -1);
            }
        }

        if (o1.isSelected("Blutgeschmiedete Rüstung")) {
            if (rüstungBool == false) {
                rüstungBool = true;
                BuildaHQ.addToInformationVectorGlobal("KDRüstung", 1);
            }
        } else if (!o1.isSelected("Blutgeschmiedete Rüstung")) {
            if (rüstungBool == true) {
                rüstungBool = false;
                BuildaHQ.addToInformationVectorGlobal("KDRüstung", -1);
            }
        }

        if (o1.isSelected("Schädelhelm des Khorne")) {
            if (helmBool == false) {
                helmBool = true;
                BuildaHQ.addToInformationVectorGlobal("KDHelm", 1);
            }
        } else if (!o1.isSelected("Schädelhelm des Khorne")) {
            if (helmBool == true) {
                helmBool = false;
                BuildaHQ.addToInformationVectorGlobal("KDHelm", -1);
            }
        }

        if (o4.isSelected("Goredrinker")) {
            if (goreBool == false) {
                goreBool = true;
                BuildaHQ.addToInformationVectorGlobal("KDGore", 1);
            }
        } else if (!o4.isSelected("Goredrinker")) {
            if (goreBool == true) {
                goreBool = false;
                BuildaHQ.addToInformationVectorGlobal("KDGore", -1);
            }
        }

        if (o4.isSelected("Schwert des Blutvergiesens")) {
            if (schwertBool == false) {
                schwertBool = true;
                BuildaHQ.addToInformationVectorGlobal("KDSchwert", 1);
            }
        } else if (!o4.isSelected("Schwert des Blutvergiesens")) {
            if (schwertBool == true) {
                schwertBool = false;
                BuildaHQ.addToInformationVectorGlobal("KDSchwert", -1);
            }
        }

        if (o4.isSelected("Kor'lath")) {
            if (axtBool == false) {
                axtBool = true;
                BuildaHQ.addToInformationVectorGlobal("KDAxt", 1);
            }
        } else if (!o4.isSelected("Kor'lath")) {
            if (axtBool == true) {
                axtBool = false;
                BuildaHQ.addToInformationVectorGlobal("KDAxt", -1);
            }
        }


        if (BuildaHQ.getCountFromInformationVectorGlobal("KDRune") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("KDHelm") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("KDRüstung") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("KDGore") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("KDSchwert") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("KDAxt") > 1) {
            uniqueError = true;
        } else {
            uniqueError = false;
        }

        o1.setAktiv(!o4.isSelected());
        o4.setAktiv(!o1.isSelected());
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

        if (runeBool == true) {
            runeBool = false;
            BuildaHQ.addToInformationVectorGlobal("KDRune", -1);
        }

        if (helmBool == true) {
            helmBool = false;
            BuildaHQ.addToInformationVectorGlobal("KDHelm", -1);
        }

        if (rüstungBool == true) {
            rüstungBool = false;
            BuildaHQ.addToInformationVectorGlobal("KDRüstung", -1);
        }

        if (goreBool == true) {
            goreBool = false;
            BuildaHQ.addToInformationVectorGlobal("KDGore", -1);
        }

        if (schwertBool == true) {
            schwertBool = false;
            BuildaHQ.addToInformationVectorGlobal("KDSchwert", -1);
        }

        if (axtBool == true) {
            axtBool = false;
            BuildaHQ.addToInformationVectorGlobal("KDAxt", -1);
        }

        super.deleteYourself();
    }

}
