package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class CHWarpsmith extends Eintrag {

    RuestkammerStarter waffen;
    OptionsEinzelUpgrade flamer, melta, mecha;
    OptionsUpgradeGruppe mark;
    
	public CHWarpsmith() {

		name = "Warpsmith";
        grundkosten = getPts("Warpsmith");
        power = 6;   
		
        add(flamer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flamer", getPts("Flamer")));
        add(melta = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meltagun", getPts("Meltagun")));
        add(mecha = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mechatendrils", getPts("Mechatendrils")));
        
        seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
		ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
		ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
		ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
		add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        waffen = new RuestkammerStarter(ID, randAbstand, cnt, "CHWaffenkammer", "");
        ((CHWaffenkammer)waffen.getKammer()).setDefaultFK("Bolt pistol");
        ((CHWaffenkammer)waffen.getKammer()).setDefaultNK("Power axe");
        ((CHWaffenkammer)waffen.getKammer()).setSorcerer(true);
        waffen.initKammer(false,true,false,false);
        waffen.setButtonText("Waffenkammer");
        add(waffen);
        waffen.setAbwaehlbar(false);
		
		complete();
		
	}

	@Override
	public void refreshen() {
		if(!flamer.isSelected())flamer.setSelected(true);
		if(!melta.isSelected())melta.setSelected(true);
		if(!mecha.isSelected())mecha.setSelected(true);
	}
}
