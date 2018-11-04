package oc.wh40k.units.cs;

import oc.*;

public class CSChaosgeneral extends Eintrag {

    OptionsUpgradeGruppe mal;
    OptionsEinzelUpgrade termi;
    RuestkammerStarter waffenUndArtefakte;
    RuestkammerStarter termiWaffen;
    RuestkammerStarter chaosBelohnungen;
    RuestkammerStarter spezialAusruestung;

    boolean khorneBool = false;
    boolean nurgleBool = false;
    boolean slaneshBool = false;

    public CSChaosgeneral() {
        name = "Chaosgeneral";
        grundkosten = 65;

        add(ico = new oc.Picture("oc/wh40k/images/ChaosLordinPowerArmour.gif"));

        seperator(8);

        ogE.addElement(new OptionsGruppeEintrag("Mal des Khorne", 10));
        ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 15));
        ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 15));
        ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 15));
        add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(termi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminatorrüstung", 40));

        seperator();

        termiWaffen = new RuestkammerStarter(ID, randAbstand, cnt, "CSTerminatorwaffen", "");
        termiWaffen.initKammer(false, true, false);
        termiWaffen.setButtonText(BuildaHQ.translate("Terminatorwaffen & Artefakte"));
        add(termiWaffen);

        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, "CSWaffenUndArtefakte", "");
        // General, Hexer, Warpschmied, Apostel, Daemon
        waffenUndArtefakte.initKammer(true, false, false, false, false);
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen & Artefakte"));
        add(waffenUndArtefakte);
        waffenUndArtefakte.setAbwaehlbar(false);

        seperator();

        chaosBelohnungen = new RuestkammerStarter(ID, randAbstand, cnt, "CSChaosbelohnungen", "");
        chaosBelohnungen.initKammer(mal.isSelected("Mal des Khorne"), mal.isSelected("Mal des Tzeentch"), mal.isSelected("Mal des Nurgle"), mal.isSelected("Mal des Slaanesh"), termi.isSelected(), false);
        chaosBelohnungen.setButtonText("Gaben des Chaos");
        add(chaosBelohnungen);

        seperator();

        spezialAusruestung = new RuestkammerStarter(ID, randAbstand, cnt, "CSSpezialausruestung", "");
        spezialAusruestung.initKammer(termi.isSelected(), mal.isSelected("Mal des Nurgle"));
        spezialAusruestung.setButtonText(BuildaHQ.translate("Spezielle Ausrüstung"));
        add(spezialAusruestung);

        seperator(5);

        complete();
    }

    @Override
    public void refreshen() {
        chaosBelohnungen.getKammer().switchEntry("Moloch des Khorne", mal.isSelected("Mal des Khorne") && !termi.isSelected());
        chaosBelohnungen.getKammer().switchEntry("Flugdämon des Tzeentch", mal.isSelected("Mal des Tzeentch") && !termi.isSelected());
        chaosBelohnungen.getKammer().switchEntry("Sänfte des Nurgle", mal.isSelected("Mal des Nurgle") && !termi.isSelected());
        chaosBelohnungen.getKammer().switchEntry("Slaaneshpferd", mal.isSelected("Mal des Slaanesh") && !termi.isSelected());

        spezialAusruestung.getKammer().switchEntry("Seuchengranaten", mal.isSelected("Mal des Nurgle"));
        spezialAusruestung.getKammer().switchEntry("Sprungmodul", !termi.isSelected());
        spezialAusruestung.getKammer().switchEntry("Chaosbike", !termi.isSelected());

        if (termi.isSelected()) {
            waffenUndArtefakte.setAktiv(false);
            termiWaffen.setAbwaehlbar(false);
            termiWaffen.setAktiv(true);
        } else {
            waffenUndArtefakte.setAktiv(true);
            termiWaffen.setAbwaehlbar(false);
            termiWaffen.setAktiv(false);
        }
        if (mal.isSelected("Mal des Khorne")) {
            if (khorneBool == false) {
                khorneBool = true;
                if (!ally) {
                    addToInformationVector("CSKhorneTroops", 1);
                    BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Khorne-Berserker");
                    BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Khorne-Berserker");
                }
            }
        } else if (!mal.isSelected("Mal des Khorne")) {
            if (khorneBool == true) {
                khorneBool = false;
                if (!ally) {
                    addToInformationVector("CSKhorneTroops", -1);
                    if (getCountFromInformationVector("CSKhorneTroops") < 1) {
                        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Khorne-Berserker");
                        BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Khorne-Berserker");
                    }
                }
            }
        }

        if (mal.isSelected("Mal des Nurgle")) {
            if (nurgleBool == false) {
                nurgleBool = true;
                if (!ally) {
                    addToInformationVector("CSNurgleTroops", 1);
                    BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Seuchenmarines");
                    BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Seuchenmarines");
                }
            }
        } else if (!mal.isSelected("Mal des Nurgle")) {
            if (nurgleBool == true) {
                nurgleBool = false;
                if (!ally) {
                    addToInformationVector("CSNurgleTroops", -1);
                    if (getCountFromInformationVector("CSNurgleTroops") < 1) {
                        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Seuchenmarines");
                        BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Seuchenmarines");
                    }
                }
            }
        }

        if (mal.isSelected("Mal des Slaanesh")) {
            if (slaneshBool == false) {
                slaneshBool = true;
                if (!ally) {
                    addToInformationVector("CSSlaanesTroops", 1);
                    BuildaHQ.getChooserGruppe(3).addSpezialAuswahl("Noisemarines");
                    BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("Noisemarines");
                }
            }
        } else if (!mal.isSelected("Mal des Slaanesh")) {
            if (slaneshBool == true) {
                slaneshBool = false;
                if (!ally) {
                    addToInformationVector("CSSlaanesTroops", -1);
                    if (getCountFromInformationVector("CSSlaanesTroops") < 1) {
                        BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Noisemarines");
                        BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Noisemarines");
                    }
                }
            }
        }

        ((CSChaosbelohnungen) chaosBelohnungen.getKammer()).bikeGesetzt = (((CSSpezialausruestung) spezialAusruestung.getKammer()).o2.isSelected() && spezialAusruestung.isSelected());
        ((CSSpezialausruestung) spezialAusruestung.getKammer()).reittierGesetzt = (((CSChaosbelohnungen) chaosBelohnungen.getKammer()).o2.isSelected() && chaosBelohnungen.isSelected());
        if (((CSWaffenUndArtefakte) waffenUndArtefakte.getKammer()).uniqueError || ((CSTerminatorwaffen) termiWaffen.getKammer()).uniqueError) {
            setFehlermeldung("Artefakt doppelt!");
        } else {
            setFehlermeldung("");
        }

        waffenUndArtefakte.getPanel().setLocation(
                (int) waffenUndArtefakte.getPanel().getLocation().getX(),
                (int) termiWaffen.getPanel().getLocation().getY() + termiWaffen.getPanel().getSize().height + 5
        );

        chaosBelohnungen.getPanel().setLocation(
                (int) chaosBelohnungen.getPanel().getLocation().getX(),
                (int) waffenUndArtefakte.getPanel().getLocation().getY() + waffenUndArtefakte.getPanel().getSize().height + 5
        );

        spezialAusruestung.getPanel().setLocation(
                (int) spezialAusruestung.getPanel().getLocation().getX(),
                (int) chaosBelohnungen.getPanel().getLocation().getY() + chaosBelohnungen.getPanel().getSize().height + 5
        );
    }

    @Override
    public void deleteYourself() {

        if (khorneBool == true) {
            khorneBool = false;
            if (!ally) {
                addToInformationVector("CSKhorneTroops", -1);
                if (getCountFromInformationVector("CSKhorneTroops") < 1) {
                    BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Khorne-Berserker");
                    BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Khorne-Berserker");
                }
            }
        }

        if (slaneshBool == true) {
            slaneshBool = false;
            if (!ally) {
                addToInformationVector("CSSlaanesTroops", -1);
                if (getCountFromInformationVector("CSSlaanesTroops") < 1) {
                    BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Noisemarines");
                    BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Noisemarines");
                }
            }
        }

        if (nurgleBool == true) {
            nurgleBool = false;
            if (!ally) {
                addToInformationVector("CSNurgleTroops", -1);
                if (getCountFromInformationVector("CSNurgleTroops") < 1) {
                    BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("Seuchenmarines");
                    BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl("Seuchenmarines");
                }
            }
        }
        super.deleteYourself();
    }

}
