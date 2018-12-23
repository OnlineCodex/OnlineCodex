package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.HIVE_MIND;

public class TYHiveTyrant extends Eintrag {

    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    OptionsEinzelUpgrade oe3;
    RuestkammerStarter psychicPowers;
    RuestkammerStarter waffen;

    public TYHiveTyrant() {
        name = "Hive Tyrant";
        grundkosten = getPts("Hive Tyrant") + getPts("Prehensile pincer tail");
        power = 10;

        add(ico = new oc.Picture("oc/wh40k/images/TYSchwarmtyrantFuss.jpg"));

        add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Wings", "Wings", 47)); //Hier gibt es keinen Eintrag

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (Monsters)")));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Hive Tyrant)")));

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(2, HIVE_MIND), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, new TYRuestkammer("Hive Tyrant"));
        waffen.setButtonText("Wargear");
        waffen.setAbwaehlbar(false);
        add(waffen);

        seperator();
        
		addWarlordTraits("", true);
        
        complete();
    }

    @Override
    public void refreshen() {
    	waffen.getPanel().setLocation(
                (int) waffen.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    	
    	warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffen.getPanel().getLocation().getY() + waffen.getPanel().getSize().height + 5
        );
    }


}
