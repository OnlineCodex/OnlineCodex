package oc.wh40k.units.cm;

import oc.*;

public class CMHexer extends Eintrag {

    OptionsUpgradeGruppe mal;
    OptionsEinzelUpgrade termi;
    OptionsEinzelUpgrade vdlk;
    OptionsUpgradeGruppe psi;
    RuestkammerStarter termiWaffen;
    RuestkammerStarter chaosBelohnungen;
    RuestkammerStarter waffenUndArtefakte;
    RuestkammerStarter spezialAusruestung;
    boolean tzeentchBool;

    boolean isBlackLegion = false;
    boolean isCrimsonSlaughter = false;

    public CMHexer() {
        name = "Hexer";
        grundkosten = 60;

        add(ico = new oc.Picture("oc/wh40k/images/ChaosLordinPowerArmour.gif"));

        seperator(8);

        ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 15));
        ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 15));
        ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 15));
        add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Meisterschaftsgrad 2", 25));
        ogE.addElement(new OptionsGruppeEintrag("Meisterschaftsgrad 3", 50));
        add(psi = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(vdlk = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Veteran", "Veteranen des Langen Krieges", 5));

        seperator();

        add(termi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminatorrüstung", 25));

        seperator();

        termiWaffen = new RuestkammerStarter(ID, randAbstand, cnt, "CMTerminatorwaffen", "");
        termiWaffen.initKammer(false, false, true);
        termiWaffen.setButtonText(BuildaHQ.translate("Terminatorwaffen  & Artefakte"));
        add(termiWaffen);

        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, "CMWaffenUndArtefakte", "");
        // General, Hexer, Warpschmied, Apostel, Daemon
        waffenUndArtefakte.initKammer(false, true, false, false, false);
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen & Artefakte"));
        add(waffenUndArtefakte);
        waffenUndArtefakte.setAbwaehlbar(false);

        seperator();

        chaosBelohnungen = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosbelohnungen", "");
        chaosBelohnungen.initKammer(mal.isSelected("Mal des Khorne"), mal.isSelected("Mal des Tzeentch"), mal.isSelected("Mal des Nurgle"), mal.isSelected("Mal des Slaanesh"), termi.isSelected(), false);
        chaosBelohnungen.setButtonText(BuildaHQ.translate("Gaben des Chaos"));
        add(chaosBelohnungen);

        seperator();

        spezialAusruestung = new RuestkammerStarter(ID, randAbstand, cnt, "CMSpezialausruestung", "");
        spezialAusruestung.initKammer(mal.isSelected("Mal des Khorne"), mal.isSelected("Mal des Tzeentch"), mal.isSelected("Mal des Nurgle"), mal.isSelected("Mal des Slaanesh"));
        spezialAusruestung.setButtonText(BuildaHQ.translate("Spezielle Ausrüstung"));
        add(spezialAusruestung);

        complete();
    }

    @Override
    public void refreshen() {

        if (getCountFromInformationVector("BlackLegion") == 1) {
            vdlk.setSelected(true);
        }

        if (getCountFromInformationVector("Terminator Annihilation Force (TL)") == 1) {
            termi.setSelected(true);
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

        chaosBelohnungen.getKammer().switchEntry("Flugdämon des Tzeentch", mal.isSelected("Mal des Tzeentch") && !termi.isSelected());
        chaosBelohnungen.getKammer().switchEntry("Sänfte des Nurgle", mal.isSelected("Mal des Nurgle") && !termi.isSelected());
        chaosBelohnungen.getKammer().switchEntry("Slaaneshpferd", mal.isSelected("Mal des Slaanesh") && !termi.isSelected());
        chaosBelohnungen.getKammer().switchEntry("Seuchengranaten", mal.isSelected("Mal des Nurgle"));

        waffenUndArtefakte.getKammer().switchEntry("Schriftrollen des Magnus", mal.isSelected("Mal des Tzeentch"));
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
            //Mal des Tzeentch
            if (mal.isSelected("Mal des Tzeentch") != tzeentchBool) {
                tzeentchBool = mal.isSelected("Mal des Tzeentch");
                addToInformationVector("CMTzeentchTroops", tzeentchBool ? 1 : -1);
            }

            if (getCountFromInformationVector("Main") > 0) {
                buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Rubric Marines");
                buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Rubric Marines");
            } else {
                if (getCountFromInformationVector("CMTzeentchTroops") < 1) {
                    buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Rubric Marines");
                    buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Rubric Marines");
                } else {
                    buildaVater.getChooserGruppeForChange(3).addSpezialAuswahl("Rubric Marines");
                    buildaVater.getChooserGruppeForChange(2).removeSpezialAuswahl("Rubric Marines");
                }
            }
        }

        ((CMChaosbelohnungen) chaosBelohnungen.getKammer()).bikeGesetzt = ((CMSpezialausruestung) spezialAusruestung.getKammer()).o2.isSelected();
        ((CMSpezialausruestung) spezialAusruestung.getKammer()).reittierGesetzt = ((CMChaosbelohnungen) chaosBelohnungen.getKammer()).o2.isSelected();
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
        if (tzeentchBool == true) {
            tzeentchBool = false;
            addToInformationVector("CMTzeentchTroops", -1);
            if (getCountFromInformationVector("CMTzeentchTroops") < 1) {
                buildaVater.getChooserGruppeForChange(2).addSpezialAuswahl("Rubric Marines");
                buildaVater.getChooserGruppeForChange(3).removeSpezialAuswahl("Rubric Marines");
            }
        }
        super.deleteYourself();
    }
}
