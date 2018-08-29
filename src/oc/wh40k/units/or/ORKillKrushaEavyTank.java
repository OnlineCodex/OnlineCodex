package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORKillKrushaEavyTank extends Eintrag {

	
    public ORKillKrushaEavyTank() {
		name = "Kill Krusha \'Eavy Tank";
		grundkosten = 275;


		add(ico = new oc.Picture("oc/wh40k/images/KillKrushaEavyTank.gif"));
		

        ogE.addElement(new OptionsGruppeEintrag("Big Shoota", 5));
		ogE.addElement(new OptionsGruppeEintrag("Skorcha", 5));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", 10));
		ogE.addElement(new OptionsGruppeEintrag("twin Big Shoota", "twin-linked Big Shoota", 10));
		ogE.addElement(new OptionsGruppeEintrag("twin Rokkit Launcha", "twin-linked Rokkit Launcha", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

        seperator();
        
        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Grot Bomm", 2, 20));
        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Grot sponsons", 2, 5));
        
		complete();

	}

	public void refreshen() {
	}
}
