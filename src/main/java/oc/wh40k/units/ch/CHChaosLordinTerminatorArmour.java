package oc.wh40k.units.ch;

import static oc.KeyWord.ALLEGIANCE;
import static oc.KeyWord.KHORNE;
import static oc.KeyWord.NURGLE;
import static oc.KeyWord.SLAANESH;
import static oc.KeyWord.TZEENTCH;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RefreshListener;

public class CHChaosLordinTerminatorArmour extends Eintrag {

	private final OptionsUpgradeGruppe mark;
	private int lastMark = -1;

    public CHChaosLordinTerminatorArmour() {

        name = "Chaos Lord in Terminator Armour";
        grundkosten = getPts("Chaos Lord in Terminator Armour");
        power = 7;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        addWeapons(CHCSMRuestkammer.class, true);

        seperator();

        addWarlordTraits("");

        complete();
    }

    @Override
    public void refreshen() {

        if(mark.getSelectedIndex() != lastMark) {
        	lastMark = mark.getSelectedIndex();
	        getWeapons().removeKeyword(KHORNE);
	        getWeapons().removeKeyword(NURGLE);
	        getWeapons().removeKeyword(TZEENTCH);
	        getWeapons().removeKeyword(SLAANESH);

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
}
