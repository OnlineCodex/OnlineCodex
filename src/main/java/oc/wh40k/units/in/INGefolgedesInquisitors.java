package oc.wh40k.units.in;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class INGefolgedesInquisitors extends Eintrag {

    RuestkammerStarter rk1;
    RuestkammerStarter rk2;
    RuestkammerStarter rk3;
    RuestkammerStarter rk4;
    RuestkammerStarter rk5;
    RuestkammerStarter rk6;
    RuestkammerStarter rk7;
    RuestkammerStarter rk8;
    RuestkammerStarter rk9;
    RuestkammerStarter rk10;
    RuestkammerStarter rkTransport;
    RuestkammerStarter rkAquila;
    RuestkammerStarter rkValk;

	public INGefolgedesInquisitors() {
		name = "Gefolge des Inquisitors";
		grundkosten = 0;
        überschriftSetzen = true;
        
		add(ico = new oc.Picture("oc/wh40k/images/GKGefolgedesInquisitors.jpg"));

        rk1 = new RuestkammerStarter(ID, randAbstand, cnt, "INGefolgeArcoFlagellanten", "");
        rk1.initKammer();
        rk1.setButtonText("Arco-Flagellanten");
        rk1.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk1);

        rk2 = new RuestkammerStarter(ID, randAbstand, cnt, "INPriester", "");
        rk2.initKammer();
        rk2.setButtonText("Priester");
        rk2.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk2);

        rk3 = new RuestkammerStarter(ID, randAbstand, cnt, "INGefolgeKreuzritter", "");
        rk3.initKammer();
        rk3.setButtonText("Kreuzritter");
        rk3.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk3);

        rk4 = new RuestkammerStarter(ID, randAbstand, cnt, "INGefolgeBesessene", "");
        rk4.initKammer();
        rk4.setButtonText("Besessene");
        rk4.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk4);

        rk5 = new RuestkammerStarter(ID, randAbstand, cnt, "INGefolgeTodeskultAssassinen", "");
        rk5.initKammer();
        rk5.setButtonText("Todeskult-Assassinen");
        rk5.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk5);

        rk6 = new RuestkammerStarter(ID, randAbstand, cnt, "INGefolgeServitoren", "");
        rk6.initKammer();
        rk6.setButtonText("Inquisitions-Servitoren");
        rk6.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk6);

        rk7 = new RuestkammerStarter(ID, randAbstand, cnt, "INGefolgeJokaeroWaffenschmiede", "");
        rk7.initKammer();
        rk7.setButtonText("Jokaero-Waffenschmiede");
        rk7.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk7);

        rk8 = new RuestkammerStarter(ID, randAbstand, cnt, "INGefolgeMystiker", "");
        rk8.initKammer();
        rk8.setButtonText("Mystiker");
        rk8.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk8);

        rk9 = new RuestkammerStarter(ID, randAbstand, cnt, "INGefolgePsioniker", "");
        rk9.initKammer();
        rk9.setButtonText("Psioniker");
        rk9.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk9);

        rk10 = new RuestkammerStarter(ID, randAbstand, cnt, "INGefolgeKriegerAkolythen", "");
        rk10.initKammer();
        rk10.setButtonText("Krieger-Akolythen");
        rk10.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rk10);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "INTransporterKammer", "Transporter");
		rkTransport.initKammer();
		rkTransport.setButtonText("Transporter");
		add(rkTransport);
		
		rkAquila = new RuestkammerStarter(ID, randAbstand, cnt, "INAquilaLanderKammer", "[IA Aeronautica] Aquila ");
		rkAquila.initKammer();
		rkAquila.setButtonText("[IA Aeronautica] Aquila ");
		add(rkAquila);
		
		rkValk = new RuestkammerStarter(ID, randAbstand, cnt, "INWalkuereKammer", "Walküre");
		rkValk.initKammer();
		rkValk.setButtonText("Walküre");
		add(rkValk);

		complete();
	}

	@Override
	public void refreshen() {
        
		rkAquila.setAktiv(!rkTransport.isSelected() && !rkValk.isSelected());
        rkTransport.setAktiv(!rkAquila.isSelected() && !rkValk.isSelected());
        rkValk.setAktiv(!rkAquila.isSelected() && !rkTransport.isSelected());

        int models =
            (rk1.isSelected() ? (Integer)rk1.getKammer().getSpecialValue() : 0) +
            (rk2.isSelected() ? (Integer)rk2.getKammer().getSpecialValue() : 0) +
            (rk3.isSelected() ? (Integer)rk3.getKammer().getSpecialValue() : 0) +
            (rk4.isSelected() ? (Integer)rk4.getKammer().getSpecialValue() : 0) +
            (rk5.isSelected() ? (Integer)rk5.getKammer().getSpecialValue() : 0) +
            (rk6.isSelected() ? (Integer)rk6.getKammer().getSpecialValue() : 0) +
            (rk7.isSelected() ? (Integer)rk7.getKammer().getSpecialValue() : 0) +
            (rk8.isSelected() ? (Integer)rk8.getKammer().getSpecialValue() : 0) +
            (rk9.isSelected() ? (Integer)rk9.getKammer().getSpecialValue() : 0) +
            (rk10.isSelected() ? (Integer)rk10.getKammer().getSpecialValue() : 0);

        rk1.setLegal(models >= 3 && models <= 12);
        rk2.setLegal(models >= 3 && models <= 12);
        rk3.setLegal(models >= 3 && models <= 12);
        rk4.setLegal(models >= 3 && models <= 12);
        rk5.setLegal(models >= 3 && models <= 12);
        rk6.setLegal(models >= 3 && models <= 12);
        rk7.setLegal(models >= 3 && models <= 12);
        rk8.setLegal(models >= 3 && models <= 12);
        rk9.setLegal(models >= 3 && models <= 12);
        rk10.setLegal(models >= 3 && models <= 12);

        
        if(models >=3 && models <= 12) {
            setFehlermeldung("");
        } else {
            setFehlermeldung("Pflicht: 3-12 Modelle");
        }
        
	}

}
