package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ORBonebreaka extends Eintrag {

	OptionsUpgradeGruppe fk;
	OptionsZaehlerGruppe fk2;
	OptionsEinzelUpgrade deffrolla;

	public ORBonebreaka() {

		name = "Bonebreaka";
		grundkosten = getPts("Bonebreaka");
		power = 9;

		add(ico = new oc.Picture("oc/wh40k/images/Kampfpanza.gif"));

		ogE.addElement(new OptionsGruppeEintrag("Kannon", getPts("Kannon")));
		ogE.addElement(new OptionsGruppeEintrag("Killkannon", getPts("Killkannon")));
		ogE.addElement(new OptionsGruppeEintrag("Zzap gun", getPts("Zzap gun")));
		add(fk = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Big shoota", getPts("Big shoota")));
		add(fk2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();

		add(deffrolla = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Deff rolla", getPts("Deff rolla")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "'Ard Case", getPts("'Ard Case")));
		
		//TODO Battlewagon Ausrüstung
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grabbin' klaw", getPts("Grabbin' klaw")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wreckin' ball", getPts("Wreckin' ball")));

		complete();
	}

	//@OVERRIDE
	public void refreshen() {
		deffrolla.setSelected(true);
	}
}
