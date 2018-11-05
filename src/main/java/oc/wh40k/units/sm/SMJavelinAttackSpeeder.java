package oc.wh40k.units.sm;

import oc.*;

public class SMJavelinAttackSpeeder extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

    public SMJavelinAttackSpeeder() {
        name = "Javelin Attack Speeder";
        grundkosten = 75;

        add(ico = new oc.Picture("oc/wh40k/images/SMIroncladCybot.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("TL Cyclone ML", "Twin-linked Cyclone Missile Launcher", 0));
        ogE.addElement(new OptionsGruppeEintrag("TL Lascannon", "Twin-linked Lascannon", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator(8);

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 10));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        seperator(8);

        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Hunter-killer missile", 2, 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Searchlight", 1));


        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) {
            o1.setSelected(0, true);
        }

        if (!o2.isSelected()) {
            o2.setSelected(0, true);
        }
    }

}
