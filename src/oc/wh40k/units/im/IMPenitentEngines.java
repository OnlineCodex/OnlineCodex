package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMPenitentEngines extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1,o2;

	public IMPenitentEngines() {
		name = "Penitent Engines";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Penitent Engines", 1, 3, getPts("Penitent Engines"));
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ASLaeuterer.jpg"));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Penitent buzz-blades", getPts("Penitent buzz-blades")));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("2 Heavy flamers", getPts("Heavy flamer (AMI)")*2));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
		o1.setAnzahl(0,squad.getModelle());
		
		o2.setMaxAnzahl(squad.getModelle());
		o2.setAnzahl(0,squad.getModelle());
	}

}
