package oc.wh40k.units.as;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class ASPurgatorschwadron extends Eintrag {
	
	RuestkammerStarter retributor1;
	RuestkammerStarter retributor2;
	RuestkammerStarter retributor3;
	RuestkammerStarter retributor4;
	RuestkammerStarter retributor5;
    
	public ASPurgatorschwadron() {
		name = "Purgatorschwadron";
		grundkosten = 50;

		add(ico = new oc.Picture("oc/wh40k/images/ASPurgatorschwadron.gif"));
		
		retributor1 =new RuestkammerStarter(ID, randAbstand, cnt, "ASRetributortruppKammer", "Retributoren",1);
		retributor1.initKammer();
        add(retributor1);

		
		retributor2 =new RuestkammerStarter(ID, randAbstand, cnt, "ASRetributortruppKammer", "Retributoren",1);
		retributor2.initKammer();
        add(retributor2);

		
		retributor3 =new RuestkammerStarter(ID, randAbstand, cnt, "ASRetributortruppKammer", "Retributoren",1);
		retributor3.initKammer();
        add(retributor3);

		
		retributor4 =new RuestkammerStarter(ID, randAbstand, cnt, "ASRetributortruppKammer", "Retributoren",1);
		retributor4.initKammer();
        add(retributor4);
		
		retributor5 =new RuestkammerStarter(ID, randAbstand, cnt, "ASRetributortruppKammer", "Retributoren",1);
		retributor5.initKammer();
        add(retributor5);

    	complete();

	}

	public void refreshen() {
		int retcnt=0;
		
		if (retributor1.isSelected()) retcnt++;
		if (retributor2.isSelected()) retcnt++;
		if (retributor3.isSelected()) retcnt++;
		if (retributor4.isSelected()) retcnt++;
		if (retributor5.isSelected()) retcnt++;
		
		retributor1.setLegal(retcnt>=3);
		retributor2.setLegal(retcnt>=3);
		retributor3.setLegal(retcnt>=3);
		retributor4.setLegal(retcnt>=3);
		retributor5.setLegal(retcnt>=3);
		
	}
}
