package oc.wh40k.units.cm;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class CMKultistenChampion extends RuestkammerVater {

    OptionsUpgradeGruppe o1, o2;
    OptionsEinzelUpgrade handwaffe, maschinenpistole;
    boolean twistbray = false;

    public CMKultistenChampion() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {

        twistbray = defaults[0];

        if (twistbray) {
            ogE.addElement(new OptionsGruppeEintrag("Nahkampfwaffen", "Nahkampfwaffen", 0));
            ogE.addElement(new OptionsGruppeEintrag("Pistole & Schwert", "Autopistole & Kettenschwert", 1));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setSelected(0, true);
        } else {
            add(handwaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Maschinenpistole", "Maschinenpistole", 0));
            add(maschinenpistole = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Handwaffe", "Handwaffe", 0));
            handwaffe.setSelected(true);
            maschinenpistole.setSelected(true);

            ogE.addElement(new OptionsGruppeEintrag("Schrotflinte", 2));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            setUeberschrift("Kultistenchampion");
        }

        sizeSetzen();
    }

    @Override
    public void refreshen() {

        if (!twistbray) {
            if (!handwaffe.isSelected()) handwaffe.setSelected(true);
            if (!maschinenpistole.isSelected()) maschinenpistole.setSelected(true);
        }
    }

}
