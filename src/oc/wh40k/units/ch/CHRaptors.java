package oc.wh40k.units.ch;


import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class CHRaptors extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;
	OptionsUpgradeGruppe ikone;
    OptionsUpgradeGruppe mark;
    
	public CHRaptors() {
		//name = "Chaos Space Marines Raptoren\n";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Raptors", 5, 15, getPts("Raptors"), "Raptors");
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ChaosBikers.gif"));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Chaos Icon", getPts("Icon of Vengeance")));
		add(ikone = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Plasma pistol & Sword", getPts("Plasma pistol")+getPts("Chainsword")));
		ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));
		ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun")));
		ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun")));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		
        seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
		ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
		ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
		ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
		add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "CHWaffenkammer", "Raptor Champion",1);
        ((CHWaffenkammer)rkBoss.getKammer()).setDefaultFK("Bolt pistol");
        ((CHWaffenkammer)rkBoss.getKammer()).setDefaultNK("Chainsword");
        ((CHWaffenkammer)rkBoss.getKammer()).setChampion(true);
		rkBoss.initKammer(true,true,true,true);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		rkBoss.setGrundkosten(getPts("Raptor Champion"));
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);
		seperator();

		complete();
	}

	@Override
	public void refreshen() {
		
		power = 7 + 
				((squad.getModelle()==10)?5:0) + 
				((squad.getModelle()==15)?10:0);
	}

}
