package drugi;

public class Plasman {
	private int godina,redniBrojUtrke,plasman;
	private String vozac;
	public Plasman(int godina, int redniBrojUtrke, String vozac, int plasman)
	{
		this.setGodina(godina);
		this.setRedniBrojUtrke(redniBrojUtrke);
		this.setVozac(vozac);
		this.setPlasman(plasman);
	}
	public int getGodina() {
		return godina;
	}
	public void setGodina(int godina2) {
		this.godina = godina2;
	}
	public int getRedniBrojUtrke() {
		return redniBrojUtrke;
	}
	public void setRedniBrojUtrke(int redniBrojUtrke2) {
		this.redniBrojUtrke = redniBrojUtrke2;
	}
	public String getVozac() {
		return vozac;
	}
	public void setVozac(String vozac) {
		this.vozac = vozac;
	}
	public int getPlasman() {
		return plasman;
	}
	public void setPlasman(int plasman2) {
		this.plasman = plasman2;
	}
}
