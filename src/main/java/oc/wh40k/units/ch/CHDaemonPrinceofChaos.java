package oc.wh40k.units.ch;

import com.google.common.collect.ImmutableSet;

import oc.*;
import oc.wh40k.units.PsychicPowers;

public class CHDaemonPrinceofChaos extends Eintrag {

    OptionsUpgradeGruppe waffe1;
    OptionsEinzelUpgrade waffe2;
    OptionsUpgradeGruppe mark;
    RuestkammerStarter psychicPowers;

    public CHDaemonPrinceofChaos() {

        name = "Daemon Prince of Chaos";
        grundkosten = getPts("Daemon Prince of Chaos");
        power = 10;
        setKeywords(ImmutableSet.of(CHAOS, DAEMON, ALLEGIANCE, CHARACTER, MONSTER, DAEMON_PRINCE_OF_CHAOS));
        
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        addWeapons(CHWaffenkammerCD.class, false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enableNurgle();
        ((PsychicPowers) psychicPowers.getKammer()).enableTzeentch();
        ((PsychicPowers) psychicPowers.getKammer()).enableSlaanesh();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();

        addWarlordTraits("", true, ALLEGIANCE);

        complete();
    }

    @Override
    public void refreshen() {
        psychicPowers.setAktiv(!mark.isSelected("Mark of Khorne") && (mark.getAnzahl() != 0));
    }
}
