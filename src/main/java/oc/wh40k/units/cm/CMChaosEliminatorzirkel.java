package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class CMChaosEliminatorzirkel extends Eintrag {

	RuestkammerStarter rkGeneral;
	RuestkammerStarter rkTermi1;
	RuestkammerStarter rkTermi2;
	RuestkammerStarter rkTermi3;
	RuestkammerStarter rkTermi4;
	RuestkammerStarter rkTermi5;
	RuestkammerStarter rkTermi6;

	public CMChaosEliminatorzirkel() {
            name = "Chaos-Eliminatorzirkel";
            grundkosten = 200;

            add(ico = new oc.Picture("oc/wh40k/images/ThousandSons.gif"));
            
            seperator();

            rkGeneral = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosgeneralKammer", "Chaosgeneral");
            rkGeneral.initKammer(true);
            rkGeneral.setButtonText("Chaosgeneral");
            add(rkGeneral);

            seperator(15);

            rkTermi1 = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosterminatorenKammer", "Chaosterminatoren");
            rkTermi1.initKammer();
            rkTermi1.setButtonText("Chaosterminatoren");
            add(rkTermi1);

            seperator();

            rkTermi2 = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosterminatorenKammer", "Chaosterminatoren");
            rkTermi2.initKammer();
            rkTermi2.setButtonText("Chaosterminatoren");
            add(rkTermi2);

            seperator();

            rkTermi3 = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosterminatorenKammer", "Chaosterminatoren");
            rkTermi3.initKammer();
            rkTermi3.setButtonText("Chaosterminatoren");
            add(rkTermi3);

            seperator();

            rkTermi4 = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosterminatorenKammer", "Chaosterminatoren");
            rkTermi4.initKammer();
            rkTermi4.setButtonText("Chaosterminatoren");
            add(rkTermi4);

            seperator();

            rkTermi5 = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosterminatorenKammer", "Chaosterminatoren");
            rkTermi5.initKammer();
            rkTermi5.setButtonText("Chaosterminatoren");
            add(rkTermi5);

            seperator();

            rkTermi6 = new RuestkammerStarter(ID, randAbstand, cnt, "CMChaosterminatorenKammer", "Chaosterminatoren");
            rkTermi6.initKammer();
            rkTermi6.setButtonText("Chaosterminatoren");
            add(rkTermi6);

            complete();
	}

	@Override
	public void refreshen() {
            rkTermi1.setAbwaehlbar(false);
            rkTermi2.setAbwaehlbar(false);
            rkTermi3.setAbwaehlbar(false);
            rkTermi4.setAktiv(rkTermi1.isSelected() && rkTermi2.isSelected() && rkTermi3.isSelected());
            rkTermi5.setAktiv(rkTermi4.isSelected());
            rkTermi6.setAktiv(rkTermi5.isSelected());
        }

}
