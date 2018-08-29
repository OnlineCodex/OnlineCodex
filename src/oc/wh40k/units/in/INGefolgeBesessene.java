package oc.wh40k.units.in;

import oc.AnzahlPanel;
import oc.RuestkammerVater;

public class INGefolgeBesessene extends RuestkammerVater {

	AnzahlPanel squad;

	public INGefolgeBesessene() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Besessener", "Besessene", 1, 12, 10));

		sizeSetzen(200, 100, 390, KAMMER_HOEHE + cnt);
	}

	@Override
	public void refreshen() {
	}

    @Override
    public Object getSpecialValue() {
        return (Integer) squad.getModelle();
    }

}
