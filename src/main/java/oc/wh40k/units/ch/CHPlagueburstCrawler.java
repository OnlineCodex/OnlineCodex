package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CHPlagueburstCrawler extends Eintrag {

	OptionsUpgradeGruppe o1, o2;
	OptionsUpgradeGruppe fkwaffen;
    OptionsUpgradeGruppe mark;
    
	public CHPlagueburstCrawler() {
		name = "Plagueburst Crawler";
		grundkosten = getPts("Plagueburst Crawler") + getPts("Plagueburst mortar");

		add(ico = new oc.Picture("oc/wh40k/images/ChaosPredator.gif"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy slugger", getPts("Heavy slugger")));
		ogE.addElement(new OptionsGruppeEintrag("Rothail volley gun", getPts("Rothail volley gun")));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 Plaguespitter", getPts("Plaguespitter")*2));
		ogE.addElement(new OptionsGruppeEintrag("2 Entropy cannon", getPts("Entropy cannon")*2));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);
		
		complete();
	}

	@Override
	public void refreshen() {		
		power = 10;
	}

}
