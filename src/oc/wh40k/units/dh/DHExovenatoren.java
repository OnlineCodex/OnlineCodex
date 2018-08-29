package oc.wh40k.units.dh;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class DHExovenatoren extends Eintrag {

	AnzahlPanel squad;
    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;

	public DHExovenatoren() {
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Exovenator", "Exovenatoren", 1, 5, 20);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/NEExovenatoren.jpg"));

		seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Sync. Tesla-Karabiner", "Synchronisierte Tesla-Karabiner", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Gauss-Blaster", "Synchronisierte Gauss-Blaster", 0));
		ogE.addElement(new OptionsGruppeEintrag("Partikelstrahler", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Nebuloskope", 5));
		ogE.addElement(new OptionsGruppeEintrag("Schattenprojektoren", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schildplatten", 10));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));

		complete();
	}

	@Override
	public void refreshen() {
        if(!o1.isSelected()) o1.setSelected(0, true);
        
        o1.setPreis(2, squad.getModelle() * 10);
        
        o2.setPreis(0, squad.getModelle() * 5);
        o2.setPreis(1, squad.getModelle() * 10);
        o2.setPreis(2, squad.getModelle() * 10);
	}

}
