package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMIntercessorSquad extends Eintrag {
	private final RuestkammerStarter rkBoss;
	private final OptionsZaehlerGruppe grenade;
	private final OptionsUpgradeGruppe o1;
    private final AnzahlPanel squad;

    public IMIntercessorSquad() {
        name = "Intercessor Squad";
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Intercessor", 5, 10, getPts("Intercessor Squad") + getPts("Heavy bolt pistol") + getPts("Krak grenade (SM)") + getPts("Frag grenade (SM)") + getPts("Shock grenades"));
        add(squad);

        ogE.addElement(new OptionsGruppeEintrag("Bolt rifle", getPts("Bolt rifle")));
        ogE.addElement(new OptionsGruppeEintrag("Auto bolt rifle", getPts("Auto bolt rifle")));
        ogE.addElement(new OptionsGruppeEintrag("Stalker bolt rifle", getPts("Stalker bolt rifle")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Auxiliary grenade launcher", getPts("Auxiliary grenade launcher")));
        add(grenade = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        
        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, IMSpaceMarinesRuestkammer.class, "Intercessor Sergeant", getKeywords());
        ((IMSpaceMarinesRuestkammer) rkBoss.getKammer()).setType("Intercessor Sergeant");
        rkBoss.initKammer();
        rkBoss.setGrundkosten(getPts("Intercessor Sergeant"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);
        
        seperator();        
    }

    @Override
    public void refreshen() {
        o1.setPreis(0, (squad.getModelle() * getPts("Bolt rifle")));
        o1.setPreis(1, (squad.getModelle() * getPts("Auto bolt rifle")));
        o1.setPreis(2, (squad.getModelle() * getPts("Stalker bolt rifle")));
        o1.alwaysSelected();
        grenade.setMaxAnzahl((squad.getModelle() + (rkBoss.isSelected() ? 1 : 0)) / 5);

        if (squad.getModelle() <= 5)
            power = 5;
        else
            power = 10;
    }
}
