package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMDreadnought extends Eintrag {
	private final OptionsUpgradeGruppe o1, o2;
	private boolean spacewolves = false;
	private boolean deathwatch = false;

    public IMDreadnought() {
    	spacewolves = BuildaHQ.aktBuildaVater.getFormationType().equals("Space Wolves");
    	deathwatch = BuildaHQ.aktBuildaVater.getFormationType().equals("Deathwatch");
        name = "Dreadnought";
        grundkosten = getPts("Dreadnought");
        power = 7;

        seperator();

        if (!buildaVater.getFormationType().equals("Deathwatch")) {
            ogE.addAll(IMSpaceMarinesDreadnoughtHeavyWeapons.createRK("Assault cannon", "Assault cannon (other)", buildaVater));
        } else {
            ogE.addElement(new OptionsGruppeEintrag("Assault cannon", getPts("Assault cannon (other)")));
            if(spacewolves) {
                ogE.addAll(IMSpaceWolvesDreadnoughtHeavyWeapons.createRK("", "", buildaVater));
            }else {
            	ogE.addElement(new OptionsGruppeEintrag("Heavy plasma cannon", getPts("Heavy plasma cannon")));
            	ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));
            }
        }
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("DCW + Storm bolter", "Dreadnought combat weapon + Storm bolter", getPts("Dreadnought combat weapon (other models)") + getPts("Storm bolter (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("DCW + Heavy flamer", "Dreadnought combat weapon + Heavy flamer", getPts("Dreadnought combat weapon (other models)") + getPts("Heavy flamer (SM other)")));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher (SM other)")));
        if (!deathwatch && !spacewolves) {
            ogE.addElement(new OptionsGruppeEintrag("Twin autocannon", getPts("Twin autocannon")));
        }
        if(spacewolves) {
        	ogE.addElement(new OptionsGruppeEintrag("Great wolf claw", getPts("great wolf claw")));
        }
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }
}
