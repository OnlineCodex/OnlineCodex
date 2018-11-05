package oc.wh40k.units.ne;

import oc.*;

public class NETransporterKammer extends RuestkammerVater {

    OptionsUpgradeGruppe typ;
    OptionsUpgradeGruppe commandWeapons;
    OptionsPanelSwitcher switcher;
    OptionsEinzelUpgrade ass;

    boolean offerGhost = false;
    boolean offerNight = false;

    public NETransporterKammer() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {

        this.offerGhost = defaults[0];
        this.offerNight = defaults[1];

        add(ico = new oc.Picture("oc/wh40k/images/NEGhost Ark.jpg"));


        if (this.offerGhost) {
            ogE.addElement(new OptionsGruppeEintrag("Geister-Barke", 105));
        }
        if (this.offerNight) {
            ogE.addElement(new OptionsGruppeEintrag("Night Scythe", 130));
        }
        add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        if (this.offerNight) {
            seperator();
            add(ass = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fliegerass", 50));
        }

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!typ.isSelected()) {
            typ.setSelected(0, true);
        }

        if (typ.isSelected("Geister-Barke")) {
            String icon = "oc/wh40k/images/NEGhost Ark.jpg";
            ico.setIcon(icon);
            try {
                ico.updateSize();
            } catch (Exception e) {
            }
            if (this.offerNight) {
                ass.setAktiv(false);
            }

        } else { // Night Scythe
            String icon = "oc/wh40k/images/NENight Scythe.jpg";
            ico.setIcon(icon);
            ass.setAktiv(true);
            try {
                ico.updateSize();
            } catch (Exception e) {
            }
        }
    }

}
