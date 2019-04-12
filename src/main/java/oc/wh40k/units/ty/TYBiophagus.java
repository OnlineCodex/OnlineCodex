package oc.wh40k.units.ty;



import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TYBiophagus extends Eintrag {

    private final OptionsUpgradeGruppe o1;

    public TYBiophagus() {

        name = "Biophagus";

        grundkosten = getPts("Biophagus");

        ogE.addElement(new OptionsGruppeEintrag("Alchemicus familiar", getPts("Familiars")));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        power = 2;

        complete();

    }

    @Override

    public void refreshen() {
    	o1.alwaysSelected();
    }

}

