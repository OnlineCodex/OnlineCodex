package oc.wh40k.units.ty;

import oc.*;
import oc.wh40k.units.PsychicPowers;
import oc.wh40k.units.Warlordtraits;

public class TYTervigon extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;

    RuestkammerStarter waffen;
    RuestkammerStarter psychicPowers;
    RuestkammerStarter warlord;

    public TYTervigon() {
        name = "Tervigon";
        grundkosten = getPts("Tervigon") + getPts("Stinger salvo");
        power = 13;
        add(ico = new oc.Picture("oc/wh40k/images/TYTervigon.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("Massive Scything Talons", getPts("Massive Scything Talons (Tervigon)")));
        ogE.addElement(new OptionsGruppeEintrag("Massive Crushing Claws", getPts("Massive Crushing Claws")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (Monsters)")));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Tervigon)")));

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enableHiveMind();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();
        
        waffen = new RuestkammerStarter(ID, randAbstand, cnt, TYRuestkammer.class, "");
        ((TYRuestkammer) waffen.getKammer()).setType("Broodlord");
        waffen.initKammer();
        add(waffen);
        waffen.setButtonText("Wargear");
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
        o1.alwaysSelected();
        
        waffen.getPanel().setLocation(
                (int) waffen.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    	
    	warlord.getPanel().setLocation(
                (int) warlord.getPanel().getLocation().getX(),
                (int) waffen.getPanel().getLocation().getY() + waffen.getPanel().getSize().height + 5
        );
    }


}
