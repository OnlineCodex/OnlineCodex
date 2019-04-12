package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

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
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (Monsters)")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Tervigon)")));

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

		addWarlordTraits("");

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
