package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHFoulBlightspawn extends Eintrag {

    OptionsUpgradeGruppe bell, pp;

    public CHFoulBlightspawn() {

        name = "Foul Blightspawn";
        grundkosten = getPts("Foul Blightspawn");
        power = 4;

        ogE.addElement(new OptionsGruppeEintrag("Plague sprayer", getPts("Plague sprayer")));
        add(bell = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
        seperator();
        
        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        bell.setSelected(0, true);
    }
}
