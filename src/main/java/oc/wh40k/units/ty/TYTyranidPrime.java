package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class TYTyranidPrime extends Eintrag {

    private final RuestkammerStarter waffen;

    public TYTyranidPrime() {
        name = "Tyranid Prime";
        grundkosten = getPts("TyranidPrime");
        power = 5;

        add(ico = new oc.Picture("oc/wh40k/images/TYKrieger.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flesh Hooks", getPts("Flesh Hooks")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Tyranid Prime)")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (others)")));

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, new TYRuestkammer(name), "Wargear");
        waffen.setAbwaehlbar(false);
        add(waffen);

        seperator();
        
		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    	warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffen.getPanel().getLocation().getY() + waffen.getPanel().getSize().height + 5
        );
    }
}