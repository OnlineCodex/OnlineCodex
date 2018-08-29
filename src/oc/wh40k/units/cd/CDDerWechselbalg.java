package oc.wh40k.units.cd;


public class CDDerWechselbalg  extends CDHerold {

	boolean nurgleBild;

	public CDDerWechselbalg() {
		name = "Der Wechselbalg";
		grundkosten = 75;

		add(ico = new oc.Picture("oc/wh40k/images/CDDaemonenprinzdesChaos.gif"));

		complete();
	}

	@Override
	public void refreshen() {
		super.refreshen();
	}

}
