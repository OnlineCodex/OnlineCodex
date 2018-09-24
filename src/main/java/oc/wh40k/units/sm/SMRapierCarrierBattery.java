package oc.wh40k.units.sm;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class SMRapierCarrierBattery extends Eintrag {

	AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1x;

	public SMRapierCarrierBattery() {
		name = "Rapier Carrier Battery\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Rapier","Rapiers", 1, 3, 40);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMRapierCarrierBattery.jpg"));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Quad heavy bolter", 0));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Laser Destroyer", 15));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		complete();

	}

	@Override
	public void refreshen() {
        o1x.setMaxAnzahl(squad.getModelle()-o1.getAnzahl());
        o1x.setAnzahl(0,squad.getModelle()-o1.getAnzahl());
        o1.setMaxAnzahl(squad.getModelle());
	}

}

