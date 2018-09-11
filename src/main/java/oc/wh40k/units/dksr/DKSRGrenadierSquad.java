package oc.wh40k.units.dksr;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class DKSRGrenadierSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
    RuestkammerStarter rkTransport;

	public DKSRGrenadierSquad() {
		name = "Death Korps Grenadier Squad";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Grenadiers", 5, 10, 12);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/IGStormTrooperSquad.jpg"));

		seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Heavy flamer-team", "Weapon team with Heavy flamer", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", 10));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vox Caster", 5));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Watchmaster-Upgrade", 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 0));
		ogE.addElement(new OptionsGruppeEintrag("Boltgun", 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power axe", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power maul", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power lance", 10));
		ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melta bombs", 5));
		
		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DKCentaur", "Centaur");
		rkTransport.initKammer(true);
		add(rkTransport);
		
		complete();
	}

	@Override
	public void refreshen() {
		oe1.setSelected(true);

        int grenadiers = squad.getModelle()-1;

        o2.setMaxAnzahl(((grenadiers - o1.getAnzahl() *2 - (oe2.isSelected()?1:0))>2)?2:(grenadiers - o1.getAnzahl() *2 - (oe2.isSelected()?1:0)));
        o1.setMaxAnzahl(((grenadiers - o2.getAnzahl() - (oe2.isSelected()?1:0))>1)?1:0);//team
        oe2.setAktiv((grenadiers - o2.getAnzahl() - o1.getAnzahl() *2)>0);//Vox

        rkTransport.setAktiv(squad.getModelle() <= 5);
	}

}
