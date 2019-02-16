package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CHSeekers extends Eintrag {

    AnzahlPanel seekers;
    OptionsEinzelUpgrade heartseeker;

    public CHSeekers() {

        name = "Seekers";
        grundkosten = 0;
        power = 5;

        add(seekers = new AnzahlPanel(ID, randAbstand, cnt, "Seekers", 5, 20, getPts("Seeker")));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument of Chaos", getPts("Instrument of Chaos")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Daemonic Icon", getPts("Daemonic Icon")));

        seperator();

        add(heartseeker = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heartseeker", getPts("Heartseeker")));

        complete();

    }

    public void deleteYourself() {
    }


    @Override
    public void refreshen() {
        if (!heartseeker.isSelected()) heartseeker.setSelected(true);

        power = 6 +
                ((seekers.getModelle() > 5) ? 5 : 0) +
                ((seekers.getModelle() > 10) ? 5 : 0) +
                ((seekers.getModelle() > 15) ? 4 : 0);
    }
}
