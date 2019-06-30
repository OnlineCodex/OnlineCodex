package oc.wh40k.units.ta;




import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class TAXV95GhostkeelBattlesuits extends Eintrag {

//	private final Vector<RuestkammerStarter> rk;
	private final OptionsEinzelUpgrade o5;

    public TAXV95GhostkeelBattlesuits() {
        name = "Ghostkeel Shas'vre";
        überschriftSetzen = true;
        grundkosten = getPts("XV95 Ghostkeel Battlesuit");

        add(ico = new oc.Picture("oc/wh40k/images/KrisisKampfanzugteam.gif"));
        
//        rk = new Vector<RuestkammerStarter>();
//        for (int i = 0; i < 1; i++) {
//            rk.add(createTroopChampion(TAKampfanzugKammer.class, true, "Ghostkeel Shas'vre", "Ghostkeel Shas'vre"));
//            rk.lastElement().initKammer(false, false, false, false, false, false, true);
//            rk.lastElement().setGrundkosten(getPts("XV95 Ghostkeel Battlesuit"));
//            add(rk.lastElement());
//        }
//
//        rk.firstElement().setAbwaehlbar(false);

        addWeapons(TAKampfanzugKammer.class, true);
        
        seperator();

        add(o5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "MV5 Stealth Drones", "MV5 Stealth Drones", getPts("MV5 Stealth Drone") * 2));
        o5.setSelected(true);

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
//        o5.getPanel().setLocation(
//                (int) o5.getPanel().getLocation().getX(),
//                (int) rk.firstElement().getPanel().getLocation().getY() + rk.firstElement().getPanel().getSize().height + 5
//        );
//
//        if (!o5.isSelected()) o5.setSelected(true);

        power = 10;
    }
}
