package oc.wh40k.units.da;

import oc.*;

public class DADropPodKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe typ;
    OptionsUpgradeGruppe podWeapon;
    OptionsPanelSwitcher switcher;
    boolean offerLucius = false;

    public DADropPodKammer() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        if (defaults.length > 0) {
            this.offerLucius = defaults[0];
        }

        add(ico = new oc.Picture("oc/wh40k/images/DADropPod.gif"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Landungskapsel", 50));
        if (this.offerLucius) {
            ogE.addElement(new OptionsGruppeEintrag("[IA2 2nd Ed] Lucius-Pod", "[IA2 2nd Ed] Lucius Pattern Drop Pod", 50));
        }
        add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Deathwind-System", 20));

        OptionsVater[] dropPod = new OptionsVater[]{ /*keine*/};

        OptionsVater[] dropPodIA2 = new OptionsVater[]{
                podWeapon = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE),
                new OptionsSeperator(5),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Peilsender", 10)
        };

        OptionsVater[] empty = new OptionsVater[]{};

        add(switcher = new OptionsPanelSwitcher(randAbstand, cnt, dropPod, dropPodIA2, empty));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        switcher.switchPanel(typ.getSelectedIndex());

        if (!typ.isSelected()) {
            typ.setSelected(0, true);
        }

        if (!podWeapon.isSelected()) {
            podWeapon.setSelected(0, true);
        }
    }

}
