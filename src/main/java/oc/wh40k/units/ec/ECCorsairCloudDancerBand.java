package oc.wh40k.units.ec;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ECCorsairCloudDancerBand extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1, o1x;
    RuestkammerStarter rkBoss;
    OptionsEinzelUpgrade drugs;
    OptionsEinzelUpgrade rage;

    public ECCorsairCloudDancerBand() {
        name = "Corsair Cloud Dancer Band\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Cloud Dancer Corsairs", 3, 10, 20);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ECCorsairSquad.jpg"));
        
        seperator();

		ogE.addElement(new OptionsGruppeEintrag("TL Shuriken catapult", 0));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Shuriken cannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Scatter laser", 10));
		ogE.addElement(new OptionsGruppeEintrag("Dark lance", 20));
		ogE.addElement(new OptionsGruppeEintrag("Splinter cannon", 5));
		ogE.addElement(new OptionsGruppeEintrag("Dissonance cannon", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Haywire Grenades", 25));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Tanglefield Grenades", 10));

		seperator();
		
		add(drugs = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Combat drugs", 15));
		add(rage = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rage SR", 0));
        
        seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairCloudDancerFelarchKammer", "Upgrade to Felarch");
		rkBoss.initKammer(true);
		add(rkBoss);
        
        complete();
    }

    @Override
    public void refreshen() {
    	o1x.setMaxAnzahl(squad.getModelle()-o1.getAnzahl());
    	o1x.setAnzahl(0,squad.getModelle()-o1.getAnzahl());
        o1.setMaxAnzahl( squad.getModelle());
        
        drugs.setAktiv(getCountFromInformationVector("ECPrinceTrait")==0);
        rage.setAktiv(getCountFromInformationVector("ECPrinceTrait")==3);
        
    }
    
}
