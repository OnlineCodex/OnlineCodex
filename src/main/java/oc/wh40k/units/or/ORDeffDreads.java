package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ORDeffDreads extends Eintrag {

	private final RuestkammerStarter d1;
	private final RuestkammerStarter d2;
	private final RuestkammerStarter d3;
	boolean kustomJobSelected = false;
	private final OptionsUpgradeGruppe op;
	
    public ORDeffDreads() {

        kategorie = 3;
        überschriftSetzen = true;
        grundkosten = 0;

        name = "Deff Dreads";
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/Gargbot.gif"));

        d1 = new RuestkammerStarter(ID, randAbstand, cnt, ORDeffDreadKammer.class, "Deff Dread ", 1);
        d1.initKammer();
        d1.setButtonText("Deff Dread 1");
        add(d1);
        d1.setAbwaehlbar(false);

        seperator();

        d2 = new RuestkammerStarter(ID, randAbstand, cnt, ORDeffDreadKammer.class, "Deff Dread ", 1);
        d2.initKammer();
        d2.setButtonText("Deff Dread 2");
        add(d2);

        seperator();

        d3 = new RuestkammerStarter(ID, randAbstand, cnt, ORDeffDreadKammer.class, "Deff Dread ", 1);
        d3.initKammer();
        d3.setButtonText("Deff Dread 3");
        add(d3);

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("KJ: Orkymatic Pistons", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("KJ: Sparkly Bitz", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("KJ: Dirty Gubbins", getPts("")));
        add(op = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        final int selected = (d1.isSelected() ? 1 : 0) + (d2.isSelected() ? 1 : 0) + (d3.isSelected() ? 1 : 0);
        if (selected == 1) power = 5;
        if (selected == 2) power = 10;
        if (selected == 3) power = 16;
    	if(op.isSelected() && !kustomJobSelected) {
    		int i = BuildaHQ.getCountFromInformationVectorGlobal("KustomJobs");
    		BuildaHQ.setInformationVectorValueGlobal("KustomJobs", i+1);
    		kustomJobSelected = true;
    	} else if(!op.isSelected() && kustomJobSelected) {
    		int i = BuildaHQ.getCountFromInformationVectorGlobal("KustomJobs");
    		BuildaHQ.setInformationVectorValueGlobal("KustomJobs", i-1);
    		kustomJobSelected = false;
    	}
    }
    
    //@OVERRIDE
    @Override
	public void deleteYourself() {
        super.deleteYourself();

        if(kustomJobSelected) {
    		int i = BuildaHQ.getCountFromInformationVectorGlobal("KustomJobs");
    		BuildaHQ.setInformationVectorValueGlobal("KustomJobs", i-1);
    		kustomJobSelected = false;
    	}
    }
}























