package oc.wh40k.units.cm;

import oc.*;

public class CMChaosgeneral extends Eintrag {

    OptionsUpgradeGruppe mal;
    OptionsEinzelUpgrade termi;
    OptionsEinzelUpgrade vdlk;
    RuestkammerStarter waffenUndArtefakte;
    RuestkammerStarter termiWaffen;
    RuestkammerStarter chaosBelohnungen;
    RuestkammerStarter spezialAusruestung;

    boolean khorneBool = false;
    boolean nurgleBool = false;
    boolean slaneshBool = false;

    boolean isBlackLegion = false;
    boolean isCrimsonSlaughter = false;

    public CMChaosgeneral() {
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

        add(vdlk = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Veteran", "Veteranen des Langen Krieges", 5));

        seperator();

        add(termi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminatorrüstung", 40));

        seperator();

        termiWaffen = new RuestkammerStarter(ID, randAbstand, cnt, "CMTerminatorwaffen", "");
        termiWaffen.initKammer(false, true, false);
        termiWaffen.setButtonText(BuildaHQ.translate("Terminatorwaffen & Artefakte"));
        add(termiWaffen);

        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, "CMWaffenUndArtefakte", "");
        // General, Hexer, Warpschmied, Apostel, Daemon
        waffenUndArtefakte.initKammer(true, false, false, false, false);
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen & Artefakte"));
        add(waffenUndArtefakte);
        waffenUndArtefakte.setAbwaehlbar(false);

        seperator();

        chaosBelohnungen = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosbelohnungen", "");
        chaosBelohnungen.initKammer(mal.isSelected("Mal des Khorne"), mal.isSelected("Mal des Tzeentch"), mal.isSelected("Mal des Nurgle"), mal.isSelected("Mal des Slaanesh"), termi.isSelected(), false);
        chaosBelohnungen.setButtonText("Gaben des Chaos");
        add(chaosBelohnungen);

        seperator();

        spezialAusruestung = new RuestkammerStarter(ID, randAbstand, cnt, "CMSpezialausruestung", "");
        spezialAusruestung.initKammer(termi.isSelected(), mal.isSelected("Mal des Nurgle"));
        spezialAusruestung.setButtonText(BuildaHQ.translate("Spezielle Ausrüstung"));
        add(spezialAusruestung);

        seperator(5);

        complete();
    }

    @Override
    public void refreshen() {

        if (getCountFromInformationVector("BlackLegion") == 1) {
            vdlk.setSelected(true);
        }

        if (getCountFromInformationVector("Death Guard") == 1) {
            vdlk.setSelected(true);
            mal.setSelected("Mal des Nurgle", true);
            mal.setAktiv("Mal des Khorne", false);
            mal.setAktiv("Mal des Tzeentch", false);
            mal.setAktiv("Mal des Slaanesh", false);
        }

        if (getCountFromInformationVector("Emperors Children") == 1) {
            vdlk.setSelected(true);
            mal.setSelected("Mal des Slaanesh", false);
            mal.setAktiv("Mal des Khorne", false);
            mal.setAktiv("Mal des Tzeentch", false);
            mal.setAktiv("Mal des Nurgle", false);
        }

        if (getCountFromInformationVector("Terminator Annihilation Force (TL)") == 1) {
            termi.setSelected(true);
        }

        if (getCountFromInformationVector("Raptor Talon (TL)") == 1) {
            spezialAusruestung.setAbwaehlbar(false);
            spezialAusruestung.getKammer().switchEntry("Raptor Talon (TL)", true);
        } else {
            spezialAusruestung.setAbwaehlbar(true);
            spezialAusruestung.getKammer().switchEntry("Raptor Talon (TL)", false);
        }

        if (getCountFromInformationVector("Maelstrom of Gore (TL)") == 1) {
            mal.setSelected("Mal des Khorne", true);
            mal.setPreis("Mal des Khorne", 0);
            mal.setAktiv("Mal des Nurgle", false);
            mal.setAktiv("Mal des Tzeentch", false);
            mal.setAktiv("Mal des Slaanesh", false);
        }

        vdlk.setAktiv(getCountFromInformationVector("CrimsonSlaughter") == 0);

        if (getCountFromInformationVector("BlackLegion") > 0 && !isBlackLegion) {
            isBlackLegion = true;
            ((CMWaffenUndArtefakte) waffenUndArtefakte.getKammer()).isBlackLegion = isBlackLegion;
            ((CMTerminatorwaffen) termiWaffen.getKammer()).isBlackLegion = isBlackLegion;
            RefreshListener.fireRefresh();
        } else if (getCountFromInformationVector("BlackLegion") < 1 && isBlackLegion) {
            isBlackLegion = false;
            ((CMWaffenUndArtefakte) waffenUndArtefakte.getKammer()).isBlackLegion = isBlackLegion;
            ((CMTerminatorwaffen) termiWaffen.getKammer()).isBlackLegion = isBlackLegion;
            RefreshListener.fireRefresh();
        }

        if (getCountFromInformationVector("The Hounds of Abaddon (BL)") > 0) {
            mal.setPreis(0, 0);
            if (!mal.isSelected(0)) {
                mal.setSelected(1, false);
                mal.setSelected(2, false);
                mal.setSelected(3, false);
                mal.setSelected(0, true);
            }
        }

        chaosBelohnungen.getKammer().switchEntry("Moloch des Khorne", mal.isSelected("Mal des Khorne") && !termi.isSelected());
        chaosBelohnungen.getKammer().switchEntry("Flugdämon des Tzeentch", mal.isSelected("Mal des Tzeentch") && !termi.isSelected());
        chaosBelohnungen.getKammer().switchEntry("Sänfte des Nurgle", mal.isSelected("Mal des Nurgle") && !termi.isSelected());
        chaosBelohnungen.getKammer().switchEntry("Slaaneshpferd", mal.isSelected("Mal des Slaanesh") && !termi.isSelected());

        waffenUndArtefakte.getKammer().switchEntry("Axt der blinden Wut", mal.isSelected("Mal des Khorne"));
        waffenUndArtefakte.getKammer().switchEntry("Schriftrollen des Magnus", mal.isSelected("Mal des Tzeentch"));

        termiWaffen.getKammer().switchEntry("Axt der blinden Wut", mal.isSelected("Mal des Khorne"));
        termiWaffen.getKammer().switchEntry("Schriftrollen des Magnus", mal.isSelected("Mal des Tzeentch"));

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

        if (getCountFromInformationVector("Formation") == 0) {//Keine Verschiebungen in Formationen
            //Mal des Khorne
            if (mal.isSelected("Mal des Khorne") != khorneBool) {
                khorneBool = mal.isSelected("Mal des Khorne");
                addToInformationVector("CMKhorneTroops", khorneBool ? 1 : -1);
            }

            if (getCountFromInformationVector("Main") < 1) {
                buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Khorne-Berserker");
                buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Khorne-Berserker");
            } else {
                if (getCountFromInformationVector("CMKhorneTroops") < 1) {
                    buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Khorne-Berserker");
                    buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Khorne-Berserker");
                } else {
                    buildaVater.getChooserGruppeForChange(3).addSpezialAuswahl("Khorne-Berserker");
                    buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Khorne-Berserker");
                }
            }

            //Mal des Nurgle
            if (mal.isSelected("Mal des Nurgle") != nurgleBool) {
                nurgleBool = mal.isSelected("Mal des Nurgle");
                addToInformationVector("CMNurgleTroops", nurgleBool ? 1 : -1);
            }

            if (getCountFromInformationVector("Main") < 1) {
                buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Seuchenmarines");
                buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Seuchenmarines");
            } else {
                if (getCountFromInformationVector("CMNurgleTroops") < 1) {
                    buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Seuchenmarines");
                    buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Seuchenmarines");
                } else {
                    buildaVater.getChooserGruppeForChange(3).addSpezialAuswahl("Seuchenmarines");
                    buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Seuchenmarines");
                }
            }

            //Mal des Nurgle
            if (mal.isSelected("Mal des Slaanesh") != slaneshBool) {
                slaneshBool = mal.isSelected("Mal des Slaanesh");
                addToInformationVector("CMSlaanesTroops", slaneshBool ? 1 : -1);
            }

            if (getCountFromInformationVector("Main") < 1) {
                buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Noisemarines");
                buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Noisemarines");
            } else {
                if (getCountFromInformationVector("CMSlaanesTroops") < 1) {
                    buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Noisemarines");
                    buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Noisemarines");
                } else {
                    buildaVater.getChooserGruppeForChange(3).addSpezialAuswahl("Noisemarines");
                    buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Noisemarines");
                }
            }
        }

        ((CMChaosbelohnungen) chaosBelohnungen.getKammer()).bikeGesetzt = (((CMSpezialausruestung) spezialAusruestung.getKammer()).o2.isSelected() && spezialAusruestung.isSelected());
        ((CMSpezialausruestung) spezialAusruestung.getKammer()).reittierGesetzt = (((CMChaosbelohnungen) chaosBelohnungen.getKammer()).o2.isSelected() && chaosBelohnungen.isSelected());
        if (((CMWaffenUndArtefakte) waffenUndArtefakte.getKammer()).uniqueError || ((CMTerminatorwaffen) termiWaffen.getKammer()).uniqueError) {
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
                addToInformationVector("CMKhorneTroops", -1);
                if (getCountFromInformationVector("CMKhorneTroops") < 1) {
                    buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Khorne-Berserker");
                    buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Khorne-Berserker");
                }
            }
        }

        if (slaneshBool == true) {
            slaneshBool = false;
            if (!ally) {
                addToInformationVector("CMSlaanesTroops", -1);
                if (getCountFromInformationVector("CMSlaanesTroops") < 1) {
                    buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Noisemarines");
                    buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Noisemarines");
                }
            }
        }

        if (nurgleBool == true) {
            nurgleBool = false;
            if (!ally) {
                addToInformationVector("CMNurgleTroops", -1);
                if (getCountFromInformationVector("CMNurgleTroops") < 1) {
                    buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Seuchenmarines");
                    buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Seuchenmarines");
                }
            }
        }
        super.deleteYourself();
    }

}
