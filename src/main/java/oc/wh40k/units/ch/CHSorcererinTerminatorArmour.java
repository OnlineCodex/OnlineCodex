package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHSorcererinTerminatorArmour extends Eintrag {

    RuestkammerStarter waffen;
    OptionsUpgradeGruppe mark;

    RuestkammerStarter psychicPowers;

    public CHSorcererinTerminatorArmour() {

        name = "Sorcerer in Terminator Armour";
        grundkosten = getPts("Sorcerer in Terminator Armour");
        power = 8;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, "CHWaffenkammer", "");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultFK("Combi-bolter");
        ((CHWaffenkammer) waffen.getKammer()).setDefaultNK("Force sword");
        ((CHWaffenkammer) waffen.getKammer()).setChampion(true);
        ((CHWaffenkammer) waffen.getKammer()).setTerminatorArmour(true);
        ((CHWaffenkammer) waffen.getKammer()).setSorcerer(true);
        waffen.initKammer(true, true, true, false);
        waffen.setButtonText("Waffenkammer");
        add(waffen);
        waffen.setAbwaehlbar(false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, "PsychicPowers", "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableDarkHereticus();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        complete();

    }

    @Override
    public void refreshen() {
        ((PsychicPowers) psychicPowers.getKammer()).setNurgle(mark.isSelected("Mark of Nurgle"));
        ((PsychicPowers) psychicPowers.getKammer()).setTzeentch(mark.isSelected("Mark of Tzeentch"));
        ((PsychicPowers) psychicPowers.getKammer()).setSlaanesh(mark.isSelected("Mark of Slaanesh"));
    }
}
