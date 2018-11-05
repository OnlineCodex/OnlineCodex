package oc.wh40k.units.cd;

import oc.Eintrag;

public class CDSkarbrand extends Eintrag {

    public CDSkarbrand() {

        name = "Skarbrand";
        grundkosten = getPts("Skarbrand");
        power = 19;
        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }
}
