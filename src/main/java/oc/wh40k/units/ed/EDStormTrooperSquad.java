package oc.wh40k.units.ed;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class EDStormTrooperSquad extends Eintrag {

    AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
    RuestkammerStarter rkTransport;

	public EDStormTrooperSquad() {
		name = "Storm Trooper Squad";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Storm Troopers", 5, 10, 16);
		squad.setGrundkosten(5);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGStormTrooperSquad.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Granade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melta", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sergeant", 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));


        seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "EDValkyrie", "Valkyrie");
		rkTransport.initKammer();
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setSelected(true);
	}

}
