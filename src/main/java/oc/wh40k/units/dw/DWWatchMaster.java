package oc.wh40k.units.dw;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DWWatchMaster extends Eintrag {

    RuestkammerStarter waffenUndReliquien;
    RuestkammerStarter spezialAusruestung;
    OptionsUpgradeGruppe o1;

    public DWWatchMaster() {
        name = "Watch Master";
        grundkosten = getPts("Watch Master");

        add(ico = new oc.Picture("oc/wh40k/images/Kommandant.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Guardian spear", getPts("Guardian spear")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 0));

        complete();
    }

    @Override
    public void deleteYourself() {

        super.deleteYourself();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
    }

}
