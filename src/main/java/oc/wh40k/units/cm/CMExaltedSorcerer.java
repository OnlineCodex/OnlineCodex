package oc.wh40k.units.cm;

import oc.*;

public class CMExaltedSorcerer extends Eintrag {

    OptionsUpgradeGruppe mal;
    OptionsEinzelUpgrade vdlk;
    OptionsUpgradeGruppe psi;
    RuestkammerStarter termiWaffen;
    RuestkammerStarter chaosBelohnungen;
    RuestkammerStarter waffenUndArtefakte;
    boolean tzeentchBool;

    boolean isBlackLegion = false;
    boolean isCrimsonSlaughter = false;

    public CMExaltedSorcerer() {
        name = "Exalted Sorcerer";
        grundkosten = 160;

        add(ico = new oc.Picture("oc/wh40k/images/ChaosLordinPowerArmour.gif"));

        seperator(8);

        ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 0));
        add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Meisterschaftsgrad 3", 25));
        add(psi = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(vdlk = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Veteran", "Veteranen des Langen Krieges", 0));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Disc of Tzeentch", 30));

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
        chaosBelohnungen.initKammer(mal.isSelected("Mal des Khorne"), mal.isSelected("Mal des Tzeentch"), mal.isSelected("Mal des Nurgle"), mal.isSelected("Mal des Slaanesh"), false, false);
        chaosBelohnungen.setButtonText(BuildaHQ.translate("Gaben des Chaos"));
        add(chaosBelohnungen);

        complete();
    }

    @Override
    public void refreshen() {

        vdlk.setSelected(true);
        mal.setSelected(0, true);

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

        chaosBelohnungen.getKammer().switchEntry("Flugdämon des Tzeentch", mal.isSelected("Mal des Tzeentch"));
        chaosBelohnungen.getKammer().switchEntry("Sänfte des Nurgle", mal.isSelected("Mal des Nurgle"));
        chaosBelohnungen.getKammer().switchEntry("Slaaneshpferd", mal.isSelected("Mal des Slaanesh"));
        chaosBelohnungen.getKammer().switchEntry("Seuchengranaten", mal.isSelected("Mal des Nurgle"));

        waffenUndArtefakte.getKammer().switchEntry("Schriftrollen des Magnus", mal.isSelected("Mal des Tzeentch"));
        termiWaffen.getKammer().switchEntry("Schriftrollen des Magnus", mal.isSelected("Mal des Tzeentch"));

        waffenUndArtefakte.setAktiv(true);
        termiWaffen.setAbwaehlbar(false);
        termiWaffen.setAktiv(false);

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
