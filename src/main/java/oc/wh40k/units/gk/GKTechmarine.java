package oc.wh40k.units.gk;

import oc.*;

public class GKTechmarine extends Eintrag {
    //TODO Ausrüstung in eine Kammer verlegen. Artefakte richtig handhaben

    OptionsUpgradeGruppe o1, o1x;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3, reliquien;

    public GKTechmarine() {
        name = "Techmarine";
        grundkosten = 90;

        add(ico = new oc.Picture("oc/wh40k/images/GKTechmarine.jpg"));
        setEintragsCNT(0.0);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolter & Servoharnisch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter & Servoharnisch", 3));
        ogE.addElement(new OptionsGruppeEintrag("Konversionsstrahler", 20));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 0));
        ogE.addElement(new OptionsGruppeEintrag("Psihellebarde", "Nemesis-Psihellebarde", 2));
        ogE.addElement(new OptionsGruppeEintrag("Falchions", "Nemesis-Falchions", 4));
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

        ogE.addElement(new OptionsGruppeEintrag("Deimos Wut", 13));
        ogE.addElement(new OptionsGruppeEintrag("Knochensplitter", "Knochensplitter des Solor", 10));
        ogE.addElement(new OptionsGruppeEintrag("Seelengleve", 20));
        ogE.addElement(new OptionsGruppeEintrag("Domina Liber Daemonica", "Domina Liber Daemonica", 25));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Skull of Petronella the Pious (GS)"), 30));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Blade of the Worthy (GS)"), 30)); // TODO NKW ersetzen
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Castigator (GS)"), 15));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("The Font of Fury (GS)"), 10));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Shroud of the Anti-Martyr (GS)"), 35));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Desvalles's Holy Circle (GS)"), 35));
        add(reliquien = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        addToInformationVector("GKTechmarine", 1);

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

        if (getCountFromInformationVector("GKTechmarine") > getCountFromInformationVector("GKHQ")) {
            setFehlermeldung("Max " + getCountFromInformationVector("GKHQ"));
        } else {
            setFehlermeldung("");
        }
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        addToInformationVector("GKTechmarine", -1);
    }

}
