package oc.wh40k.units.am;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class AMLightning extends Eintrag {

    OptionsUpgradeGruppe o1;

	public AMLightning() {
		name = "Lightning";
		grundkosten = 145;

		add(ico = new oc.Picture("oc/wh40k/images/LightningKampfbomber.gif"));
		
        ogE.addElement(new OptionsGruppeEintrag("L/B autocannon", "long barreled autocannon", 0));
  	    ogE.addElement(new OptionsGruppeEintrag("hellstrike missiles", "two hellstrike missiles", 0));
  	    ogE.addElement(new OptionsGruppeEintrag("tactical bombs", "2 tactical bombs and Strafing Run", 0));
  	    add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("hellstrike missiles", "four hellstrike missiles", 40));
  	    ogE.addElement(new OptionsGruppeEintrag("hellfury missiles", "four hellfury missiles", 40));
        ogE.addElement(new OptionsGruppeEintrag("tactical bombs", "four tactical bombs", 40));
  	    ogE.addElement(new OptionsGruppeEintrag("skystrike missiles", "six skystrike missiles", 50));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();
        
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "chaff launcher", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "infra-red targeting", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "illum flares", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "paint sheme", "distinctive paint sheme", 10));

		complete();

	}

	public void refreshen() {
        o1.alwaysSelected();
	}
}
