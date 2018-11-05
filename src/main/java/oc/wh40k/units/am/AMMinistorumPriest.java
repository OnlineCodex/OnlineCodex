package oc.wh40k.units.am;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class AMMinistorumPriest extends Eintrag {

    OptionsUpgradeGruppe o1;

    public AMMinistorumPriest() {
        name = "Ministorum Priest";
        grundkosten = 25;
        this.setEintragsCNT(0);

        addToInformationVector("AMMinistorumPriest", 1);

        add(ico = new oc.Picture("oc/wh40k/images/IGMinistrorumPriest.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sturmgewehr", 0));
        ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));

        complete();
    }

    @Override
    public void refreshen() {
        if (getCountFromInformationVector("AMMinistorumPriest") > 3) {
            setFehlermeldung("0-3 Auswahl!");
        } else {
            setFehlermeldung("");
        }
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        addToInformationVector("AMMinistorumPriest", -1);
    }

}
