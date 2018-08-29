package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.Eintrag;

public class CHChaosDecimator extends Eintrag {
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
    AnzahlPanel squad;

	public CHChaosDecimator() {
		name = "Chaos Decimator";
		grundkosten = getPts("Chaos Decimator");

		ogE.addElement(new OptionsGruppeEintrag("Decimator claw/Flamer", getPts("Decimator claw")+getPts("Hellflamer")));
		ogE.addElement(new OptionsGruppeEintrag("Soulburner petard", getPts("Soulburner petard")));
		ogE.addElement(new OptionsGruppeEintrag("C-beam cannon", getPts("C-beam cannon")));
		ogE.addElement(new OptionsGruppeEintrag("Butcher cannon", getPts("Butcher cannon")));
		ogE.addElement(new OptionsGruppeEintrag("Decimator storm laser", getPts("Decimator storm laser")));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Decimator claw/Flamer", getPts("Decimator claw")+getPts("Hellflamer")));
		ogE.addElement(new OptionsGruppeEintrag("Soulburner petard", getPts("Soulburner petard")));
		ogE.addElement(new OptionsGruppeEintrag("C-beam cannon", getPts("C-beam cannon")));
		ogE.addElement(new OptionsGruppeEintrag("Butcher cannon", getPts("Butcher cannon")));
		ogE.addElement(new OptionsGruppeEintrag("Decimator storm laser", getPts("Decimator storm laser")));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		complete();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
		o2.alwaysSelected();
	}
}
