
package oc.wh40k.units.kd;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class KDKultistenChampion extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade handwaffe, maschinenpistole;

	public KDKultistenChampion() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

		add(handwaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Maschinenpistole", "Maschinenpistole", 0));
		add(maschinenpistole = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Handwaffe", "Handwaffe", 0));
		handwaffe.setSelected(true);
		maschinenpistole.setSelected(true);
		
        ogE.addElement(new OptionsGruppeEintrag("Schrotflinte", 2));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        setUeberschrift("Kultistenchampion");
        sizeSetzen();
	}

	@Override
	public void refreshen() {
		if(!handwaffe.isSelected()) handwaffe.setSelected(true);
		if(!maschinenpistole.isSelected()) maschinenpistole.setSelected(true);
	}

}
