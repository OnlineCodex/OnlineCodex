package oc.wh40k.units.ne;

import oc.*;

public class NETransporterKammer extends RuestkammerVater {

    private final OptionsUpgradeGruppe typ;
    private final OptionsEinzelUpgrade ass;

    private final boolean offerNight;

    public NETransporterKammer(boolean offerGhost, boolean offerNight) {
        this.offerNight = offerNight;

        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/NEGhost Ark.jpg"));


        if (offerGhost) {
            ogE.addElement(new OptionsGruppeEintrag("Geister-Barke", 105));
        }
        if (this.offerNight) {
            ogE.addElement(new OptionsGruppeEintrag("Night Scythe", 130));
        }
        add(typ = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        if (this.offerNight) {
            seperator();
            add(ass = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fliegerass", 50));
        } else {
            ass = null;
        }

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (!typ.isSelected()) {
            typ.setSelected(0, true);
        }

        if (typ.isSelected("Geister-Barke")) {
            if (this.offerNight) {
                ass.setAktiv(false);
            }

            String icon = "oc/wh40k/images/NEGhost Ark.jpg";
            ico.setIcon(icon);
            try {
                ico.updateSize();
            } catch (Exception e) {
            }
        } else { // Night Scythe
            ass.setAktiv(true);

            String icon = "oc/wh40k/images/NENight Scythe.jpg";
            ico.setIcon(icon);
            try {
                ico.updateSize();
            } catch (Exception e) {
            }
        }
    }

}
