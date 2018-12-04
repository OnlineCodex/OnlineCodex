package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHLordofContagion extends Eintrag {

    OptionsUpgradeGruppe reaper;

    public CHLordofContagion() {

        name = "Lord of Contagion";
        grundkosten = getPts("Lord of Contagion");
        power = 9;

        ogE.addElement(new OptionsGruppeEintrag("Plaguereaper", getPts("Plaguereaper")));
        ogE.addElement(new OptionsGruppeEintrag("Manreaper", getPts("Manreaper")));
        add(reaper = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        reaper.setSelected(0, true);
        
        seperator();
        
        addWarlordTraits("", true);
        
        complete();
    }

    @Override
    public void refreshen() {
        if (!reaper.isSelected()) reaper.setSelected(0, true);
    }
}
