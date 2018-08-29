package oc.wh40k.units.rh_ia13;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class RH_IA13RenegadeBloodSlaughterers extends Eintrag {

	AnzahlPanel Slaughterers;
	OptionsZaehlerGruppe NK;

	public RH_IA13RenegadeBloodSlaughterers() {

		grundkosten = 0;

		Slaughterers = new AnzahlPanel(ID, randAbstand, cnt, "Blood Slaughterer", "Blood Slaughterers", 1, 3, 130);
		add(Slaughterers);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Impaler", 5));
		add(NK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		addToInformationVector("RHBloodSlaughterer", +1);
		
		complete();
	}

	//@OVERRIDE
	public void refreshen() {

		NK.setMaxAnzahl(Slaughterers.getModelle());
		if(getCountFromInformationVector("RHBloodSlaughterer") > 1) {
			setFehlermeldung("0-1 Auswahl!");
		} else {
			setFehlermeldung("");
		}
	}
	
	@Override
	public void deleteYourself() {
		super.deleteYourself();
		addToInformationVector("RHBloodSlaughterer", -1);
	}
}
