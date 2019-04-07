package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMAssaultSquadBA extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1, o1x;
	private final OptionsZaehlerGruppe o2;
	private final RuestkammerStarter rkBoss;

	private final OptionsEinzelUpgrade jump;

    public IMAssaultSquadBA() {
        name = "Assault Squad\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, getPts("Assault Squad") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/SMTaktischerTrupp.jpg"));

        seperator();

        add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump packs", getPts("Assault Squad with Jump Packs") - getPts("Assault Squad")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol + Chainsword", getPts("Bolt pistol (SM)") + getPts("Chainsword (SM)")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        //Special Weapons
        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol + chainsword", getPts("Plasma pistol (SM)") + getPts("Chainsword (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Hand flamer + chainsword", getPts("Hand flamer (BA)") + getPts("Chainsword (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Inferno pistol + chainsword", getPts("Inferno pistol (BA)") + getPts("Chainsword (SM)")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        ogE.addElement(new OptionsGruppeEintrag("Eviscerator", getPts("Eviscerator")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, IMSergeant.class, "Sergeant");
        ((IMSergeant) rkBoss.getKammer()).type = "Assault Squad";
        rkBoss.initKammer();
        rkBoss.setGrundkosten(getPts("Sergeant"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {

        jump.setModelle(squad.getModelle());

        o1x.setMaxAnzahl(squad.getModelle() - 1 - o1.getAnzahl() - o2.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - 1 - o1.getAnzahl() - o2.getAnzahl());
        o2.setMaxAnzahl(squad.getModelle() / 5 - ((IMSergeant) rkBoss.getKammer()).o3.getAnzahl());

        power = 5;
        if (jump.isSelected()) {
            power += 1;
        }
        if (squad.getModelle() > 5) {
            power += 4;
            if (jump.isSelected()) {
                power += 1;
            }
        }
    }

}
