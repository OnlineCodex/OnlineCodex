package oc.wh40k.units.cs;

import oc.*;

public class CSDunklerApostel extends Eintrag {

    OptionsUpgradeGruppe mal;
    RuestkammerStarter nahkampfWaffen;
    RuestkammerStarter waffenUndArtefakte;
    RuestkammerStarter chaosBelohnungen;
    RuestkammerStarter spezialAusruestung;

    public CSDunklerApostel() {
        name = "Dunkler Apostel";
        grundkosten = 105;

        add(ico = new oc.Picture("oc/wh40k/images/ChaosLordinPowerArmour.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mal des Khorne", 10));
        ogE.addElement(new OptionsGruppeEintrag("Mal des Tzeentch", 15));
        ogE.addElement(new OptionsGruppeEintrag("Mal des Nurgle", 15));
        ogE.addElement(new OptionsGruppeEintrag("Mal des Slaanesh", 15));
        add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, "CSWaffenUndArtefakte", "");
        // General, Hexer, Warpschmied, Apostel, Daemon
        waffenUndArtefakte.initKammer(false, false, false, true, false);
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen & Artefakte"));
        add(waffenUndArtefakte);
        waffenUndArtefakte.setAbwaehlbar(false);

        seperator();

        chaosBelohnungen = new RuestkammerStarter(ID, randAbstand, cnt, "CSChaosbelohnungen", "");
        chaosBelohnungen.initKammer(mal.isSelected("Mal des Khorne"), mal.isSelected("Mal des Tzeentch"), mal.isSelected("Mal des Nurgle"), mal.isSelected("Mal des Slaanesh"), false, false);
        chaosBelohnungen.setButtonText(BuildaHQ.translate("Gaben des Chaos"));
        add(chaosBelohnungen);

        complete();
    }

    @Override
    public void refreshen() {
        chaosBelohnungen.getKammer().switchEntry("Moloch des Khorne", false);
        chaosBelohnungen.getKammer().switchEntry("Flugdämon des Tzeentch", false);
        chaosBelohnungen.getKammer().switchEntry("Sänfte des Nurgle", false);
        chaosBelohnungen.getKammer().switchEntry("Slaaneshpferd", false);

        waffenUndArtefakte.getKammer().switchEntry("Axt der blinden Wut", mal.isSelected("Mal des Khorne"));
        waffenUndArtefakte.getKammer().switchEntry("Schriftrollen des Magnus", mal.isSelected("Mal des Tzeentch"));

        if (((CSWaffenUndArtefakte) waffenUndArtefakte.getKammer()).uniqueError) {
            setFehlermeldung("Artefakt doppelt!");
        } else {
            setFehlermeldung("");
        }
    }

}
