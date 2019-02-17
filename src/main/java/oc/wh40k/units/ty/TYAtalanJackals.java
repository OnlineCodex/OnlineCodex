package oc.wh40k.units.ty;

import oc.*;

public class TYAtalanJackals extends Eintrag {

    private final AnzahlPanel squad;
    private final RuestkammerStarter rkBoss;
    private final RuestkammerStarter rkTrike, rkTrike2, rkTrike3;
    private final OptionsZaehlerGruppe o1;
    private final OptionsZaehlerGruppe o2;

    public TYAtalanJackals() {
        name = "Atalan Jackals\n";
        grundkosten = 0;
        überschriftSetzen = true;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Atalan Jackals", 3, 11, getPts("Atalan Jackals") + getPts("Twin boltgun")));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Autogun", getPts("Autogun")));
        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe")));
        ogE.addElement(new OptionsGruppeEintrag("Autopistol", getPts("Autopistol")));
        ogE.addElement(new OptionsGruppeEintrag("Cultist knife", getPts("Cultist knife")));
        ogE.addElement(new OptionsGruppeEintrag("Demolition charge", getPts("Demolition charge")));
        ogE.addElement(new OptionsGruppeEintrag("Improvised weapon", getPts("Improvised weapon")));
        ogE.addElement(new OptionsGruppeEintrag("Power hammer", getPts("Power hammer")));
        ogE.addElement(new OptionsGruppeEintrag("Power pick", getPts("Power pick")));
        ogE.addElement(new OptionsGruppeEintrag("Shotgun", getPts("Shotgun")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", getPts("Grenade launcher")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, TYLeader.class, "Atalan Leader");
        ((TYLeader) rkBoss.getKammer()).type = "Atalan Leader";
        rkBoss.setGrundkosten(getPts("Atalan Jackals"));
        rkBoss.initKammer();
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        seperator();

        rkTrike = new RuestkammerStarter(ID, randAbstand, cnt, TYWolfquad.class, "Wolfquad");
        rkTrike.initKammer();
        rkTrike.setGrundkosten(getPts("Atalan Wolfquads"));
        add(rkTrike);
        
        seperator();
        
        rkTrike2 = new RuestkammerStarter(ID, randAbstand, cnt, TYWolfquad.class, "Wolfquad");
        rkTrike2.initKammer();
        rkTrike2.setGrundkosten(getPts("Atalan Wolfquads"));
        add(rkTrike2);

        seperator();
        
        rkTrike3 = new RuestkammerStarter(ID, randAbstand, cnt, TYWolfquad.class, "Wolfquad");
        rkTrike3.initKammer();
        rkTrike3.setGrundkosten(getPts("Atalan Wolfquads"));
        add(rkTrike3);

        complete();
    }

    @Override
    public void refreshen() {
    	o1.setMaxAnzahl(squad.getModelle()*2 - o2.getAnzahl());
    	rkTrike.setAktiv(squad.getModelle()>=3);
    	rkTrike2.setAktiv(squad.getModelle()>=7);
    	rkTrike3.setAktiv(squad.getModelle()>=11);
    	
    	o2.setMaxAnzahl((squad.getModelle()+1)/4);
    	
    	int powerWolfquad = 0;
    	if(rkTrike.isSelected()) powerWolfquad+=2;
    	if(rkTrike2.isSelected()) powerWolfquad+=2;
    	if(rkTrike3.isSelected()) powerWolfquad+=2;
    	
    	int powerJackals = ((squad.getModelle() + 1)/4) * 3;
    	power = powerJackals + powerWolfquad;
    	
    	boolean legal = ((o1.getAnzahl() == squad.getModelle()*2) || (o1.getAnzahl() + o2.getAnzahl() == squad.getModelle()*2));
    	o1.setLegal(legal);
    }

}

