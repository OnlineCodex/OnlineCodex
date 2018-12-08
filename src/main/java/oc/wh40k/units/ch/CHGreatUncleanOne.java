package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHGreatUncleanOne extends Eintrag {

    OptionsUpgradeGruppe o1;
    RuestkammerStarter psychicPowers;

    public CHGreatUncleanOne() {

        name = "Great Unclean One";
        grundkosten = 0;
        power = 12;

        ogE.addElement(new OptionsGruppeEintrag("Bilesword and bileblade", getPts("Great Unclean one with Bilesword and bileblade")));
        ogE.addElement(new OptionsGruppeEintrag("Bilesword and plague fail", getPts("Great Unclean one with Bilesword and plague fail")));
        ogE.addElement(new OptionsGruppeEintrag("Doomsday bell and bileblade", getPts("Great Unclean one with Doomsday bell and bileblade")));
        ogE.addElement(new OptionsGruppeEintrag("Doomsday bell and plague fail", getPts("Great Unclean one with Doomsday bell and plague fail")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableNurgle();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();
        
        addWarlordTraits("", true);

        complete();

    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}
