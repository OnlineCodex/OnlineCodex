package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMWolfGuard extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1, o1x;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe o3, o3x;
	OptionsEinzelUpgrade jump;

	OptionsZaehlerGruppe wolfsklauen;


	public IMWolfGuard() {
		name = "Wolf Guard\n";
		grundkosten = 0;
		überschriftSetzen = true;

		add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Wolf Guard", 5, 10, getPts("Wolf Guard")));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
		add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));
		ogE.addAll(IMSpaceWolvesCombiWeapons.createRK("", "", buildaVater));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));
		
		seperator();

		ogE.addAll(IMSpaceWolvesMeleeWeapons.createRK("", "", buildaVater));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
		add(o3x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasma Pistol", getPts("Plasma Pistol (SM)")));
		ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (Characters)")));
		ogE.addAll(IMSpaceWolvesMeleeWeapons.createRK("", "", buildaVater));
		add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("2 Wolf claws", getPts("Wolf claw (pair)")));
		ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
		add(wolfsklauen = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));
		
		seperator();
		
		add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump Packs", getPts("Wolf Guard with Jump Packs") - getPts("Wolf Guard")));
		
		complete();
	}
     

	@Override
	public void refreshen() {
		o1x.setMaxAnzahl(squad.getModelle() - o1.getAnzahl());
		o1x.setAnzahl(0,squad.getModelle() - o1.getAnzahl());
		o1.setMaxAnzahl(squad.getModelle());
		
		o2.setMaxAnzahl(squad.getModelle() - wolfsklauen.getAnzahl());
		
		o3x.setMaxAnzahl(squad.getModelle() - o3.getAnzahl() - wolfsklauen.getAnzahl());
		o3x.setAnzahl(0,squad.getModelle() - o3.getAnzahl() - wolfsklauen.getAnzahl());
		o3.setMaxAnzahl(squad.getModelle() - wolfsklauen.getAnzahl());
		
		wolfsklauen.setMaxAnzahl(squad.getModelle() - (o2.getAnzahl()>o3.getAnzahl()?o2.getAnzahl():o3.getAnzahl()));
		
		power = 9;
		if(squad.getModelle()>5){
			power+=9;
		}
		if(jump.isSelected()){
			power+=squad.getModelle()/5;
		}
	}
}
