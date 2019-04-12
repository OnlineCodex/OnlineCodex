package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTA_SORORITAS;
import static oc.KeyWord.ADEPTUS_MINISTORUM;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.ORDER;
import static oc.KeyWord.REPENTIA_SQUAD;

import oc.AnzahlPanel;
import oc.Eintrag;

public class IMRepentiaSquad extends Eintrag {
	private final AnzahlPanel squad;

    public IMRepentiaSquad() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ADEPTA_SORORITAS, ORDER, INFANTRY, REPENTIA_SQUAD);
        name = "Repentia Squad\n";
        grundkosten = 0;
        applyTitle = true;
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Repentias", 3, 9, getPts("Repentia Squad") + getPts("Penitent eviscerator"));
        add(squad);

        addToInformationVector(REPENTIA_SQUAD_CNT, 1);

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() <= 3)
            power = 2;
        else if (squad.getModelle() <= 6)
            power = 4;
        else if (squad.getModelle() <= 9)
            power = 6;
    }

    @Override
    public void deleteYourself() {
    	addToInformationVector(REPENTIA_SQUAD_CNT, -1);
    	super.deleteYourself();
    }

}
