package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CHDaemonettesCSM extends Eintrag {

	private final AnzahlPanel daemonettes;
	private final OptionsEinzelUpgrade alluress;

    public CHDaemonettesCSM() {

        name = "Daemonettes";
        grundkosten = 0;
        power = 5;

        add(daemonettes = new AnzahlPanel(ID, randAbstand, cnt, "Daemonettes", 10, 30, getPts("Daemonettes CSM")));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument of Chaos", getPts("Instrument of Chaos")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Icon", getPts("Daemonic Icon CSM")));

        seperator();

        add(alluress = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Alluress", getPts("Alluress")));

        complete();

    }

    @Override
	public void deleteYourself() {
    }


    @Override
    public void refreshen() {
        power = 5 +
                ((daemonettes.getModelle() == 20) ? 5 : 0) +
                ((daemonettes.getModelle() == 30) ? 10 : 0);

        if (!alluress.isSelected()) alluress.setSelected(true);
    }
}
