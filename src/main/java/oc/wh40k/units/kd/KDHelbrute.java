package oc.wh40k.units.kd;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class KDHelbrute extends Eintrag {

	OptionsUpgradeGruppe oe1;
	OptionsZaehlerGruppe oe2;
	OptionsUpgradeGruppe oe3;

	public KDHelbrute() {
		name = "Helbrute";
		grundkosten = 100;

		add(ico = new oc.Picture("oc/wh40k/images/ChaosDreadnought.gif"));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Zwillings-Maschinenkanone", 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", 25));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Energiegeiﬂel", 10));
		add(oe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 0));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Energiegeiﬂel", 10));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
		add(oe3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));	
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Synchronisierter Bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flammenwerfer", 15));
		add(oe2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));	
		
		seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dreadclaw [FW/IAA]", "Dreadclaw [Forgeworld/Imperial Armour Apocalypse]", 65));
        
		complete();
	}

	@Override
	public void refreshen() {
		
		oe1.alwaysSelected();
		oe3.alwaysSelected();
		
		oe2.setMaxAnzahl((oe3.isSelected("Energiefaust")?1:0)+(oe1.isSelected("Energiefaust")?1:0));
		oe1.setAktiv("Raketenwerfer", !oe3.isSelected("Raketenwerfer"));
		oe3.setAktiv("Raketenwerfer", !oe1.isSelected("Raketenwerfer"));
	}

}
