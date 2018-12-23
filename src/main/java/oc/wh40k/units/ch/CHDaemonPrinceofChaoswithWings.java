package oc.wh40k.units.ch;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DISCIPLINE_OF_NURGLE;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DISCIPLINE_OF_TZEENTCH;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DISCIPLINE_OF_SLAANESH;

import oc.*;
import oc.wh40k.units.PsychicPowers;

public class CHDaemonPrinceofChaoswithWings extends Eintrag {
    OptionsUpgradeGruppe mark;
    RuestkammerStarter psychicPowers;
    int lastMark = -1;

    public CHDaemonPrinceofChaoswithWings() {
        super(CHAOS, DAEMON, ALLEGIANCE, CHARACTER, MONSTER, FLY, DAEMON_PRINCE_OF_CHAOS);

        name = "Daemon Prince of Chaos with Wings";
        grundkosten = getPts("Daemon Prince of Chaos with Wings");
        power = 10;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        addWeapons(new CHWaffenkammerCD(name, getKeywords()), false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(1, DISCIPLINE_OF_NURGLE, DISCIPLINE_OF_TZEENTCH, DISCIPLINE_OF_SLAANESH), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        seperator();

        addWarlordTraits("", ALLEGIANCE);

        complete();
    }

    @Override
    public void refreshen() {
        psychicPowers.setAktiv(!mark.isSelected("Mark of Khorne") && (mark.getAnzahl() != 0));

        CHWaffenkammerCD kammer = (CHWaffenkammerCD) getWeapons();

        if(mark.getSelectedIndex() != lastMark) {
        	lastMark = mark.getSelectedIndex();
            kammer.getKeywords().remove(KHORNE);
            kammer.getKeywords().remove(NURGLE);
            kammer.getKeywords().remove(TZEENTCH);
            kammer.getKeywords().remove(SLAANESH);
            kammer.getKeywords().remove(PSYKER);
	        
	        if(mark.isSelected("Mark of Khorne")) {
                kammer.getKeywords().add(KHORNE);
                kammer.getKeywords().remove(ALLEGIANCE);
	        } else if(mark.isSelected("Mark of Nurgle")) {
                kammer.getKeywords().add(NURGLE);
                kammer.getKeywords().add(PSYKER);
                kammer.getKeywords().remove(ALLEGIANCE);
	        } else if(mark.isSelected("Mark of Tzeentch")) {
                kammer.getKeywords().add(TZEENTCH);
                kammer.getKeywords().add(PSYKER);
                kammer.getKeywords().remove(ALLEGIANCE);
	        } else if(mark.isSelected("Mark of Slaanesh")) {
                kammer.getKeywords().add(SLAANESH);
                kammer.getKeywords().add(PSYKER);
                kammer.getKeywords().remove(ALLEGIANCE);
	        }
	        RefreshListener.fireRefresh();
        }
    }
}
