package oc.wh40k.units.cd;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CDSeelenzermalmer extends Eintrag {

    OptionsUpgradeGruppe mal, waffe;

    public CDSeelenzermalmer() {

        name = "Seelenzermalmer";

        grundkosten = 135;

        add(ico = new oc.Picture("oc/wh40k/images/CDSeelenzermalmer.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Dämon des Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Dämon des Tzeentch", 5));
        ogE.addElement(new OptionsGruppeEintrag("Dämon des Nurgle", 15));
        ogE.addElement(new OptionsGruppeEintrag("Dämon des Slaanesh", 15));
        add(mal = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hexenfeuerschwall", 20));
        ogE.addElement(new OptionsGruppeEintrag("Warpblick", 25));
        ogE.addElement(new OptionsGruppeEintrag("Explodierender Auswurf", 30));
        add(waffe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Warpschwert", 25));

        complete();

    }

    @Override
    public void refreshen() {
        if (mal.getAnzahl() < 1) {
            mal.setLegal(false);
            setFehlermeldung("Wähle einen Gott");
        } else {
            mal.setLegal(true);
            setFehlermeldung("");
        }
    }
}
