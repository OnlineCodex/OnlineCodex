package oc.wh40k.units.ch;

import static oc.KeyWord.ALLEGIANCE;
import static oc.KeyWord.KHORNE;
import static oc.KeyWord.NURGLE;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.SLAANESH;
import static oc.KeyWord.TZEENTCH;

import oc.*;
import oc.wh40k.units.PsychicPowers;

public class CHSorcerer extends Eintrag {

	private final OptionsUpgradeGruppe mark;
	private int lastMark = -1;
	private final RuestkammerStarter psychicPowers;

    public CHSorcerer() {

        name = "Sorcerer";
        grundkosten = getPts("Sorcerer");
        power = 7;

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump pack", getPts("Sorcerer with Jump Pack") - getPts("Sorcerer")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        
        addWeapons(CHCSMRuestkammer.class, true);
        
        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableDarkHereticus();
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
