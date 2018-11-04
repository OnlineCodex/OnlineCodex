package oc.wh40k.units.ae;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class AELelithHesperax extends Eintrag {

    OptionsUpgradeGruppe o1;

    public AELelithHesperax() {
        name = "Lelith Hesperax";
        grundkosten = getPts("Lelith Hesperax");

        ogE.addElement(new OptionsGruppeEintrag("Penetrating blade", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Impaler", getPts("")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        power = 7;
        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}