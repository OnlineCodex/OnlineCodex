package oc.wh40k.units.ia;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IATechPriestEnginseer extends Eintrag {

	public IATechPriestEnginseer() {
		name = "Tech-Priest Enginseer";
		grundkosten = 40;

		add(ico = new oc.Picture("oc/wh40k/images/IGTechpriestEnginseer.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "", "Melterbomben", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "", "Digitalwaffen", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "", "Refractor Feld", 10));

		seperator();
		
		complete();
	}

	@Override
	public void refreshen() {
			}

	@Override
	public void deleteYourself() {
	}

}
