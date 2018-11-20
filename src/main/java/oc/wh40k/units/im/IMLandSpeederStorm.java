package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMLandSpeederStorm extends Eintrag {

    AnzahlPanel squad;
    OptionsUpgradeGruppe o1;

    public IMLandSpeederStorm() {
        name = "Land Speeder Storm";
        grundkosten = getPts("Land Speeder Storm");
        power = 5;
        
        if(!BuildaHQ.aktBuildaVater.getFormationType().equals("Space Wolves")) {
	        seperator();
	
	        ogE.addElement(new OptionsGruppeEintrag("Heavy Bolter", getPts("Heavy Bolter (SM)")));
	        ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", getPts("Heavy Flamer (SM)")));
	        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta (SM)")));
	        ogE.addElement(new OptionsGruppeEintrag("Assault cannon", getPts("Assault cannon")));
	        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }
        complete();
    }

    @Override
    public void refreshen() {
    	if(!BuildaHQ.aktBuildaVater.getFormationType().equals("Space Wolves")) {
    		o1.alwaysSelected();
    	}
    }

}
