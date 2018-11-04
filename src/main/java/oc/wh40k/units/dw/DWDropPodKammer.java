package oc.wh40k.units.dw;

import oc.*;

public class DWDropPodKammer extends RuestkammerVater {

    OptionsUpgradeGruppe typ;
    OptionsPanelSwitcher switcher;
    OptionsUpgradeGruppe podWeapon;

    public DWDropPodKammer() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        if (defaults.length > 0) {
        }
        if (defaults.length > 1) {
        }

        add(ico = new oc.Picture("oc/wh40k/images/SMDropPod.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Landungskapsel", 35));
        add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
        ogE.addElement(new OptionsGruppeEintrag("Deathwind-System", 15));

        OptionsVater[] pod = new OptionsVater[]{
                podWeapon = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE),
                new OptionsSeperator(5),
                new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Peilsender", 10)
        };

        OptionsVater[] empty = new OptionsVater[]{};

        add(switcher = new OptionsPanelSwitcher(randAbstand, cnt, pod, empty));

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
