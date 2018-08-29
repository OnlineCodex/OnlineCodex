package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORRuntherd extends Eintrag {

    OptionsUpgradeGruppe o1 = null;
    OptionsUpgradeGruppe o2 = null;

    public ORRuntherd() {
        kategorie = 1;
        name = "Runtherd";
        grundkosten = getPts("Runtherd");
        power = 1;

        add(ico = new oc.Picture("oc/wh40k/images/Runtherd.gif"));

        
        ogE.addElement(new OptionsGruppeEintrag("Grabba Stikk", getPts("Grabba Stikk")));
        ogE.addElement(new OptionsGruppeEintrag("Grot-prod", getPts("Grot-prod")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
        seperator();
    
        ogE.addElement(new OptionsGruppeEintrag("Grot lash", getPts("Grot lash")));
        ogE.addElement(new OptionsGruppeEintrag("Squig hound", getPts("Squig hound")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }

    @Override
    public void refreshen() {
    	o1.alwaysSelected();
    }

}
