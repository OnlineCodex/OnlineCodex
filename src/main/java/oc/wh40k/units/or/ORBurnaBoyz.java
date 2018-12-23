package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class ORBurnaBoyz extends Eintrag {

    private final AnzahlPanel boyz;
    private final RuestkammerStarter Spanner2;
    private final RuestkammerStarter Spanner3;

    public ORBurnaBoyz() {

        kategorie = 1;

        name = "Boyz";
        grundkosten = 0;
        add(boyz = new AnzahlPanel(ID, randAbstand, cnt, "Burna Boyz", 5, 15, getPts("Burna Boyz") + getPts("Burna") + getPts("Stikkbombs")));
        add(ico = new oc.Picture("oc/wh40k/images/Moschaboy.gif"));

        seperator();

        ORWaffenUndGeschenke kammer0 = new ORWaffenUndGeschenke("No weapon", "No weapon", false, false, true, false, false, false, false, false);
        kammer0.setKillsawNK(true); //TODO: können nur mit mega-blasta, big shoota oder rokkit bewaffnet werden
        RuestkammerStarter spanner1 = new RuestkammerStarter(ID, randAbstand, cnt, kammer0, "Spanner");
        spanner1.setGrundkosten(getPts("Spanner"));
        add(spanner1);

        seperator();

        Spanner2 = new RuestkammerStarter(ID, randAbstand, cnt, new ORWaffenUndGeschenke("No weapon", "No weapon", false, false, true, false, false, false, false, false), "Spanner");
        Spanner2.setGrundkosten(getPts("Spanner"));
        add(Spanner2);

        seperator();

        ORWaffenUndGeschenke kammer = new ORWaffenUndGeschenke("No weapon", "No weapon", false, false, true, false, false, false, false, false);
        kammer.setKillsawNK(true);
        Spanner3 = new RuestkammerStarter(ID, randAbstand, cnt, kammer, "Spanner");
        Spanner3.setGrundkosten(getPts("Spanner"));
        add(Spanner3);

        complete();
    }


    @Override
    public void refreshen() {
    	if(boyz.getModelle() > 10) {
    		power = 9;
    	} else if(boyz.getModelle() > 5) {
    		power = 6;
    	} else {
    		power = 3;
    	}

        Spanner2.setAktiv(boyz.getModelle() >= 10);
        Spanner3.setAktiv(boyz.getModelle() == 15);
    }
}
