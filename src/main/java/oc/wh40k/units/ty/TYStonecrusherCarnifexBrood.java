package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class TYStonecrusherCarnifexBrood extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter ob1, ob2, ob3;

	public TYStonecrusherCarnifexBrood() {
		name = "Stonecrusher Carnifex Brood";
		grundkosten = 0;

		add(ico = new oc.Picture("oc/wh40k/images/TYCarnifex.jpg"));

		ob1 = new RuestkammerStarter(ID, randAbstand, cnt, "TYRuestkammer", "Stonecrusher Carnifex");
		((TYRuestkammer)ob1.getKammer()).setType("Stonecrusher Carnifex");
		ob1.initKammer();
		add(ob1);
		ob1.setGrundkosten(getPts("Stonecrusher Carnifex"));
		ob1.setAbwaehlbar(false);
		
		seperator();
		
		ob2 = new RuestkammerStarter(ID, randAbstand, cnt, "TYRuestkammer", "Stonecrusher Carnifex");
		((TYRuestkammer)ob2.getKammer()).setType("Stonecrusher Carnifex");
		ob2.initKammer();
		ob2.setGrundkosten(getPts("Stonecrusher Carnifex"));
		add(ob2);

		seperator();
		
		ob3 = new RuestkammerStarter(ID, randAbstand, cnt, "TYRuestkammer", "Stonecrusher Carnifex");
		((TYRuestkammer)ob3.getKammer()).setType("Stonecrusher Carnifex");
		ob3.initKammer();
		ob3.setGrundkosten(getPts("Stonecrusher Carnifex"));
		add(ob3);

		complete();
	}

	@Override
	public void refreshen() {

	}

}
