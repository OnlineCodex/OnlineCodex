package oc.wh40k.units.in;

import oc.AnzahlPanel;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class INGefolgeServitoren extends RuestkammerVater {

	AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1def;

	public INGefolgeServitoren() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Inquisitions-Servitor", "Inquisitions-Servitoren", 1, 12, 10));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Servo-Arm", 0));
		add(o1def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		sizeSetzen(200, 100, 390, KAMMER_HOEHE + cnt);
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle() < 3 ? squad.getModelle() : 3);
		o1def.setMaxAnzahl(squad.getModelle() - o1.getAnzahl());
		o1def.setAnzahl(0, squad.getModelle() - o1.getAnzahl());
	}

    @Override
    public Object getSpecialValue() {
        return (Integer) squad.getModelle();
    }

}
