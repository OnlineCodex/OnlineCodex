package oc.wh40k.units.da;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class DARavenwingLandSpeeders extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1a;
	OptionsZaehlerGruppe o2;

	public DARavenwingLandSpeeders() {
		name = "Ravenwing-Unterstützungsschwadron\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Land Speeder", 1, 5, 50);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/DARavenwingSupportSquadron.gif"));

		seperator(12);

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
		add(o1a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		o1.setMaxAnzahl(squad.getModelle());
		o1a.setAnzahl(0, squad.getModelle());
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Typhoon", "Typhoon-Raketenwerfer", 25));
		ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 20));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		o2.setMaxAnzahl(squad.getModelle());

		seperator();

		complete();
	}

	@Override
	public void refreshen() {
		o1a.setMaxAnzahl(squad.getModelle()-o1.getAnzahl());
		o1a.setAnzahl(0,squad.getModelle()-o1.getAnzahl());
		o1.setMaxAnzahl(squad.getModelle());
		o2.setMaxAnzahl(squad.getModelle());
	}

}
