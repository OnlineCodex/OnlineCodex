package oc.wh40k.units.rh_ia13;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class RH_IA13RenegadeValkyrieKammer extends RuestkammerVater {

        OptionsUpgradeGruppe o4;
        OptionsUpgradeGruppe o3;
        OptionsEinzelUpgrade mt;

	public RH_IA13RenegadeValkyrieKammer() {}
		
	@Override
	public void initButtons(boolean... b) {
		
		name = "Renegade Valkyrie";
		grundkosten = 115;
		
		add(ico = new oc.Picture("oc/wh40k/images/AquilaLander.gif"));
		
	    ogE.addElement(new OptionsGruppeEintrag("TL Multi-laser","Twin-linked multi-laser", 0));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon", 10));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("2 Hellstrike missiles", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multiple rocket pods", 10));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
	            
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "2 Heavy bolters", 20));
		add(mt = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Militia Training", 10));
		
		sizeSetzen();
	}
	
	public void refreshen() {
		o4.alwaysSelected();
		o3.alwaysSelected();
		
		if(BuildaHQ.aktBuildaVater.getCountFromInformationVector("RHBloodyHandedReaver")==1){
        	mt.setSelected(true);
		}
	}
}
