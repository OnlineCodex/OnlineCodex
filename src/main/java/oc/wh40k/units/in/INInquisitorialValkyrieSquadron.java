package oc.wh40k.units.in;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class INInquisitorialValkyrieSquadron extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2a;
    OptionsZaehlerGruppe o2b;
    OptionsZaehlerGruppe o1x;
    OptionsZaehlerGruppe o2x;
    OptionsEinzelZaehler oe1;
    OptionsEinzelZaehler oez1; 
    OptionsEinzelZaehler oez2; 
    OptionsEinzelZaehler oez3; 
    OptionsEinzelZaehler oez4; 

    public INInquisitorialValkyrieSquadron() {
        name = "Inquisitorial Valkyrie Squadron";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Valkyrie", "Valkyrie", 1, 3, 100);
        squad.setGrundkosten(0);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/IGValkyrieAssaultCarrierSquadron.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Multi-laser", 0));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", 15));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("hellstrike missiles", 0));
        add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        ogE.addElement(new OptionsGruppeEintrag("mindstrike missiles", 0));
        add(o2a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        ogE.addElement(new OptionsGruppeEintrag("2 Multiple rocket pods", 30));
        add(o2b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        add(oe1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "option", "2 Heavy bolters", 3, 10));

        seperator();
        
        add(oez1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "chaff launcher", 3, 10));
        add(oez2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "armoured cockpit", 3, 15));
        add(oez3 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "illum flares",  3, 5));
        add(oez4 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "paint sheme", "distinctive paint sheme",  3, 10));
        
        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());
        o1x.setMaxAnzahl(squad.getModelle() - o1.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl());

        o2a.setMaxAnzahl(squad.getModelle()-o2b.getAnzahl());
        o2b.setMaxAnzahl(squad.getModelle()-o2a.getAnzahl());
        o2x.setMaxAnzahl(squad.getModelle() - o2a.getAnzahl() -o2b.getAnzahl());
        o2x.setAnzahl(0, squad.getModelle() - o2a.getAnzahl() -o2b.getAnzahl());

        oe1.setMaxAnzahl(squad.getModelle());
        oez1.setMaxAnzahl(squad.getModelle());
        oez2.setMaxAnzahl(squad.getModelle());
        oez3.setMaxAnzahl(squad.getModelle());
        oez4.setMaxAnzahl(squad.getModelle());
    }
    
}
