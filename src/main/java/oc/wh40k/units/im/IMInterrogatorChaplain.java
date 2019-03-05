package oc.wh40k.units.im;

import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

public class IMInterrogatorChaplain extends Eintrag {

	private final OptionsEinzelUpgrade jp;

    public IMInterrogatorChaplain() {
        name = "Interrogator-Chaplain";
        grundkosten = getPts("Interrogator-Chaplain") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();

        add(jp = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump pack", getPts("Interrogator-Chaplain with Jump Pack") - getPts("Interrogator-Chaplain")));
                
        seperator();

        addWeapons(IMDarkAngelsRuestkammer.class, true);

        seperator();
        
        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        if (jp.isSelected()) power = 6;
        else power = 5;
    }

}