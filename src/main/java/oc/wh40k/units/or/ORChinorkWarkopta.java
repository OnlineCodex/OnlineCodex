package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORChinorkWarkopta extends Eintrag {

	OptionsEinzelUpgrade ball;
	OptionsUpgradeGruppe tech;
	OptionsUpgradeGruppe tech2;

	public ORChinorkWarkopta() {
		grundkosten = getPts("'Chinork' Warkopta");
		power = 8;
		name= "'Chinork' Warkopta";
		add(ico = new oc.Picture("oc/wh40k/images/Pikk-Up.gif"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Big shoota", getPts("Big shoota")));
        ogE.addElement(new OptionsGruppeEintrag("Skorcha", getPts("Skorcha")));
        ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha", getPts("Rokkit launcha")));
        ogE.addElement(new OptionsGruppeEintrag("Kustom mega-blasta", getPts("Kustom mega-blasta")));
        add(tech = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("2 Deffgunz", getPts("Deffgun") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Rattler kannons", getPts("Rattler kannon") * 2));
        ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha", getPts("Rokkit launcha")));
        add(tech2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
		seperator();

        add(ball=new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "2 Bigbomms", getPts("Bigbomm") * 2));

		complete();
	}

	// @OVERRIDE
	public void refreshen() {
		tech.alwaysSelected();
		tech2.alwaysSelected();
	}

}
