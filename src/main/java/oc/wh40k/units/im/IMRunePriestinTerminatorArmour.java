package oc.wh40k.units.im;

import oc.*;
import oc.wh40k.units.PsychicPowers;

public class IMRunePriestinTerminatorArmour extends Eintrag {

    OptionsEinzelUpgrade oe1;
    RuestkammerStarter waffenUndArtefakte;
    boolean fenrisSupp = false;
	RuestkammerStarter psychicPowers;

    public IMRunePriestinTerminatorArmour() {
        name = "Rune Priest on Bike";
        grundkosten = getPts("Rune Priest on Bike");
        power = 8;

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Psychic hood", getPts("psychic hood")));
        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Runic Terminator armour", getPts("runic Terminator armour")));

        seperator();
        
        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableTempestasDiscipline();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(false);

        seperator();

        waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceWolvesRuestkammer.class, "");
        ((IMSpaceWolvesRuestkammer) waffenUndArtefakte.getKammer()).setType("Rune Priest in Terminator Armour");
        waffenUndArtefakte.initKammer();
        waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen"));
        add(waffenUndArtefakte);
        waffenUndArtefakte.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        waffenUndArtefakte.getPanel().setLocation(
                (int) waffenUndArtefakte.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }

}
