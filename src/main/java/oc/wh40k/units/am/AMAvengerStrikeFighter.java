package oc.wh40k.units.am;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class AMAvengerStrikeFighter extends Eintrag {

	public AMAvengerStrikeFighter() {
		name = "Avenger Strike Fighter";
		grundkosten = 150;

		add(ico = new oc.Picture("oc/wh40k/images/LightningKampfbomber.gif"));
		
        ogE.addElement(new OptionsGruppeEintrag("6 Tactical Bombs", 40));
  	    ogE.addElement(new OptionsGruppeEintrag("2 Hellstrike missiles", 20));
        ogE.addElement(new OptionsGruppeEintrag("2 Hellfury missiles", 20));
  	    ogE.addElement(new OptionsGruppeEintrag("2 missile launchers", 40));
  	    ogE.addElement(new OptionsGruppeEintrag("2 autocannon 30", 30));
	    ogE.addElement(new OptionsGruppeEintrag("2 multi-lasers", 30));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();
        
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "chaff launcher", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "infra-red targeting", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "illum flares", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "paint sheme", "distinctive paint sheme", 10));

		complete();

	}

	public void refreshen() {
	}
}
