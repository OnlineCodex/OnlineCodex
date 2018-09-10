package oc.wh40k.units.im;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class IMWolfPriest extends Eintrag {


	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppe o4;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
    RuestkammerStarter termiWaffen;
    RuestkammerStarter waffenUndArtefakte;
    RuestkammerStarter spezialAusruestung;
    boolean fenrisSupp = false;

	public IMWolfPriest() {
		name = "Wolf Priest";
		grundkosten = getPts("Wolf Priest") + getPts("crozius arcanum");
		
		seperator();
		
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Pack", getPts("Wolf Priest with Jump Pack") - getPts("Wolf Priest")));
	
		seperator();
		
		waffenUndArtefakte = new RuestkammerStarter(ID, randAbstand, cnt, "IMSpaceWolvesRuestkammer", "");
		((IMSpaceWolvesRuestkammer)waffenUndArtefakte.getKammer()).setType("Wolf Priest");
		waffenUndArtefakte.initKammer();
		waffenUndArtefakte.setButtonText(BuildaHQ.translate("Waffen"));
		add(waffenUndArtefakte);
		waffenUndArtefakte.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
		power = 5;
		if(oe1.isSelected()){
			power += 1;
		}
	}

}
