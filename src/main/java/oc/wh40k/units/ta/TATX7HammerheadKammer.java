package oc.wh40k.units.ta;

import oc.*;

public class TATX7HammerheadKammer extends RuestkammerVater {

    private final OptionsUpgradeGruppe o2;
    private final OptionsUpgradeGruppe o3;

    public TATX7HammerheadKammer() {
        name = "Hammerhai-Gefechtspanzer";
        grundkosten = 125;

        add(ico = new oc.Picture("oc/wh40k/images/Hammerhai.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Railgun", getPts("Railgun")));
        ogE.addElement(new OptionsGruppeEintrag("Ion cannon", getPts("Ion cannon")));
        o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(o2);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 MV1 Gun Drones", getPts("MV1 Gun Drone") * 2 + getPts("Pulse carbine") * 4));
        ogE.addElement(new OptionsGruppeEintrag("2 Burst cannons", getPts("Burst cannon") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Smart missile systems", getPts("Smart missile system") * 2));
        o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(o3);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Seeker missile", getPts("Seeker missile")));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!o2.isSelected()) o2.setSelected(0, true);
        if (!o3.isSelected()) o3.setSelected(0, true);
    }
}