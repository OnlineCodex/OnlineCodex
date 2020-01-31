package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;
import oc.wh40k.units.Warlordtraits;

public class IMOrdoMalleusInquisitorinTerminatorArmour extends Eintrag {
	private final RuestkammerStarter psychicPowers;
	private final OptionsUpgradeGruppe o1;
	
    public IMOrdoMalleusInquisitorinTerminatorArmour() {
    	super(IMPERIUM, INQUISITION);
        name = "Ordo Malleus Inquisitor in Terminator Armour";
        grundkosten = getPts("Ordo Malleus Inquisitor in Terminator Armour");
        power = 6;

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Ordo Malleus", 0));
        //ogE.addElement(new OptionsGruppeEintrag("Ordo Xenos", 0));
        //ogE.addElement(new OptionsGruppeEintrag("Ordo Hereticus", 0));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);
        
        seperator();
        
        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setMalleus(true);
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableTelethesiaDiscipline();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);
        
        seperator();
        
        addWeapons(IMInquistionRuestkammer.class, true);
        
        seperator();
        
		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    	
    	((PsychicPowers) psychicPowers.getKammer()).setMalleus(o1.isSelected("Ordo Malleus"));
    	((PsychicPowers) psychicPowers.getKammer()).setXenos(o1.isSelected("Ordo Xenos"));
    	((PsychicPowers) psychicPowers.getKammer()).setHereticus(o1.isSelected("Ordo Hereticus"));
    	
    	if(o1.isSelected("Ordo Malleus")) {
    		addKeyword(ORDO_MALLEUS);
    		removeKeyword(ORDO_HERETICUS);
    		removeKeyword(ORDO_XENOS);
    	} else if(o1.isSelected("Ordo Hereticus")) {
    		removeKeyword(ORDO_MALLEUS);
    		addKeyword(ORDO_HERETICUS);
    		removeKeyword(ORDO_XENOS);
    	} else if(o1.isSelected("Ordo Xenos")) {
    		removeKeyword(ORDO_MALLEUS);
    		removeKeyword(ORDO_HERETICUS);
    		addKeyword(ORDO_XENOS);
    	}
    	
        String selectedTrait = (((Warlordtraits)getWarlordtraits()).getSelectedTrait());
        if(selectedTrait.equalsIgnoreCase("Ordo Malleus: Psychic Mastery")) {
        	((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(3);
        } else {
        	((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        }
    }

}
