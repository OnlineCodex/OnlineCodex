package oc.wh40k.units.ia;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IAServitors extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;

	public IAServitors() {
		grundkosten = 0;
        
        addToInformationVector("BAServitoren", 1);

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Servitor", "Servitoren", 1, 5, 10);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMServitoren.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 20));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

		complete();
	}

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        addToInformationVector("BAServitoren", -1);
    }

	@Override
	public void refreshen() {
        o1.setMaxAnzahl((squad.getModelle() > 1 ? 2 : 1));
	}

}
