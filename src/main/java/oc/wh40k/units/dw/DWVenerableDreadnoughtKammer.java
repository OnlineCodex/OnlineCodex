package oc.wh40k.units.dw;

import oc.*;

public class DWVenerableDreadnoughtKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    RuestkammerStarter rkPod;

    boolean siegeForce;

    public DWVenerableDreadnoughtKammer() {
        name = "Venerable Dradnought";
        grundkosten = 125;
    }

    @Override
    public void initButtons(boolean... defaults) {
        siegeForce = OnlineCodex.getInstance().isCurrentArmy(oc.wh40k.armies.VOLKSiegeVanguardIA10.class);

        add(ico = new oc.Picture("oc/wh40k/images/SMCybot.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 10));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 0));
        ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o3.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Multimelter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 10));
        ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 15));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();

        o1.setAktiv(o3.isSelected("Energiefaust"));
    }

}
