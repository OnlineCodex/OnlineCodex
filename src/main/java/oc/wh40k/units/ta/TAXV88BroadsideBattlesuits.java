package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TAXV88BroadsideBattlesuits extends Eintrag {

	RuestkammerStarter ob1;
	RuestkammerStarter o1;
	RuestkammerStarter o2;
	RuestkammerStarter o3;
	OptionsZaehlerGruppe o4;

	public TAXV88BroadsideBattlesuits() {
		name = "XV88 Broadside Battlesuits";
		überschriftSetzen = true;
		grundkosten = 0;

		add(ico = new oc.Picture("oc/wh40k/images/KolossKampfanzugteam.gif"));
		ob1 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKampfanzugKammer", "Broadside Shas'vre");
		ob1.setGrundkosten(getPts("XV88 Broadside Battlesuit"));
		ob1.initKammer(false, false, false, true, false, false, false);
		add(ob1);
		
		seperator();

		o1 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKampfanzugKammer", "Broadside Shas'ui");
		o1.initKammer(false, false, false, true, false, false, false);
		o1.setGrundkosten(getPts("XV88 Broadside Battlesuit"));
		add(o1);
		
		seperator();

		o2 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKampfanzugKammer", "Broadside Shas'ui");
		o2.initKammer(false, false, false, true, false, false, false);
		o2.setGrundkosten(getPts("XV88 Broadside Battlesuit"));
		add(o2);
		
		seperator();

		o3 = new RuestkammerStarter(ID, randAbstand, cnt, "TAKampfanzugKammer", "Broadside Shas'ui");
		o3.initKammer(false, false, false, true, false, false, false);
		o3.setGrundkosten(getPts("XV88 Broadside Battlesuit"));
		add(o3);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("MV8 Missile Drone", getPts("MV8 Missile Drone")));
		ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
		ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
		ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
		add(o4 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));
	}

	@Override
	public void refreshen() {
		o3.setAktiv(!ob1.isSelected());
		 o4.setMaxAnzahl(((ob1.isSelected() ? 1 : 0) + (o1.isSelected() ? 1 : 0) + (o2.isSelected() ? 1 : 0) + (o3.isSelected() ? 1 : 0))*2);
         
		 o4.getPanel().setLocation(
					(int) o4.getPanel().getLocation().getX(),
					(int) o3.getPanel().getLocation().getY() + o3.getPanel().getSize().height + 5
		    );	        	
		
        power = 0;
        if (ob1.isSelected()) {
        	power = power + 7;
        }
        if (o1.isSelected()) {
        	power = power + 7;
        }
        if (o2.isSelected()) {
        	power = power + 7;
        }
        if (o3.isSelected()) {
        	power = power + 7;
        }
   	}

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }

}
