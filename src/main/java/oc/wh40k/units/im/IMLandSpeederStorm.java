package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMLandSpeederStorm extends Eintrag {

	private OptionsUpgradeGruppe o1;

    public IMLandSpeederStorm() {
        name = "Land Speeder Storm";
        grundkosten = getPts("Land Speeder Storm");
        power = 5;

        if(!BuildaHQ.aktBuildaVater.getFormationType().equals("Space Wolves")) {
	        seperator();

	        ogE.addElement(new OptionsGruppeEintrag("Heavy Bolter", getPts("Heavy Bolter (SM other)")));
	        ogE.addElement(new OptionsGruppeEintrag("Heavy Flamer", getPts("Heavy flamer (SM other)")));
	        ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta (SM other)")));
	        ogE.addElement(new OptionsGruppeEintrag("Assault cannon", getPts("Assault cannon (other)")));
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
