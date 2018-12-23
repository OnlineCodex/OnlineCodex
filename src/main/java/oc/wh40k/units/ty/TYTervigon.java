package oc.wh40k.units.ty;

import oc.*;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.HIVE_MIND;

public class TYTervigon extends Eintrag {

    private final OptionsUpgradeGruppe o1;

    private final RuestkammerStarter waffen;
    private final RuestkammerStarter psychicPowers;

    public TYTervigon() {
        name = "Tervigon";
        grundkosten = getPts("Tervigon") + getPts("Stinger salvo");
        power = 13;
        add(ico = new oc.Picture("oc/wh40k/images/TYTervigon.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("Massive Scything Talons", getPts("Massive Scything Talons (Tervigon)")));
        ogE.addElement(new OptionsGruppeEintrag("Massive Crushing Claws", getPts("Massive Crushing Claws")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (Monsters)")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Tervigon)")));

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(1, HIVE_MIND), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();
        
        waffen = new RuestkammerStarter(ID, randAbstand, cnt, new TYRuestkammer("Broodlord"));
        waffen.setButtonText("Wargear");
        waffen.setAbwaehlbar(false);
        add(waffen);

        seperator();
        
		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        
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
