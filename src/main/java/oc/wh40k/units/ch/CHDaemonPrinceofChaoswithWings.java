package oc.wh40k.units.ch;

import static oc.KeyWord.ALLEGIANCE;
import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.DAEMON_PRINCE_OF_CHAOS;
import static oc.KeyWord.FLY;
import static oc.KeyWord.KHORNE;
import static oc.KeyWord.MONSTER;
import static oc.KeyWord.NURGLE;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.SLAANESH;
import static oc.KeyWord.TZEENTCH;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHDaemonPrinceofChaoswithWings extends Eintrag {
	private final OptionsUpgradeGruppe mark;
	private final RuestkammerStarter psychicPowers;
	private int lastMark = -1;

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
        add(mark = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        addWeapons(CHWaffenkammerCD.class, true);

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

        addWarlordTraits("", ALLEGIANCE);

        complete();
    }

    @Override
    public void refreshen() {
        psychicPowers.setAktiv(!mark.isSelected("Mark of Khorne") && !(mark.getAnzahl() == 0));

        ((PsychicPowers) psychicPowers.getKammer()).setNurgle(mark.isSelected("Mark of Nurgle"));
        ((PsychicPowers) psychicPowers.getKammer()).setTzeentch(mark.isSelected("Mark of Tzeentch"));
        ((PsychicPowers) psychicPowers.getKammer()).setSlaanesh(mark.isSelected("Mark of Slaanesh"));


        if(mark.getSelectedIndex() != lastMark) {
        	lastMark = mark.getSelectedIndex();
	        getWeapons().removeKeyword(KHORNE);
	        getWeapons().removeKeyword(NURGLE);
	        getWeapons().removeKeyword(TZEENTCH);
	        getWeapons().removeKeyword(SLAANESH);
	        getWeapons().removeKeyword(PSYKER);

	        if(mark.isSelected("Mark of Khorne")) {
	        	getWeapons().addKeyword(KHORNE);
	            getWeapons().removeKeyword(ALLEGIANCE);
	        } else if(mark.isSelected("Mark of Nurgle")) {
	        	getWeapons().addKeyword(NURGLE);
	        	getWeapons().addKeyword(PSYKER);
	            getWeapons().removeKeyword(ALLEGIANCE);
	        } else if(mark.isSelected("Mark of Tzeentch")) {
	        	getWeapons().addKeyword(TZEENTCH);
	        	getWeapons().addKeyword(PSYKER);
	            getWeapons().removeKeyword(ALLEGIANCE);
	        } else if(mark.isSelected("Mark of Slaanesh")) {
	        	getWeapons().addKeyword(SLAANESH);
	        	getWeapons().addKeyword(PSYKER);
	            getWeapons().removeKeyword(ALLEGIANCE);
	        }
	        RefreshListener.fireRefresh();
        }
    }
}
