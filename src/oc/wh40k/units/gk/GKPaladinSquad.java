package oc.wh40k.units.gk;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class GKPaladinSquad extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1, o1x, o3x, o4x;
	OptionsZaehlerGruppe o1def;
	OptionsZaehlerGruppe o3def;
	OptionsZaehlerGruppe o4, bomben, peilsender, digitalwaffen;
    OptionsEinzelUpgrade apo;
    OptionsUpgradeGruppe banner;
    RuestkammerStarter rkRaider;

	public GKPaladinSquad() {
		name = "Paladin-Squad\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Paladin", "Paladine", 3, 10, 55);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/GKPaladinTrupp.jpg"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Psischwert", "Nemesis-Psischwert", 0));
		add(o1def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Psihellebarde", "Nemesis-Psihellebarde", 2));
		ogE.addElement(new OptionsGruppeEintrag("Falchions", "Paar Nemesis-Falchions", 4));
		ogE.addElement(new OptionsGruppeEintrag("Wehrstab", "Nemesis-Wehrstab", 5));
		ogE.addElement(new OptionsGruppeEintrag("Dämonenhammer", "Nemesis-Dämonenhammer", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		ogE.addElement(new OptionsGruppeEintrag("Meisterhaftes Schwert", "Meisterhaftes Nemesis-Psischwert", 10));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafte Hellebarde", "Meisterhafte Nemesis-Psihellebarde", 12));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafte Falchions", "Paar Meisterhafte Nemesis-Falchions", 14));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Wehrstab", "Meisterhafter Wehrstab", 15));
		ogE.addElement(new OptionsGruppeEintrag("Meisterh. Däm.hammer", "Meisterhafter Nemesis-Dämonenhammer", 20));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
		add(o3def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		ogE.addElement(new OptionsGruppeEintrag("Meisterh. Sturmbolter", 10));
		add(o3x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

		ogE.addElement(new OptionsGruppeEintrag("Erlöser-Flamer", "Erlöser-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Psipulser", 15));
		ogE.addElement(new OptionsGruppeEintrag("Psibolter", 20));
		add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Flamer", "Meisterhafter Erlöser-Flammenwerfer", 20));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Psipulser", 25));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Psibolter", 30));
		add(o4x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

		add(apo = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Apothecarius", "Upgrade zum Apothecarius", 20));
		
		ogE.addElement(new OptionsGruppeEintrag("Bruderschaftsbanner", 25));
        ogE.addElement(new OptionsGruppeEintrag("Nemesisbanner", 35));
        add(banner = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
        ogE.addElement(new OptionsGruppeEintrag("Melterbomben", 5));
		add(bomben = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Digitalwaffe", 10));
		add(digitalwaffen = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Peilsender", 10));
		add(peilsender = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();
		
		rkRaider = new RuestkammerStarter(ID, randAbstand, cnt, "GKLandRaiderKammer", "Land Raider");
		rkRaider.initKammer();
		rkRaider.setButtonText("Land Raider");
		add(rkRaider);
		
		complete();
	}

	@Override
	public void refreshen() {
		int subtractor = (banner.isSelected() ? 1 : 0);
		
		o1.setMaxAnzahl(squad.getModelle() - subtractor - o1x.getAnzahl()); // heavy weapon
		o1x.setMaxAnzahl(squad.getModelle() - subtractor - o1.getAnzahl()); // heavy weapon
		o1def.setMaxAnzahl(squad.getModelle() - o1.getAnzahl() - o1x.getAnzahl() - subtractor);
		o1def.setAnzahl(0, squad.getModelle() - o1.getAnzahl() - o1x.getAnzahl() - subtractor);

		subtractor = o4.getAnzahl() + o4x.getAnzahl() + (apo.isSelected() ? 1 : 0);
		o3def.setMaxAnzahl(squad.getModelle() - subtractor);
		o3x.setMaxAnzahl(squad.getModelle() - subtractor);
		o3def.setAnzahl(0, squad.getModelle() - o3x.getAnzahl() - subtractor);
		o3x.setAnzahl(0, squad.getModelle() - o3def.getAnzahl() - subtractor);

        o4.setMaxAnzahl((int) Math.floor(squad.getModelle() / 5) * 2 - o4x.getAnzahl());
        o4x.setMaxAnzahl((int) Math.floor(squad.getModelle() / 5) * 2 - o4.getAnzahl());
        
        peilsender.setMaxAnzahl(squad.getModelle());
        bomben.setMaxAnzahl(squad.getModelle());
        digitalwaffen.setMaxAnzahl(squad.getModelle());
        
        boolean legal = (o1x.getAnzahl() + o3x.getAnzahl() + o4x.getAnzahl() <= squad.getModelle());

        o1x.setLegal(legal);
        o3x.setLegal(legal);
        o4x.setLegal(legal);
        
        if(!legal)
        {
        	setFehlermeldung("Meisterhafte > " + squad.getModelle());
        }
        else
        {
        	setFehlermeldung("");
        }
	}

}
