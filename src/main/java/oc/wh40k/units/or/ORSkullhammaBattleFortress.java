package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ORSkullhammaBattleFortress extends Eintrag {

	OptionsUpgradeGruppe o1;

	public ORSkullhammaBattleFortress() {
		name = "Skullhamma Battle Fortress";
		grundkosten = 430;

		add(ico = new oc.Picture("oc/wh40k/images/ORKustomBattleFortress.gif"));
		
		ogE.addElement(new OptionsGruppeEintrag("Kannon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Lobba", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "","Supa-Rokkit",3, 20));
		
		seperator();

        ogE.addElement(new OptionsGruppeEintrag("Big Shoota", 10));
		ogE.addElement(new OptionsGruppeEintrag("twin Rokkit Launcha", "twin-linked Rokkit Launcha", 10));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		complete();

	}

	public void refreshen() {
		
		if(!o1.isSelected()){
			o1.setSelected(0, true);
		}
       
	}
}
