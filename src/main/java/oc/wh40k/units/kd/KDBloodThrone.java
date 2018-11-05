package oc.wh40k.units.kd;

import oc.*;

public class KDBloodThrone extends Eintrag {

    OptionsUpgradeGruppe o1, o2, o3;
    OptionsUpgradeGruppe praesenz, mount;
    RuestkammerStarter chaosBelohnungen;
    RuestkammerStarter waffenUndArtefakte;

    public KDBloodThrone() {
        name = "Blood Throne";
        grundkosten = 130;

        add(ico = new oc.Picture("oc/wh40k/images/CDHerolddesKhorne.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Präsenz des Trotzes", "Geringe Präsenz der Trotzes", 10));
        ogE.addElement(new OptionsGruppeEintrag("Präsenz der Wut", "Mächtige Präsenz der Wut", 20));
        ogE.addElement(new OptionsGruppeEintrag("Präsenz des Zorns", "Erhabene Präsenz des Zorns", 25));
        add(praesenz = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        // lord, termi, dp, herald, bloodthrone
        chaosBelohnungen = new RuestkammerStarter(ID, randAbstand, cnt, "KDChaosbelohnungen", "");
        chaosBelohnungen.initKammer(false, false, false, false, true);
        chaosBelohnungen.setButtonText(BuildaHQ.translate("Gaben des Chaos"));
        add(chaosBelohnungen);

        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, "KDWaffenUndArtefakte", "");
        // lord, termi, dp, herald, bloodthrone
        waffenUndArtefakte.initKammer(false, false, false, false, true);
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen & Artefakte"));
        add(waffenUndArtefakte);
        waffenUndArtefakte.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        if (((KDWaffenUndArtefakte) waffenUndArtefakte.getKammer()).uniqueError) {
            setFehlermeldung("Artefakt doppelt!");
        } else {
            setFehlermeldung("");
        }
    }

}
