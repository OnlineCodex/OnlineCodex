package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class IMWatchMaster extends Eintrag {

    RuestkammerStarter waffenUndReliquien;
    RuestkammerStarter spezialAusruestung;
    OptionsUpgradeGruppe o1;

    public IMWatchMaster() {
        name = "Watch Master";
        grundkosten = getPts("Watch Master");

        add(ico = new oc.Picture("oc/wh40k/images/Kommandant.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Guardian spear", getPts("Guardian spear")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
    }
}
