package oc.wh40k.units.ab;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ABArmouredFistSquad extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsZaehlerGruppe lasgun;
    OptionsZaehlerGruppe laspistol;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    OptionsEinzelUpgrade oe3;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkTransport;

    public ABArmouredFistSquad() {
        name = "Armoured Fist Squad";
        grundkosten = 50;

        add(ico = new oc.Picture("oc/wh40k/images/ABArmouredFistSquad.jpg"));
        
        ogE.addElement(new OptionsGruppeEintrag("Lasgun", 0));
        add(lasgun = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,9));

        ogE.addElement(new OptionsGruppeEintrag("Laspistol", 0));
        add(laspistol = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE,9));
        
        seperator();
        
        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Voxcaster", 5));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mortar", 5));
        ogE.addElement(new OptionsGruppeEintrag("Autocannon", 10));
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 15));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", 20));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sniper rifle", 5));
        ogE.addElement(new OptionsGruppeEintrag("Melta gun", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", 15));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Krak grenades", 10));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "ABSquadSergeant", "Sergeant");
        rkBoss.initKammer();
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(false);
        add(rkBoss);

        seperator();

        rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "ABChimeraKammer", "Chimera Transport");
        rkTransport.initKammer();
        rkTransport.setAbwaehlbar(false);
        add(rkTransport);

        complete();
    }

    @Override
    public void refreshen() {
        rkTransport.getPanel().setLocation(
            (int) rkTransport.getPanel().getLocation().getX(),
            (int) rkBoss.getPanel().getLocation().getY() + rkBoss.getPanel().getSize().height
        );
        
        lasgun.setMaxAnzahl(9-(o1.isSelected()?2:0)-(o2.isSelected()?1:0)-laspistol.getAnzahl());
        lasgun.setAnzahl(0, lasgun.getMaxAnzahl());
        
        laspistol.setMaxAnzahl(9-(o1.isSelected()?2:0)-(o2.isSelected()?1:0));
        
        o1.setAktiv(lasgun.getMaxAnzahl()>1 || o1.isSelected());
        o2.setAktiv(lasgun.getMaxAnzahl()>0 || o2.isSelected());
        
    }
}
