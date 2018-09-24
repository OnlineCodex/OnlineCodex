package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ORBattlewagon extends Eintrag {

	OptionsEinzelUpgrade Panzakanonä;
	OptionsUpgradeGruppe FK2;
	OptionsZaehlerGruppe KampfpanzaFK;

	public ORBattlewagon() {

		name = "Battlewagon";
		grundkosten = getPts("Battlewagon");
		power = 11;

		add(ico = new oc.Picture("oc/wh40k/images/Kampfpanza.gif"));


		add(Panzakanonä = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Killkannon", getPts("Killkannon")));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Kannon", getPts("Kannon")));
		ogE.addElement(new OptionsGruppeEintrag("Lobba", getPts("Lobba")));
		ogE.addElement(new OptionsGruppeEintrag("Zzap gun", getPts("Zzap gun")));
		add(FK2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Big shoota", getPts("Big shoota")));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha", getPts("Rokkit launcha")));
		add(KampfpanzaFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Deff rolla", getPts("Deff rolla")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "'Ard Case", getPts("'Ard Case")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grabbin' klaw", getPts("Grabbin' klaw")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wreckin' ball", getPts("Wreckin' ball")));

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
	}
}
