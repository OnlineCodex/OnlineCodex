package oc.wh40k.units.ch;

import static oc.KeyWord.ALLEGIANCE;
import static oc.KeyWord.KHORNE;
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

public class CHDarkApostle extends Eintrag {

	private final OptionsUpgradeGruppe mark;
	private int lastMark = -1;
	private final RuestkammerStarter psychicPowers;

    public CHDarkApostle() {

        name = "Dark Apostle";
        grundkosten = getPts("DarkApostle");
        power = 5;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        addWeapons(CHCSMRuestkammer.class, true);

        seperator();

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enablePrayers();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setButtonText("Prayers");
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(false);

        seperator();

        seperator();

        addWarlordTraits("");

        setInformationVectorValue("Dark Apostle", getCountFromInformationVector("Dark Apostle") + 1);

        complete();

    }

    @Override
    public void refreshen() {
    	((PsychicPowers) psychicPowers.getKammer()).setKhorne(mark.isSelected("Mark of Khorne"));
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
	            getWeapons().removeKeyword(ALLEGIANCE);
	        } else if(mark.isSelected("Mark of Tzeentch")) {
	        	getWeapons().addKeyword(TZEENTCH);
	            getWeapons().removeKeyword(ALLEGIANCE);
	        } else if(mark.isSelected("Mark of Slaanesh")) {
	        	getWeapons().addKeyword(SLAANESH);
	            getWeapons().removeKeyword(ALLEGIANCE);
	        }
	        RefreshListener.fireRefresh();
        }
    }

    @Override
    public void deleteYourself() {
    	setInformationVectorValue("Dark Apostle", getCountFromInformationVector("Dark Apostle") - 1);
    }
}
