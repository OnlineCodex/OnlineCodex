package oc.wh40k.units.rh_ia13;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class RH_IA13SonicDreadnought extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

    public RH_IA13SonicDreadnought() {
        name = "Sonic Dreadnought";
        grundkosten = 160;

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Warp Amp", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Extra armour", 10));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("TL Sonic blaster", "Twin-linked Sonic blaster", 0));
        ogE.addElement(new OptionsGruppeEintrag("Blastmaster", 15));
        ogE.addElement(new OptionsGruppeEintrag("TL Lascannon", "Twin-linked Lascannon", 25));
        ogE.addElement(new OptionsGruppeEintrag("TL Heavy bolters", "Twin-linked heavy bolters", 5));
        ogE.addElement(new OptionsGruppeEintrag("TL Heavy bolters (MA)", "Twin-linked heavy bolters with malefic ammonition", 25));
        ogE.addElement(new OptionsGruppeEintrag("Multi melta", 0));
        ogE.addElement(new OptionsGruppeEintrag("Plasma cannon", 5));
        ogE.addElement(new OptionsGruppeEintrag("TL Autocannon", "Twin-linked Autocannon with malefic ammonition", 25));
        ogE.addElement(new OptionsGruppeEintrag("TL Autocannon (MA)", "Twin-linked Autocannon", 5));
        ogE.addElement(new OptionsGruppeEintrag("DCCW + storm bolter", "Dreadnought close combar weapon + storm bolter", 10));
        ogE.addElement(new OptionsGruppeEintrag("DCCW + heavy flamer", "Dreadnought close combar weapon + heavy flamer", 15));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();


        ogE.addElement(new OptionsGruppeEintrag("Chainfist + storm bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Chainfist + heavy flamer", 0));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 0));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();

        o1.setAktiv(10, !o2.isSelected(1));
        o2.setAktiv(1, !o2.isSelected(10));

    }

}
