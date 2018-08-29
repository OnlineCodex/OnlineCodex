package oc.wh40k.units.dh;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DHMaynarkhImmortals extends Eintrag {

	AnzahlPanel squad;
    OptionsUpgradeGruppe o1;
	RuestkammerStarter rkTransport;

	public DHMaynarkhImmortals() {
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Extinktoren", 5, 10, 17);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/NEExtinktoren.jpg"));
        
		setCountToMinimum(false);
		
        seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Gauss-Blaster", 0));
		ogE.addElement(new OptionsGruppeEintrag("Tesla-Karabiner", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flensing scrarabs",10));

        seperator();;

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DHTransporterKammer", "Transporter");
		rkTransport.initKammer(false, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!o1.isSelected()) o1.setSelected(0, true);        
	}
}
