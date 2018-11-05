package oc.wh40k.units.cm;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class CMDreadClawTalonChaosCybotKammer extends RuestkammerVater {

    OptionsUpgradeGruppe oe1;
    OptionsZaehlerGruppe oe2;
    OptionsUpgradeGruppe oe3;

    public CMDreadClawTalonChaosCybotKammer() {
    }

    public void initButtons(boolean... defaults) {
        name = "Höllenschlächter";
        grundkosten = 100;

        add(ico = new oc.Picture("oc/wh40k/images/ChaosDreadnought.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Multimelter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Schw. Bolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Zwillings-MaschKa", 5));
        ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 10));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", 25));
        ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 0));
        ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energiegeißel", 10));
        add(oe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 0));
        ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energiegeißel", 10));
        ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
        add(oe3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Synchronisierter Bolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Schwerer Flammenwerfer", 15));
        add(oe2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));


        sizeSetzen();
    }

    @Override
    public void refreshen() {

        oe1.alwaysSelected();
        oe3.alwaysSelected();

        oe2.setMaxAnzahl((oe3.isSelected("Energiefaust") ? 1 : 0) + (oe1.isSelected("Energiefaust") ? 1 : 0));
        oe1.setAktiv("Raketenwerfer", !oe3.isSelected("Raketenwerfer"));
        oe3.setAktiv("Raketenwerfer", !oe1.isSelected("Raketenwerfer"));
    }

}
