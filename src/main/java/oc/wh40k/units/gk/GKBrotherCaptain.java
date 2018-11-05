package oc.wh40k.units.gk;

import oc.*;

public class GKBrotherCaptain extends Eintrag {
    //TODO Ausrüstung in eine Kammer verlegen. Artefakte richtig handhaben
    OptionsUpgradeGruppe o1, o1x;
    OptionsUpgradeGruppe o2, reliquien;
    boolean grandmasterBool;
    OptionsEinzelUpgrade grandmaster;

    public GKBrotherCaptain() {
        name = "Brother Captain";
        grundkosten = 150;

        add(ico = new oc.Picture("oc/wh40k/images/GKBruderCaptainderGreyKnights.jpg"));
        addToInformationVector("GKHQ", 1);

        seperator();

        add(grandmaster = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grand Master", 35));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Erlöser-Flammenwerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Psipulser", 15));
        ogE.addElement(new OptionsGruppeEintrag("Psibolter", 20));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Psischwert", "Nemesis-Psischwert", 0));
        ogE.addElement(new OptionsGruppeEintrag("Psihellebarde", "Nemesis-Psihellebarde", 2));
        ogE.addElement(new OptionsGruppeEintrag("Falchions", "Paar Nemesis-Falchions", 4));
        ogE.addElement(new OptionsGruppeEintrag("Wehrstab", "Nemesis-Wehrstab", 5));
        ogE.addElement(new OptionsGruppeEintrag("Dämonenhammer", "Nemesis-Dämonenhammer", 10));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Digitalwaffen", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Teleport-Peilsender", 10));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffe Meisterhaft", 10));
        ogE.addElement(new OptionsGruppeEintrag("Fernkampfwaffe Meisterhaft", 10));
        add(o1x = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Deimos Wut", 10));
        ogE.addElement(new OptionsGruppeEintrag("Knochensplitter", "Knochensplitter des Solor", 10));
        ogE.addElement(new OptionsGruppeEintrag("Kürass der Märtyer", "Kürass der Märtyer", 15));
        ogE.addElement(new OptionsGruppeEintrag("Seelengleve", 20));
        ogE.addElement(new OptionsGruppeEintrag("Domina Liber Daemonica", "Domina Liber Daemonica", 25));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Skull of Petronella the Pious (GS)"), 30));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blade of the Worthy (GS)"), 30)); // TODO NKW ersetzen
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Castigator (GS)"), 15));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("The Font of Fury (GS)"), 10));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Shroud of the Anti-Martyr (GS)"), 35));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Desvalles's Holy Circle (GS)"), 35));
        add(reliquien = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));


        complete();
    }

    @Override
    public void refreshen() {

        boolean EcclesiarchyRelics = getCountFromInformationVector("EcclesiarchyRelics") > 0;

        reliquien.setAktiv("Skull of Petronella the Pious (GS)", EcclesiarchyRelics);
        reliquien.setAktiv("Blade of the Worthy (GS)", EcclesiarchyRelics);
        reliquien.setAktiv("Castigator (GS)", EcclesiarchyRelics);
        reliquien.setAktiv("The Font of Fury (GS)", EcclesiarchyRelics);
        reliquien.setAktiv("Shroud of the Anti-Martyr (GS)", EcclesiarchyRelics);
        reliquien.setAktiv("Desvalles's Holy Circle (GS)", EcclesiarchyRelics);

        if (!o1.isSelected()) o1.setSelected(0, true);
        if (!o2.isSelected()) o2.setSelected(0, true);

        if (reliquien.isSelected("Deimos Wut")) {
            o1.setAktiv(false);
            o1x.setAktiv(1, false);
        } else {
            o1.setAktiv(true);
            o1x.setAktiv(1, true);
        }

        if (reliquien.isSelected("Seelengleve") || reliquien.isSelected("Blade of the Worthy (GS)")) {
            o2.setAktiv(false);
        } else {
            o2.setAktiv(true);
        }

        if (grandmaster.isSelected() && grandmasterBool == false) {
            grandmasterBool = true;
            addToInformationVector("GKGrandmaster", 1);
        }

        if (!grandmaster.isSelected() && grandmasterBool == true) {
            grandmasterBool = false;
            addToInformationVector("GKGrandmaster", -1);
        }

        if (getCountFromInformationVector("Grey Knight Brotherhood") == 1 && getCountFromInformationVector("GKGrandmaster") != 1) {
            setFehlermeldung("1 Grandmaster wählen");
        } else {
            setFehlermeldung("");
        }

    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        addToInformationVector("GKHQ", -1);
        if (grandmaster.isSelected()) {
            addToInformationVector("GKGrandmaster", -1);
        }
    }
}
