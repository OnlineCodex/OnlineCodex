package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CMChaosSpartanAssaultTank extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;

    public CMChaosSpartanAssaultTank() {
        name = "Spartan Assault Tank";
        grundkosten = 285;

        add(ico = new oc.Picture("oc/wh40k/images/SMSpartanAssaultTank.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("TL Heavy Bolter", "twin-linked heavy bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("TL Heavy Flamer", "Twin-linked heavy flamer", 0));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Quad-Lascannon", "Two sponson-mounted quad lascannon", 0));
        ogE.addElement(new OptionsGruppeEintrag("2 Laser Destroyer", 0));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Frag assault Launchers", 10));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter Killer Missile", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armoured Ceramite", 20));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Possession", 25));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dirge Caster", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Warpflame Gargoyles", 5));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Combi-Bolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Havoc Launcher", 12));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 15));
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 15));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 20));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
