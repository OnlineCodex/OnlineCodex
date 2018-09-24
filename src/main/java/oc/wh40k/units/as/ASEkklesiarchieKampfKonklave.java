package oc.wh40k.units.as;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;


public class ASEkklesiarchieKampfKonklave extends Eintrag {

	OptionsZaehlerGruppe o1;
	RuestkammerStarter rkTransport;

	boolean added = false;

	public ASEkklesiarchieKampfKonklave() {
		name = "Jünger der Ekklesiarchie";
		grundkosten = 0;
		this.setEintragsCNT(0);
		überschriftSetzen = true;

		addToInformationVector("ASJuengerderEkklesiarchie", 1);

		add(ico = new oc.Picture("oc/wh40k/images/ASCelestiatrupp.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Arco-Flagellant", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kreuzritter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Todeskultassassine", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 10));
		o1.setAnzahl(0, 3);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "ASTransporterKammer", "Transporter");
		rkTransport.initKammer(true, true, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        o1.setLegal(o1.getAnzahl() >= 3);
        
		int selectedSquads = getCountFromInformationVector("ASJuengerderEkklesiarchie");
		int possibleSquads = getCountFromInformationVector("ASPriester");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("Konklaven > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		addToInformationVector("ASJuengerderEkklesiarchie", -1);
	}

}
