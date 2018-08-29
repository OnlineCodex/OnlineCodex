package oc.wh40k.units.fo;

import oc.AnzahlPanel;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class FOVergelterWaffenbatterieKammer extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsEinzelZaehler oe1;
	OptionsEinzelZaehler oe2;
	OptionsEinzelZaehler oe3;
	OptionsZaehlerGruppe ozg1;

	public FOVergelterWaffenbatterieKammer() {}
	public void initButtons(boolean... defaults) {
		name = "Vergelter Waffenbatterie";
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Vergelter Waffenbatterie", "Vergelter Waffenbatterien", 1, 2, 75);
		add(squad);

		add(oe1 =new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Vollstrecker-Stuka","Vollstrecker-Sturmkanone",1,0));
		add(oe3 =new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Icarus-Laska", "Icarus-Laserkanone",1,0));
		add(oe2 =new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Kampfgeschütz",1,10));
		
		add(ico = new oc.Picture("oc/wh40k/images/TARemoteSensorTowerTeam.jpg"));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Stacheldraht", 5));
		ogE.addElement(new OptionsGruppeEintrag("Barrikaden", 10));
		ogE.addElement(new OptionsGruppeEintrag("Panzersperren", 15));
		add(ozg1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,6));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		oe2.setMaxAnzahl(squad.getModelle()-oe3.getAnzahl());
        oe3.setMaxAnzahl(squad.getModelle()-oe2.getAnzahl());
        oe1.setMaxAnzahl(squad.getModelle() -oe2.getAnzahl() -oe3.getAnzahl());
        oe1.setAnzahl(oe1.getMaxAnzahl());
	}
}
