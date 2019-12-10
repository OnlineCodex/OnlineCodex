package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMImpulsor extends Eintrag {

	private final OptionsUpgradeGruppe o1, o2;
	
    public IMImpulsor() {
        name = "Impulsor";
        grundkosten = getPts("Impulsor");
        power = 4;

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ironhail heavy stubber", getPts("Ironhail heavy stubber")));

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("2 Storm bolters", getPts("Storm bolter (SM)")*2));
        ogE.addElement(new OptionsGruppeEintrag("2 Fragstorm grenade launcher", getPts("Fragstorm grenade launcher")*2));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Bellicatus missile array", getPts("Bellicatus missile array")));
        ogE.addElement(new OptionsGruppeEintrag("Ironhail skytalon array", getPts("Ironhail skytalon array")));
        ogE.addElement(new OptionsGruppeEintrag("Orbital comms array", getPts("Orbital comms array")));
        ogE.addElement(new OptionsGruppeEintrag("Shield Dome", getPts("Shield Dome")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        complete();
    }

    @Override
    public void refreshen() {
    	o1.alwaysSelected();
    }
}
