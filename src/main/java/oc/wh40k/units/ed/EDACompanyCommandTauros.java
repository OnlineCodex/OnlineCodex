package oc.wh40k.units.ed;

import oc.Eintrag;

public class EDACompanyCommandTauros extends Eintrag {

    public EDACompanyCommandTauros() {
        name = "A-Company Command Tauros";
        grundkosten = 60;


        add(ico = new oc.Picture("oc/wh40k/images/ACompanyCommandTauros.jpg"));


        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }

}
