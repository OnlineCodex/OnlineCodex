package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMWolfGuard extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1x;
	private final OptionsZaehlerGruppe o2;
	private final OptionsZaehlerGruppe o3, o3x;
	private final OptionsEinzelUpgrade jump;

	private final OptionsZaehlerGruppe wolfsklauen;


    public IMWolfGuard() {
        grundkosten = 0;
        applyTitle = true;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Wolf Guard", 5, 10, getPts("Wolf Guard")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasma Pistol", getPts("Plasma Pistol (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (others)")));
        ogE.addAll(IMSpaceWolvesCombiWeapons.createRK("", "", buildaVater));
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
        o1x.setMaxAnzahl(squad.getModelle() - o2.getAnzahl() - wolfsklauen.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - o2.getAnzahl() - wolfsklauen.getAnzahl());
        o2.setMaxAnzahl(squad.getModelle() - wolfsklauen.getAnzahl());

        o3x.setMaxAnzahl(squad.getModelle() - o3.getAnzahl() - wolfsklauen.getAnzahl());
        o3x.setAnzahl(0, squad.getModelle() - o3.getAnzahl() - wolfsklauen.getAnzahl());
        o3.setMaxAnzahl(squad.getModelle() - wolfsklauen.getAnzahl());

        wolfsklauen.setMaxAnzahl(squad.getModelle() - Math.max(o2.getAnzahl(),o3.getAnzahl()));

        power = 8;
        if (squad.getModelle() > 5) {
            power += 8;
        }
        if (jump.isSelected()) {
            power += squad.getModelle() > 5 ? 2 : 1;
        }
    }
}
