package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ORBattlewagon extends Eintrag {

	private static OptionsEinzelUpgrade sht, ft, pincha;
	boolean kustomJobSelected = false;
	private static OptionsUpgradeGruppe o1;
	
	public ORBattlewagon() {

        name = "Battlewagon";
        grundkosten = getPts("Battlewagon");
        power = 8;

        add(ico = new oc.Picture("oc/wh40k/images/Kampfpanza.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kannon", getPts("Kannon")));
        ogE.addElement(new OptionsGruppeEintrag("Killkannon", getPts("Killkannon")));
        ogE.addElement(new OptionsGruppeEintrag("KJ: Da Boomer", getPts("Killkannon")));
        ogE.addElement(new OptionsGruppeEintrag("Zzap gun", getPts("Zzap gun")));
        ogE.addElement(new OptionsGruppeEintrag("KJ: Zagzap", getPts("Zzap gun")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Big shoota", getPts("Big shoota")));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Deff rolla", getPts("Deff rolla")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "'Ard Case", getPts("'Ard Case")));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grabbin' klaw", getPts("Grabbin' klaw")));
        add(pincha = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "KJ: Pincha", getPts("Grabbin' klaw")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot rigger", getPts("Grot rigger")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Lobba", getPts("Lobba")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbomb chukka", getPts("Stikkbomb chukka")));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wreckin' ball", getPts("Wreckin' ball")));

		seperator();
		
		add(sht = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "KJ: Squig-Hife Tyres", getPts("Squig-Hife Tyres")));
		add(ft = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "KJ: Forktress", getPts("Squig-Hife Tyres")));
		
        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
    	if((sht.isSelected() || ft.isSelected() || pincha.isSelected() || o1.isSelected("KJ: Da Boomer") || o1.isSelected("KJ: Zagzap")) && !kustomJobSelected) {
    		int i = BuildaHQ.getCountFromInformationVectorGlobal("KustomJobs");
    		BuildaHQ.setInformationVectorValueGlobal("KustomJobs", i+1);
    		kustomJobSelected = true;
    	} else if(!(sht.isSelected() || ft.isSelected() || pincha.isSelected() || o1.isSelected("KJ: Da Boomer") || o1.isSelected("KJ: Zagzap")) && kustomJobSelected) {
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
