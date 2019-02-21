package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class TYHiveTyrant extends Eintrag {

    private final OptionsEinzelUpgrade oe1;
    private final OptionsEinzelUpgrade oe2;
    private final OptionsEinzelUpgrade oe3;
    private final RuestkammerStarter psychicPowers;
    private final RuestkammerStarter waffen;

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

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableHiveMind();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, TYRuestkammer.class, "");
        ((TYRuestkammer) waffen.getKammer()).setType("Hive Tyrant");
        waffen.initKammer();
        add(waffen);
        waffen.setButtonText("Wargear");
        waffen.setAbwaehlbar(false);

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
