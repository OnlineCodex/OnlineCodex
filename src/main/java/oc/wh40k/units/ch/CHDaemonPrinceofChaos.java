package oc.wh40k.units.ch;

import static oc.KeyWord.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.*;

import oc.*;
import oc.wh40k.units.PsychicPowers;

import java.util.Set;

public class CHDaemonPrinceofChaos extends Eintrag {

    private final OptionsUpgradeGruppe mark;
    private final RuestkammerStarter psychicPowers;
    private int lastMark = -1;

    public CHDaemonPrinceofChaos() {
        super(CHAOS, DAEMON, ALLEGIANCE, CHARACTER, MONSTER, DAEMON_PRINCE_OF_CHAOS);

        name = "Daemon Prince of Chaos";
        grundkosten = getPts("Daemon Prince of Chaos");
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

        if(mark.getSelectedIndex() != lastMark) {
            lastMark = mark.getSelectedIndex();
            Set<KeyWord> keywords = ((CHWaffenkammerCD) getWeapons()).getKeywords();
            keywords.remove(KHORNE);
	        keywords.remove(NURGLE);
            keywords.remove(TZEENTCH);
            keywords.remove(SLAANESH);
            keywords.remove(PSYKER);
	        
	        if(mark.isSelected("Mark of Khorne")) {
                keywords.add(KHORNE);
                keywords.remove(ALLEGIANCE);
	        } else if(mark.isSelected("Mark of Nurgle")) {
                keywords.add(NURGLE);
                keywords.add(PSYKER);
                keywords.remove(ALLEGIANCE);
	        } else if(mark.isSelected("Mark of Tzeentch")) {
                keywords.add(TZEENTCH);
                keywords.add(PSYKER);
                keywords.remove(ALLEGIANCE);
	        } else if(mark.isSelected("Mark of Slaanesh")) {
                keywords.add(SLAANESH);
                keywords.add(PSYKER);
                keywords.remove(ALLEGIANCE);
	        }
	        RefreshListener.fireRefresh();
        }
    }
}
