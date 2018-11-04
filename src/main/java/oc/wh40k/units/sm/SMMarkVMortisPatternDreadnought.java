package oc.wh40k.units.sm;

import oc.*;

public class SMMarkVMortisPatternDreadnought extends Eintrag {

    OptionsUpgradeGruppe o3;

    boolean siegeForce;

    public SMMarkVMortisPatternDreadnought() {
        name = "Mark V Mortis Pattern Dreadnought";
        grundkosten = 115;
        setUnikat(true);

        siegeForce = OnlineCodex.getInstance().isCurrentArmy(oc.wh40k.armies.VOLKSiegeVanguardIA10.class);

        add(ico = new oc.Picture("oc/wh40k/images/SMCybot.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Missile launchers", 0));
        ogE.addElement(new OptionsGruppeEintrag("2 TL Heavy bolters", 5));
        ogE.addElement(new OptionsGruppeEintrag("2 TL Autocannons", 10));
        ogE.addElement(new OptionsGruppeEintrag("2 TL Lascannons", 30));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o3.setSelected(0, true);

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 10));

        complete();
    }

    @Override
    public void refreshen() {
        o3.alwaysSelected();
    }

}
