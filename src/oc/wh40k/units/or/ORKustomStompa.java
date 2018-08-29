package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORKustomStompa extends Eintrag {

	OptionsUpgradeGruppe oug1;
	OptionsUpgradeGruppe oug2;
	
	public ORKustomStompa() {

		name = "Kustom Stompa";
		power = 52;
		grundkosten = getPts("Kustom Stompa") + 
					  getPts("big shoota") * 3 + 
					  getPts("supa-rokkit") * 3 + 
					  getPts("skorcha") + 
					  getPts("Gaze of Mork");

		add(ico = new oc.Picture("oc/wh40k/images/KustomStompa.gif"));

		ogE.addElement(new OptionsGruppeEintrag("Deff kanon + Supa-gatler", getPts("deff kannon") + getPts("supa-gatler")));
		ogE.addElement(new OptionsGruppeEintrag("Lifta-droppa", getPts("Lifta-droppa")));
		ogE.addElement(new OptionsGruppeEintrag("Mega klaw", getPts("mega klaw")));
		oug1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
		add(oug1);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Mega klaw", getPts("mega klaw")));
		ogE.addElement(new OptionsGruppeEintrag("Lifta-droppa", getPts("Lifta-droppa")));
		oug2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
		add(oug2);

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "","Belly gun", getPts("belly gun")));

		seperator();
		
		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "","Supa-rokkit" , 2, getPts("supa-rokkit")));
		
		seperator();
		
		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "","Grot sponson",4,getPts("Grot sponson")));
		
		complete();
	}

	//@OVERRIDE
	public void refreshen() {
		oug1.alwaysSelected();
		oug2.alwaysSelected();
	}
}
