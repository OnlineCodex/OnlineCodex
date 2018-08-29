package oc.wh40k.units.kd;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsZaehlerGruppe;

public class KDBloodletters extends Eintrag {

	AnzahlPanel CDZerfleischerdesKhorne;
	OptionsEinzelUpgrade Hoellenkrieger, Chaosikone;
	OptionsZaehlerGruppe o1,o2;

	public KDBloodletters() {

		name = "Bloodletters";

		grundkosten = 0;

		CDZerfleischerdesKhorne = new AnzahlPanel(ID, randAbstand, cnt, "Bloodletters", 8, 20, 10);

		add(CDZerfleischerdesKhorne);

		add(ico = new oc.Picture("oc/wh40k/images/CDZerfleischerdesKhorne.gif"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument des Chaos", 10));
		add(Chaosikone = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Blutbanner", 20));
		
		seperator();

		add(Hoellenkrieger = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bloodreaper", 5));

		complete();

	}

	@Override
	public void refreshen() {
	}

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }
}
