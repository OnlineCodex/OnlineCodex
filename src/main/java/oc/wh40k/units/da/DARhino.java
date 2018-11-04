package oc.wh40k.units.da;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DARhino extends Eintrag {
    OptionsUpgradeGruppe o1;

    public DARhino() {
        name = "Rhino";
        grundkosten = 35;

        add(ico = new oc.Picture("oc/wh40k/images/SWEhrwuerdigerCybot.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bulldozerschaufel", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("HK Rakete", 10));
        ogE.addElement(new OptionsGruppeEintrag("Zusatzpanzerung", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setMaxAnzahl(o1.getNumberOfOptions());

        complete();
    }

    @Override
    public void refreshen() {
    }
}
