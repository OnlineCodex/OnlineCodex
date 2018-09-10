package oc.wh40k.units.dh;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class DHSentryPylon extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1x;
    OptionsUpgradeGruppe o2;

	public DHSentryPylon() {
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Sentry Pylon", "Sentry Pylons", 1, 3, 135);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/NEExovenatoren.jpg"));

		seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Gauss Exterminator", 0));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,1));
		ogE.addElement(new OptionsGruppeEintrag("Heat cannon", 40));
		ogE.addElement(new OptionsGruppeEintrag("Focussed death ray", 25));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,1));

		seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Teleportation matrix", 35));
		ogE.addElement(new OptionsGruppeEintrag("Sepulchral scarabs", 15));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));

		complete();
	}

	@Override
	public void refreshen() {
	   o1.setMaxAnzahl(squad.getModelle());
       o1x.setMaxAnzahl(squad.getModelle()-o1.getAnzahl());
       o1x.setAnzahl(0,squad.getModelle()-o1.getAnzahl());
        
        o2.setPreis(0, squad.getModelle() * 35);
        o2.setPreis(1, squad.getModelle() * 15);
	}

}
