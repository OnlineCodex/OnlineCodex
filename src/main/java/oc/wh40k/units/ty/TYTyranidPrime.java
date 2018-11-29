package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.Warlordtraits;

public class TYTyranidPrime extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

    RuestkammerStarter waffen;
    RuestkammerStarter warlord;

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

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, TYRuestkammer.class, "Wargear");
        ((TYRuestkammer) waffen.getKammer()).setType("Tyranid Prime");
        waffen.initKammer();
        add(waffen);
        waffen.setAbwaehlbar(false);

        seperator();
        
        warlord = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
        warlord.initKammer();
        warlord.setUeberschriftTrotzNullKostenAusgeben(true);
        warlord.setButtonText("Warlord");
        add(warlord);

        complete();
    }

    @Override
    public void refreshen() {
    	warlord.getPanel().setLocation(
                (int) warlord.getPanel().getLocation().getX(),
                (int) waffen.getPanel().getLocation().getY() + waffen.getPanel().getSize().height + 5
        );
    }

}
