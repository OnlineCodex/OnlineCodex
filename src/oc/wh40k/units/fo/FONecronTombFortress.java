package oc.wh40k.units.fo;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class FONecronTombFortress extends Eintrag {

	OptionsZaehlerGruppe o1;

	public FONecronTombFortress() {
		grundkosten = 500;
		name="Necron Tomb Fortress";

		add(ico = new oc.Picture("oc/wh40k/images/NEExovenatoren.jpg"));

		seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Tesla destructor", 65));
		ogE.addElement(new OptionsGruppeEintrag("Gauss exterminator", 100));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,4));

		seperator();
        
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Comms relay", 20));
		

		complete();
	}

	@Override
	public void refreshen() {
	}

}
