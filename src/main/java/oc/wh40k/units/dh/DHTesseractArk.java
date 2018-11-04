package oc.wh40k.units.dh;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DHTesseractArk extends Eintrag {

    OptionsUpgradeGruppe weapons;

    public DHTesseractArk() {
        grundkosten = 250;
        name = "Tesseract Ark";
        add(ico = new oc.Picture("oc/wh40k/images/NEKommandogleiter.jpg"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Tesla cannons", 0));
        ogE.addElement(new OptionsGruppeEintrag("2 Gauss cannons", 0));
        ogE.addElement(new OptionsGruppeEintrag("2 Particle beamers", 20));
        add(weapons = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        if (!weapons.isSelected()) {
            weapons.setSelected(0, true);
        }
    }
}
