package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMVenerableDreadnought extends Eintrag {
    OptionsUpgradeGruppe o1, o2;
    boolean spacewolves = false;
    boolean deathwatch = false;
	OptionsEinzelUpgrade greatAxe;

    public IMVenerableDreadnought() {
    	spacewolves = BuildaHQ.aktBuildaVater.getFormationType().equals("Space Wolves");
    	deathwatch = BuildaHQ.aktBuildaVater.getFormationType().equals("Deathwatch");
        name = "Venerable Dreadnought";
        grundkosten = getPts("Venerable Dreadnought");
        power = 8;

        seperator();
        if(spacewolves) {
            ogE.addAll(IMSpaceWolvesDreadnoughtHeavyWeapons.createRK("Assault cannon", "Assault cannon", buildaVater));
        }else if (deathwatch) {
            ogE.addElement(new OptionsGruppeEintrag("Assault cannon", getPts("Assault cannon")));
            ogE.addElement(new OptionsGruppeEintrag("Heavy plasma cannon", getPts("Heavy plasma cannon")));
            ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));
        } else {
            ogE.addAll(IMSpaceMarinesDreadnoughtHeavyWeapons.createRK("Assault cannon", "Assault cannon", buildaVater));
        }
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("DCW + Storm bolter", "Dreadnought combat weapon + Storm bolter", getPts("Dreadnought combat weapon (other models)") + getPts("Storm bolter (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("DCW + Heavy flamer", "Dreadnought combat weapon + Heavy flamer", getPts("Dreadnought combat weapon (other models)") + getPts("Heavy flamer (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher (SM)")));
        if (!deathwatch && !spacewolves) {
            ogE.addElement(new OptionsGruppeEintrag("Twin autocannon", getPts("Twin autocannon")));
        }
        if(spacewolves) {
        	ogE.addElement(new OptionsGruppeEintrag("Great wolf claw", getPts("great wolf claw")));
        }
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        if(spacewolves) {
            seperator();
            
			add(greatAxe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Great axe + Blizzard shield", "Fenrisian great axe + Blizzard shield", getPts("Fenrisian great axe") + getPts("Blizzard shield")));
        }
        
        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        if(spacewolves) {
    		o1.setAktiv(!greatAxe.isSelected());
    		o2.setAktiv(!greatAxe.isSelected());
        }
    }
}
