//IA Adeptus Astartes
package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMRelicTyphonHeavySiegeTank extends Eintrag {

	OptionsZaehlerGruppe o1, o2;

	public IMRelicTyphonHeavySiegeTank() {
		name = "Relic Typhon Heavy Siege Tank";
		grundkosten = getPts("Relic Typhon Heavy Siege Tank") + getPts("Dreadhammer siege cannon") + getPts("Crushing tracks");
		power = 27;
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 lascannon", 2*getPts("Lascannon (IA)")));
		ogE.addElement(new OptionsGruppeEintrag("2 heavy bolters", 2*getPts("Heavy bolter (IA)")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (IA)")));
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 2*getPts("Heavy flamer")));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", getPts("Multi-melta")));
		ogE.addElement(new OptionsGruppeEintrag("Storm bolter", 2*getPts("Storm bolter (IA)")));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		complete();
	}

	@Override
	public void refreshen() {
	}
}
